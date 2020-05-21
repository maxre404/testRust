extern crate jni;
extern crate futures;
extern crate hyper;
extern crate tokio_core;
#[macro_use]
extern crate log;
extern crate android_logger;
use jni::JNIEnv;
use jni::objects::{JClass, JObject};
use log_utils::{initLog, logPirnt};
mod log_utils;
#[no_mangle]
#[allow(non_snake_case)]
pub extern "C" fn Java_com_example_testrust_MainActivity_startRequestFromJni(env: JNIEnv,
                                                                             _class: JClass,
                                                                             callback: JObject) {
    env.call_method(callback, "hello", "()V", &[]).unwrap();
    env.call_method(callback, "good1", "()V", &[]).unwrap();
    logPirnt("触发点击事件哦 嘿嘿")
}

#[no_mangle]
#[allow(non_snake_case)]
pub extern "C" fn Java_com_example_testrust_MainActivity_initLog(_env: JNIEnv,
                                                                 _class: JClass,) {
    initLog()
}


