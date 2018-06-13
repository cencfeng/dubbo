package com.cen.dubboconsumer.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.cen.dubboapi.entity.Login;
import com.cen.dubboapi.entity.User;
import com.cen.dubboapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@SessionAttributes("login")
public class UserController {
    @Reference
    private UserService userService;
    @RequestMapping("/login")
    public String login(Login login,HttpSession session){
        login = userService.getUser(login);
        session.setAttribute("user",login);
        if(login != null){
            return "menu";
        }
        return "failed";
    }
    @RequestMapping("/getuserbyname")
    @ResponseBody
    public User getUserByName(@ModelAttribute("login") Login login){
        User user = userService.getUserByName(login.getAccount());
        return user;
    }
    @RequestMapping("/getuserbyaccount")
    @ResponseBody
    public String getUserByAccount(String account){
        User user = userService.getUserByAccount(account);
        if(user != null){
            if(user.getStayintime() != null){
                return "r";//已有账号并已分配宿舍
            }
            return user.getUser_name();
        }
        return "f";//无账号
    }
    @RequestMapping("/applyaccount")
    @ResponseBody
    public boolean applyAccount(HttpServletRequest request, HttpServletResponse response,User user)throws Exception{
        //System.out.println(user.getDept());
        String dept = request.getParameter("ddldept");
        String position = request.getParameter("ddlposition");
        Map<String, Object> hasmap = new HashMap<String, Object>();
        hasmap.put("account",user.getAccount());
        hasmap.put("user_name",user.getUser_name());
        hasmap.put("sex",user.getSex());
        hasmap.put("email",user.getEmail());
        hasmap.put("tel",user.getTel());
        hasmap.put("ic_card",user.getIc_card());
        hasmap.put("location",user.getLocation());
        hasmap.put("dept",dept);
        hasmap.put("position",position);
        hasmap.put("description",user.getDescription());
        userService.insertUser(hasmap);
        return true;
        //return "redirect:/topage/applydormitory";
    }
}
