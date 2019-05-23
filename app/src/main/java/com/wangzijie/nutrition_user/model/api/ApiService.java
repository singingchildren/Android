package com.wangzijie.nutrition_user.model.api;

import com.wangzijie.nutrition_user.model.bean.AstatusBean;
import com.wangzijie.nutrition_user.model.bean.BaseBean;
import com.wangzijie.nutrition_user.model.bean.DataBean;
import com.wangzijie.nutrition_user.model.bean.DietAssessmentBean;
import com.wangzijie.nutrition_user.model.bean.DieticianDetailsData;
import com.wangzijie.nutrition_user.model.bean.DietitianStudioBean;
import com.wangzijie.nutrition_user.model.bean.DocmentsBean;
import com.wangzijie.nutrition_user.model.bean.FindContent;
import com.wangzijie.nutrition_user.model.bean.FriendBean;
import com.wangzijie.nutrition_user.model.bean.HasStudioBean;
import com.wangzijie.nutrition_user.model.bean.HealthArticlesBean;
import com.wangzijie.nutrition_user.model.bean.HealthAssessmentBean;
import com.wangzijie.nutrition_user.model.bean.HealthParkBean;
import com.wangzijie.nutrition_user.model.bean.HealthPlanListBean;
import com.wangzijie.nutrition_user.model.bean.HistoryEntity;
import com.wangzijie.nutrition_user.model.bean.HomeData;
import com.wangzijie.nutrition_user.model.bean.LoginData;
import com.wangzijie.nutrition_user.model.bean.MoenyData;
import com.wangzijie.nutrition_user.model.bean.MoreNutritionBean;
import com.wangzijie.nutrition_user.model.bean.MyDietitianBean;
import com.wangzijie.nutrition_user.model.bean.MyHealthGuidePlan2Bean;
import com.wangzijie.nutrition_user.model.bean.NewPassData;
import com.wangzijie.nutrition_user.model.bean.NewsData;
import com.wangzijie.nutrition_user.model.bean.OSSBean;
import com.wangzijie.nutrition_user.model.bean.OrderBean;
import com.wangzijie.nutrition_user.model.bean.OrderListBean;
import com.wangzijie.nutrition_user.model.bean.PayResultBean;
import com.wangzijie.nutrition_user.model.bean.RecommendData;
import com.wangzijie.nutrition_user.model.bean.RegisterData;
import com.wangzijie.nutrition_user.model.bean.ReplyData;
import com.wangzijie.nutrition_user.model.bean.ReportBean;
import com.wangzijie.nutrition_user.model.bean.ServiceNeedBean;
import com.wangzijie.nutrition_user.model.bean.ShopData;
import com.wangzijie.nutrition_user.model.bean.ShopHeadData;
import com.wangzijie.nutrition_user.model.bean.SiteBean;
import com.wangzijie.nutrition_user.model.bean.StopData;
import com.wangzijie.nutrition_user.model.bean.StudioListBean;
import com.wangzijie.nutrition_user.model.bean.SuccessBean;
import com.wangzijie.nutrition_user.model.bean.UserFileListBean;
import com.wangzijie.nutrition_user.model.bean.UserInfo;
import com.wangzijie.nutrition_user.utils.Verification;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiService {
    /**
     * 访问网络 基础 url
     */
    String BASE_URL = "http://101.201.209.158:80/";
    String BASE_URL2 = "http://app.jzjsclub.com/";
//    String BASE_URL = "http://huangyong.free.idcfengye.com/";



    //注册接口
    @POST("api/user/register")
    Observable<RegisterData> register(@Body RequestBody body);

    //我的信息
    @POST("api/user/myprofile")
    Observable<UserInfo> myProfile(@Body RequestBody body);

    //高级营养师申请
    @POST("api/dietician/apply")
    Observable<BaseBean> dieticianApply(@Body RequestBody body);

    //发送验证码POST请求
    @POST("api/user/sendRegisterCode")
    Observable<Verification> postVerification(@Body RequestBody body);


    //登录接口
    @POST("api/user/login")
    Observable<LoginData> postLogin(@Body RequestBody body);


    //重置密码
    @POST("api/user/resetPwd")
    Observable<NewPassData> resetPwd(@Body RequestBody requestBody);

    //修改密码
    @POST("api/user/changePwd")
    Observable<SuccessBean> amendPwd(@Body RequestBody requestBody);


    //首页请求接口
    @POST("api/homePage")
    Observable<HomeData> getHomeData(@Body RequestBody requestBody);


    //像服务器发送城市
    @POST("api/area/dcarealist")
    Observable<SiteBean> getAreadcarealist(@Body RequestBody requestBody);


    //设置地区\区域
    @POST("api/user/bindArea")
    Observable<BaseBean> setBindArea(@Body RequestBody requestBody);


    //优秀营养师
    @POST("api/dietician/recommend")
    Observable<DataBean<MoreNutritionBean>> getRecommend(@Body RequestBody requestBody);
    //优秀营养师（定制化服务）
    @POST("api/customizationList")
    Observable<DataBean<MoreNutritionBean>> getMoreData(@Body RequestBody requestBody);


    //获取oss签名接口,异步
//    @POST("business/uploadfile/sign")
//    Observable<OSSBean> getOSS();

    //获取oss签名接口,同步
    @POST("business/uploadfile/sign")
    Call<OSSBean> getOSS();


    //我的收藏接口
    @POST("api/user/collections")
    Observable<BaseBean> getCollections(@Body RequestBody requestBody);


    //申请高级营养师的状态
    @POST("api/dietician/astatus")
    Observable<AstatusBean>  getAstatus();


    //营养师端>消息>用户档案列表
    @POST("api/dietician/mycustomerlist")
    Observable<UserFileListBean>  getMycustomerList(@Body RequestBody requestBody);


    //健康乐园菜单接口
    @POST("api/healthPark")
    Observable<HealthParkBean> getHealthPark(@Body RequestBody body);


    //营养师工作室Git请求
    @POST("api/studio")
    Observable<StudioListBean> getStudiodata(@Body RequestBody body);


    //生成订单 type annualfee（年费）, servicefee（服务费），DCSV_ID（定制化服务主键）
    @POST("api/pay/generateOrder")
    Observable<DataBean<OrderBean>> generateOrder( @Body RequestBody requestBody);

    //订单列表
    @POST("/api/user/orders")
    Observable<DataBean<OrderListBean>> orders(@Body RequestBody requestBody);

    //删除，取消订单
    @POST("/api/delOrders")
    Observable<DataBean> delOrders(@Body RequestBody requestBody);

    //去支付
    @POST("api/pay")
    Observable<DataBean<PayResultBean>> getPay(@Body RequestBody body);



    //提交个人档案信息接口
    @POST("api/user/submitDocument")
    Observable<BaseBean> submitDocument(@Body RequestBody body);


    //发现中的推荐
    @POST("api/discover/blog")
    Observable<RecommendData> getRecommendData(@Body RequestBody requestBody);


    //提交会员档案接口
    @POST("api/user/submitDocument")
    Observable<BaseBean> postPersonal(@Body RequestBody body);



    ////////////////////
    //获取我以往提交的健康评估(//diet:饮食/sleep:睡眠/sport:运动/psychology:心理)
    @POST("api/user/myHealthAssessment")
    Observable<HealthAssessmentBean> getHealthAssessment(@Body RequestBody body);


    //提交饮食评估数据
    @POST("api/user/dietAssessment")
    Observable<DietAssessmentBean> DietAssessment(@Body RequestBody requestBody);


    //获取运动评估menu
    @POST("api/sportAssess/menu")
    Observable<StopData> getStopData(@Body RequestBody requestBody);//传空对象

    //提交睡眠，运动评估数据
    @POST("api/user/submitSleepAndSportData")
    Observable<BaseBean> PutSleepAndSportData(@Body RequestBody requestBody);


    //焦虑，压力测试题目menu
    @POST("api/user/anxiousAndPressure")
    Observable<BaseBean> userAnxiousAndPressure(@Body RequestBody requestBody);

    //提交焦虑,压力测试评估数据
    @POST("api/user/submitAnxiousAndPressure")
    Observable<BaseBean> submitAnxiousAndPressure(@Body RequestBody requestBody);
    ////////////////////



    //我的报告
    @POST("api/myReport")
    Observable<ReportBean> myReport(@Body RequestBody requestBody);//服务器说要一个空的json

    //修改用户信息
    @POST("api/user/changeProfile")
    Observable<SuccessBean> changeProfile(@Body RequestBody requestBody);


    //我的营养师
    @POST("api/user/myDietitian")
    Observable<MyDietitianBean> getMyDietitian(@Body RequestBody requestBody);


    //病例
    @POST("api/user/cases/list")
    Observable<HistoryEntity> getCasesList(@Body RequestBody requestBody);


    //上传病例
    @POST("api/user/cases/add")
    Observable<BaseBean> putAddCases(@Body RequestBody requestBody);


    //我的健康指导方案 膳食
    @POST("api/user/myHealthGuidePlan")
    Observable<DataBean<HealthPlanListBean>> getMyHealthGuidePlan(@Body RequestBody  body);
    //我的健康指导方案 睡眠 运动 心理
    @POST("api/user/myHealthGuidePlan")
    Observable<MyHealthGuidePlan2Bean> getMyHealthGuidePlan2(@Body RequestBody  body);


    //营养师撰写 膳食 睡眠 运动 心理
    @POST("api/dietician/publish")
    Observable<SuccessBean> getDieticianWriteElse(@Body RequestBody body);


    //营养师详情页面
    @POST("api/dietician/{dcId}")
    Observable<DieticianDetailsData> getDetailData(@Path("dcId") String dcId);


    //查看工作室的状态
    @POST("api/dietician/hasstudio")
    Observable<HasStudioBean> getHasStudio();


    //工作室注册
    @POST("api/studio/register")
    Observable<HasStudioBean> registerStudio(@Body RequestBody body);



    //营养师详情页面
    @POST("api/user/invitationcode")
    Observable<SuccessBean> getInvitationCode(@Body RequestBody body);



    //加入营养师工作室
    @POST("api/user/studio")
    Observable<BaseBean> joinStudio(@Body RequestBody body);


    //营养师用户文档
    @POST("api/user/getdocument/{userId}")
    Observable<DocmentsBean> getDocuments(@Path("userId") String userId);


    //退出营养师工作室
    @POST("api/dietician/quitstudio")
    Observable<BaseBean> quitStudio(@Body RequestBody body);

    //会员查询服务需求
    @POST("api/user/demands")
    Observable<ServiceNeedBean> queryServiceNeed(@Body RequestBody body);

    //会员提交服务需求
    @POST("api/user/submitDemands")
    Observable<SuccessBean> submitServiceNeed(@Body RequestBody body);


    //工作室详情页面
    @POST("api/studio/content")
    Observable<DietitianStudioBean> getDietitianStudio(@Body RequestBody body);


    //营养师查询擅长领域标签
    @POST("api/dietician/demands ")
    Observable<ServiceNeedBean> queryExpertise(@Body RequestBody body);


    //营养师名片
    @POST("api/dietician/savecard")
    Observable<SuccessBean> saveMyCard(@Body RequestBody body);


    //工作室
    @POST("api/content")
    Observable<ShopData> getShopData();


    //工作室里的营养师
    @POST("api/studio/dietician/{id}")
    Observable<ShopHeadData> getShopHeadData(@Path("id") String id);



    @POST("api/studio/updatedescr")
    Observable<SuccessBean> getupdatedescr(@Body RequestBody route);




    @POST("api/healthPark/menu/0")
    Observable<HealthArticlesBean> getHealthParkMenu(@Body RequestBody route);















































    //评论页面
    @POST("api/discover/comments")
    Observable<NewsData> getNewData(@Query("blogId") int blogId, @Query("limit") int limit, @Query("page") int page);


    //回复页面
    @POST()
    Observable<ReplyData> getReplyData(@Url String url);

    //对文章评论，点赞，收藏
    @POST("api/operation")
    Observable<BaseBean> pointReply(@Body RequestBody requestBody);

    //正文页面
    @PUT
    Observable<FindContent> getFindData(@Url String url);






    //支付页面
    @POST("pay/call")
    @Headers("access-token:token")
    Observable<MoenyData> getMoneyData(@Body RequestBody requestBody, @Query("appId") String appid, @Query("type") String type, @Query("payChannle") String payChannerle);





    //健康乐园,文章正文接口
    @POST("api/healthPark/content/:contentId")
    Observable<BaseBean> healthTextPart();

    //我的好友列表
    @POST("open/im/myFriendDetail")
    Observable<FriendBean> getFriend(@Query("userId") int userId);

    //设置用户标签
    @POST("/open/im/{userId}/tags")
    Observable<String> setType(@Query("updateTags") int[] updateTags, @Query("inserTags") String[] inserTags);

    //获取当前用户设置过的标签
    @POST("/open/im/tags")
    Observable<String> getType(@Query("updateTags") String code);











}
