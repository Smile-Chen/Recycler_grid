package co.example.hp.qwe.mvp.model;

import android.util.Log;

import com.google.gson.Gson;

import co.example.hp.qwe.http.OkhtttpUtils;


/**
 * Created by hp on 2018/6/25.
 */

public class HomeModel {
    private static final String TAG = "HomeModel";
                 public void homes(final InClient inClient) {
                     String url = "http://365jia.cn/news/api3/365jia/news/headline?page=1";
                     Log.d(TAG, "getSuccess: hhhhhhhhhhhh=========="+url);
                     OkhtttpUtils.getInstance().doGet(url, new OkhtttpUtils.OkCallback() {
                         @Override
                         public void onFailure(Exception e) {
                         }
                         @Override
                         public void onResponse(String json) {
                             Log.d(TAG, "onResponse: "+json);
                             Gson gson = new Gson();
                             HomeBean homeBean = gson.fromJson(json, HomeBean.class);
                             int code = homeBean.getCode();
                             if (0==code){
                                 if (inClient!=null){
                                     inClient.getSuccess(homeBean);
                                 }
                             }else {
                             inClient.getError("失败了");
                             }


                         }
                        });
                 }

                 //创建接口
              public interface InClient{
                     void getSuccess(HomeBean homeBean);
                     void getError(String error);

                 }



}
