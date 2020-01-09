package cn.xinzhi.xsxs.service.serviceimpl;

import cn.xinzhi.xsxs.dao.LoginDao;
import cn.xinzhi.xsxs.pojo.PicTure;
import cn.xinzhi.xsxs.pojo.UserInfo;
import cn.xinzhi.xsxs.service.ILoginService;
import cn.xinzhi.xsxs.service.IRedisService;
import cn.xinzhi.xsxs.uilt.AuthCode;
import cn.xinzhi.xsxs.uilt.RandomUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author youName
 * @create 2019-12-24 12:12
 */
@Service("is")
@Slf4j
public class LoginServiceimpl implements ILoginService {
    @Autowired
    @Qualifier("lgd")
    private LoginDao lgd;

    public void setLd(LoginDao lgd) {
        this.lgd = lgd;
    }

    @Autowired
    @Qualifier("rsi")
    IRedisService irs;

    /**
     * 将随机数和随机昵称插入数据库
     *
     * @return 实体对象
     */
    public UserInfo insert() {
        log.info("开始获取随机数");
        UserInfo ui = new UserInfo();
        RandomUser ru = new RandomUser();
        try {
            ui.setUid(ru.randomId());
            ui.setUname(ru.randomName());
            //将随机数和昵称插入数据库
            int i = lgd.FirstLogin(ui);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info("返回实体类,前端保存星号信息");
        return ui;
    }

    /**
     * 获取手机验证码
     *
     * @param phone 手机号
     * @return
     */
    @Override
    public String updateAuth(String phone) {
        UserInfo user = lgd.selectPhone(phone);
//        String p_phone = userInfo.getP_phone();
        String a = null;
        if (user != null) {
            a = "手机号已经存在";
        } else {
            //发送短信验证码
            String auth = AuthCode.getAuth(phone);
            irs.remove(phone);     //清除未失效的key对应的value值
            irs.set(phone, auth);//缓存新的key-value值
            irs.expire(phone, 300);  //设置过期时间
            a = "验证码发送成功";
        }
        return a;
    }

    /**
     * @return 返回图片路径
     */
    @Override
    public PicTure getPhtoto() {
        PicTure pt = new PicTure();
        Set<PicTure> photo = lgd.getPhoto();
        Iterator<PicTure> iterator = photo.iterator();
        String tx = null;
        if(photo != null) {
            while (iterator.hasNext()){
                pt = iterator.next();
            }
        }
        return pt;
    }


    /**
     * 校验验证码.设置密码,存入手机号
     *
     * @param ui 实体类
     * @return
     */
    @Override
    public String updateUserinfo(UserInfo ui) {
        String a = null;
//        String verification1 = ui.getVerification();
//        String p_phone = ui.getP_phone();
        String verification1 = irs.get(ui.getP_phone());
        String verification = ui.getVerification();
        System.out.println(verification + verification1);
        Integer uid = ui.getUid();
        String p_phone = ui.getP_phone();
        String upwd = ui.getUpwd();
        if (verification1 != null) {
            if (verification1.equals(verification)) {
                int i = lgd.updatePhone(uid, p_phone);
                int g = lgd.updateUpwd(uid, upwd);
                if (i > 0 && g > 0) {
                    a = "手机号密码绑定成功";
                } else {
                    a = "手机号密码绑定失败";
                }
            }
        } else {
            a = "验证码为空";
        }
        return a;
    }

//    /**
//     * 获取星号id
//     *
//     * @return userinfo
//     */
//    @Override
//    public UserInfo uId() {
//        return ui;
//    }

    /**
     * 登录
     *
     * @param ui 实体类
     * @return
     */
    @Override
    public String login(UserInfo ui) {
        Integer uid = ui.getUid();
        String upwd = ui.getUpwd();
        String a = null;
        UserInfo longin = lgd.longin(uid, upwd);
        if (longin != null) {
            a = "登录成功";
        } else {
            a = "登录失败";
        }
        System.out.println(upwd);
        return a;
    }

    /**
     * 设备码
     */
//    public void fetch_status(){
//        TelephonyManager tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
//        String str = "";
//        str += "DeviceId(IMEI) = " + tm.getDeviceId() + "\n";
//        str += "DeviceSoftwareVersion = " + tm.getDeviceSoftwareVersion() + "\n";
//        str += "Line1Number = " + tm.getLine1Number() + "\n";
//        str += "NetworkCountryIso = " + tm.getNetworkCountryIso() + "\n";
//        str += "NetworkOperator = " + tm.getNetworkOperator() + "\n";
//        str += "NetworkOperatorName = " + tm.getNetworkOperatorName() + "\n";
//        str += "NetworkType = " + tm.getNetworkType() + "\n";
//        str += "PhoneType = " + tm.getPhoneType() + "\n";
//        str += "SimCountryIso = " + tm.getSimCountryIso() + "\n";
//        str += "SimOperator = " + tm.getSimOperator() + "\n";
//        str += "SimOperatorName = " + tm.getSimOperatorName() + "\n";
//        str += "SimSerialNumber = " + tm.getSimSerialNumber() + "\n";
//        str += "SimState = " + tm.getSimState() + "\n";
//        str += "SubscriberId(IMSI) = " + tm.getSubscriberId() + "\n";
//        str += "VoiceMailNumber = " + tm.getVoiceMailNumber() + "\n";
//        TextView sys = (TextView) findViewById(R.id.sys);
//        sys.setText(str);
//    }
}
