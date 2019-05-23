package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

/**
 * 详情
 */
public class NewsData {
    /**
     * id : 1571513135336450
     * text : 很多女人都说和老公好好聊聊，其实就是和老公吵架，你越和老公吵架，老公越不会往你这边靠。
     * reply_count : 17
     * reply_list : [{"id":1571515070744578,"text":"队","user_id":59555636592,"user_name":"小银说事","user_verified":false,"user_auth_info":"","is_pgc_author":1,"author_badge":[{"url":"http://p1.pstatp.com/large/c08000f223c4bf564b9.png","open_url":"","width":78,"height":42,"url_list":[{"url":"http://p2.pstatp.com/large/c08000f223c4bf564b9.png"},{"url":"http://p3.pstatp.com/large/c08000f223c4bf564b9.png"},{"url":"http://p4.pstatp.com/large/c08000f223c4bf564b9.png"}],"uri":"large/c08000f223c4bf564b9.png"}]},{"id":1571516187533313,"text":"胸大无脑，很多时候都是女人亲自一步步把老公的心推出这个家，反而过后装作两眼茫然，一脸无辜","user_id":6362248770,"user_name":"漂泊尘","user_verified":false,"user_auth_info":"","is_pgc_author":0,"author_badge":[]},{"id":1571522212933650,"text":"我就想骂了\u2026\u2026男人要犯贱的时候女人做什么都是错的","user_id":61716324337,"user_name":"法海不懂爱173580759","user_verified":false,"user_auth_info":"","is_pgc_author":0,"author_badge":[]}]
     * digg_count : 217
     * bury_count : 0
     * create_time : 1498711715
     * score : 0.4305717647075653
     * user_id : 3634071107
     * user_name : 雨20359066
     * user_profile_image_url : http://p1.pstatp.com/thumb/2171/6003290650
     * user_verified : false
     * is_following : 0
     * is_followed : 0
     * is_blocking : 0
     * is_blocked : 0
     * is_pgc_author : 0
     * author_badge : []
     * verified_reason :
     * user_bury : 0
     * user_digg : 0
     * user_relation : 0
     * user_auth_info :
     * media_info : {"name":"","avatar_url":""}
     * platform : feifei
     */

    private long id;
    private String text;
    private int reply_count;
    private int digg_count;
    private int bury_count;
    private int create_time;
    private double score;
    private long user_id;
    private String user_name;
    private String user_profile_image_url;
    private boolean user_verified;
    private int is_following;
    private int is_followed;
    private int is_blocking;
    private int is_blocked;
    private int is_pgc_author;
    private String verified_reason;
    private int user_bury;
    private int user_digg;
    private int user_relation;
    private String user_auth_info;
    private MediaInfoBean media_info;
    private String platform;
    private List<ReplyListBean> reply_list;
    private List<?> author_badge;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getReply_count() {
        return reply_count;
    }

    public void setReply_count(int reply_count) {
        this.reply_count = reply_count;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public int getBury_count() {
        return bury_count;
    }

    public void setBury_count(int bury_count) {
        this.bury_count = bury_count;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_profile_image_url() {
        return user_profile_image_url;
    }

    public void setUser_profile_image_url(String user_profile_image_url) {
        this.user_profile_image_url = user_profile_image_url;
    }

    public boolean isUser_verified() {
        return user_verified;
    }

    public void setUser_verified(boolean user_verified) {
        this.user_verified = user_verified;
    }

    public int getIs_following() {
        return is_following;
    }

    public void setIs_following(int is_following) {
        this.is_following = is_following;
    }

    public int getIs_followed() {
        return is_followed;
    }

    public void setIs_followed(int is_followed) {
        this.is_followed = is_followed;
    }

    public int getIs_blocking() {
        return is_blocking;
    }

    public void setIs_blocking(int is_blocking) {
        this.is_blocking = is_blocking;
    }

    public int getIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(int is_blocked) {
        this.is_blocked = is_blocked;
    }

    public int getIs_pgc_author() {
        return is_pgc_author;
    }

    public void setIs_pgc_author(int is_pgc_author) {
        this.is_pgc_author = is_pgc_author;
    }

    public String getVerified_reason() {
        return verified_reason;
    }

    public void setVerified_reason(String verified_reason) {
        this.verified_reason = verified_reason;
    }

    public int getUser_bury() {
        return user_bury;
    }

    public void setUser_bury(int user_bury) {
        this.user_bury = user_bury;
    }

    public int getUser_digg() {
        return user_digg;
    }

    public void setUser_digg(int user_digg) {
        this.user_digg = user_digg;
    }

    public int getUser_relation() {
        return user_relation;
    }

    public void setUser_relation(int user_relation) {
        this.user_relation = user_relation;
    }

    public String getUser_auth_info() {
        return user_auth_info;
    }

    public void setUser_auth_info(String user_auth_info) {
        this.user_auth_info = user_auth_info;
    }

    public MediaInfoBean getMedia_info() {
        return media_info;
    }

    public void setMedia_info(MediaInfoBean media_info) {
        this.media_info = media_info;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<ReplyListBean> getReply_list() {
        return reply_list;
    }

    public void setReply_list(List<ReplyListBean> reply_list) {
        this.reply_list = reply_list;
    }

    public List<?> getAuthor_badge() {
        return author_badge;
    }

    public void setAuthor_badge(List<?> author_badge) {
        this.author_badge = author_badge;
    }

    public static class MediaInfoBean {
        /**
         * name :
         * avatar_url :
         */

        private String name;
        private String avatar_url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }
    }

    public static class ReplyListBean {
        /**
         * id : 1571515070744578
         * text : 队
         * user_id : 59555636592
         * user_name : 小银说事
         * user_verified : false
         * user_auth_info :
         * is_pgc_author : 1
         * author_badge : [{"url":"http://p1.pstatp.com/large/c08000f223c4bf564b9.png","open_url":"","width":78,"height":42,"url_list":[{"url":"http://p2.pstatp.com/large/c08000f223c4bf564b9.png"},{"url":"http://p3.pstatp.com/large/c08000f223c4bf564b9.png"},{"url":"http://p4.pstatp.com/large/c08000f223c4bf564b9.png"}],"uri":"large/c08000f223c4bf564b9.png"}]
         */

        private long id;
        private String text;
        private long user_id;
        private String user_name;
        private boolean user_verified;
        private String user_auth_info;
        private int is_pgc_author;
        private List<AuthorBadgeBean> author_badge;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }

        public String getUser_auth_info() {
            return user_auth_info;
        }

        public void setUser_auth_info(String user_auth_info) {
            this.user_auth_info = user_auth_info;
        }

        public int getIs_pgc_author() {
            return is_pgc_author;
        }

        public void setIs_pgc_author(int is_pgc_author) {
            this.is_pgc_author = is_pgc_author;
        }

        public List<AuthorBadgeBean> getAuthor_badge() {
            return author_badge;
        }

        public void setAuthor_badge(List<AuthorBadgeBean> author_badge) {
            this.author_badge = author_badge;
        }

        public static class AuthorBadgeBean {
            /**
             * url : http://p1.pstatp.com/large/c08000f223c4bf564b9.png
             * open_url :
             * width : 78
             * height : 42
             * url_list : [{"url":"http://p2.pstatp.com/large/c08000f223c4bf564b9.png"},{"url":"http://p3.pstatp.com/large/c08000f223c4bf564b9.png"},{"url":"http://p4.pstatp.com/large/c08000f223c4bf564b9.png"}]
             * uri : large/c08000f223c4bf564b9.png
             */

            private String url;
            private String open_url;
            private int width;
            private int height;
            private String uri;
            private List<UrlListBean> url_list;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getOpen_url() {
                return open_url;
            }

            public void setOpen_url(String open_url) {
                this.open_url = open_url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public List<UrlListBean> getUrl_list() {
                return url_list;
            }

            public void setUrl_list(List<UrlListBean> url_list) {
                this.url_list = url_list;
            }

            public static class UrlListBean {
                /**
                 * url : http://p2.pstatp.com/large/c08000f223c4bf564b9.png
                 */

                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
