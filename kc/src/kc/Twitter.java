package kc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Twitter {
	int global_time = 0;
	Map<Integer, User> users;
    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<Integer, User>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(userId, global_time, tweetId);
        global_time++;
    	if(users.containsKey(userId)) {
    		users.get(userId).tweets.add(newTweet);
        } else {
        	User newUser = new User(userId);
        	newUser.tweets.add(newTweet);
        	users.put(userId, newUser);
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	if(!users.containsKey(userId)) return new ArrayList<Integer>();
    	
        User user = users.get(userId);
        List<User> followees = user.followees;
        if(followees.size() == 0) {
        	List<Integer> list = new ArrayList<Integer>();
        	for(int i = user.tweets.size() -1 ; i >= 0; i--){
        		if(list.size() == 10) break;
        		list.add(user.tweets.get(i).value);
        	}
        	return list;
        }
        
    	Comparator<Tweet> comp = new Comparator<Tweet>(){
    		public int compare(Tweet a, Tweet b) {
    			if(a.time > b.time) {
    				return -1;
    			} else if(a.time < b.time) {
    				return 1;
    			} else{
    				return 0;
    			}
    		}
    	};
    	
    	List<User> users = new ArrayList<User>();
    	Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
    	for(User us : followees) {
    		users.add(us);
    		counter.put(us.userId, us.tweets.size()-1);
    	}
    	users.add(user);
    	counter.put(user.userId, user.tweets.size()-1);
    	
    	
        PriorityQueue<Tweet> heap = new PriorityQueue<Tweet>(users.size(), comp);
        
        for(User us : users) {
        	if(us.tweets.size() != 0) {
        		heap.offer(us.tweets.get(counter.get(us.userId)));
        		counter.put(us.userId, counter.get(us.userId) -1);
        	}
        }
        
        List<Integer> res = new ArrayList<Integer>();
        
        while(!heap.isEmpty()) {
        	Tweet t = heap.poll();
        	int tUserId = t.userId;
        	if(counter.get(tUserId) >= 0) {
        		heap.offer(this.users.get(tUserId).tweets.get(counter.get(tUserId)));
        		counter.put(tUserId, counter.get(tUserId) - 1);
        	}
        	
        	res.add(t.value);        	
        	if(res.size() == 10) break;
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if(followerId == followeeId) return;
        if(!users.containsKey(followerId)) {
        	User user = new User(followerId);
        	users.put(followerId, user);
        } 
        
        if(!users.containsKey(followeeId)) {
        	User user = new User(followeeId);
        	users.put(followeeId, user);
        }
        
        User followee = users.get(followeeId);
        
        if(!users.get(followerId).followees.contains(followee))
        users.get(followerId).followees.add(users.get(followeeId));
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId) || !users.containsKey(followeeId)) {
        	return;
        }
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        
        for(User us : follower.followees) {
        	if(us == followee) {
        		follower.followees.remove(us);
        		return;
        	}
        }
    }
    
    private class Tweet {
    	Integer time;
    	Integer value;
    	Integer userId;
    	public Tweet(int userId, int time, int value) {
    		this.time = time;
    		this.value = value;
    		this.userId = userId;
    	}
    }
    
    private class User {
    	List<Tweet> tweets = new ArrayList<Tweet>();
    	List<User> followees = new ArrayList<User>();
    	Integer userId;
    	public User(int userId) {
    		this.userId = userId;
    	}
    }
    
    public static void main(String[] args) {

    	Twitter twitter = new Twitter();
    	twitter.postTweet(1, 5);
    	twitter.postTweet(1, 3);
    	twitter.postTweet(1, 101);
    	twitter.postTweet(1, 13);
    	twitter.postTweet(1, 10);
    	twitter.postTweet(1, 2);
    	twitter.postTweet(1, 94);
    	twitter.postTweet(1, 505);
    	twitter.postTweet(1, 333);
    	twitter.postTweet(1, 22);
    	twitter.postTweet(1, 11);
    	System.out.println(twitter.getNewsFeed(1));
	}
}
