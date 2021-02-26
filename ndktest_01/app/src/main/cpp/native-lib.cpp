#include <jni.h>
#include <string>
static char * EXTRA_SIGNATURE = "DARREN";
using namespace std;
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_ndktest_101_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_ndktest_101_SignatureUtils_signatureParams(JNIEnv *env, jclass clazz,
                                                            jstring pasd) {
const char * params = env->GetStringUTFChars(pasd,0);
string signature(params);
signature.insert(0,EXTRA_SIGNATURE);
signature = signature.substr(0,signature.length()-2);
    return env->NewStringUTF(signature.c_str());
}