package com.lss.girls.controller;

import com.lss.girls.dao.GirlRepository;
import com.lss.girls.entity.Girl;
import com.lss.girls.webSocket.MyWebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Magic
 * @date 10:08 2018/2/11
 * @description
 */
@RestController
public class TestController {

    @Autowired
    private GirlRepository girlRepository;

    @GetMapping("test")
    public List<Girl> test(){
        List<Girl> girls = girlRepository.findAll();
        return girls;
       // return null;
    }

    @GetMapping("/file")
    public String fileTest() throws  Exception{
//        String result = fastDFSClient.uploadFile("\\C:\\Users\\Magic\\Desktop\\test.png", "png", null);
//        return result;
        return "";
    }

    @GetMapping("/deploy/{username}")
    public String deploy(@PathVariable String username) throws Exception{
        MyWebSocket.sendText(username,"hello,我是服务器");
        return "发送成功";
    }
}
