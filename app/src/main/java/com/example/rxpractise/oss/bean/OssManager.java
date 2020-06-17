package com.example.rxpractise.oss.bean;

import android.content.Context;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.example.rxpractise.response.ResponseBookDownInfo;

public class OssManager {
    //DRM
    static private final String OSS_DRM_BUCKET_CN = "onyx-cloud-DRM";
    static private final String OSS_DRM_ENDPOINT_CN = "onyx-drm.oss-cn-shenzhen.aliyuncs.com";

    private Context context;

    public OssManager(Context application) {
        context = application;
    }

    private void init() {

        OSSCredentialProvider credentialProvider = new OSSStsTokenCredentialProvider("<StsToken.AccessKeyId>", "<StsToken.SecretKeyId>", "<StsToken.SecurityToken>");

        //该配置类如果不设置，会有默认配置，具体可看该类
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒
        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒
        conf.setMaxConcurrentRequest(5); // 最大并发请求数，默认5个
        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次
        OSSLog.enableLog(); //这个开启会支持写入手机sd卡中的一份日志文件位置在SDCard_path\OSSLog\logs.csv


        OSS oss = new OSSClient(context, OSS_DRM_ENDPOINT_CN, credentialProvider, conf);

    }


}
