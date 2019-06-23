package Design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Twitter {

    static int time = 0;

    Map<Integer, User> users;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        users = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId, new HashSet<>(), new Tweet(null, time++, tweetId)));
            return;
        }

        Tweet tweet = users.get(userId).tweet;
        while (tweet.next != null) tweet = tweet.next;
        tweet.next = new Tweet(null, time++, tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> res = new LinkedList<>();
        if (!users.containsKey(userId)) return res;

        return null;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId))
            users.put(followeeId, new User(followerId, new HashSet<>(), null));
        if (!users.containsKey(followeeId))
            users.put(followeeId, new User(followeeId, new HashSet<>(), null));
        users.get(followeeId).followedBy(followerId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId) || !users.containsKey(followeeId))
            return;
        users.get(followeeId).unfollowedBy(followerId);
    }

    private class User {
        int id;

        Set<Integer> followers;

        Tweet tweet;

        public User(int id, Set<Integer> followers, Tweet tweet) {
            this.id = id;
            this.followers = followers;
            this.tweet = tweet;
        }

        public void followedBy(int id) {
            followers.add(id);
        }

        public void unfollowedBy(int id) {
            followers.remove(id);
        }
    }

    private class Tweet {
        Tweet next;

        int time;

        int id;

        public Tweet(Tweet next, int time, int id) {
            this.next = next;
            this.time = time;
            this.id = id;
        }
    }
}
