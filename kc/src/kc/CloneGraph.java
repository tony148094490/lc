package kc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null || node.neighbors == null) return node;
    	    	
    	Queue<UndirectedGraphNode> parent = new LinkedList<UndirectedGraphNode>();
    	Queue<UndirectedGraphNode> children = new LinkedList<UndirectedGraphNode>();
     	 
    	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    	
    	UndirectedGraphNode res = new UndirectedGraphNode(node.label);
    	parent.add(node);
    	map.put(node, res);
    	
    	while(!parent.isEmpty()) {
    		
    		UndirectedGraphNode parentOld = parent.poll();
    		UndirectedGraphNode parentNew = map.get(parentOld);

    		for(UndirectedGraphNode ne : parentOld.neighbors) {
    			if(!map.containsKey(ne)) {
        			UndirectedGraphNode a = new UndirectedGraphNode(ne.label);
        			parentNew.neighbors.add(a);
    				children.add(ne);
    				map.put(ne, a);
    			} else {
    				parentNew.neighbors.add(map.get(ne));
    			}
    		}

    		if(parent.isEmpty()) {
    			parent = children;
    			children = new LinkedList<UndirectedGraphNode>();
    		}
    	}
    	return res;
    }
    
    
    Map<UndirectedGraphNode, UndirectedGraphNode> directed = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
    	if(node == null) return null;
    	if(directed.containsKey(node)) return directed.get(node);
    	UndirectedGraphNode cur = new UndirectedGraphNode(node.label);
    	directed.put(node, cur);
    	for(UndirectedGraphNode x : node.neighbors) {
    		UndirectedGraphNode cl = cloneGraph2(x);
    		cur.neighbors.add(cl);
    	}
    	return cur;
    }
    
    public static void main(String[] args) {
    	CloneGraph x = new CloneGraph();
    	
    	UndirectedGraphNode node = new UndirectedGraphNode(0);
    	node.neighbors.add(node);
    	node.neighbors.add(node);
    	
    	
    	UndirectedGraphNode copied = x.cloneGraph2(node);

    	System.out.println(node + "||" + copied);
    	System.out.println(node.hashCode() + "," + copied.hashCode());
    	
    }
    
}
