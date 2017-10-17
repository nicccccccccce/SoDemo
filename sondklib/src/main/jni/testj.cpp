#include <jni.h>
#include <com_eshi_bridge_sondklib_TestNdk.h>

jobject m_object;
jmethodID m_mid;
jfieldID m_fid;

JNIEXPORT jint JNICALL Java_com_eshi_bridge_sondklib_TestNdk_getStringFromNative
        (JNIEnv *env, jclass cls) {
    return 1;
}
JNIEXPORT jint JNICALL Java_com_eshi_bridge_sondklib_TestNdk_isB
        (JNIEnv *env, jclass cls, jboolean boo) {
    return 2;
}
JNIEXPORT void JNICALL Java_com_eshi_bridge_sondklib_TestNdk_setUp
        (JNIEnv *env, jobject thiz) {
    jclass clazz = (*env).GetObjectClass(thiz);//获取该对象的类
    m_object = (*env).NewGlobalRef(thiz);//创建对象的本地变量
    m_mid =(*env).GetMethodID(clazz, "notifyFiledChange", "()V");//获取JAVA方法的ID
    m_fid = (*env).GetFieldID(clazz,"a","I");//获取java变量的ID
    return;
}

JNIEXPORT void JNICALL Java_com_eshi_bridge_sondklib_TestNdk_setA
        (JNIEnv *env, jobject thiz,jint i) {
    (*env).SetIntField( m_object, m_fid,i);
    (*env).CallVoidMethod(m_object,m_mid);
    return;
}