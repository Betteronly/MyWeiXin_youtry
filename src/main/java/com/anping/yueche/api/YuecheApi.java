package com.anping.yueche.api;

import com.anping.yueche.pojo.CarOrderInfo;
import com.anping.yueche.service.CommonService;
import com.anping.yueche.service.YuecheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/yuecheApi")
public class YuecheApi {
    private static Logger log = LoggerFactory.getLogger(YuecheApi.class);

    @Autowired
    private YuecheService yuecheService;

    @Autowired
    private CommonService commonService;

    public YuecheApi() {
        super();
    }

    /**
     * 约车信息状态变更
     * @param oprateType
     * @param carOrderId
     * @return
     */
    @RequestMapping(value = { "/manageapi/orderInfoStatus" }, method = RequestMethod.GET)
    @ResponseBody
    public String orderInfoManage(String oprateType, String carOrderId) {
        String ret = "";
        CarOrderInfo carOrderInfo = new CarOrderInfo();
        if ("订单确认".equals(carOrderId)){
            carOrderInfo.setOrderStatus("待出发");
            int retStatus = yuecheService.editCarOrderInfo(carOrderInfo);
        } else if ("订单作废".equals(carOrderId)){
            carOrderInfo.setOrderStatus("订单作废");
            int retStatus = yuecheService.editCarOrderInfo(carOrderInfo);
        }

        return "{orderStatus:待出发}";
    }
}