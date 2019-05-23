package com.wangzijie.nutrition_user.presenter;


import com.wangzijie.nutrition_user.base.contract.BasePresenter;
import com.wangzijie.nutrition_user.contract.PointReplyContact;
import com.wangzijie.nutrition_user.model.api.ApiStore;
import com.wangzijie.nutrition_user.model.bean.BaseBean;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class PointReplyPresenter extends BasePresenter<PointReplyContact.View> implements PointReplyContact.Pre{

    private PointReplyContact.View view;
    public PointReplyPresenter(PointReplyContact.View view){
        this.view = view;
    }

    /**
     * 评论主文章的评论
     * @param blogId
     * @param userId
     * @param content
     * @return
     */
    public String replyPL(int blogId,int userId, String content){
        String url=null;

        try {
            JSONObject body = new JSONObject();
            body.put("blogId",blogId);
            body.put("userId",userId);
            body.put("content",content);
            body.put("type","comment");
            url=body.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return url;
    }

    /**
     * 楼中楼回复
     * @param blogId
     * @param userId
     * @param pid
     * @param replyId
     * @param content
     * @return
     */
    public String NoreplyPL(int blogId,int userId,int pid,int replyId,String content){
        String url=null;

        try {
            JSONObject body = new JSONObject();
            body.put("blogId",blogId);
            body.put("userId",userId);
            body.put("pid",pid);
            body.put("replyId",replyId);
            body.put("content",content);
            body.put("type","comment");
            url=body.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return url;
    }

    /**
     * 楼中楼点赞
     * @param blogId
     * @param userId
     * @param pid
     * @param replyId
     * @param flag
     * @return
     */
    public String NoreplyZ(int blogId,int userId,int pid,int replyId,int flag){
        String url=null;

        try {
            JSONObject body = new JSONObject();
            body.put("blogId",blogId);
            body.put("userId",userId);
            body.put("pid",pid);
            body.put("replyId",replyId);
            body.put("flag",flag);
            body.put("type","agree");
            url=body.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return url;
    }

    /**
     * 主文章点赞收藏
     * @param blogId
     * @param userId
     * @param flag
     * @param type
     * @return
     */
    public String replyZS(int blogId,int userId, int flag,int type){
        String url=null;

        try {
            JSONObject body = new JSONObject();
            body.put("blogId",blogId);
            body.put("userId",userId);
            body.put("flag",flag);
            if (type == 1){//点赞
                body.put("type","agree");
            }else {//收藏
                body.put("type","private");
            }
            url=body.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return url;
    }

    /**
     * 文章评论的点赞
     * @param blogId
     * @param userId
     * @param pid
     * @return
     */
    public String noReplyDZ(int blogId,int userId,int pid,int flag){
        String url=null;

        try {
            JSONObject body = new JSONObject();
            body.put("blogId",blogId);
            body.put("userId",userId);
            body.put("pid",pid);
            body.put("flag",flag);
            body.put("type","agree");
            url=body.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return url;
    }


    @Override
    public void putPointReply(int blogId, int userId, int pid,boolean isReply, int replyId, String content, int flag, int typeId) {
        String bodyS = "";
        if (isReply){//文章
            /**
             * 点赞/收藏
             */
            if (typeId == 1 || typeId == 2){
                bodyS = replyZS(blogId,userId,flag,typeId);
                /**
                 *
                 */
            }else if (typeId == 3){
                bodyS = replyPL(blogId,userId,content);
            }
        }else {//文章评论点赞
            if (typeId ==1){
                bodyS =  noReplyDZ(blogId,userId,pid,flag);
            }
        }



        RequestBody body = (RequestBody) RequestBody.create(MediaType.parse("/api/operation"),bodyS);
        ApiStore.getService()
                .pointReply(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean newPassData) {
                        if (newPassData.isSuccess()){
//                            view.Suess(isReply,typeId,flag,newPassData.getData().);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.Err(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void putWzPointReply(int blogId, int userId, int pid, boolean isReply, int replyId, String content, int flag, int typeId) {
        String bodyS = "";
        if (typeId ==1){
            bodyS = NoreplyZ(blogId,userId,pid,replyId,flag);
        }else {
            bodyS = NoreplyPL(blogId,userId,pid,replyId,content);
        }
        RequestBody body = (RequestBody) RequestBody.create(MediaType.parse("api/operation"),bodyS);
        ApiStore.getService()
                .pointReply(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean newPassData) {
                        if (newPassData.isSuccess()){
//                            view.Suess(isReply,typeId,flag,newPassData.getData().);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.Err(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}