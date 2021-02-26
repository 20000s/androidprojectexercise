#include <jni.h>
#include <string>

using namespace std;

}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_antidebug_idaport_libget_aaa(JNIEnv *env, jclass clazz) {
    // TODO: implement aaa()

    string ad = "helloc ok c++";
    return env->NewStringUTF(ad.c_str());

}

void antiida(){

}