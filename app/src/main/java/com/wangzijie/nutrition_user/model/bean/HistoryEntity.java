package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

/**
 * 病例历史记录
 *
 * @author fanjiangpeng
 */
public class HistoryEntity  extends  BaseBean{

    /**
     * errorCode : 0
     * masg : Success
     * data : {"cases":[{"id":1,"content":"今天康复了","img_url":[{"url":"http://jzjscljub.com"},{"url":"http://jzjscljub.com"},{"url":"http://jzjscljub.com"}],"createdAt":"2019-11-11"},{"id":2,"content":"今天康复了","img_url":[{"url":"http://jzjscljub.com"},{"url":"http://jzjscljub.com"},{"url":"http://jzjscljub.com"}],"createdAt":"2019-11-10"}],"netxPage":true}
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
         * cases : [{"id":1,"content":"今天康复了","img_url":[{"url":"http://jzjscljub.com"},{"url":"http://jzjscljub.com"},{"url":"http://jzjscljub.com"}],"createdAt":"2019-11-11"},{"id":2,"content":"今天康复了","img_url":[{"url":"http://jzjscljub.com"},{"url":"http://jzjscljub.com"},{"url":"http://jzjscljub.com"}],"createdAt":"2019-11-10"}]
         * netxPage : true
         */

        private boolean netxPage;
        private List<CasesBean> cases;
        public boolean isNetxPage() {
            return netxPage;
        }

        public void setNetxPage(boolean netxPage) {
            this.netxPage = netxPage;
        }

        public List<CasesBean> getCases() {
            return cases;
        }

        public void setCases(List<CasesBean> cases) {
            this.cases = cases;
        }

        public static class CasesBean {
            /**
             * id : 1
             * content : 今天康复了
             * img_url : [{"url":"http://jzjscljub.com"},{"url":"http://jzjscljub.com"},{"url":"http://jzjscljub.com"}]
             * createdAt : 2019-11-11
             */

            private int id;
            private String content;
            private String createdAt;
            private List<String > img_url;

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

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public List<String > getImg_url() {
                return img_url;
            }

            public void setImg_url(List<String> img_url) {
                this.img_url = img_url;
            }


        }
    }
}
