package com.cen.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cen.dubboapi.entity.Dormitory;
import com.cen.dubboapi.entity.User;
import com.cen.dubboapi.service.DormitoryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/dormitory")
public class DormitoryController {
    @Reference
    private DormitoryService dormitoryService;
    @RequestMapping("/getdormitoryname")
    @ResponseBody
    public List<Dormitory> getDormitoryName(){
        return dormitoryService.getDormitoryName();
    }
    @RequestMapping("/getallroombydormitoryname")
    @ResponseBody
    public List<Dormitory> getAllRoomeByDormitoryName(String dormitoryName){
        return dormitoryService.getAllRoomByDormitoryName(dormitoryName);
    }
    @RequestMapping("/getdormitoryinfor")
    @ResponseBody
    public PageInfo<Dormitory> getDormitoryInfor(String dormitoryName, String room, String searchDate, Integer currentPage, Integer pageSize){
        PageInfo<Dormitory> pageInfo =  dormitoryService.getDormitoryInfor(dormitoryName, room, searchDate, currentPage, pageSize);
        return pageInfo;
    }
    @RequestMapping("/getdormitorymember")
    @ResponseBody
    public PageInfo<User> getDormitoryMember(String dormitoryName, String room, Integer currentPage, Integer pageSize){
        PageInfo<User> pageInfo =  dormitoryService.getDormitoryMember(dormitoryName, room, currentPage, pageSize);
        return pageInfo;
    }
    @RequestMapping("/getleftroombydormitoryname")
    @ResponseBody
    public List<Dormitory> getLeftRoomByDormitoryName(String dormitoryName){
        return dormitoryService.getLeftRoomByDormitory(dormitoryName);
    }
    @RequestMapping("/applydormitory")
    @ResponseBody
    public boolean applyDormitory(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //response.setContentType("text/html; charset=UTF-8"); //转码
        //PrintWriter out = response.getWriter();
        //out.flush();
        //try {
            String account = request.getParameter("txtAccount");
            String userName = request.getParameter("txtName");
            String dormitoryName = request.getParameter("dormitoryName");
            String room = request.getParameter("room");
           int row = dormitoryService.applyDormitory(account, userName, dormitoryName, room);
            //out.print("<script>alert('申请成功！');history.back();</script>");
       /* }catch (Exception e){
            //return false;
            //out.println("<script>alert('发生错误,请联系管理员！'"+e.toString()+");history.back();</script>");
        }finally {
            //out.close();
        }*/
        if(row > 0){
            return true;
        }
        else{
            return false;
        }
        //return "redirect:/topage/applydormitory";
    }
}
