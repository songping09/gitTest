package com.bwf.lgqingdan;

import android.app.Application;
import android.util.Log;

import com.bwf.lgqingdan.entity.ResponseDailyTips;
import com.bwf.lgqingdan.entity.ThingsBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;

/**
 * Created by LG on 2016/10/19.
 * Tips:
 */

public class QingdanApplication extends Application{
    public static QingdanApplication instance;
    public static ThingsBean thingsBean;
    public static ResponseDailyTips dailyTips;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Fresco.initialize(this);
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        //TbsDownloader.needDownload(getApplicationContext(), false);

        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                Log.e("apptbs", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub

            }
        };
        QbSdk.setTbsListener(new TbsListener() {
            @Override
            public void onDownloadFinish(int i) {
                Log.d("apptbs","onDownloadFinish");
            }

            @Override
            public void onInstallFinish(int i) {
                Log.d("apptbs","onInstallFinish");
            }

            @Override
            public void onDownloadProgress(int i) {
                Log.d("apptbs","onDownloadProgress:"+i);
            }
        });

        QbSdk.initX5Environment(getApplicationContext(),  cb);
    }

    /**
     * 清空图片缓存
     */
    public void clearDiskImgCaches(){
        Fresco.getImagePipeline().clearDiskCaches();
    }
}
