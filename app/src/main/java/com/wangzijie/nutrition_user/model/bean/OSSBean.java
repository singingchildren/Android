package com.wangzijie.nutrition_user.model.bean;

public class OSSBean extends BaseBean{

    /**
     * data : {"accessKeyId":"STS.NHahWpYpVeQxUYRy9aYPurcmw","accessKeySecret":"rgvAAzF3jXccpNJKtXpGjmhN5WH4oGCB9givWQtDoPx","securityToken":"CAIShwJ1q6Ft5B2yfSjIr4vUI+3EtK930pOTV3/jnTk0Vd9ZnabGlTz2IHBIfXlqBOkbvvQ/mWxU6PwelqQqFsIbFBKcMZUhscQGqYduonAB/p7b16cNrbH4M0rxYkeJ8a2/SuH9S8ynCZXJQlvYlyh17KLnfDG5JTKMOoGIjpgVBbZ+HHPPD1x8CcxROxFppeIDKHLVLozNCBPxhXfKB0ca0WgVy0EHsPvmnJ3BsEKH1QOjm7JI+76ceMb0M5NeW75kSMqw0eBMca7M7TVd8RAi9t0t3PAdqW2a54zNUwkMv0nYabbOgdRrLR5kYK8hALJDr/X6mvB+t/bai4Pt0RFJMPHfku8l0EZOqxqAAVx2Kuz5reXfK/hiQ1pq6vFfrJxOnuGDpHqLdb+lJbKQZ8rTQpiryixEZgp1JR5rejFqTN0zMFpNxeBL6DxQl/a+Fs2t2yZdo4oZ3nU38pGxN5nAE9/TYnSloUBVQ0uplW3kHeoJh5v2VO4J/6ArVd69povYZg+cUJbc5cJ/ja5K","bucketName":"jzjsclub","endpoint":"sts.aliyuncs.com"}
     * success : true
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }


    public static class DataBean {
        /**
         * accessKeyId : STS.NHahWpYpVeQxUYRy9aYPurcmw
         * accessKeySecret : rgvAAzF3jXccpNJKtXpGjmhN5WH4oGCB9givWQtDoPx
         * securityToken : CAIShwJ1q6Ft5B2yfSjIr4vUI+3EtK930pOTV3/jnTk0Vd9ZnabGlTz2IHBIfXlqBOkbvvQ/mWxU6PwelqQqFsIbFBKcMZUhscQGqYduonAB/p7b16cNrbH4M0rxYkeJ8a2/SuH9S8ynCZXJQlvYlyh17KLnfDG5JTKMOoGIjpgVBbZ+HHPPD1x8CcxROxFppeIDKHLVLozNCBPxhXfKB0ca0WgVy0EHsPvmnJ3BsEKH1QOjm7JI+76ceMb0M5NeW75kSMqw0eBMca7M7TVd8RAi9t0t3PAdqW2a54zNUwkMv0nYabbOgdRrLR5kYK8hALJDr/X6mvB+t/bai4Pt0RFJMPHfku8l0EZOqxqAAVx2Kuz5reXfK/hiQ1pq6vFfrJxOnuGDpHqLdb+lJbKQZ8rTQpiryixEZgp1JR5rejFqTN0zMFpNxeBL6DxQl/a+Fs2t2yZdo4oZ3nU38pGxN5nAE9/TYnSloUBVQ0uplW3kHeoJh5v2VO4J/6ArVd69povYZg+cUJbc5cJ/ja5K
         * bucketName : jzjsclub
         * endpoint : sts.aliyuncs.com
         */

        private String accessKeyId;
        private String accessKeySecret;
        private String securityToken;
        private String bucketName;
        private String endpoint;

        public String getAccessKeyId() {
            return accessKeyId;
        }

        public void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        public String getAccessKeySecret() {
            return accessKeySecret;
        }

        public void setAccessKeySecret(String accessKeySecret) {
            this.accessKeySecret = accessKeySecret;
        }

        public String getSecurityToken() {
            return securityToken;
        }

        public void setSecurityToken(String securityToken) {
            this.securityToken = securityToken;
        }

        public String getBucketName() {
            return bucketName;
        }

        public void setBucketName(String bucketName) {
            this.bucketName = bucketName;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }
    }
}
