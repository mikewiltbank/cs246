package wiltbank;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Wiltbank on 1/21/17.
 */
public class User {

    String name;
    @SerializedName("followers_count")
    int followers;

    /**
     * @return the User
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

}
