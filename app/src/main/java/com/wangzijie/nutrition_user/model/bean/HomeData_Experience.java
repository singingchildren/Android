package com.wangzijie.nutrition_user.model.bean;

import java.util.ArrayList;

/**
 * 首页健康乐园
 */
public class HomeData_Experience {

    private ArrayList<Data> experienceList = new ArrayList<>();

    public ArrayList<Data> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(ArrayList<Data> experienceList) {
        this.experienceList = experienceList;
    }

    public class Data {
        private String title;
        private int image;
        private String imageURL;
        private String imagePath;
        private String read;
        private String transmit;
        private String jumpLink;


        public Data(String title, String imageURL, String imagePath, String read,
                    String transmit,String jumpLink) {
            this.title = title;
            this.imageURL = imageURL;
            this.imagePath = imagePath;
            this.read = read;
            this.transmit = transmit;
            this. jumpLink= jumpLink;
        }

        public Data(String title, String imageURL, String read, String transmit,
                    String jumpLink) {
            this.title = title;
            this.imageURL = imageURL;
            this.read = read;
            this.transmit = transmit;
            this. jumpLink= jumpLink;
        }

        public Data() {
            super();
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getImageURL() {
            return imageURL;
        }

        public void setImageURL(String imageURL) {
            this.imageURL = imageURL;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public String getRead() {
            return read;
        }

        public void setRead(String read) {
            this.read = read;
        }

        public String getTransmit() {
            return transmit;
        }

        public void setTransmit(String transmit) {
            this.transmit = transmit;
        }

        public String getJumpLink() {
            return jumpLink;
        }

        public void setJumpLink(String jumpLink) {
            this.jumpLink = jumpLink;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "title='" + title + '\'' +
                    ", imageURL='" + imageURL + '\'' +
                    ", imagePath='" + imagePath + '\'' +
                    ", read=" + read +
                    ", transmit=" + transmit +
                    ", jumpLink='" + jumpLink + '\'' +
                    '}';
        }
    }





}
