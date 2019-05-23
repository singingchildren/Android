#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jlongArray JNICALL
Java_com_wangzijie_nutrition_1user_utils_oss_OssServiceUtil_getMicroseconds(
        JNIEnv *env,
        jobject /* this */) {//获取微秒值的方法
    jlongArray time = env->NewLongArray(2);
    jlong temp[] = { 0, 0 };
    struct timeval begin;
    gettimeofday(&begin, NULL);
    temp[0] = begin.tv_sec;
    temp[1] = begin.tv_usec;
    env->SetLongArrayRegion(time, 0, 2, temp);
    return time;
}
