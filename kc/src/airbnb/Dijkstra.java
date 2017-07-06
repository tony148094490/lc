package airbnb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
// a.k.a find people to people or wizard to wizard distance
// https://tinyurl.com/yarhobmg
// http://www.1point3acres.com/bbs/thread-229065-1-1.html
// https://tinyurl.com/ycn47fu4
// this question is the same as wizard (see the other file)
// 总共有0，1，2，3，4，5，6，7，8，9个人， 每个人认识一些人， 
// 求从0到9，cost最小的路径。cost(i, j) = (j - i) * (j - i).
// Important NOTICE: Dijkstra can only work with non-negative weight (or where negative weight)
public class Dijkstra {
	// assumption, a full 9 sublist
	// version 1: get min distance
	public int getMin(List<List<Integer>> relation) {
		Node source = null, destination = null;
		Map<Integer, Node> nodeMap = new HashMap<>();
		for(int i = 0 ; i < relation.size(); i++) {
			Node node = nodeMap.getOrDefault(i, new Node(i));
			for(int j : relation.get(i)) {
				if(!nodeMap.containsKey(j)) {
					Node neigh = new Node(j);
					nodeMap.put(j, neigh);
				}
				node.neighbors.add(nodeMap.get(j));
			}
			if(i == 0) source = node;
			if(i == relation.size() - 1) destination = node;
		}
		
		Comparator<Node> comp = (a,b) -> {return a.distanceToOrigin - b.distanceToOrigin;};
		PriorityQueue<Node> pq = new PriorityQueue<Node>(comp);
		source.distanceToOrigin = 0;
		pq.add(source);
		while(!pq.isEmpty()) {
			Node parent = pq.poll();
			for(Node neighbor : parent.neighbors) {
				int newDistance = parent.distanceToOrigin + (parent.id - neighbor.id) * (parent.id - neighbor.id);
				if(neighbor.distanceToOrigin > newDistance) {
					// pq doesn't do reorder when editing elements inside
					// therefore we need to remove and insert the edited node
					// alternative is to mark the node as visited and add a new duplicate
					// https://stackoverflow.com/questions/6952660/java-priority-queue-reordering-when-editing-elements
					pq.remove(neighbor);
					neighbor.distanceToOrigin = newDistance;
					pq.add(neighbor);
				}
			}
		}
		
		return destination.distanceToOrigin;
	}
	
	
	// version 2: get min path
	 public List<Integer> getPath(List<List<Integer>> relation) {
			Node source = null, destination = null;
			Map<Integer, Node> nodeMap = new HashMap<>();
			Map<Integer, Integer> path = new HashMap<>();
			
			for(int i = 0 ; i < relation.size(); i++) {
				Node node = nodeMap.getOrDefault(i, new Node(i));
				for(int j : relation.get(i)) {
					if(!nodeMap.containsKey(j)) {
						Node neigh = new Node(j);
						nodeMap.put(j, neigh);
					}
					node.neighbors.add(nodeMap.get(j));
				}
				if(i == 0) source = node;
				if(i == relation.size() - 1) destination = node;
			}
			
			Comparator<Node> comp = (a,b) -> {return a.distanceToOrigin - b.distanceToOrigin;};
			PriorityQueue<Node> pq = new PriorityQueue<Node>(comp);
			source.distanceToOrigin = 0;
			pq.add(source);
			while(!pq.isEmpty()) {
				Node parent = pq.poll();
				for(Node neighbor : parent.neighbors) {
					int newDistance = parent.distanceToOrigin + (parent.id - neighbor.id) * (parent.id - neighbor.id);
					if(neighbor.distanceToOrigin > newDistance) {
						// pq doesn't do reorder when editing elements inside
						// therefore we need to remove and insert the edited node
						// alternative is to mark the node as visited and add a new duplicate
						// https://stackoverflow.com/questions/6952660/java-priority-queue-reordering-when-editing-elements
						pq.remove(neighbor);
						neighbor.distanceToOrigin = newDistance;
						path.put(neighbor.id, parent.id);
						pq.add(neighbor);
					}
				}
			}
			
			List<Integer> res = new ArrayList<>();
			int cur = destination.id;
			while(cur != source.id) {
				res.add(cur);
				cur = path.get(cur);
			}
			res.add(cur);
			Collections.reverse(res);
			return res;
	 }
	
	
	public class Node {
		int id;
		int distanceToOrigin;
		List<Node> neighbors = new ArrayList<>();
		public Node(int i) {
			id = i;
			distanceToOrigin = Integer.MAX_VALUE;
		}
	}
	
	public static void main(String[] args) {
		Dijkstra d = new Dijkstra();
		List<List<Integer>> relation = new ArrayList<>();
		for(int i = 0 ; i <= 9 ;i++) {
			relation.add(new ArrayList<>());
		}

		relation.get(0).add(1);
		relation.get(0).add(3);
		relation.get(0).add(7);
		
		relation.get(1).add(0);
		relation.get(1).add(2);
		relation.get(1).add(4);
		relation.get(1).add(5);
		
		relation.get(2).add(1);
		relation.get(2).add(4);
		relation.get(2).add(3);
		relation.get(2).add(9);

		relation.get(3).add(0);
		relation.get(3).add(2);
		relation.get(3).add(9);
		relation.get(3).add(6);
		relation.get(3).add(8);
		
		relation.get(4).add(1);
		relation.get(4).add(2);
		
		relation.get(5).add(1);
		
		relation.get(6).add(3);
		relation.get(6).add(9);
		
		relation.get(7).add(0);
		relation.get(7).add(8);
		
		relation.get(8).add(3);		
		relation.get(8).add(7);
		
		relation.get(9).add(2);
		relation.get(9).add(3);
		relation.get(9).add(6);
		
		System.out.println(d.getMin(relation));
		System.out.println(d.getPath(relation));
	}
}
