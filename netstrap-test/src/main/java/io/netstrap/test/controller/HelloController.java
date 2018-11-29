package io.netstrap.test.controller;

import io.netstrap.core.server.http.datagram.HttpRequest;
import io.netstrap.core.server.http.datagram.HttpResponse;
import io.netstrap.core.server.http.wrapper.HttpBody;
import io.netstrap.core.server.mvc.stereotype.GetMapping;
import io.netstrap.core.server.mvc.stereotype.PostMapping;
import io.netstrap.core.server.mvc.stereotype.RestController;
import io.netstrap.test.config.WechatConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description 控制器示例
 * @author minghu.zhang
 * @date 2018/11/29 11:01
 */
@RestController
@Log4j2
public class HelloController {

    private final WechatConfig config;

    @Autowired
    public HelloController(WechatConfig config) {
        this.config = config;
    }

    /**
     * 打印字符串
     */
    @GetMapping("/hello")
    public void hello(HttpRequest request, HttpResponse response) {
        response.setBody(HttpBody.wrap("hello netstrap".getBytes()));
    }

    /**
     * 打印字符串
     */
    @PostMapping("/hi")
    public String hi(HttpRequest request, HttpResponse response) {
        return "hi netstrap";
    }

    /**
     * 打印配置对象
     */
    @GetMapping("/config")
    public WechatConfig config(HttpRequest request, HttpResponse response) {
        return config;
    }

}