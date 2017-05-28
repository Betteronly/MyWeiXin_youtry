package com.youtry.myweixin_youtry.util;

import java.io.IOException;
import java.util.Properties;

public class AppConfigs {

    public static String APP_APP_ID = null;
    public static String APP_APP_SECRET = null;
    public static String APP_OPENID_LIR = null;

    static {
        Properties appConfigsProps = new Properties();
        try {
            appConfigsProps.load(AppConfigs.class.getClassLoader().getResourceAsStream("appConfigs.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        APP_APP_ID = appConfigsProps.getProperty("app.appId");
        APP_APP_SECRET = appConfigsProps.getProperty("app.appSecret");
        APP_OPENID_LIR = appConfigsProps.getProperty("app.openId.lir");
    }

}
