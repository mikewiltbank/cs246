package wiltbank;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TweetLoader tweetLoader = new TweetLoader();
        Map<String, BYUITweet> tweets = tweetLoader.retrieveTweetsWithHashTag("#byui");

        for(String name : tweets.keySet()) {
            BYUITweet tweet = tweets.get(name);
            System.out.println(String.format("%s (%d followers): %s",
                    name, tweet.getUser().getFollowers(), tweet.getText()));
        }

        List<String> names = new ArrayList<>(tweets.keySet());

        Collections.sort(names, (o1, o2) -> Integer.compare(tweets.get(o2).getUser().getFollowers(),
                                                            tweets.get(o1).getUser().getFollowers())
        );

        for(String name : names) {
            BYUITweet tweet = tweets.get(name);
            System.out.println(String.format("%s (%d followers): %s", name, tweet.getUser().getFollowers(), tweet.getText()));

        }


    }
}
