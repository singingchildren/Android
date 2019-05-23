package com.wangzijie.nutrition_user.utils.oss;

/**
 * endPoint 所用的oss服务器的地址，
 * bucketName oss上的名称，
 * objectKey oss上所存储文件的名称 eg: vic/test/xxx.mp4 前半段由服务器提供，
 * 最好在请求STS的时候返回给移动端（这样后期服务器迁移也不会出现问题，），
 * 后一部分xxx 文件名自行解决，但是要保证文件名称唯一，查找使用，
 * uploadFilePath 本地存储文件的路径
 *
 * @author WangZequan
 * @time 2019/5/4 1:46
 * @describe    移动端所需服务端提的参数 STS凭证的三个参数 accessKeyId，accessKeySecret，securityToken
 */
class StsToken {

    public static String AccessKeyId;
    public static String SecretKeyId;
    public static String SecurityToken;

}
