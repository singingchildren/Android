package com.wangzijie.nutrition_user.model.bean.find;


import com.wangzijie.nutrition_user.adapter.find.NewsListAdapter;

/**
 *  @author     WangZequan
 *  @time       2019/4/20  19:10
 *  @describe   发现中推荐列表数据用到的bean对象
 */
public class NewsListBean {

    /**
     * 新闻类型,总共有四种
     * @see NewsListAdapter
     */
    private int newsType;

    private int newsId;//新闻id
    private String title;//新闻标题
    private long create_time;//新闻创建的时间
    private String comment;//评论数
    private String Author;//作者


    public int getNewsId() {
        return newsId;
    }

    public void setid(int newsId) {
        this.newsId = newsId;
    }

    public int getNewsType() {
        return newsType;
    }

    public void setNewsType(int newsType) {
        this.newsType = newsType;
    }

    public NewsListBean(int newsType) {
        this.newsType = newsType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

}
