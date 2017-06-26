package airbnb;
/**
 * Two variations:
 * 1) char can be re-used
 * 2) char cannot be reused
 * 
 * question: given a dict and a board, find the path that has largest number of word in a dict
 */
// i followed the solution below, a little hard to understand at first but eventually you'll get it
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=214074
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=191416
// 小哥给的思路是double recursion，第一个function go through所有的position 如果这个position没有被visit过就call第二个function backtrack，
// backtrack function里面如果目前的prefix不是一个词，就考虑上下左右继续backtrack，如果是一个词，就call第一个function，
// 然后把这个词加到第一个function return的list里。为了加速搜索要用trie但trie写起来有点麻烦所以小哥就让写一个hashset里面有所有的prefix。时间有点久有点忘了但大概就是这样。。。
public class BoggleGame {
	
	
	
}

/**
 * 
Java: (This is the good one)
Trie+dfs
import java.util.*;

class TNode{
        TNode[] leaves;
        boolean isword;
        public TNode(){
                this.leaves=new TNode[26];
                this.isword=false;
        }
}

public class Solution {
        public static void main(String[] args){
                String[] dict={"abs","abc","dd","bb"};
                char[][] mat={{'a','b','c'},{'d','d','d'},{'b','b','d'}};
                Solution sol=new Solution();
                System.out.println(sol.findmaxPath(dict,mat));
        }
       
        private int max=0;
        private TNode root=new TNode();
       
        public int findmaxPath(String[] words, char[][] mat){
                for(int i=0;i<words.length;i++){
                        insertT(words[i]);
                }
                int range=mat.length*mat[0].length;
                HashSet<Integer> set=new HashSet<Integer>();
                for(int i=0;i<range;i++){
                        pathfind(set,this.root,mat,i,0);
                }
                return this.max;
        }
       
        public void pathfind(Set<Integer> set, TNode node, char[][] mat, int pos, int curcount){
                if(node.isword){
                        this.max=Math.max(max,curcount+1);
                        node.isword=false;
                        pathfind(set,this.root,mat,pos,curcount+1);
                        node.isword=true;
                }
                int x=pos/mat[0].length;
                int y=pos%mat[0].length;
                if(node.leaves[mat[x][y]-'a']!=null){
                        set.add(pos);
                        for(Integer connect:connected(pos,mat)){
                                if(!set.contains(connect)){
                                        pathfind(set,node.leaves[mat[x][y]-'a'],mat,connect,curcount);
                                }
                        }
                        set.remove(pos);
                }
                return;
        }
       
        public List<Integer> connected(int pos, char[][] mat){
                int m=mat.length;
                int n=mat[0].length;
                int x=pos/n;
                int y=pos%n;
                List<Integer> res=new ArrayList<Integer>();
                for(int i=-1;i<=1;i+=2){
                        if(x+i>=0&&x+i<m){
                                res.add((x+i)*n+y);
                        }
                        if(y+i>=0&&y+i<n){
                                res.add(x+y+i);
                        }
                }
                return res;
        }
       
        public void insertT(String s){
                TNode cur=this.root;
                for(int i=0;i<s.length();i++){
                        if(cur.leaves[s.charAt(i)-'a']==null){
                                 cur.leaves[s.charAt(i)-'a']=new TNode();
                        }
                        cur=cur.leaves[s.charAt(i)-'a'];
                        if(i==s.length()-1){
                                cur.isword=true;
                        }
                }
        }
}
 * 
 */



