package mizushio_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * 本demo只是简单的整理了下，关于数据库部分暂时没添加，另一个线上版本有用mybais实现版本。jdbc我需要一个demo（悲）
 * 接口样板已经完成。
 */


@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class MizushioSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MizushioSecurityApplication.class, args);
    }

}
