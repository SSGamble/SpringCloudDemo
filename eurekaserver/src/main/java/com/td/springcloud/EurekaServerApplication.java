package com.td.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import cn.hutool.core.util.NetUtil;

/**
 * EurekaServer 启动类。
 * 这是一个 EurekaServer ，它扮演的角色是注册中心，用于注册各种微服务，以便于其他微服务找到和访问。
 */
@SpringBootApplication // EurekaServer 本身就是个 SpringBoot 微服务, 所以它有 @SpringBootApplication 注解。
@EnableEurekaServer // @EnableEurekaServer 表示这是个 EurekaServer 。
public class EurekaServerApplication {

    public static void main(String[] args) {
        // 8761 这个端口是默认的，就不要修改了，后面的子项目，都会访问这个端口。
        int port = 8761;
        if(!NetUtil.isUsableLocalPort(port)) { // NetUtil 是 Hutool 的工具，在父项目的 pom.xml 里已经依赖了。
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(EurekaServerApplication.class).properties("server.port=" + port).run(args);
    }
}
