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
        // 第三方用户唯一凭证
        String appId = "wx3c37aec02f10b164";
        // 第三方用户唯一凭证密钥
        String appSecret = "743e889ea363a61e4cc8c42643ce25b3";

        // 调用接口获取access_token
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

        if (null != at) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), at.getAccessToken());

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
    private static Menu getMenu() {
        ViewButton btn11 = new ViewButton();
        btn11.setName("今天特价产品");
        btn11.setType("view");
        btn11.setUrl("http://youtry.applinzi.com/");

        ViewButton btn12 = new ViewButton();
        btn12.setName("二手交通工具");
        btn12.setType("view");
        btn12.setUrl("http://youtry.applinzi.com/");

        ViewButton btn13 = new ViewButton();
        btn13.setName("二手家具桌椅");
        btn13.setType("view");
        btn13.setUrl("http://youtry.applinzi.com/");

        CommonButton btn14 = new CommonButton();
        btn14.setName("二手手机、电器");
        btn14.setType("click");
        btn14.setKey("14");

        CommonButton btn15 = new CommonButton();
        btn15.setName("二手求购、回收");
        btn15.setType("click");
        btn15.setKey("14");

        ViewButton btn21 = new ViewButton();
        btn21.setName("平台约车");
        btn21.setType("view");
        btn21.setUrl(
                "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3c37aec02f10b164&redirect_uri=http%3a%2f%2fyoutry.applinzi.com%2foauthServlet&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");

        CommonButton btn22 = new CommonButton();
        btn22.setName("二手楼房厂房");
        btn22.setType("click");
        btn22.setKey("22");

        CommonButton btn23 = new CommonButton();
        btn23.setName("安平便民门诊");
        btn23.setType("click");
        btn23.setKey("23");

        CommonButton btn24 = new CommonButton();
        btn24.setName("安平公交车");
        btn24.setType("click");
        btn24.setKey("24");

        CommonButton btn25 = new CommonButton();
        btn25.setName("求职招聘");
        btn25.setType("click");
        btn25.setKey("25");

        CommonButton btn31 = new CommonButton();
        btn31.setName("二手机器设备");
        btn31.setType("click");
        btn31.setKey("31");

        CommonButton btn32 = new CommonButton();
        btn32.setName("库存丝网处理");
        btn32.setType("click");
        btn32.setKey("32");

        CommonButton btn33 = new CommonButton();
        btn33.setName("丝网计算公式");
        btn33.setType("click");
        btn33.setKey("33");

        CommonButton btn34 = new CommonButton();
        btn34.setName("盘条信息");
        btn34.setType("click");
        btn34.setKey("34");

        CommonButton btn35 = new CommonButton();
        btn35.setName("快递物流");
        btn35.setType("click");
        btn35.setKey("35");

        /**
         * 微信： mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("找宝贝");
        // 一级下有4个子菜单
        // mainBtn1.setSub_button( new CommonButton[] { btn11, btn12, btn13, btn14 });
        mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13, btn14, btn15 });

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("便民服务");
        mainBtn2.setSub_button(new Button[] { btn21, btn22, btn23, btn24, btn25 });

        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("丝网");
        mainBtn3.setSub_button(new Button[] { btn31, btn32, btn33, btn34, btn35 });

        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

        return menu;
    }
}