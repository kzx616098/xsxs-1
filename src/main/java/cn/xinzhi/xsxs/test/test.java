package cn.xinzhi.xsxs.test;

import cn.xinzhi.xsxs.uilt.RandomUser;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

class SendSms {
    public static void main(String[] args) {
        RandomUser ru = new RandomUser();
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4Fkcsm7BQij9BZGy7yeu", "g0HajyMArMqFCl2gUychv01o6waOdY");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "");
        request.putQueryParameter("SignName", "心诉星说");
        request.putQueryParameter("TemplateCode", "SMS_181861153");
        request.putQueryParameter("TemplateParam", "{\"code\":" + ru.randomId() + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
