package com.anping.yueche.api;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String yuecheIndex(HttpServletRequest httpRequest, Model model, String openId, ServletRequest servletRequest) {
        String openId1 = openId; // 参数传入方式
        String openId2 = httpRequest.getParameter("openId"); // 获取参数方式
        // 微信传入用户信息
        // SNSUserInfo SNSuserInfo = (SNSUserInfo) httpRequest.getAttribute("snsUserInfo");
        // 状态值
        // String state = (String) httpRequest.getAttribute("state");

        // 微信静默方式传入OpenID查询用户信息
        UserInfo userInfo = yuecheService.getUserInfo(openId1);

        // List<GradeAndClass> allGradeAndClasses = teachToolsService.getGradeAndClasses(schoolId);
        model.addAttribute("openId", openId1);
        model.addAttribute("addrFromList", "{安平,北京}");
        model.addAttribute("addrToList", "{石家庄,安平,北京}");
        model.addAttribute("serviceTel", "13711111112");
        model.addAttribute("userInfo", (userInfo == null ? null : userInfo));
        // model.addAttribute("state", state);

        return "anping/yueche/index";
    }

    /**
     * 约车首页、约车处理
     * 
     * @param orderInfo
     * @return
     */

    @RequestMapping(value = { "/doorder" }, method = RequestMethod.POST)
    public String doOrder(@RequestBody OrderInfo orderInfo) {

        return "anping/yueche/done_order";
    }
}