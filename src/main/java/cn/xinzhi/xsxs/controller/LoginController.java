package cn.xinzhi.xsxs.controller;

import cn.xinzhi.xsxs.pojo.PicTure;
import cn.xinzhi.xsxs.pojo.UserInfo;
import cn.xinzhi.xsxs.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@Api("登录接口")
@Slf4j
public class LoginController {
    @Autowired
    @Qualifier("is")
    private ILoginService ils;

    public void setIs(ILoginService is) {
        this.ils = is;
    }

    //登录的接口
    @ApiImplicitParams({
            @ApiImplicitParam(name = "upwd", value = "密码", dataType = "String", example = "密码不能少于六位"),
            @ApiImplicitParam(name = "uid", value = "星号", dataType = "String", example = "6位纯数字")
    }
    )
    @CrossOrigin
    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public String login(@RequestBody UserInfo ui){
        String login = ils.login(ui);
        return login;
    }

    //获取随机数的接口
    @CrossOrigin
    @PostMapping("/random")
    @ApiOperation(value = "获取随机昵称和随机数")
    public ResponseEntity<UserInfo> randomName(){
        UserInfo ui = ils.insert();
        if(ui == null){
            log.info("随机数获取失败");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ui) ;
    }

    //获取随机图片
    @CrossOrigin
    @PostMapping("/getphoto")
    @ApiOperation(value = "获取随机图片")
    public ResponseEntity<PicTure> getPhoto(){
        PicTure photo = ils.getPhtoto();
        if (photo == null){
            log.info("图片获取失败");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(photo);
    }

    @ApiImplicitParam(name = "phone", value = "手机号", dataType = "String", example = "11位手机号")
    //获取验证码的接口
    @CrossOrigin
    @PostMapping("/authcode/{phone}")
    @ApiOperation(value = "通过手机号获取验证码")
    public ResponseEntity<String> getAuthcode(@PathVariable("phone") String phone){
        String s = ils.updateAuth(phone);
        return ResponseEntity.ok(s);
    }

    //设置密码,绑定手机号
    @ApiImplicitParams({
            @ApiImplicitParam(name = "upwd", value = "密码", dataType = "String", example = "密码不能少于六位"),
            @ApiImplicitParam(name = "verification", value = "验证码", dataType = "String", example = "六位纯数字验证码"),
            @ApiImplicitParam(name = "p_phone", value = "手机号", dataType = "String", example = "11位数手机号"),
            @ApiImplicitParam(name = "uid", value = "星号", dataType = "String", example = "6位纯数字随机数")
    }
    )
    @CrossOrigin
    @ApiOperation(value = "设置密码,绑定手机号")
    @PostMapping("/updateUserinfo")
    public ResponseEntity<String>  updatePwd( @RequestBody UserInfo user){
        String s = ils.updateUserinfo(user);
        return ResponseEntity.ok(s);
    }
}
