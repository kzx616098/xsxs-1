package cn.xinzhi.xsxs.uilt;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class AuthCode {
    public static String getAuth(String phone){
        RandomUser ru = new RandomUser();
        Integer id = ru.randomId();
        String s = id.toString();
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4Fkcsm7BQij9BZGy7yeu", "g0HajyMArMqFCl2gUychv01o6waOdY");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "心诉星说");
        request.putQueryParameter("TemplateCode", "SMS_181861153");
        request.putQueryParameter("TemplateParam", "{\"code\":" + s + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
