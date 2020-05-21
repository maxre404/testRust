
// #[macro_use]
extern crate log;
extern crate android_logger;
// use log::{Level, Log, Metadata, Record};
use self::android_logger::{Config, FilterBuilder};
use self::log::Level;


#[no_mangle]
#[allow(non_snake_case)]
pub fn initLog(){
    android_logger::init_once(
        Config::default()
            .with_min_level(Level::Trace) // limit log level
            .with_tag("mytag") // logs will show under mytag tag
            .with_filter( // configure messages for specific crate
                          FilterBuilder::new()
                              .parse("debug,hello::crate=error")
                              .build())
    );
    error!(">>>>>>>>>>>>>>>>>>>log mod init>>>>>>>>>>>>>>>>>>>>>>>>");
}


/**
*how to set button clickListener
*https://stackoverflow.com/questions/55543649/how-to-path-c-callback-as-a-click-handler-of-a-button-in-android
*/
#[allow(non_snake_case)]
pub fn logPirnt(message: &str) {
    error!("+++++++++++++{}+++++++++++++++", message);
}
