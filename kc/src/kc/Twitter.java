package kc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
    private static final int NEWS_LIMIT = 10;
    private Map<Integer, User> userMap;
    private long counter = 0;
    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();    
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        synchronized(this) {
            userMap.putIfAbsent(userId, new User(userId));
            User user = userMap.get(userId);
            Tweet newTweet = new Tweet(userId, tweetId, this.counter);
            this.counter += 1;
            user.tweets.addFirst(newTweet);
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)) return new ArrayList<>();
        Comparator<Tweet> comp = (a,b) -> {return (int) (b.counter - a.counter);};
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>(comp);
        Map<Integer, Iterator<Tweet>> map = new HashMap<>();
        for(User followee : userMap.get(userId).followees) {
            Iterator<Tweet> iterator = followee.tweets.iterator();
            if(!iterator.hasNext()) continue;
            map.put(followee.userId, followee.tweets.iterator());
        }
        
        if(userMap.get(userId).tweets.iterator().hasNext()) map.put(userId, userMap.get(userId).tweets.iterator());
        
        List<Integer> res = new ArrayList<>();
        for(int f : map.keySet()) {
            pq.add(map.get(f).next());
        }
        while(!pq.isEmpty()) {
            Tweet newTweet = pq.poll();

            res.add(newTweet.tweetId);
            if(res.size() == NEWS_LIMIT) break;
            int uid = newTweet.userId;
            if(map.get(uid).hasNext()) pq.add(map.get(uid).next());
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followeeId).followers.add(userMap.get(followerId));
        userMap.get(followerId).followees.add(userMap.get(followeeId));
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) return;
        userMap.get(followeeId).followers.remove(userMap.get(followerId));
        userMap.get(followerId).followees.remove(userMap.get(followeeId));
    }
    
    public class Tweet {
        int tweetId;
        int userId;
        long counter;
        public Tweet(int user, int tweet, long counter) {
            tweetId = tweet;
            userId = user;
            this.counter = counter;
        }
    }
    
    public class User {
        Set<User> followers;
        Set<User> followees;
        LinkedList<Tweet> tweets;
        int userId;
        public User(int user) {
            userId = user;
            followers = new HashSet<>();
            followees = new HashSet<>();
            tweets = new LinkedList<>();
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
