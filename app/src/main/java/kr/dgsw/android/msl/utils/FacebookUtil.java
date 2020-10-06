package kr.dgsw.android.msl.utils;

import com.facebook.AccessToken;
import com.facebook.Profile;


public class FacebookUtil {

    static private String name = null;

    AccessToken accessToken;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        FacebookUtil.name = name;
    }

    public boolean isLogin(){
        accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        return isLoggedIn;
    }

}
