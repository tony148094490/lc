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
	Map<Long, TreeMap<Long, Integer>> map = new HashMap<>();
	public void deposit(long accountId, int amount, long time) {
		TreeMap<Long, Integer> accountBalance = map.getOrDefault(accountId, new TreeMap<>());
		int currentBalance = 0;
		if(accountBalance.size() > 0)
		currentBalance = accountBalance.lastEntry().getValue();
		
		currentBalance += amount;
		
		accountBalance.put(time, currentBalance);
		
		map.put(accountId, accountBalance);
	}
	
	public void withdraw(long accountId, int amount, long time) throws Exception {
		if(!map.containsKey(accountId) || map.get(accountId).lastEntry().getValue() < amount) throw new Exception("Not enough balance for account: " + accountId);
		map.get(accountId).put(time, map.get(accountId).lastEntry().getValue() - amount);
	}
	
	// return the balance at start date and end date. Not between.
	public int[] getRemain(long accountId, long start, long end, long time) throws Exception {
		if(!map.containsKey(accountId)) throw new Exception("Acount " + accountId + " does not exist.");
		int[] res = new int[2];
		
		if(map.get(accountId).floorEntry(start) != null)
		res[0] = map.get(accountId).floorEntry(start).getValue();
		
		if(map.get(accountId).floorEntry(end) != null) 
		res[1] = map.get(accountId).floorEntry(end).getValue();
		
		return res;
	}
}
