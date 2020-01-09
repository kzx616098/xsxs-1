package cn.xinzhi.xsxs.service;

import cn.xinzhi.xsxs.pojo.PicTure;
import cn.xinzhi.xsxs.pojo.UserInfo;
/**
 * @author youName
 * @create 2019-12-24 12:10
 */
public interface ILoginService {
    /**
     *
     * @return 获取随机数
     */
    UserInfo insert();

    /**
     * 给登录页面传星号
     * @return userinfo
     */
//    UserInfo uId();

    /**
     * 登录
     * @param ui 实体类
     * @return 登录结果
     */
    String login(UserInfo ui);

    /**
     *  校验验证码,设置手机密码,绑定手机号
     * @param ui 实体类
     * @return
     */
    String updateUserinfo(UserInfo ui);

    /**
     *  获取手机验证码
     * @param phone 手机号
     * @return
     */
    String updateAuth(String phone);

    /**
     *
     * @return 实体类
     */
    PicTure getPhtoto();
}
