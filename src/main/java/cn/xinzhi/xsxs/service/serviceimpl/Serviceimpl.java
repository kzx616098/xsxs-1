package cn.xinzhi.xsxs.service.serviceimpl;

import cn.xinzhi.xsxs.dao.LoginDao;
import cn.xinzhi.xsxs.jopo.UserInfo;
import cn.xinzhi.xsxs.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author youName
 * @create 2019-12-24 12:12
 */
@Service("sil")
public class Serviceimpl implements IService {
    @Autowired
    @Qualifier("lgd")
    private LoginDao lgd;

    public void setLd(LoginDao lgd) {
        this.lgd = lgd;
    }

    @Override
    public String login(String uname, String pwd) {
        UserInfo longin = lgd.longin(uname, pwd);
        String a = null;
        if (longin != null){
            a = "登录成功";
        }else {
            a = "登录失败";
        }
        return a;
    }
}
