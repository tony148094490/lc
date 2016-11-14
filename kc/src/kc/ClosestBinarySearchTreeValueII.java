package kc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ClosestBinarySearchTreeValueII {
    Map<Double, List<Integer>> map = new HashMap<Double, List<Integer>>();
	PriorityQueue<Double> heap = new PriorityQueue<Double>();
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        helper(root, target);
        List<Integer> res = new ArrayList<Integer>();
        double last = -1.0;
        while(k > 0) {
        	double current = heap.poll();
        	if(current == last) continue;
        	last = current;
        	List<Integer> list = map.get(current);
        	for(int i = 0 ; i < list.size(); i++) {
        		res.add(list.get(i));
        		k--;
        		if(k == 0) break;
        	}
        }
        return res;
    }
    
    private void helper(TreeNode root, double target) {
    	if(root == null) return;
    	int val = root.val;
    	double diff = Math.abs(val - target);
    	if(map.containsKey(diff)) {
    		map.get(diff).add(root.val);
    	} else {
    		List<Integer> list = new ArrayList<Integer>();
    		list.add(root.val);
    		map.put(diff, list);
    	}
    	heap.add(diff);
    	helper(root.left, target);
    	helper(root.right, target);
    }
	
    // in order level traversal with window of k
    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	helper2(root, target, k , list);
    	return list;
    }
    
    private void helper2(TreeNode root, double target, int k , LinkedList<Integer> res) {
    	if(root == null) return;
    	helper2(root.left, target, k, res);
    	
    	if(res.size() == k) {
    		if(Math.abs(root.val - target) < Math.abs(res.peekFirst() - target)) {
    			res.removeFirst();
    		} else {
    			return;
    		}
    	}
    	
    	res.add(root.val);
    	helper2(root.right, target, k, res);
    }
    
}
