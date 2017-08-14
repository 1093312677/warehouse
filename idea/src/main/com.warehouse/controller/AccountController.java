package com.warehouse.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kone on 2017-08-05.
 */
@Controller
@RequestMapping("/controller/account")
public class AccountController {

    @RequestMapping("/login")
    public String login() {
        System.out.print("ok");
        return "main";
    }
}
