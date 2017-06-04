package com.anping.yueche.api;

import static com.anping.yueche.utils.CommonConstant.ADDR_FROM_LIST;
import static com.anping.yueche.utils.CommonConstant.ADDR_TO_LIST;
import static com.anping.yueche.utils.CommonConstant.DEPART_TIME_LIST;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anping.yueche.entity.CodeItem;
import com.anping.yueche.pojo.CarOrderInfo;
import com.anping.yueche.pojo.UserInfo;
import com.anping.yueche.service.CommonService;
import com.anping.yueche.service.YuecheService;

@Controller
@RequestMapping("/yueche")
public class YuecheController {
    private static Logger log = LoggerFactory.getLogger(YuecheController.class);

    @Autowired
    private YuecheService yuecheService;

    @Autowired
    private CommonService commonService;

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
        // 客户手机号码
        if (userInfo != null) {
            model.addAttribute("orderPhone", userInfo.getPhone());
        } else {
            model.addAttribute("orderPhone", "");
        }

        List<CodeItem> addrFromList = commonService.getCodeItemList(ADDR_FROM_LIST);
        model.addAttribute("addrFromList", addrFromList);

        List<CodeItem> addrToList = commonService.getCodeItemList(ADDR_TO_LIST);
        model.addAttribute("addrToList", addrToList);

        // model.addAttribute("anpingServiceTel", "10086");

        List<CodeItem> departTimeList = commonService.getCodeItemList(DEPART_TIME_LIST);
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
    public String orderCar(CarOrderInfo carOrderInfo, Model model) {
        // 00：用户预约成功、10：客服确认成功、11：客服确认失败
        carOrderInfo.setOrderStatus("00");
        // 0：有效、1：无效
        carOrderInfo.setDataState("0");
        // 约车
        boolean ret = yuecheService.doOrderCar(carOrderInfo);
        if (ret) {
            model.addAttribute("carOderStatus", "OK");
        } else {
            model.addAttribute("carOderStatus", "NG");
        }

        // return "anping/yueche/ordercar_confirm";
        return "anping/yueche/ordercar_finish";
    }

}