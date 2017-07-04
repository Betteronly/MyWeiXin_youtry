package com.youtry.myweixin_youtry.util;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.IOException;
import java.util.Properties;

public class AppConfigs {

    public static String APP_URL = null;
    public static String APP_APP_ID = null;
    public static String APP_APP_SECRET = null;
    public static String APP_OPENID_LIR = null;


    public static String APP_SMS_ENDPOINT = null;
    public static String APP_SMS_ACCESSKEYID = null;
    public static String APPAPP_SMS_SECRETACCESSKY = null;
    public static String APP_SMS_INVOKEID = null;
    public static String APP_SMS_PHONENUMBER = null;
    public static String APP_SMS_TEMPLATECODE = null;

    static {
        Properties appConfigsProps = new Properties();
        try {
            appConfigsProps.load(AppConfigs.class.getClassLoader().getResourceAsStream("appConfigs.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        APP_URL = appConfigsProps.getProperty("app.url");
        APP_APP_ID = appConfigsProps.getProperty("app.appId");
        APP_APP_SECRET = appConfigsProps.getProperty("app.appSecret");
        APP_OPENID_LIR = appConfigsProps.getProperty("app.openId.lir");


        // #SMS服务域名，可根据环境选择具体域名
        APP_SMS_ENDPOINT = appConfigsProps.getProperty("app.sms.endPoint");
        // #发送账号安全认证的Access Key ID
        APP_SMS_ACCESSKEYID = appConfigsProps.getProperty("app.sms.accessKeyId");
        // #发送账号安全认证的Secret Access Key
        APPAPP_SMS_SECRETACCESSKY = appConfigsProps.getProperty("app.sms.secretAccessKy");
        // #发送使用签名的调用ID
        APP_SMS_INVOKEID = appConfigsProps.getProperty("app.sms.invokeId");
        // #客服电话
        APP_SMS_PHONENUMBER = appConfigsProps.getProperty("app.sms.phoneNumber");
        // #本次发送使用的模板Code “您的订单已生成，订单号是${code}”
        APP_SMS_TEMPLATECODE = appConfigsProps.getProperty("app.sms.templateCode");
    }

}
