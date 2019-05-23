package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

public class ReplyData {

    /**
     * data : {"errorCode":0,"masg":"Success","data":{"doubleDeck":[{"id":1,"content":"张三今天中奖了啊······","nickname":"特大新闻","avatar":"http://jzjsclub.oss-cn-beijing.aliyuncs.com/demo/267H.jpg?Expires=1552641324&OSSAccessKeyId=TMP.AQGnEny-iJf5m7pnzabXQFAmRTZVQvUGCM7Ukw3rsyUOqK7Zm98jIq9eKB7QADAtAhUAvWUd7bQQu0PyleUehz_7WAujwTQCFCNCL8LkgJokzPZygaQ3xbxMsTm6&Signature=kEoxbNKa6bRf9Um0zUpEJRWlxSs%3D","agree_count":30},{"id":2,"content":"张你好天中奖了啊······","nickname":"好啦水电费","avatar":"http://jzjsclub.oss-cn-beijing.aliyuncs.com/demo/267H.jpg?Expires=1552641324&OSSAccessKeyId=TMP.AQGnEny-iJf5m7pnzabXQFAmRTZVQvUGCM7Ukw3rsyUOqK7Zm98jIq9eKB7QADAtAhUAvWUd7bQQu0PyleUehz_7WAujwTQCFCNCL8LkgJokzPZygaQ3xbxMsTm6&Signature=kEoxbNKa6bRf9Um0zUpEJRWlxSs%3D","agree_count":22}],"nextPage":true}}
     */

    private DataBeanX data;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * errorCode : 0
         * masg : Success
         * data : {"doubleDeck":[{"id":1,"content":"张三今天中奖了啊······","nickname":"特大新闻","avatar":"http://jzjsclub.oss-cn-beijing.aliyuncs.com/demo/267H.jpg?Expires=1552641324&OSSAccessKeyId=TMP.AQGnEny-iJf5m7pnzabXQFAmRTZVQvUGCM7Ukw3rsyUOqK7Zm98jIq9eKB7QADAtAhUAvWUd7bQQu0PyleUehz_7WAujwTQCFCNCL8LkgJokzPZygaQ3xbxMsTm6&Signature=kEoxbNKa6bRf9Um0zUpEJRWlxSs%3D","agree_count":30},{"id":2,"content":"张你好天中奖了啊······","nickname":"好啦水电费","avatar":"http://jzjsclub.oss-cn-beijing.aliyuncs.com/demo/267H.jpg?Expires=1552641324&OSSAccessKeyId=TMP.AQGnEny-iJf5m7pnzabXQFAmRTZVQvUGCM7Ukw3rsyUOqK7Zm98jIq9eKB7QADAtAhUAvWUd7bQQu0PyleUehz_7WAujwTQCFCNCL8LkgJokzPZygaQ3xbxMsTm6&Signature=kEoxbNKa6bRf9Um0zUpEJRWlxSs%3D","agree_count":22}],"nextPage":true}
         */

        private int errorCode;
        private String masg;
        private DataBean data;

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getMasg() {
            return masg;
        }

        public void setMasg(String masg) {
            this.masg = masg;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * doubleDeck : [{"id":1,"content":"张三今天中奖了啊······","nickname":"特大新闻","avatar":"http://jzjsclub.oss-cn-beijing.aliyuncs.com/demo/267H.jpg?Expires=1552641324&OSSAccessKeyId=TMP.AQGnEny-iJf5m7pnzabXQFAmRTZVQvUGCM7Ukw3rsyUOqK7Zm98jIq9eKB7QADAtAhUAvWUd7bQQu0PyleUehz_7WAujwTQCFCNCL8LkgJokzPZygaQ3xbxMsTm6&Signature=kEoxbNKa6bRf9Um0zUpEJRWlxSs%3D","agree_count":30},{"id":2,"content":"张你好天中奖了啊······","nickname":"好啦水电费","avatar":"http://jzjsclub.oss-cn-beijing.aliyuncs.com/demo/267H.jpg?Expires=1552641324&OSSAccessKeyId=TMP.AQGnEny-iJf5m7pnzabXQFAmRTZVQvUGCM7Ukw3rsyUOqK7Zm98jIq9eKB7QADAtAhUAvWUd7bQQu0PyleUehz_7WAujwTQCFCNCL8LkgJokzPZygaQ3xbxMsTm6&Signature=kEoxbNKa6bRf9Um0zUpEJRWlxSs%3D","agree_count":22}]
             * nextPage : true
             */

            private boolean nextPage;
            private List<DoubleDeckBean> doubleDeck;

            public boolean isNextPage() {
                return nextPage;
            }

            public void setNextPage(boolean nextPage) {
                this.nextPage = nextPage;
            }

            public List<DoubleDeckBean> getDoubleDeck() {
                return doubleDeck;
            }

            public void setDoubleDeck(List<DoubleDeckBean> doubleDeck) {
                this.doubleDeck = doubleDeck;
            }

            public static class DoubleDeckBean {
                /**
                 * id : 1
                 * content : 张三今天中奖了啊······
                 * nickname : 特大新闻
                 * avatar : http://jzjsclub.oss-cn-beijing.aliyuncs.com/demo/267H.jpg?Expires=1552641324&OSSAccessKeyId=TMP.AQGnEny-iJf5m7pnzabXQFAmRTZVQvUGCM7Ukw3rsyUOqK7Zm98jIq9eKB7QADAtAhUAvWUd7bQQu0PyleUehz_7WAujwTQCFCNCL8LkgJokzPZygaQ3xbxMsTm6&Signature=kEoxbNKa6bRf9Um0zUpEJRWlxSs%3D
                 * agree_count : 30
                 */

                private int id;
                private String content;
                private String nickname;
                private String avatar;
                private int agree_count;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public int getAgree_count() {
                    return agree_count;
                }

                public void setAgree_count(int agree_count) {
                    this.agree_count = agree_count;
                }
            }
        }
    }
}
