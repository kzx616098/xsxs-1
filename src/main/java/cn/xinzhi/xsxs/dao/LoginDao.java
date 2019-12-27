package cn.xinzhi.xsxs.dao;

import cn.xinzhi.xsxs.jopo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author youName
 * @create 2019-12-24 12:09
 */
@Repository("lgd")
public interface LoginDao {
    UserInfo longin(@Param("name") String uname, @Param("pwd")String pwd);
}
