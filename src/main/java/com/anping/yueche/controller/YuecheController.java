package com.anping.yueche.controller;

import com.anping.yueche.entity.CodeItem;
import com.anping.yueche.pojo.CarOrderInfo;
import com.anping.yueche.pojo.ServiceTelCallHistory;
import com.anping.yueche.pojo.UserInfo;
import com.anping.yueche.service.CommonService;
import com.anping.yueche.service.YuecheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.anping.yueche.utils.CommonConstants.*;
import com.youtry.myweixin_youtry.util.SendSMSUtil;

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
        if (!StringUtils.isEmpty(openId)) {
            UserInfo userInfo = yuecheService.getUserInfo(openId);

            model.addAttribute("openId", openId);
            // 客户NO
            if (userInfo != null) {
                model.addAttribute("userNo", userInfo.getUserNo());
            } else {
                model.addAttribute("userNo", "");
            }
            // 客户昵称
            if (userInfo != null) {
                model.addAttribute("nickName", userInfo.getNickName());
            } else {
                model.addAttribute("nickName", "");
            }
            // 客户姓名
            if (userInfo != null) {
                model.addAttribute("name", userInfo.getName());
            } else {
                model.addAttribute("name", "");
            }
            // 客户手机号码
            if (userInfo != null) {
                model.addAttribute("orderPhone", userInfo.getPhone());
            } else {
                model.addAttribute("orderPhone", "");
            }
        }

        // 出发地
        List<CodeItem> addrFromList = commonService.getCodeItemList(ADDR_FROM_LIST);
        model.addAttribute("addrFromList", addrFromList);
        // 目的地
        List<CodeItem> addrToList = commonService.getCodeItemList(ADDR_TO_LIST);
        model.addAttribute("addrToList", addrToList);

        // model.addAttribute("anpingServiceTel", "10086");
        // 出发日期
//        List<CodeItem> departDateList = commonService.getCodeItemList(DEPART_DATE_LIST);
        List<CodeItem> departDateList = new ArrayList<CodeItem>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //设置日期格式
        Date today = new Date();
        // 7天内预约
        for (int i=0; i < 7; i++){
            CodeItem codeItem = new CodeItem();
            String newDay = sdf.format(new Date(today.getTime() + i * 24 * 60 * 60 * 1000));
            codeItem.setKey(newDay);
            codeItem.setValue(newDay);
            departDateList.add(codeItem);
        }
        model.addAttribute("departDateList", departDateList);

        // 出发时刻
        List<CodeItem> departTimeList = commonService.getCodeItemList(DEPART_TIME_LIST);
        model.addAttribute("departTimeList", departTimeList);

        // model.addAttribute("userInfo", (userInfo == null ? null : userInfo));
        // model.addAttribute("state", state);

        return "anping/yueche/index";
    }

    /**
     * 约车首页、约车处理
     * @param carOrderInfo
     * @param userInfo
     * @param model
     * @return
     */
    @RequestMapping(value = { "/orderCar" }, method = RequestMethod.POST)
    public String orderCar(CarOrderInfo carOrderInfo, UserInfo userInfo, Model model) {
        // 00：用户预约成功、10：客服确认成功、11：客服确认失败
        carOrderInfo.setOrderStatus("待确认");
        // 0：有效、1：无效
        carOrderInfo.setDataState("0");
        // 约车用户名
        if (!StringUtils.isEmpty(userInfo.getName())) {
            carOrderInfo.setOrderName(userInfo.getName());
        } else {
            if (!StringUtils.isEmpty(userInfo.getNickName())) {
                carOrderInfo.setOrderName(userInfo.getNickName());
            } else {
                carOrderInfo.setOrderName("");
            }
        }

        // 约车
        boolean ret = yuecheService.doOrderCar(carOrderInfo);

        model.addAttribute("openId", carOrderInfo.getOpenId());

        if (ret) {
            model.addAttribute("carOderStatus", "OK");
            // 发送客服通知短信
            SendSMSUtil.sendSingleSms(null, carOrderInfo.getCarOrderId());
        } else {
            model.addAttribute("carOderStatus", "NG");
        }

        // return "anping/yueche/ordercar_confirm";
        return "anping/yueche/order_finish";
    }


    /**
     * 约车信息管理
     * @param model
     * @return
     */
    @RequestMapping(value = { "/manage/orderCarInfo" }, method = RequestMethod.GET)
    public String orderInfoManage(Model model, String selectedOrderStatusList) {
        // 预约状态
        CarOrderInfo carOrderInfo = new CarOrderInfo();
        if (selectedOrderStatusList == null){
            carOrderInfo.setOrderStatus("'待确认','待出发'"); //初始化
        } else if ("".equals(selectedOrderStatusList)){
            carOrderInfo.setOrderStatus(null); //全量检索
        } else {
            carOrderInfo.setOrderStatus(selectedOrderStatusList);
        }

        List<CarOrderInfo> carOrderInfoList = yuecheService.getCarOrderInfo(carOrderInfo);
        model.addAttribute("carOrderInfoList", carOrderInfoList);

        List<CodeItem> orderStatusList = commonService.getCodeItemList(ORDER_STATUS);
        model.addAttribute("orderStatusList", orderStatusList);

        if (selectedOrderStatusList == null) {
            // 状态选择框 选择状态保持
            model.addAttribute("chkbxOrderStatusWaitConfirm", true);
            model.addAttribute("chkbxOrderStatusWaitDepart", true);
        } else {
            // 状态选择框 选择状态保持
            model.addAttribute("chkbxOrderStatusWaitConfirm", selectedOrderStatusList.contains("待确认") ? true : false);
            model.addAttribute("chkbxOrderStatusWaitDepart", selectedOrderStatusList.contains("待出发") ? true : false);
            model.addAttribute("chkbxOrderStatusFinish", selectedOrderStatusList.contains("订单完成") ? true : false);
            model.addAttribute("chkbxOrderStatusDelete", selectedOrderStatusList.contains("订单作废") ? true : false);
        }

        ServiceTelCallHistory serviceTelCallHistory = new ServiceTelCallHistory();
        String count = yuecheService.getServiceTelCallCount(serviceTelCallHistory);
        model.addAttribute("countOfServiceTelCall", count);

        return "anping/yueche/order_info_manage";
    }

}