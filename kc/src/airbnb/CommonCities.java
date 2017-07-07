package airbnb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://tinyurl.com/y7jwpjyo  1. 我有一个感兴趣的城市列表，我的朋友们每个人也有感兴趣的城市列表，如果朋友和我感兴趣的城市占总共他总城市个数的至少一半，
// 就输出他的名字，要求按照相同城市个数排序。第二问输出的名字对应相同城市名字。楼主是hashset直接暴力的，最后被问如何优化，也没时间了。
// 现在想想应该用bitset吧，不知道有没有更好的方法

// buddy list http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=218938
//  大概就是每个人都有一些想去的city，如果你想去的city和另一个人想去的city的
// 相似度高于50%的话你们就是travel buddy，叫你ouput一个list of travel buddy按相似度又高往低排序。之前地里好像也有人提到过这道题的

/*
 * 1. buddy list
followup是给了一个max值，找出你的buddy的wishlist里不在你的wishlist里的最多max个城市，
根据buddy和你的重合程度来排序

例如 你的wishlist是 a,b,c,d
buddy1 的wishlist 是 a,b,e,f, 有两个和你的一样，所以是你的buddy
buddy2 的wishlist 是 a,c,d,g, 有三个和你的一样，也是你的budy

问题是输出一个size最多为max的推荐城市列表
当size为10时，buddy1和buddy2的wishlist中不在你的wishlist中的城市都可以加入推荐中，
因为buddy2的重合度更高，所以先输出buddy2中的，所以推荐为 g,e,f
当size为2时，推荐是g,e 或 g,f
 */
public class CommonCities {
	
	// first question
	public List<Buddy> getBuddies(List<Buddy> list, Buddy self) {
		List<Buddy> res = new ArrayList<>();
		int mySize = self.favs.size();
		List<List<Buddy>> buckets = new ArrayList<>();
		for(int i = 0 ; i < mySize; i++) {
			buckets.add(new ArrayList<>());
		}
		for(Buddy buddy : list) {
			int size = buddy.favs.size();
			if(size > mySize * 2) continue;
			int counter = 0;
			for(String city : buddy.favs) {
				if(self.favs.contains(city)) counter++;
			}
			buckets.get(counter-1).add(buddy);
		}
		
		for(int i = mySize-1; i >= 0; i--) {
			List<Buddy> buddies = buckets.get(i);
			for(Buddy buddy : buddies) {
				if(buddy.favs.size() < (i+1) * 2) res.add(buddy);
			}
		}
		return res;
	}
	
	// first follow up: output all cities corresponding to the buddy. kind of trivial after first question
	// public List<String> getCommonCities(List<Buddy> list, Buddy self)
	
	// second follow up: output recommended cities that are not overlapping with your buddies and rank them based on buddy closeness
	// also trivial after first question
	// public List<String> getRecommendation(List<Buddy> list, Buddy self, int max) 
	
	public class Buddy {
		Set<String> favs = new HashSet<>();
		String name;
		public Buddy(String n) {
			name = n;
		}
	}
}
