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
        log.info("授权后的回调请求处理 START OAuthServlet.doGet()");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        // TODO
        String openId = "";

        // 用户同意授权  #########  单纯 获取OPEN_ID，跳转至 约车首页。 不获取 用户基础信息
        if (!"authdeny".equals(code)) {
            // 获取网页授权access_token
            WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(APP_APP_ID, APP_APP_SECRET, code);
            // 网页授权接口访问凭证
//            String accessToken = weixinOauth2Token.getAccessToken();
            // 用户标识
            openId = weixinOauth2Token.getOpenId();
            // 获取用户信息
//            SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);

            // 设置要传递的参数
//            request.setAttribute("snsUserInfo", snsUserInfo);
//            request.setAttribute("state", state);

            log.info("授权后的回调请求处理 [### openId]:" + openId);
        }

        // 跳转到index.jsp
        // request.getRequestDispatcher("OAuthPersonInfo.jsp").forward(request, response);
        log.info("跳转至 约车首页:[.. /yueche/index?openId=" + openId + "]");
        request.getRequestDispatcher("/yueche/index?openId=" + openId).forward(request, response);

        log.info("授权后的回调请求处理 E N D OAuthServlet.doGet()");
    }
}