package com.xiaojiezhu.jrc.web.server;

import com.xiaojiezhu.jrc.web.server.support.WebJsonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * start web server
 */
@Import({WebJsonConfig.class})
@SpringBootApplication
public class WebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServerApplication.class,args);
    }
}