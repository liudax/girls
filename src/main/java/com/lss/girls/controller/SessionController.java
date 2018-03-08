package com.lss.girls.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Magic
 * @date 16:18 2018/2/28
 * @description
 */
@RequestMapping("/session")
@RestController
public class SessionController {

    @GetMapping("/create")
    public Map<String,Object> createSession(HttpServletRequest request){

        Map mp = new HashMap();
        request.getSession().setAttribute("requestUrl",request.getRequestURL());
        mp.put("requestUrl",request.getSession().getAttribute("requestUrl"));
        return mp;
    }

    @GetMapping("/get")
    public Map<String,Object> getSession(HttpServletRequest request){
        Map mp = new HashMap();
        mp.put("sessionId",request.getSession().getId());
        mp.put("message",request.getSession().getAttribute("requestUrl"));
        return mp;
    }


}
