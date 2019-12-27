package cn.xinzhi.xsxs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.xinzhi.xsxs")
public class XsxsApplication {

    public static void main(String[] args) {
        SpringApplication.run(XsxsApplication.class, args);
    }

}
