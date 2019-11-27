package com.maimai.ueditorsourcecode.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: all
 * @description: 22
 * @author: zxb
 * @create: 2019-11-11 14:32
 **/
@Controller
@RequestMapping("/ueditor")
public class UeditorControler {
    @RequestMapping(value="/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("maimai")
    public String maimai(){
        return "maimai";
    }

    @RequestMapping("/index")
    public String sayHello() {
        return "index";
    }


}