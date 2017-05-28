package com.youtry.myweixin_youtry.test;

import java.io.UnsupportedEncodingException;

import com.youtry.myweixin_youtry.util.CommonUtil;

public class MakeTestURL {

    /**
     * 方法名：main</br>
     * 详述：生成URL编码 </br>
     * 开发人员：souvc </br>
     * 创建时间：2016-1-4 </br>
     * 
     * @param args
     *            说明返回值含义
     * @throws 说明发生此异常的条件
     */
    public static void main(String[] args) {
        // String source = "http://youtry.applinzi.com/youtryServlet";
        String source = "http://youtry.applinzi.com/oauthServlet";
        // decode:http%3a%2f%2fyoutry.applinzi.com%2fyoutryServlet
        String source1 = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c37aec02f10b164&redirect_uri=http%3a%2f%2fyoutry.applinzi.com%2foauthServlet&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
        // decode:https%3A%2F%2Fopen.weixin.qq.com%2Fconnect%2Foauth2%2Fauthorize%3Fappid%3Dwx3c37aec02f10b164%26redirect_uri%3Dhttp%3A%2F%2Fyoutry.applinzi.com%2FyoutryServlet%26response_type%3Dcode%26scope%3Dsnsapi_base%26state%3DSTATE%23wechat_redirect
        String source2 = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c37aec02f10b164&redirect_uri=http%3a%2f%2fyoutry.applinzi.com%2foauthServlet&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        System.out.println(CommonUtil.urlEncodeUTF8(source));
    }

    /**
     * URL编码（utf-8）
     * 
     * @param source
     * @return
     */
    public static String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}