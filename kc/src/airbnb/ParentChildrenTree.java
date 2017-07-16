package airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://tinyurl.com/ya5vwk2r
详细说一下题目：
给的map是这个样子的
   A   B   C  D
A AC CD D  B
B B   C   A  CD
C A   C   D  B
D BC D   A  C

i,j 以为着左孩子是i，右孩子是j的时候， 父亲结点的可能值

然后给定最低层的叶子结点 A B C D

那么倒数第二层就只可能是  D A B 和 C A B 两种，因为A B -> CD

!!!!MUST READ: https://users.cs.duke.edu/~ola/courses/cps149/problems/week2/trellis.html
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=224107  记忆化搜索
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=158743
// Q1 http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=146537&fromuid=188454
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=212660
 * https://www.udebug.com/UVa/251
 * 
 * the question is that you are given 1) the leaf nodes value (in the given order) of a 'binary-tree like structure' and 2) a map (called 'transition table') indicating the children parent relation
 * 3) a list(array) of possible root values. Output if the root value is among the given list.
 * this should be dfs + memorization
 */

// a.k.a string pyrimid, below answer should be the correct one, i did some tests with some online judge(https://www.udebug.com/UVa/251)
public class ParentChildrenTree {

	Map<String, Boolean> cache = new HashMap<>();
	
	// states map can be in other format, this is (left -> (right, parent/next))
	public boolean validNTA(Map<Character, Map<Character, String>> map, char[] input, String acceptedApexValues) {
		
		if(input.length == 0) return false;
		
		// base case, reached last point
		if(input.length == 1) {
			for(char c : acceptedApexValues.toCharArray()) {
				if(c == input[0]) return true;
			}
			return false;
		}
		
		// exit earlier if computed before
		String inputString = new String(input);
		if(cache.containsKey(inputString)) return cache.get(inputString);
		
		// based on given input, we can get multiple (expoential) potential next iteration candidates 
		Set<String> nextStates = getNextStates(input, map);
		
		for(String str : nextStates) {
			if(validNTA(map, str.toCharArray(), acceptedApexValues)) {
				cache.put(inputString, true);// i think this might not needed (as we only care to fail fast, instead of 'succeed' fast) 
				return true;
			}
		}
		
		// cache failures
		cache.put(inputString, false);
		return false;
	}
	
	private Set<String> getNextStates(char[] input, Map<Character, Map<Character, String>> map) {
		Set<String> res = new HashSet<>();
		dfs(input, 1, map, "", res);
		return res;
	}
	
	private void dfs(char[] input, int index, Map<Character, Map<Character, String>> map, String cur, Set<String> res) {
		if(index == input.length) {
			res.add(cur);
			return;
		}
		
		// no valid next state as the left-right combo do not have a valid next state
		if(!map.containsKey(input[index-1]) || !map.get(input[index]).containsKey(input[index])) return;
		
		String next = map.get(input[index-1]).get(input[index]);
		
		for(Character c : next.toCharArray()) {
			dfs(input, index+1, map, cur + c, res);
		}
	}
	
	public static void main(String[] args) {
		
		ParentChildrenTree solver = new ParentChildrenTree();
		// example from https://users.cs.duke.edu/~ola/courses/cps149/problems/week2/trellis.html
		
		// NTA 1:, the only acceptable final state is 'c'.
		Map<Character, Map<Character, String>> map = new HashMap<>();
		map.put('a', new HashMap<>());		//		a	b	c
		map.put('b', new HashMap<>());		//		---------	
		map.put('c', new HashMap<>());		//	 a|	a	a	c
		map.get('a').put('a', "a");			//	 b|	ca	a	b
		map.get('a').put('b', "a");			//	 c|	c	b	a
		map.get('a').put('c', "c");
		map.get('b').put('a', "ca");
		map.get('b').put('b', "a");
		map.get('b').put('c', "b");
		map.get('c').put('a', "c");
		map.get('c').put('b', "b");
		map.get('c').put('c', "a");
		
		String input1 = "bba";
		String input2 = "abab";
		String input3 = "babbba";
		String input4 = "a";
		String input5 = "aaaaa";
		String input6 = "baaab";
		String input7 = "abbbaba";
		String input8 = "baba";
		String input9 = "bcbab";
		
		List<String> inputs = new ArrayList<>();
		inputs.add(input1);inputs.add(input2);inputs.add(input3);inputs.add(input4);
		inputs.add(input5);inputs.add(input6);inputs.add(input7);inputs.add(input8);
		inputs.add(input9);
		
		
		System.out.println("NTA 1");
		for(int i = 0 ; i < inputs.size(); i++) {
			solver.cache.clear();
			System.out.println("input: " + inputs.get(i) + 
					", result: " + ((solver.validNTA(map, inputs.get(i).toCharArray(), "c") == true) ? "accept" : "reject"));
		}
		
		// NTA 2: the acceptable final states are 'b' and 'c'
		Map<Character, Map<Character, String>> map2 = new HashMap<>();
		map2.put('a', new HashMap<>());
		map2.put('b', new HashMap<>());
		map2.put('c', new HashMap<>());
		map2.get('a').put('a', "ab");
		map2.get('a').put('b', "a");
		map2.get('a').put('c', "c");
		map2.get('b').put('a', "a");
		map2.get('b').put('b', "ab");
		map2.get('b').put('c', "b");
		map2.get('c').put('a', "c");
		map2.get('c').put('b', "b");
		map2.get('c').put('c', "ab");
		System.out.println("NTA 2");
		solver.cache.clear();
		System.out.println("Input: abc " + (solver.validNTA(map2, "abc".toCharArray(), "bc") == true ? "accept" : "reject") );
		solver.cache.clear();
		System.out.println("Input: cbc " + (solver.validNTA(map2, "cbc".toCharArray(), "bc") == true ? "accept" : "reject") );
	}
}
