package wiltbank;

import com.google.gson.Gson;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Wiltbank on 1/21/17.
 */
public class TweetLoader {

    Twitter _twitter;

    public TweetLoader() {
        configureKeys();
    }

    private void configureKeys() {
        ConfigurationBuilder cb = new ConfigurationBuilder();

        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("instructions said to hide")
                .setOAuthConsumerSecret("instructions said to hide")
                .setOAuthAccessToken("instructions said to hide")
                .setOAuthAccessTokenSecret("instructions said to hide")
                .setJSONStoreEnabled(true);

        TwitterFactory tf = new TwitterFactory(cb.build());
        _twitter = tf.getInstance();
    }

    public Map<String, BYUITweet> retrieveTweetsWithHashTag(String hashtag) {
        Map<String, BYUITweet> tweets = new TreeMap<>();
        Query query = new Query("#byui");
        QueryResult result;

        try{
            result = _twitter.search(query);
        }
        catch (TwitterException e) {
            e.printStackTrace();
            return null;
        }

        for (Status status : result.getTweets()) {
            String json = TwitterObjectFactory.getRawJSON(status);

            Gson gson = new Gson();
            BYUITweet bt = gson.fromJson(json, BYUITweet.class);

            tweets.put(bt.user.name, bt);
        }

        return tweets;
    }

}
