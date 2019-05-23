package com.wangzijie.nutrition_user.model.bean;

import java.util.List;

/**
 * @author WangZequan
 * @time 2019/5/6 17:24
 * @describe
 */
public class MentalityTestBean extends BaseBean{

    /**
     * data : {"errorCode":0,"msg":"Success","data":[{"id":1,"question":"我长得好看吗？","answer":[{"content":"还行"},{"content":"不好看"},{"content":"好丑啊"},{"content":"美美美"}]},{"id":2,"question":"今天天气好么？","answer":[{"content":"还行"},{"content":"不好看"},{"content":"好丑啊"},{"content":"美美美"}]},{"id":3,"question":"饿了吗？","answer":[{"content":"还行"},{"content":"不好看"},{"content":"好丑啊"},{"content":"美美美"}]}]}
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
         * msg : Success
         * data : [{"id":1,"question":"我长得好看吗？","answer":[{"content":"还行"},{"content":"不好看"},{"content":"好丑啊"},{"content":"美美美"}]},{"id":2,"question":"今天天气好么？","answer":[{"content":"还行"},{"content":"不好看"},{"content":"好丑啊"},{"content":"美美美"}]},{"id":3,"question":"饿了吗？","answer":[{"content":"还行"},{"content":"不好看"},{"content":"好丑啊"},{"content":"美美美"}]}]
         */

        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 1
             * question : 我长得好看吗？
             * answer : [{"content":"还行"},{"content":"不好看"},{"content":"好丑啊"},{"content":"美美美"}]
             */

            private int id;
            private String question;
            private List<AnswerBean> answer;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getQuestion() {
                return question;
            }

            public void setQuestion(String question) {
                this.question = question;
            }

            public List<AnswerBean> getAnswer() {
                return answer;
            }

            public void setAnswer(List<AnswerBean> answer) {
                this.answer = answer;
            }

            public static class AnswerBean {
                /**
                 * content : 还行
                 */

                private String content;

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }
            }
        }
    }
}
