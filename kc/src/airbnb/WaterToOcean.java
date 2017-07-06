package airbnb;
// https://tinyurl.com/ybgy4c3g
/**
* Given: An array of strings where L indicates land and W indicates water,
*   and a coordinate marking a starting point in the middle of the ocean.
*
* Challenge: Find and mark the ocean in the map by changing appropriate Ws to Os.
*   An ocean coordinate is defined to be the initial coordinate if a W, and
*   any coordinate directly adjacent to any other ocean coordinate.
*
* void findOcean(String[] map, int row, int column);
*
* String[] map = new String[]{
*  "WWWLLLW",
*  "WWLLLWW",
*  "WLLLLWW"
* };
* printMap(map);
*
* STDOUT:
* WWWLLLW
* WWLLLWW
* WLLLLWW
*
* findOcean(map, 0, 1);
*
* printMap(map);
*
* STDOUT:
* OOOLLLW
* OOLLLWW
* OLLLLWW
*/
public class WaterToOcean {
		// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=141746
		// this question was raised in mid 2015, you can actually tell skills of people increased a lot from 2015 - 2017
		// simple bfs/dfs
		public void findOcean(String[] map, int row, int column) {
			
		}
}
