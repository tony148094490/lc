package kc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	
	public UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
	
	@Override
	public String toString() {
		Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
		StringBuilder x = new StringBuilder();
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		Queue<UndirectedGraphNode> children = new LinkedList<UndirectedGraphNode>();
		
		q.add(this);
		while(!q.isEmpty()) {
			UndirectedGraphNode n = q.poll();

			set.add(n);

			x.append(n.label);
			x.append(",");
			List<UndirectedGraphNode> nei = n.neighbors;
			for(UndirectedGraphNode ne : nei) {
				if(!set.contains(ne)) {
					children.add(ne);
				}
				x.append(ne.label);x.append(",");
			}

			if(q.isEmpty()) {
				q = children;
				children = new LinkedList<UndirectedGraphNode>();
			}
			
			if(!q.isEmpty()) 			x.append("#");
		}
		return x.toString();
	}
}
