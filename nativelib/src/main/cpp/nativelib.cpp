#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_nativelib_NativeLib_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_nativelib_CPlusCallToJava_intFromJNI(JNIEnv *env, jobject thiz) {
    // TODO: implement intFromJNI()
    return 100;
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_nativelib_CPlusCallToJava_testCPlusCallJava1(JNIEnv *env, jobject thiz) {
    // TODO: implement testCPlusCallJava1()
    if (env == nullptr || thiz == nullptr) {
        return -1;
    }
    jmethodID notification_method = env->GetMethodID(env->GetObjectClass(thiz),
                                                     "showCPlusMessage", "(Ljava/lang/String;)V");
    std::string hello = "Calling from C++";
    env->CallVoidMethod(thiz, notification_method, env->NewStringUTF(hello.c_str()));
    return 0;
}
extern "C"
JNIEXPORT void JNICALL
Java_com_example_nativelib_CPlusCallToJava_testVoidMethod(JNIEnv *env, jobject thiz) {
    // TODO: implement testVoidMethod()
    if (env == nullptr || thiz == nullptr) {
        return;
    }
    jmethodID notification_method = env->GetMethodID(env->GetObjectClass(thiz),
                                                     "testVoidMethod", "(Ljava/lang/String;)V");
    std::string hello = "Test void Method";
    env->CallVoidMethod(thiz, notification_method, env->NewStringUTF(hello.c_str()));
}