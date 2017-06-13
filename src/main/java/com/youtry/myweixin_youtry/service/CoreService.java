package com.youtry.myweixin_youtry.service;

import com.anping.yueche.pojo.UserInfo;
import com.anping.yueche.service.YuecheService;
import com.youtry.myweixin_youtry.message.resp.TextMessage;
import com.youtry.myweixin_youtry.pojo.WeixinUserInfo;
import com.youtry.myweixin_youtry.util.CommonUtil;
import com.youtry.myweixin_youtry.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

import static com.youtry.myweixin_youtry.util.AppConfigs.APP_APP_ID;
import static com.youtry.myweixin_youtry.util.AppConfigs.APP_APP_SECRET;

/**
 * 类名: CoreService </br>
 * 描述: 核心服务类 </br>
 * 开发人员： souvc </br>
 * 创建时间： 2015-9-30 </br>
 * 发布版本：V1.0 </br>
 */
@Component
public class CoreService {
    private static Logger log = LoggerFactory.getLogger(CoreService.class);

    @Autowired
    public YuecheService yuecheService;
    // 静态类注入
    private static CoreService coreService;

    // 静态类注入
    @PostConstruct
    public void init() {
        coreService = this;
        coreService.yuecheService = this.yuecheService;
    }

    /**
     * 处理微信发来的请求
     * 
     * @param request
     * @return xml
     */
    public static String processRequest(HttpServletRequest request) {
        log.info("处理微信发来的请求 开始");

        // xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent = "未知的消息类型！";
        try {
            // 调用parseXml方法解析请求消息
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            // 发送方帐号
            String fromUserName = requestMap.get("FromUserName");
            // 开发者微信号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                respContent = "您发送的是文本消息！";
            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
            }
            // 语音消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是语音消息！";
            }
            // 视频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                respContent = "您发送的是视频消息！";
            }
            // 视频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)) {
                respContent = "您发送的是小视频消息！";
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 关注
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "谢谢您的关注！";
                }
                // 取消关注
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
                }
                // 扫描带参数二维码
                else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
                    // TODO 处理扫描带参数二维码事件
                }
                // 上报地理位置
                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                    log.info("上报地理位置 openId:[" + fromUserName + "]");

                    // String accessToken = CommonUtil.getToken("wxde94b700faa2bf44", "8919ff46e96695e488f497c3df5ccff1").getAccessToken(); // 有趣生活 李荣
                    // String accessToken = CommonUtil.getToken("wx3c37aec02f10b164", "743e889ea363a61e4cc8c42643ce25b3").getAccessToken(); // 测试公众号 李荣
                    // String accessToken = CommonUtil.getToken("wx2a0cd38d56194397", "347634d8d5d8a9b82de714eaff8807b1").getAccessToken(); // 安平二手
                    String accessToken = CommonUtil.getToken(APP_APP_ID, APP_APP_SECRET).getAccessToken();
                    /**
                     * 获取用户信息
                     */
                    WeixinUserInfo user = CommonUtil.getUserInfo(accessToken, fromUserName); // 会话人的OPENID 来查询其本人基本信息
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
                    System.out.println();

                    // 处理上报地理位置事件
                    // 地理位置 纬度
                    String latitude = requestMap.get("Latitude");
                    // 地理位置 经度
                    String longitude = requestMap.get("Longitude");
                    System.out.println("纬度：" + latitude);
                    System.out.println("经度：" + longitude);

                    // 将信息发送给固定人: 测试公众号 李荣
                    //textMessage.setToUserName("ouJig1XpsaW108s6gaLxrxPyhIaE");
                    // 将信息发送给固定人: 安平二手车 姚永斌
                    //textMessage.setToUserName("osd9pwubMzK6RF5lYeif8HYnk5mY");
                    respContent = "感谢您的对话，我们获取了您的如下信息：\n" + "纬度:" + latitude + "\n经度:" + longitude + "\nOpenID：" + user.getOpenId() + "\n关注状态：" + user.getSubscribe() + "\n关注时间："
                            + user.getSubscribeTime() + "\n昵称：" + user.getNickname() + "\n性别：" + user.getSex() + "\n国家：" + user.getCountry() + "\n省份：" + user.getProvince() + "\n城市：" + user.getCity()
                            + "\n语言：" + user.getLanguage() + "\n头像：" + user.getHeadImgUrl();

                    log.info("上报地理位置同时获取的信息:[\n" + respContent + "]");
                    // 用户关注时保存用户信息
                    saveUser(user);
                }
                // 自定义菜单
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // TODO 处理菜单点击事件
                }
            }
            // 设置文本消息的内容
            textMessage.setContent(respContent);
            // 将文本消息对象转换成xml
            respXml = MessageUtil.messageToXml(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }

    /**
     * 用户关注时保存用户信息
     * @param user
     */
    private static void saveUser(WeixinUserInfo user){
        log.info("用户信息保存开始：" + user.toString());
        if (user.getOpenId() == null) {
            log.info("用户OPEN_ID=NULL");
            return;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setOpenId(user.getOpenId());
        userInfo.setNickName(user.getNickname());
        userInfo.setSex(user.getSex());
        userInfo.setCountry(user.getCountry());
        userInfo.setProvince(user.getProvince());
        userInfo.setCity(user.getCity());
        userInfo.setHeadImgUrl(user.getHeadImgUrl());

        // 该OPEN_ID用户已存在判断
        UserInfo oldUserInfo = coreService.yuecheService.getUserInfo(user.getOpenId());
        if (oldUserInfo == null) {
            coreService.yuecheService.saveUserInfo(userInfo);
        } else {
            coreService.yuecheService.editUserInfo(userInfo);
        }
        log.info("用户信息保存结束");
    }
}