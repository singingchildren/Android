package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

/**
 * @author fanjiangpeng
 * 好友数据
 */
public class FriendBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 350000201306063740
         * nickname : Mary Thompson
         * tags : [{"id":53453702,"name":"Laura Rodriguez"},{"id":16410503,"name":"Elizabeth Martin"},{"id":-74628818,"name":"David Taylor"}]
         */

        private long id;
        private String nickname;
        private List<TagsBean> tags;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class TagsBean {
            /**
             * id : 53453702
             * name : Laura Rodriguez
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
