package com.example.testrust;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    // Used to load the 'rust' library on application startup.
    static {
        System.loadLibrary("rust");
//        System.loadLibrary("rust");
    }

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv1);
        initLog();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRequestFromJni(MainActivity.this);
            }
        });
    }
    /**
     * A native method that is implemented by the 'rust' native library,
     * which is packaged with this application.
     */
    private static native void startRequestFromJni(MainActivity callback);



    private static native void initLog();

    public void appendToTextView(String string) {
        textView.append(string + "\n");
    }

    public void hello() {
        Log.d(TAG, "Looks like it works");
    }
    public void good(){
        Log.d(TAG,"hhh+=++++++++++++++good+++++++++++++++");
    }
    public void good1(){
        Log.d(TAG,"h部编版宝贝宝贝宝贝宝贝+=++++++++++++++good+++++++++++++++");
    }

    /**
     * let url = "http://echo.jsontest.com/title/ipsum/content/blah".parse::<hyper::Uri>().unwrap();
     *     let mut core = tokio_core::reactor::Core::new().unwrap();
     *     let handle = core.handle();
     *     let client = Client::new(&handle);
     *
     *     let work = client.get(url).and_then(|res| {
     *
     *         res.body().fold(Vec::new(), |mut v, chunk| {
     *                         v.extend(&chunk[..]);
     *                         future::ok::<_, Error>(v)
     *                     }).and_then(|chunks| {
     *                         let s = String::from_utf8(chunks).unwrap();
     *
     *                         let response = env.new_string(&s)
     *                                         .expect("Couldn't create java string!");
     *                         env.call_method(callback, "appendToTextView", "(Ljava/lang/String;)V",
     *                         &[JValue::from(JObject::from(response))]).unwrap();
     *
     *
     *                         future::ok::<_, Error>(s)
     *                     })
     *     });
     *     let _ = core.run(work).unwrap();
     */



}
