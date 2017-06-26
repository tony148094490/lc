package airbnb;

import java.util.List;
// https://tinyurl.com/yaczkyu4
// 她要求除了最后一页，每一页都要满。即使有相同id，还有就是比如说有5个id都是1，最后结果有3页，他希望第一页一个1，后面两页都两个1，而不是113
// don't modify input
//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=197945&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3086%5D%5Bvalue%5D%3D6%26searchoption%5B3086%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D37%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
/**
 * 
/*
Host Crowding

You’re given an array of CSV strings representing search results. Results are sorted
by a score initially. A given host may have several listings that show up in these results.
Suppose we want to show 12 results per page, but we don’t want the same host to dominate
the results. Write a function that will reorder the list so that a host shows up at most
once on a page if possible, but otherwise preserves the ordering. Your program should return 
the new array and print out the results in blocks representing the pages.

Input:
*  An array of csv strings, with sort score
*  number of results per page

class Solution {
  public static void main(String [] args) {
    int PER_PAGE = 12;

    ArrayList<String> input = new ArrayList<String>();
    input.add("host_id,listing_id,score,city");
    input.add("1,28,300.1,San Francisco");
    input.add("4,5,209.1,San Francisco");
    input.add("20,7,208.1,San Francisco");
    input.add("23,8,207.1,San Francisco");
    input.add("16,10,206.1,Oakland");
    input.add("1,16,205.1,San Francisco");
    input.add("6,29,204.1,San Francisco");
    input.add("7,20,203.1,San Francisco");
    input.add("8,21,202.1,San Francisco");
    input.add("2,18,201.1,San Francisco");
    input.add("2,30,200.1,San Francisco");
    input.add("15,27,109.1,Oakland");
    input.add("10,13,108.1,Oakland");
    input.add("11,26,107.1,Oakland");
    input.add("12,9,106.1,Oakland");
    input.add("13,1,105.1,Oakland");
    input.add("22,17,104.1,Oakland");
    input.add("1,2,103.1,Oakland");
    input.add("28,24,102.1,Oakland");
    input.add("18,14,11.1,San Jose");
    input.add("6,25,10.1,Oakland");
    input.add("19,15,9.1,San Jose");
    input.add("3,19,8.1,San Jose");
    input.add("3,11,7.1,Oakland");
    input.add("27,12,6.1,Oakland");
    input.add("1,3,5.1,Oakland");
    input.add("25,4,4.1,San Jose");
    input.add("5,6,3.1,San Jose");
    input.add("29,22,2.1,San Jose");
    input.add("30,23,1.1,San Jose");
  }
 *
 * 比方说input是 1231111222，每页5个
   那么第一页是12311而不是12312
   第二页是12122
 *
 *
 */
public class PagePaginationListings {
	public List<List<String>> getPage(List<String> page) {
		
	}
}
