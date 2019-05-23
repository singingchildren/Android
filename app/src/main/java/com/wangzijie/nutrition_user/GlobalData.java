package com.wangzijie.nutrition_user;

public class GlobalData {
    private String seniorDietitianType;
    private boolean isNutritionist = false;//是否是营养师
    private boolean isAuthentication;//如果是营养师，是否通过验证
    private boolean isOssNetworksuccess=false;//oss获取是否成功
    private String version;//应用当前版本

    private String studioInvitationCode="获取失败";//我的工作室邀请码
    private String deviceUuid;//设备id
    private String token="";//服务器会话id
    private String platform="";//第三方平台
    private String platform_udi="";//第三方平台id
    private String accessToken="";//第三方登录token
    private String hxLogId;//环信账号
    private String hxPwd;//环信密码
    private String areaId;
    private String areaName;


    private boolean isExistStudio;

    public boolean isOssNetworksuccess() {
        return isOssNetworksuccess;
    }

    public void setOssNetworksuccess(boolean ossNetworksuccess) {
        isOssNetworksuccess = ossNetworksuccess;
    }

    public String getSeniorDietitianType() {
        return seniorDietitianType;
    }

    public void setSeniorDietitianType(String seniorDietitianType) {
        this.seniorDietitianType = seniorDietitianType;
    }

    public String isVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHxLogId() {
        return hxLogId;
    }

    public void setHxLogId(String hxLogId) {
        this.hxLogId = hxLogId;
    }

    public String getHxPwd() {
        return hxPwd;
    }

    public void setHxPwd(String hxPwd) {
        this.hxPwd = hxPwd;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public boolean isAuthentication() {
        return isAuthentication;
    }

    public void setAuthentication(boolean authentication) {
        isAuthentication = authentication;
    }

    public boolean isNutritionist() {
        return isNutritionist;
    }

    public void setNutritionist(boolean nutritionist) {
        isNutritionist = nutritionist;
    }

    public String getDeviceUuid() {
        return deviceUuid;
    }

    public void setDeviceUuid(String deviceUuid) {
        this.deviceUuid = deviceUuid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public String getVersion() {
        return version;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatform_udi() {
        return platform_udi;
    }

    public void setPlatform_udi(String platform_udi) {
        this.platform_udi = platform_udi;
    }

    public boolean isExistStudio() {
        return isExistStudio;
    }
    public void setExistStudio(boolean isExistStudio) {
        this.isExistStudio=isExistStudio;
    }

    public String getStudioInvitationCode() {
        return studioInvitationCode;
    }

    public void setStudioInvitationCode(String studioInvitationCode) {
        this.studioInvitationCode = studioInvitationCode;
    }
}
