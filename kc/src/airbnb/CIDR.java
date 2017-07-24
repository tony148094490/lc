package airbnb;

import java.util.ArrayList;
import java.util.List;

// https://stackoverflow.com/questions/5020317/in-java-given-an-ip-address-range-return-the-minimum-list-of-cidr-blocks-that
// https://stackoverflow.com/questions/33443914/how-to-convert-ip-address-range-to-cidr-in-java  叶泰航
// [IMPORTANT] http://www.cisco.com/c/en/us/support/docs/ip/routing-information-protocol-rip/13788-3.html
// http://www.1point3acres.com/bbs/thread-282139-1-1.html
/**
 * 这个是背景介绍： https://en.wikipedia.org/wiki/Classless_Inter-Domain_Routing
这个是个online转化工具 http://www.ipaddressguide.com/cidr
大概的思路是group as much IPs as you can. 描述起来还真的麻烦呢，建议跑几个case，就理解了
 */
/*
 * some notes for this:
 * CIDR is just a notation, doesn't necesarily mean subnetting
 * 192.168.100.14/24 -> 24 is not a subnet mask
 * 192.168.100.0/22 -> 22 is just cidr notation, and this is just a group, there is no subnetting here.
 * 192.168.100.3/25 -> 25 is a subnet mask, it means the subnet 192.168.100.0 and host address is 0000011 (7bits)
 * 192.168.100.192/25 -> 25 is a subnet mask, it means it's on subnet 192.168.100.128 and host address i 1000000 (7bits)
 * VLSM is just to increase the subnet bit even more to make smaller subnets(batches)
 */
public class CIDR {
	// algo is not hard but needs practice: try matching as many ip addresses with one group and then iterate
	// this question has two variations: 1) given a start ip and a range 2) given a start ip and an end ip
	public List<String> getCIDRGroups(String startIp, int range) {
		if(startIp == null || startIp.length() < 7 || range <= 0) return null;
		List<String> res = new ArrayList<>();
		int counter = range; // if given end ip, range is (getIpFromString(end) - getIpFromString(start) + 1)
		long startIpInLongFormat = getIpFromString(startIp); // the long number expression of an ip address
		while(counter > 0 ) {
			
			int rightMostSetBitLocationOfStartIp = getRightMostSetBit(startIpInLongFormat);

			// largest number that is a single bit and can cover the most of the given range
			// i.e if the range is 8, we need 3 bits and luckily we can cover them all with 3 bits
			// if range is 10, at this round, we still need 3 bits and will leave 2 numbers out
			// because if we use 4 bits, we will cover 2 ^ 4 = 16 numbers which is larger than 10.
			int largest2ToTheNThatAtLeastPartiallyOfRange = (int) Math.floor(Math.log(counter) / Math.log(2)); // get leftMost 1 bit
			
			// this is the actual bit we can set without exceeding the limit safely. 
			// i.e by setting the bit to one, the rest bit to the right can be anything and still within our range.
			int rightMostBit = Math.min(rightMostSetBitLocationOfStartIp, largest2ToTheNThatAtLeastPartiallyOfRange);
			
			int actualMask = 32 - rightMostBit;
			
			String cidrGroupIp = getIp(startIpInLongFormat);
			res.add(cidrGroupIp + "/" + actualMask);
			counter -= Math.pow(2, 32 - actualMask);
			startIpInLongFormat += Math.pow(2, 32 - actualMask);
		}
		return res;
	}
	
	private long getIpFromString(String ip) {
		String[] parts = ip.split("\\.");
		long res = 0;
		for(int i = 0 ; i < parts.length; i++) {
			res <<= 8;
			res += Integer.parseInt(parts[i]);
		}
		return res;
	}
	
	private String getIp(long ip) {
		String sb = "";
		for(int i = 1; i <= 4; i++) {
			sb = String.valueOf(ip & 255) + "." + sb;
			ip >>= 8;
		}
		return sb.substring(0, sb.length()-1);
	}
	
	private int getRightMostSetBit(long a) {
		int start = 0;
		while(((1<<start) & a) == 0) start++;
		return start;
	}
	
	
	// impl 2, same idea, cleaner
	public List<String> getCIDR(String startIp, int range) {
		int counter = range;
		long start = stringToIp(startIp);
		List<String> res = new ArrayList<>();
		while(counter > 0) {
			int rightMostOfStart = getRightMost(start);
			int rightMostOfCounter = getLeftMost(counter);
			int actualRightMost = Math.min(rightMostOfStart, rightMostOfCounter);
			int mask = 32 - actualRightMost;
			res.add(ipToString(start) + "/" + mask);
			counter -= Math.pow(2, actualRightMost);
			start += Math.pow(2, actualRightMost);
		}
		return res;
	}

	private String ipToString(Long ip) {
			String sb = "";
			for(int i = 1; i <= 4; i++) {
				sb = String.valueOf(ip & 255) + "." + sb;
				ip >>= 8;
			}
			return sb.substring(0, sb.length()-1);
	}

	private Long stringToIp(String ip) {
			String[] parts = ip.split("\\.");
			long res = 0;
			for(int i = 0 ; i < parts.length; i++) {
				res <<= 8;
				res += Integer.parseInt(parts[i]);
			}
			return res;
	}

	private int getRightMost(Long i) {
		int j = 0;
		while(((i >> j) & 1)  == 0) j++;
		return j;
	}

	private int getLeftMost(int i) {
		int j = 31;
		while(((i >> j) & 1) == 0) j--;
		return j;
	}
	
	public static void main(String[] args) {
		CIDR ci = new CIDR();
		System.out.println(ci.getCIDRGroups("2.255.255.255", 10));	
		System.out.println(ci.getCIDRGroups("128.0.0.4", 4));
		System.out.println(ci.getCIDRGroups("255.0.0.7", 10));
		System.out.println();
		System.out.println(ci.getCIDR("2.255.255.255", 10));	
		System.out.println(ci.getCIDR("128.0.0.4", 4));
		System.out.println(ci.getCIDR("255.0.0.7", 10));
		
		
	}
}