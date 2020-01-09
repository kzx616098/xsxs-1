package cn.xinzhi.xsxs.dao;

import cn.xinzhi.xsxs.pojo.PicTure;
import cn.xinzhi.xsxs.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author youName
 * @create 2019-12-24 12:09
 */
@Repository("lgd")
public interface LoginDao {
    /**
     * 插入随机数和随机昵称
     * @param ui 实体类
     * @return
     */
    int FirstLogin(@Param("ui") UserInfo ui);

    /**
     * 设置密码
     * @param uid 星号
     * @param upwd  密码
     * @return
     */
    int updateUpwd(@Param("id") Integer uid,@Param("pwd") String upwd);

    /**
     * 查找手机号
     * @param phone 手机号
     * @return
     */
    UserInfo selectPhone(@Param("phone") String phone);

    /**
     * 插入手机号
     * @param phone 手机号
     * @param uid 星号
     * @return
     */
    int updatePhone(@Param("id2") Integer uid,@Param("phone1") String phone);

    /**
     * 星号+密码登录
     * @param uid 星号
     * @param upwd 密码
     * @return
     */
    UserInfo longin(@Param("id1") Integer uid, @Param("pwd1")String upwd);

    /**
     * 获取图片
     * @return 图片路径集合
     */
    Set<PicTure> getPhoto();

}
