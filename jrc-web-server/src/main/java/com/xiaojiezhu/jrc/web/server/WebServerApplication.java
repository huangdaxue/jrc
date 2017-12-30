package com.xiaojiezhu.jrc.web.server;

import com.xiaojiezhu.jrc.web.server.support.WebMvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * start web server
 * @author xiaojie.zhu
 */
@Import({WebMvcConfig.class})
@SpringBootApplication
public class WebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServerApplication.class,args);
    }
}