package airbnb;
/**
 * https://tinyurl.com/ya5vwk2r
详细说一下题目：
给的map是这个样子的
   A   B   C  D
A AC CD D  B
B B   C   A  CD
C A   C   D  B
D BC D   A  C

i,j 以为着左孩子是i，右孩子是j的时候，父亲结点的可能值

然后给定最低层的叶子结点 A B C D

那么倒数第二层就只可能是  D A B 和 C A B 两种，因为A B -> CD

CYK algorithm
https://users.cs.duke.edu/~ola/courses/cps149/problems/week2/trellis.html
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=224107  记忆化搜索
 */

public class ParentChildrenTree {

}
