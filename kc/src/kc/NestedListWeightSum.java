package kc;

import java.util.List;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
    	if(nestedList.size() == 0) return 0;
        return helper(nestedList, 1);
    }
    
    private int helper(List<NestedInteger> list, int depth) {
    	int res = 0;
    	for(NestedInteger ni : list) {
    		if(ni.isInteger()) {
    			res += ni.getInteger() * depth;
    		} else {
    			res += helper(ni.getList(), depth+1);
    		}
    	}
    	return res;
    }
}
