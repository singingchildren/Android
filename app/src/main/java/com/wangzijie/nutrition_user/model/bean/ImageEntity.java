package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

/**
 * 图片实体类
 * @author fanjiangpeng
 * @date
 *
 */
public class ImageEntity {
    /**
     * url : http://p3.pstatp.com/list/300x196/2c23000095ae9f56b15f.webp
     * width : 700
     * url_list : [{"url":"http://p3.pstatp.com/list/300x196/2c23000095ae9f56b15f.webp"},{"url":"http://pb9.pstatp.com/list/300x196/2c23000095ae9f56b15f.webp"},{"url":"http://pb1.pstatp.com/list/300x196/2c23000095ae9f56b15f.webp"}]
     * uri : list/2c23000095ae9f56b15f
     * height : 393
     */

    public String url;
    public int width;
    public String uri;
    public int height;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<UrlListBeanX> getUrl_list() {
        return url_list;
    }

    public void setUrl_list(List<UrlListBeanX> url_list) {
        this.url_list = url_list;
    }

    public List<UrlListBeanX> url_list;

    public static class UrlListBeanX {
        /**
         * url : http://p3.pstatp.com/list/300x196/2c23000095ae9f56b15f.webp
         */

        public String url;
    }
}
