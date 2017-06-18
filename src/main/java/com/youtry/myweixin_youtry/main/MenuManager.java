package com.youtry.myweixin_youtry.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.youtry.myweixin_youtry.menu.Button;
import com.youtry.myweixin_youtry.menu.CommonButton;
import com.youtry.myweixin_youtry.menu.ComplexButton;
import com.youtry.myweixin_youtry.menu.Menu;
import com.youtry.myweixin_youtry.menu.ViewButton;
import com.youtry.myweixin_youtry.pojo.AccessToken;
import com.youtry.myweixin_youtry.util.WeixinUtil;

/**
 * 类名: MenuManager </br>
 * 包名： com.souvc.weixin.main
 * 描述:菜单管理器类 </br>
 * 开发人员： liuhf </br>
 * 创建时间： 2015-12-1 </br>
 * 发布版本：V1.0 </br>
 */
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    public static void main(String[] args) {
        //##################################
        // 第三方用户唯一凭证 APPID
        //##################################
//        String appId = "wx3c37aec02f10b164"; //李荣 测试用
        String appId = "wxc9b7dadeaabc523d"; // 安平二手交易
        //##################################
        // 第三方用户唯一凭证密钥  APP_SECRET
        //##################################
        //        String appSecret = "743e889ea363a61e4cc8c42643ce25b3"; //李荣 测试用
        String appSecret = "326ef58e0857052c05f40411f181098a"; // 安平二手交易
        //##################################
        // 网站地址 app.url
        //##################################
        //        String appSecret = "youtry.applinzi.com"; // 李荣 新浪云
        String appUrl = "anpingershou.duapp.com"; // 姚永斌 百度云

        // 调用接口获取access_token
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

        if (null != at) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(appId, appUrl), at.getAccessToken());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }
    }

    /**
     * 组装菜单数据
     * 
     * @return
     */
    private static Menu getMenu(String appId, String appUrl) {
        ViewButton btn11 = new ViewButton();
        btn11.setName("\uE102今天特价产品");
        btn11.setType("view");
        btn11.setUrl("http://mp.weixin.qq.com/s/BZCHiQxEwntfc_QxYweX2w");

        ViewButton btn12 = new ViewButton();
        btn12.setName("\uE42E二手交通工具");
        btn12.setType("view");
        btn12.setUrl("http://mp.weixin.qq.com/s/qhd_JN_rFXZVLFVA6uw6Hg");

        ViewButton btn13 = new ViewButton();
        btn13.setName("\uE124二手家具货架");
        btn13.setType("view");
        btn13.setUrl("http://mp.weixin.qq.com/s/kkWnNVJspw8t2WtfR6DGuA");

        ViewButton btn14 = new ViewButton();
        btn14.setName("\uE00C二手手机、电器");
        btn14.setType("view");
        btn14.setUrl("http://mp.weixin.qq.com/s/ByTJFGuUUibTV5oVXzsE7A");

        ViewButton btn15 = new ViewButton();
        btn15.setName("\uE331二手求购、回收");
        btn15.setType("view");
        btn15.setUrl("http://mp.weixin.qq.com/s/cR_pcctRaW14kWlEqkBujA");

//        CommonButton btn14 = new CommonButton();
//        btn14.setName("\uE00C二手手机、电器");
//        btn14.setType("click");
//        btn14.setKey("14");
//
//        CommonButton btn15 = new CommonButton();
//        btn15.setName("二手求购、回收");
//        btn15.setType("click");
//        btn15.setKey("14");

        ViewButton btn21 = new ViewButton();
        btn21.setName("平台约车");
        btn21.setType("view");
        //###################################################################################
        // 服务号 有获取 基本信息 和 用户信息权限，故 跳转服务，获取OPEN_ID， 且自带用户手机号至约车页面
//        btn21.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appId
//                + "&redirect_uri=http%3a%2f%2f" + appUrl + "%2foauthServlet&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");
        //###################################################################################

        //###################################################################################
        // 订阅号 没有获取 基本信息 和 用户信息权限，故 直接跳转
        btn21.setUrl("http://" + appUrl + "/yueche/index");
        //###################################################################################

        ViewButton btn22 = new ViewButton();
        btn22.setName("违章查询");
        btn22.setType("view");
        btn22.setUrl("http://m.hbgajg.com/?sukey=1d7adfb17f4c2cfc883077fc8c90dad1e54706c0fa47b12f6e5ba1cf525fd88f745fe80cfe46f0cf31480f9884972ad0#wechat_redirect");

        ViewButton btn23 = new ViewButton();
        btn23.setName("文章搜索");
        btn23.setType("view");
        btn23.setUrl("http://www.juzicc.com");

        ViewButton btn24 = new ViewButton();
        btn24.setName("小品大联欢");
        btn24.setType("view");
        btn24.setUrl("http://www.aidabang.com/wei/xiaopin/main.php");

        ViewButton btn25 = new ViewButton();
        btn25.setName("便民信息大全");
        btn25.setType("view");
        btn25.setUrl("http://mp.weixin.qq.com/s?__biz=MzI3NTc0MjA1NQ==&mid=100000022&idx=1&sn=2108c881eebd81175e09d8b334d1c575&chksm=6b016d1e5c76e4081e157d645e7cc353bae4c095da2221e929a4a1c918aa87e2ee6e188fb590&scene=18#wechat_redirect");


        ViewButton btn31 = new ViewButton();
        btn31.setName("盘条信息");
        btn31.setType("view");
        btn31.setUrl("http://mp.weixin.qq.com/s/dtmhF0iVzKVMfkqweE-ocA");

        ViewButton btn32 = new ViewButton();
        btn32.setName("库存丝网处理");
        btn32.setType("view");
        btn32.setUrl("http://mp.weixin.qq.com/s/Dk-j0Vgfrk5L3xzHFf_LBA");

        ViewButton btn33 = new ViewButton();
        btn33.setName("二手机器、设备");
        btn33.setType("view");
        btn33.setUrl("http://mp.weixin.qq.com/s/myKTfX0hbxRloQaercDUKA");

        ViewButton btn34 = new ViewButton();
        btn34.setName("消防队路口路况");
        btn34.setType("view");
        btn34.setUrl("http://square.ys7.com/play/index?cameraId=1717728");

        ViewButton btn35 = new ViewButton();
        btn35.setName("德奥大厦路口路况");
        btn35.setType("view");
        btn35.setUrl("http://square.ys7.com/play/index?cameraId=1717758");


        /**
         * 微信： mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("找\uE114宝贝");
        // 一级下有4个子菜单
        // mainBtn1.setSub_button( new CommonButton[] { btn11, btn12, btn13, btn14 });
        mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13, btn14, btn15 });

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("便民服务");
        mainBtn2.setSub_button(new Button[] { btn21, btn22, btn23, btn24, btn25 });

        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("\uE513丝网");
        mainBtn3.setSub_button(new Button[] { btn31, btn32, btn33, btn34, btn35 });

        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

        return menu;
    }
}