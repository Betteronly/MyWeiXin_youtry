package com.anping.yueche.api;

import com.anping.yueche.pojo.CarOrderInfo;
import com.anping.yueche.pojo.CarOrderInfoManage;
import com.anping.yueche.pojo.ServiceTelCallHistory;
import com.anping.yueche.service.CommonService;
import com.anping.yueche.service.YuecheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
     * @param carOrderInfoManage
     * @return
     */
    @RequestMapping("/manageapi/orderInfoStatus")
    public @ResponseBody CarOrderInfo orderInfoManage(@RequestBody CarOrderInfoManage carOrderInfoManage) {
        int retStatus = -1;

        CarOrderInfo carOrderInfo = new CarOrderInfo();
        carOrderInfo.setCarOrderId(carOrderInfoManage.getCarOrderId()); // 更新对象carOrderId

        if ("btnOrderInfoOK".equals(carOrderInfoManage.getOprateType())){
            carOrderInfo.setOrderStatus("待出发");
            retStatus = yuecheService.editCarOrderInfo(carOrderInfo);
        } else if ("btnOrderDelete".equals(carOrderInfoManage.getOprateType())){
            carOrderInfo.setOrderStatus("订单作废");
            retStatus = yuecheService.editCarOrderInfo(carOrderInfo);
        } else if ("btnOrderFinish".equals(carOrderInfoManage.getOprateType())){
            carOrderInfo.setOrderStatus("订单完成");
            retStatus = yuecheService.editCarOrderInfo(carOrderInfo);
        }

        if (retStatus < 1) {
            carOrderInfo.setOrderStatus(carOrderInfoManage.getOrderStatus());
        }
        return carOrderInfo;
    }

    /**
     * 约车客服电话拨打 记录
     * @param serviceTelCallHistory
     * @return
     */
    @RequestMapping("/saveServiceTelCall")
    public int saveServiceTelCall(@RequestBody ServiceTelCallHistory serviceTelCallHistory) {
        return yuecheService.saveServiceTelCall(serviceTelCallHistory);
    }

    /**
     * 约车客服 电话拨打拨打次数
     * @param serviceTelCallHistory
     * @return
     */
//    @RequestMapping("/countOfServiceTelCall")
//    public @ResponseBody ServiceTelCallHistory getCountOfServiceTelCall(@RequestBody ServiceTelCallHistory serviceTelCallHistory) {
//        ServiceTelCallHistory ret = new ServiceTelCallHistory();
//        String count = yuecheService.getServiceTelCallCount(serviceTelCallHistory);
//        ret.setCount(count);
//        return ret;
//    }
}