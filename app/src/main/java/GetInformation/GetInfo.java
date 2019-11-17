package GetInformation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import entity.InFormationItem;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GetInfo {
    public String GetJson(final String url,RequestBody requestBody){
        String result_json = null;
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        try {
            Response response=okHttpClient.newCall(request).execute();
            if(response.isSuccessful()){
                result_json =response.body().string();
            }
        } catch (IOException e) {
            Log.d("io err","获取服务端数据错误");
            e.printStackTrace();
        }
        return result_json;
    }
    public String GetItemlength(String string){
        //获取返回json数据中的长度，用于初始化InFormationItem对象
        String lenght=null;
        try {
            JSONArray jsonArray=new JSONArray(string);
            JSONObject jsonObject=jsonArray.getJSONObject(0);
            lenght=jsonObject.getString("length");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lenght;
    }
    public Bitmap getBitmap(String path) throws IOException {
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                InputStream inputStream = conn.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public InFormationItem toInFormationItem(String json){
        Gson gson=new Gson();
        InFormationItem ifi=new InFormationItem();
        ifi=gson.fromJson(json,InFormationItem.class);
        return ifi;
    }
}
