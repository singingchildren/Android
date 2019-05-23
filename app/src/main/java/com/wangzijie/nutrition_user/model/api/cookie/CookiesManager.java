package com.wangzijie.nutrition_user.model.api.cookie;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * cookie 处理累
 */
public class CookiesManager implements CookieJar {

    private static final PersistentCookieStore cookieStore = new PersistentCookieStore();

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if (cookies != null && cookies.size() > 0){
            for (Cookie item: cookies) {
                cookieStore.add(url, item);
            }
        }
    }

    /**
     * 清除所有cookie
     */
    public static void clearAllCookies(){
        cookieStore.removeAll();
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = cookieStore.get(url);
        return cookies;
    }

    /**
     * 清楚指定cookie
     * @param url
     * @param cookie
     * @return
     */
    public static boolean clearCookies(HttpUrl url, Cookie cookie){
        return cookieStore.remove(url,cookie);
    }
}
