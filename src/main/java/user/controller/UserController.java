package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import user.model.Login;
import user.model.User;
import user.service.impl.IUserService;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/home")
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView("user/home","login",new Login());
        return modelAndView;
    }

    @PostMapping("login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = userService.checkLogin(login);
        ModelAndView modelAndView  = new ModelAndView();
        if (user==null){
            modelAndView.setViewName("user/error");
        }else {
            modelAndView.setViewName("user/user");
            modelAndView.addObject("user",user);
        }
        return modelAndView;
    }
}
