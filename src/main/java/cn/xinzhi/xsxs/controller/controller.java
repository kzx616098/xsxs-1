package cn.xinzhi.xsxs.controller;

import cn.xinzhi.xsxs.jopo.UserInfo;
import cn.xinzhi.xsxs.service.IService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/test")
@Api("登录接口")
public class controller {
    @Autowired
    @Qualifier("sil")
    private IService is;

    public void setIs(IService is) {
        this.is = is;
    }

    @PostMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uname", value = "用户名",dataType = "String",example = "kzx"),
            @ApiImplicitParam(name = "pwd", value = "密码", dataType = "String",example = "123")
    }
    )
    @CrossOrigin
    public String login(@RequestBody UserInfo userInfo){
        System.out.println(userInfo);
        String login = is.login(userInfo.getUsername(), userInfo.getUserpwd());
        return login;
    }

}
