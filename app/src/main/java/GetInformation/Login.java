package GetInformation;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import entity.Check_username;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Login {

    public String Create_check_uesrname(Check_username checkUesrname, String url){       //检查创建的用户名是否重复，true为不重复，false为重复
        String result_json;
        OkHttpClient okHttpClient=new OkHttpClient();
        RequestBody requestBody=new FormBody.Builder()
                .add("username",checkUesrname.getUsername())
                .add("petname",checkUesrname.getPetname())
                .add("password",checkUesrname.getUserpassword())
                .add("database","userinfo")
                .add("table","user-info")
                .build();
        Request request=new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        try {
            Response response=okHttpClient.newCall(request).execute();
            if(response.isSuccessful()){
                result_json=response.body().string();
                Gson gson=new Gson();
                Check_username check_uesrname=gson.fromJson(result_json, Check_username.class);
                return check_uesrname.getChecked();
            }
        } catch (IOException e) {
            Log.d("check_username","获取数据失败");
            e.printStackTrace();
            return "网络无法连接";
        }
        return "未知错误";
    }
    public String login(String username,String password,String url){
        OkHttpClient okHttpClient=new OkHttpClient();
        RequestBody requestBody=new FormBody.Builder()
                .add("username",username)
                .add("password",password)
                .add("database","userinfo")
                .add("table","user-info")
                .build();
        Request request=new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        try {
            Response response=okHttpClient.newCall(request).execute();
            if(response.isSuccessful()){
                String result_json=response.body().string();
                Gson gson=new Gson();
                Check_username check_username=gson.fromJson(result_json,Check_username.class);
                return check_username.getChecked();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "网络错误";
        }
        return "网络错误";
    }
}
