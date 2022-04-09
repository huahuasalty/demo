package com.xyh.demo.controller;

import com.xyh.demo.common.BaseResponse;
import com.xyh.demo.serivce.WebSocketServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SocketController {
    private final WebSocketServer socketServer;

    @GetMapping("/test")
    public BaseResponse test(){
        String message = "我是来自服务端的消息";
        WebSocketServer.sessionPools.values().forEach(x->{
            try {
                socketServer.sendMessage(x,message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return BaseResponse.success();
    }
}
