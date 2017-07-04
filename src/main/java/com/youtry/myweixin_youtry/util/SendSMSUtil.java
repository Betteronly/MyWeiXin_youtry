package com.youtry.myweixin_youtry.util;

import java.util.HashMap;
import java.util.Map;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.sms.SmsClient;
import com.baidubce.services.sms.SmsClientConfiguration;
import com.baidubce.services.sms.model.SendMessageV2Request;
import com.baidubce.services.sms.model.SendMessageV2Response;

import static com.youtry.myweixin_youtry.util.AppConfigs.*;

public class SendSMSUtil {
    public static SmsClientConfiguration config = new SmsClientConfiguration();

    public static int sendSingleSms(String phoneNo, String orderId) {
        // 相关参数定义
        String endPoint = APP_SMS_ENDPOINT;                     // SMS服务域名，可根据环境选择具体域名
        String accessKeyId = APP_SMS_ACCESSKEYID;               // 发送账号安全认证的Access Key ID
        String secretAccessKy = APPAPP_SMS_SECRETACCESSKY;      // 发送账号安全认证的Secret Access Key

        // ak、sk等config
        // SmsClientConfiguration config = new SmsClientConfiguration();
        config.setCredentials(new DefaultBceCredentials(accessKeyId, secretAccessKy));
        config.setEndpoint(endPoint);

        // 实例化发送客户端
        SmsClient smsClient = new SmsClient(config);

        // 定义请求参数
        String invokeId = APP_SMS_INVOKEID;                 // 发送使用签名的调用ID
        // 要发送的手机号码(只能填写一个手机号)
        String phoneNumber = APP_SMS_PHONENUMBER;           // 客服号码
        // 本次发送使用的模板Code
        String templateCode = APP_SMS_TEMPLATECODE;         // 您的订单已生成，订单号是${code}
        Map<String, String> vars = new HashMap<String, String>(); // 若模板内容为：您的验证码是${code},在${time}分钟内输入有效
        // 订单号
        vars.put("code", orderId);

        //实例化请求对象
        SendMessageV2Request request = new SendMessageV2Request();
        request.withInvokeId(invokeId)
                .withPhoneNumber(phoneNumber)
                .withTemplateCode(templateCode)
                .withContentVar(vars);

        // 发送请求
        SendMessageV2Response response = smsClient.sendMessage(request);

        // 解析请求响应 response.isSuccess()为true 表示成功
        if (response != null && response.isSuccess()) {
            //  submit success
            return 0;
        } else {
            // fail
            return 1;
        }
    }
}
