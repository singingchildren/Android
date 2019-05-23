package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

public class CollectionBean {

    /**
     * data : {"errorCode":0,"masg":"Success","data":{"blogList":[{"id":1,"user_nickname":"张三","title":"你好........","comment_count":30,"content_id":1,"createdAt":"2019-3-12 17:21:33","imgUrl":[{"url":"http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg"}]},{"id":2,"user_nickname":"李四","title":"大家伙","comment_count":22,"content_id":2,"createdAt":"2019-3-12 17:21:33","imgUrl":[{"url":"http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg"},{"url":"http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg"},{"url":"http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg"}]},{"id":3,"user_nickname":"小红","title":"天气好","comment_count":11,"content_id":52,"createdAt":"2019-3-12 17:21:33","imgUrl":[]}],"nextPage":false}}
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
         * data : {"blogList":[{"id":1,"user_nickname":"张三","title":"你好........","comment_count":30,"content_id":1,"createdAt":"2019-3-12 17:21:33","imgUrl":[{"url":"http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg"}]},{"id":2,"user_nickname":"李四","title":"大家伙","comment_count":22,"content_id":2,"createdAt":"2019-3-12 17:21:33","imgUrl":[{"url":"http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg"},{"url":"http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg"},{"url":"http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg"}]},{"id":3,"user_nickname":"小红","title":"天气好","comment_count":11,"content_id":52,"createdAt":"2019-3-12 17:21:33","imgUrl":[]}],"nextPage":false}
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
             * blogList : [{"id":1,"user_nickname":"张三","title":"你好........","comment_count":30,"content_id":1,"createdAt":"2019-3-12 17:21:33","imgUrl":[{"url":"http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg"}]},{"id":2,"user_nickname":"李四","title":"大家伙","comment_count":22,"content_id":2,"createdAt":"2019-3-12 17:21:33","imgUrl":[{"url":"http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg"},{"url":"http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg"},{"url":"http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg"}]},{"id":3,"user_nickname":"小红","title":"天气好","comment_count":11,"content_id":52,"createdAt":"2019-3-12 17:21:33","imgUrl":[]}]
             * nextPage : false
             */

            private boolean nextPage;
            private List<BlogListBean> blogList;

            public boolean isNextPage() {
                return nextPage;
            }

            public void setNextPage(boolean nextPage) {
                this.nextPage = nextPage;
            }

            public List<BlogListBean> getBlogList() {
                return blogList;
            }

            public void setBlogList(List<BlogListBean> blogList) {
                this.blogList = blogList;
            }

            public static class BlogListBean {
                /**
                 * id : 1
                 * user_nickname : 张三
                 * title : 你好........
                 * comment_count : 30
                 * content_id : 1
                 * createdAt : 2019-3-12 17:21:33
                 * imgUrl : [{"url":"http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg"}]
                 */

                private int id;
                private String user_nickname;
                private String title;
                private int comment_count;
                private int content_id;
                private String createdAt;
                private List<ImgUrlBean> imgUrl;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getUser_nickname() {
                    return user_nickname;
                }

                public void setUser_nickname(String user_nickname) {
                    this.user_nickname = user_nickname;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getComment_count() {
                    return comment_count;
                }

                public void setComment_count(int comment_count) {
                    this.comment_count = comment_count;
                }

                public int getContent_id() {
                    return content_id;
                }

                public void setContent_id(int content_id) {
                    this.content_id = content_id;
                }

                public String getCreatedAt() {
                    return createdAt;
                }

                public void setCreatedAt(String createdAt) {
                    this.createdAt = createdAt;
                }

                public List<ImgUrlBean> getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(List<ImgUrlBean> imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public static class ImgUrlBean {
                    /**
                     * url : http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg
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
}
