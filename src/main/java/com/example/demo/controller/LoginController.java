package com.example.demo.controller;



import com.example.demo.util.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private String userName="admin";

    private String userPwd = "123";


    @PostMapping("/login")
    public String login(User user, HttpServletRequest req, HttpServletResponse rep){
        if(user==null && "".equals(user.getName())&& "".equals(user.getPwd())){
            return "redirect:/";
        }else if(!user.getName().equals(userName)  || !user.getPwd().equals(userPwd)){
            return "redirect:/";

        }else{

           req.getSession().setAttribute("user",user);
           return "redirect:/home";
        }

    }

    @GetMapping("/loginout")
    public String loginout(HttpServletRequest req){
        HttpSession s = req.getSession();
        if(s.getAttribute("user")!=null){

            s.removeAttribute("user");
        }
        return "redirect:/";



    }
}
