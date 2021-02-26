#include <jni.h>
#include <string>
using namespace std;
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_test1_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_test1_MainActivity_jni1(JNIEnv *env, jobject thiz) {
    string a = "asdfdsfsd";
            return env->NewStringUTF(a.c_str());
}extern "C"
JNIEXPORT jboolean JNICALL
Java_com_example_test1_sign_m1(JNIEnv *env, jobject thiz, jstring a, jstring b) {
    return a==b;
}