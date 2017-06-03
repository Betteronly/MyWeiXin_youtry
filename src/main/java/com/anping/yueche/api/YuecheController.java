package com.anping.yueche.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anping.yueche.entity.CodeItem;
import com.anping.yueche.pojo.CarOrderInfo;
import com.anping.yueche.pojo.UserInfo;
import com.anping.yueche.service.YuecheService;

@Controller
@RequestMapping("/yueche")
public class YuecheController {

    @Autowired
    private YuecheService yuecheService;

    public YuecheController() {
        super();
    }

    /**
     * 约车首页显示
     * 
     * @param httpRequest
     * @param model
     * @param openId
     * @param servletRequest
     * @return
     */
    @RequestMapping(value = { "/yuecheIndex", "/", "/index" }, method = RequestMethod.GET)
    public String yuecheIndex(HttpServletRequest httpRequest, Model model, String openId, ServletRequest servletRequest) {
        // String openId = openId; // 参数传入方式
        // String openId2 = httpRequest.getParameter("openId"); // 获取参数方式
        // 微信传入用户信息
        // SNSUserInfo SNSuserInfo = (SNSUserInfo) httpRequest.getAttribute("snsUserInfo");
        // 状态值
        // String state = (String) httpRequest.getAttribute("state");

        // 微信静默方式传入OpenID查询用户信息
        UserInfo userInfo = yuecheService.getUserInfo(openId);

        model.addAttribute("openId", openId);
        // 最近预约手机号码
        model.addAttribute("orderPhone", "13600000000");

        List<CodeItem> addrFromList = new ArrayList();
        CodeItem codeItem11 = new CodeItem();
        codeItem11.setKey("Anping");
        codeItem11.setValue("安平");
        addrFromList.add(codeItem11);
        CodeItem codeItem12 = new CodeItem();
        codeItem12.setKey("Shijiazhuang");
        codeItem12.setValue("石家庄");
        addrFromList.add(codeItem12);
        CodeItem codeItem13 = new CodeItem();
        codeItem13.setKey("Beijing");
        codeItem13.setValue("北京");
        addrFromList.add(codeItem13);
        CodeItem codeItem14 = new CodeItem();
        codeItem14.setKey("Bazhou");
        codeItem14.setValue("霸州");
        addrFromList.add(codeItem14);
        CodeItem codeItem15 = new CodeItem();
        codeItem15.setKey("Hengshui");
        codeItem15.setValue("衡水");
        addrFromList.add(codeItem15);
        CodeItem codeItem16 = new CodeItem();
        codeItem16.setKey("Baoding");
        codeItem16.setValue("保定");
        addrFromList.add(codeItem16);
        CodeItem codeItem17 = new CodeItem();
        codeItem17.setKey("Tianjin");
        codeItem17.setValue("天津");
        addrFromList.add(codeItem17);
        model.addAttribute("addrFromList", addrFromList);

        List<CodeItem> addrToList = new ArrayList();
        CodeItem codeItem21 = new CodeItem();
        codeItem21.setKey("Shijiazhuang");
        codeItem21.setValue("石家庄");
        addrToList.add(codeItem21);
        CodeItem codeItem22 = new CodeItem();
        codeItem22.setKey("Anping");
        codeItem22.setValue("安平");
        addrToList.add(codeItem22);
        CodeItem codeItem23 = new CodeItem();
        codeItem23.setKey("Beijing");
        codeItem23.setValue("北京");
        addrToList.add(codeItem23);
        CodeItem codeItem24 = new CodeItem();
        codeItem24.setKey("Bazhou");
        codeItem24.setValue("霸州");
        addrToList.add(codeItem24);
        CodeItem codeItem25 = new CodeItem();
        codeItem25.setKey("Hengshui");
        codeItem25.setValue("衡水");
        addrToList.add(codeItem25);
        CodeItem codeItem26 = new CodeItem();
        codeItem26.setKey("Baoding");
        codeItem26.setValue("保定");
        addrToList.add(codeItem26);
        CodeItem codeItem27 = new CodeItem();
        codeItem27.setKey("Tianjin");
        codeItem27.setValue("天津");
        addrToList.add(codeItem27);
        model.addAttribute("addrToList", addrToList);

        // model.addAttribute("anpingServiceTel", "10086");

        List<CodeItem> departTimeList = new ArrayList();
        CodeItem codeItem31 = new CodeItem();
        codeItem31.setKey("2017-06-01 09:00");
        codeItem31.setValue("2017-06-01 09:00");
        departTimeList.add(codeItem31);
        CodeItem codeItem32 = new CodeItem();
        codeItem32.setKey("2017-06-02 09:00");
        codeItem32.setValue("2017-06-02 09:00");
        departTimeList.add(codeItem32);
        CodeItem codeItem33 = new CodeItem();
        codeItem33.setKey("2017-06-03 09:00");
        codeItem33.setValue("2017-06-03 09:00");
        departTimeList.add(codeItem33);
        model.addAttribute("departTimeList", departTimeList);

        // model.addAttribute("userInfo", (userInfo == null ? null : userInfo));
        // model.addAttribute("state", state);

        return "anping/yueche/index";
    }

    /**
     * 约车首页、约车处理
     * 
     * @param orderInfo
     * @return
     */
    @RequestMapping(value = { "/orderCar" }, method = RequestMethod.POST)
    public String orderCar(CarOrderInfo carOrderInfo) {

        // return "anping/yueche/ordercar_confirm";
        return "anping/yueche/ordercar_finish";
    }

}