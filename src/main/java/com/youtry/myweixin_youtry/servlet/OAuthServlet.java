package com.youtry.myweixin_youtry.servlet;

import static com.youtry.myweixin_youtry.util.AppConfigs.APP_APP_ID;
import static com.youtry.myweixin_youtry.util.AppConfigs.APP_APP_SECRET;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.youtry.myweixin_youtry.pojo.SNSUserInfo;
import com.youtry.myweixin_youtry.pojo.WeixinOauth2Token;
import com.youtry.myweixin_youtry.util.AdvancedUtil;

/**
 * 类名: OAuthServlet </br>
 * 描述: 授权后的回调请求处理 </br>
 * 开发人员： souvc </br>
 * 创建时间： 2015-11-27 </br>
 * 发布版本：V1.0 </br>
 */
public class OAuthServlet extends HttpServlet {
    private static final long serialVersionUID = -1847238807216447030L;

    private static Logger log = LoggerFactory.getLogger(OAuthServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        log.info("request:[" + request.toString() + "]");
        System.out.println("request:[" + request.toString() + "]");

        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        String state = request.getParameter("state");

        // 用户同意授权
        if (!"authdeny".equals(code)) {
            // 获取网页授权access_token
            WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(APP_APP_ID, APP_APP_SECRET, code);
            // 网页授权接口访问凭证
            String accessToken = weixinOauth2Token.getAccessToken();
            // 用户标识
            String openId = weixinOauth2Token.getOpenId();
            // 获取用户信息
            SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);

            // 设置要传递的参数
            request.setAttribute("snsUserInfo", snsUserInfo);
            request.setAttribute("state", state);
        }
        // 跳转到index.jsp
        request.getRequestDispatcher("OAuthPersonInfo.jsp").forward(request, response);
    }
}