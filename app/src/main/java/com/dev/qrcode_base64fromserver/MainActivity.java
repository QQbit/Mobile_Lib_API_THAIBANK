package com.dev.qrcode_base64fromserver;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    String TAG = "MAINACTIVITY";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        try{
            OkHttpClient api = new OkHttpClient();


//            RequestBody params = new MultipartBody.Builder()
//                    .setType(MultipartBody.FORM)
//                    .addFormDataPart("","")
//                    .build();

            String JSON = "{ \n" +
                    "\t\"qrType\": \"PP\", \n" +
                    "\t\"ppType\": \"BILLERID\", \n" +
                    "\t\"ppId\": \"819215642864059\", \n" +
                    "\t\"amount\": \"500\", \n" +
                    "\t\"ref1\": \"REFERENCE1\", \n" +
                    "\t\"ref2\": \"REFERENCE2\", \n" +
                    "\t\"ref3\": \"SCB\" \n" +
                    "}";
            RequestBody body =  RequestBody.create(MediaType.parse("application/json"),JSON.toString());

            Request request = new Request.Builder()
                    .url("")
                    .addHeader("authorization","Bearer aef945e5-736f-407b-a7c9-d591c3e83047")
                    .addHeader("resourceOwnerId","l71616c5ae6b314578abd6929b713ce369")
                    .addHeader("requestUId","l71616c5ae6b314578abd6929b713ce369")
                    .post(body)
                    .build();
            Response reponseBody = api.newCall(request).execute();

            if(reponseBody.code() == 200) {
                Log.d(TAG, "onResume: " + reponseBody.body().string());
            }else{
                Log.d(TAG, "onResume: " + "HTTPCODE : "+ reponseBody.code() + "Body : " + reponseBody.body().string());
            }


        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
