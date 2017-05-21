package com.youtry.myweixin_youtry.test;

import org.junit.Test;

import com.youtry.myweixin_youtry.pojo.Token;
import com.youtry.myweixin_youtry.pojo.WeixinUserInfo;
import com.youtry.myweixin_youtry.util.CommonUtil;

public class TokenTest {

    /**
     * 获取TOKEN的方法 ！！重要！！
     */

    // @Test
    // public void testGetToken1() throws Exception {
    // String tokenUrl =
    // "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxde94b700faa2bf44&secret=8919ff46e96695e488f497c3df5ccff1";
    // // 建立连接
    // URL url = new URL(tokenUrl);
    // HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
    //
    // // 创建SSLContext对象，并使用我们指定的信任管理器初始化
    // TrustManager[] tm = { new MyX509TrustManager() };
    // SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
    // sslContext.init(null, tm, new java.security.SecureRandom());
    // // 从上述SSLContext对象中得到SSLSocketFactory对象
    // SSLSocketFactory ssf = sslContext.getSocketFactory();
    //
    // httpUrlConn.setSSLSocketFactory(ssf);
    // httpUrlConn.setDoOutput(true);
    // httpUrlConn.setDoInput(true);
    //
    // // 设置请求方式（GET/POST）
    // httpUrlConn.setRequestMethod("GET");
    //
    // // 取得输入流
    // InputStream inputStream = httpUrlConn.getInputStream();
    // InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
    // BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    // // 读取响应内容
    // StringBuffer buffer = new StringBuffer();
    // String str = null;
    // while ((str = bufferedReader.readLine()) != null) {
    // buffer.append(str);
    // }
    // bufferedReader.close();
    // inputStreamReader.close();
    // // 释放资源
    // inputStream.close();
    // httpUrlConn.disconnect();
    // // 输出返回结果
    // System.out.println(buffer);
    // }

    // @Test
    public void testGetToken2() {
        // Token token = CommonUtil.getToken("wxde94b700faa2bf44", "8919ff46e96695e488f497c3df5ccff1"); //有趣生活
        Token token = CommonUtil.getToken("wx3c37aec02f10b164", "743e889ea363a61e4cc8c42643ce25b3"); // 测试公众号
        System.out.println("access_token:" + token.getAccessToken());
        System.out.println("expires_in:" + token.getExpiresIn());
    }

    @Test
    public void testGetToken3() {
        // 获取接口访问凭证
        // String accessToken = CommonUtil.getToken("wxde94b700faa2bf44", "8919ff46e96695e488f497c3df5ccff1").getAccessToken(); // 有趣生活
        String accessToken = CommonUtil.getToken("wx3c37aec02f10b164", "743e889ea363a61e4cc8c42643ce25b3").getAccessToken(); // 测试公众号
        /**
         * 获取用户信息
         */
        WeixinUserInfo user = CommonUtil.getUserInfo(accessToken, "ouJig1XpsaW108s6gaLxrxPyhIaE"); // 李荣的OPENID
        System.out.println("OpenID：" + user.getOpenId());
        System.out.println("关注状态：" + user.getSubscribe());
        System.out.println("关注时间：" + user.getSubscribeTime());
        System.out.println("昵称：" + user.getNickname());
        System.out.println("性别：" + user.getSex());
        System.out.println("国家：" + user.getCountry());
        System.out.println("省份：" + user.getProvince());
        System.out.println("城市：" + user.getCity());
        System.out.println("语言：" + user.getLanguage());
        System.out.println("头像：" + user.getHeadImgUrl());
    }

    /**
     * 方法名：testgetConnection</br>
     * 详述：测试是否连接</br>
     * 开发人员：souvc </br>
     * 创建时间：2015-10-5 </br>
     * @throws SQLException
     * @throws
     */
    // @Test
    // public void testgetConnection() throws SQLException {
    // DBUtility db = new DBUtility();
    // System.out.println(db.getConnection());
    // }

    // @Test
    // public void testGetToken31() {
    // Map<String, Object> token = TokenUtil.getToken();
    // System.out.println(token.get("access_token"));
    // System.out.println(token.get("expires_in"));
    // }

    // @Test
    // public void testSaveToken5() {
    // Token token = CommonUtil.getToken("appID", "appsecret");
    // TokenUtil.saveToken(token);
    // }

}