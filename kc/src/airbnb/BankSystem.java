package airbnb;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//https://tinyurl.com/ycra756s
//https://tinyurl.com/y9knfgok
// Design a system that can deposit, withdraw and getRemaining given a timestamp
public class BankSystem {
	
	// use ordered map to help with the date search later on.
	// if treemap is not allowed, use linkedlist<Transaction> with binary search
	Map<Long, TreeMap<Long, Integer>> bank = new HashMap<>();
	public void deposit(long accountId, int amount, long time) {
			bank.putIfAbsent(accountId, new TreeMap<>());
			TreeMap<Long, Integer> account = bank.get(accountId);
			int newBalance = account.lastEntry().getValue() + amount;
			account.put(time, newBalance);
	}
	
	public void withdraw(long accountId, int amount, long time) {
		if(!bank.containsKey(accountId)) return;//or throw exception
		TreeMap<Long, Integer> account = bank.get(accountId);
		int remainder = account.lastEntry().getValue() - amount;
		if(remainder < 0) return; // or throw exception
		account.put(time, remainder);
	}
	
	public int[] getStatus(long accountId, long start, long end) {
		if(!bank.containsKey(accountId)) return new int[2]; // or throw exception
		int[] res = new int[2];
		TreeMap<Long, Integer> account = bank.get(accountId);
		Integer s = account.floorEntry(start).getValue();
		Integer e = account.ceilingEntry(end).getValue();
		res[0] = s == null ? 0 : s;
		res[1] = e == null ? 0 : e;
		return res;
	}
}
