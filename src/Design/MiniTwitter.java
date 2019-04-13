package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Definition of Tweet:
 * public class Tweet {
 * public int id;
 * public int user_id;
 * public String text;
 * public static Tweet create(int user_id, String tweet_text) {
 * // This will create a new tweet object,
 * // and auto fill id
 * }
 * }
 */


public class MiniTwitter {

    private final List<Tweet> tweets;

    private final Map<Integer, Set<Integer>> map;

    public MiniTwitter() {
        tweets = new ArrayList<>();
        map = new HashMap<>();
    }

    /*
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */
    public Tweet postTweet(int user_id, String tweet_text) {
        Tweet tweet = Tweet.create(user_id, tweet_text);
        tweets.add(tweet);
        return tweet;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
        List<Tweet> res = new ArrayList<>();
        int cnt = 0;
        for (int i = tweets.size(); i > -1; i--) {
            Tweet tweet = tweets.get(i);
            if (tweet.user_id == user_id || map.get(user_id).contains(tweet.user_id)) {
                res.add(tweet);
            }
            if (++cnt == 10) {
                break;
            }
        }
        return res;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
        List<Tweet> res = new ArrayList<>();
        int cnt = 0;
        for (int i = tweets.size(); i > -1; i--) {
            Tweet tweet = tweets.get(i);
            if (tweet.user_id == user_id) {
                res.add(tweet);
            }
            if (++cnt == 10) {
                break;
            }
        }
        return res;
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        map.putIfAbsent(from_user_id, new HashSet<>());
        map.get(from_user_id).add(to_user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        map.get(from_user_id).remove(to_user_id);
        if (map.get(from_user_id).size() == 0) {
            map.remove(from_user_id);
        }
    }
}

class Tweet {


    private static Integer tweetId;

    int user_id;

    private int id;

    private String text;

    static Tweet create(int user_id, String tweet_text) {
        // This will create a new tweet object,
        // and auto fill id
        Tweet tweet = new Tweet();
        tweet.id = tweetId++;
        tweet.user_id = user_id;
        tweet.text = tweet_text;
        return tweet;
    }

}
