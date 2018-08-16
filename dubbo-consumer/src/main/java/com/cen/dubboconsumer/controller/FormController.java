package com.cen.dubboconsumer.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cen.dubboapi.entity.*;
import com.cen.dubboapi.service.FormService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/costform")
public class FormController {
    @Reference
    private FormService formService;
    @Value("${file.upload.localpath}")
    private String uploadPath;
    @RequestMapping(value = "/uploadone",method = RequestMethod.POST)
    @ResponseBody
    public int upload(@RequestParam(value = "file",required = false)MultipartFile file,HttpServletRequest request,@RequestParam(value = "formcode",required = false)String formcode) throws IOException {
        //JSONObject jsonObject = new JSONObject();
        //System.out.println(formcode);
        //String result = "failed";
        int i = 0;
        if(!file.isEmpty())
        {
            Atta atta = new Atta();
            atta.setFormcode(formcode);
            atta.setAttaurl(uploadPath);
            atta.setAttaname(file.getOriginalFilename());
            byte[] filedata = file.getBytes();
            i = formService.insertAtta(atta, filedata);
            //result = "success";
        }
        return i;
        //result = JSON.toJSONString(result);
        //return result;
    }
    @RequestMapping(value = "/prform")
    @ResponseBody
    public String prform(HttpServletRequest request, HttpServletResponse response, Costform costform, HttpSession session) throws IOException {
        String[] description = request.getParameterValues("description");
        String[] quantity = request.getParameterValues("quantity");
        String[] unitprice = request.getParameterValues("unitprice");
        String[] total = request.getParameterValues("total");
        //String[] fileatta = request.getParameterValues("fileatta");
        //StringBuilder sb = new StringBuilder();
        List<FormDetail> formDetailList = new ArrayList<FormDetail>();
        for(int i=0;i<description.length;i++){
            FormDetail formDetail = new FormDetail();
            formDetail.setFormcode(costform.getFormcode());
            formDetail.setPartno(i+1);
            formDetail.setDescription(description[i]);
            formDetail.setQuantity(quantity[i]);
            formDetail.setUnitprice(unitprice[i]);
            formDetail.setTotal(total[i]);
            formDetailList.add(formDetail);
        }
//        response.setContentType("text/html; charset=UTF-8"); //转码
//        PrintWriter out = response.getWriter();
//        out.flush();
//        out.println("<script>alert('提交成功！');history.back();</script>");
//        out.close();
        /*for (int i = 0;i < fileatta.length; i++){
            if(i > 0) {
                sb.append(";"+fileatta[i] );
            }else{
                sb.append(fileatta[i]);
            }
        }*/
        //costform.setAttaurl(sb.toString());
        Login login = (Login)session.getAttribute("login");
        formService.insertPrform(costform,formDetailList,login);
        //formService.insertPrDetail(formDetailList);
        return "success";
    }
    @RequestMapping(value = "/createformcode")
    @ResponseBody
    public String createFormcode(String dept){
        String formcode = formService.getCodeByDept(dept);
        return formcode;
    }
    @RequestMapping("/delatta")
    @ResponseBody
    public int delAttaBykey(long keyid){
        return formService.delAttaBykey(keyid);
    }
    @RequestMapping("/getsigninfor")
    @ResponseBody
    public List<Sign> getSignInfor(HttpSession session){
        Login login = (Login)session.getAttribute("login");
        Object object = session.getAttribute("login");
//        Login login = new Login();
//        if(obj instanceof Login) {
//            login = (Login) obj;
//        }
        return formService.getSignInfor(login.getAccount());
    }
    @RequestMapping("/getsignsum")
    @ResponseBody
    public List<Map<String, Object>> getSignsum(HttpSession session){
        Login login = (Login)session.getAttribute("login");
       //System.out.println("11111");
        List<Map<String,Object>> mapList = formService.getSignsum(login.getAccount());
        return mapList;
    }
    @RequestMapping("/getprlist")
    @ResponseBody
    public PageInfo<Sign> getPrList(Integer currentPage, Integer pageSize,String formtype, HttpSession session){
        Login login = (Login)session.getAttribute("login");
        PageInfo<Sign> pageInfo =  formService.getPrList(currentPage, pageSize, formtype, login.getAccount());
        return pageInfo;
    }
    @RequestMapping("/prformsign/{view}")
    public ModelAndView getPrFormInfor(HttpServletRequest request,@PathVariable(name = "view",required = false)String view){
        String formcode = request.getParameter("formcode");
        List<Costform> costformList = formService.getPrformInfor(formcode);
        ModelAndView mv = new ModelAndView("prformsign");
        mv.addObject("costformList", costformList);
        mv.addObject("view", view);
        return mv;
    }
    @RequestMapping("/getatta")
    @ResponseBody
    public List<Atta> getAtta(String formcode){
        return formService.getAtta(formcode);
    }
    @RequestMapping("/signform")
    @ResponseBody
    public String signForm(HttpServletRequest request, HttpSession session) throws IOException {
//        response.setContentType("text/html; charset=UTF-8"); //转码
//        PrintWriter out = response.getWriter();
//        out.flush();
//        try{
        String formtype = request.getParameter("formtype");
        String information = request.getParameter("information");
        String formcode = request.getParameter("formcode");
        Login login = (Login)session.getAttribute("login");
        Sign sign = formService.getSignByFormcode(formcode);
        String a = login.getAccount();
        String b = sign.getAccount();
        if(sign.getAccount().equals(login.getAccount())){
            formService.signForm(formcode, information);
            return "success";
        }else {
            return "failed";
        }
           // out.print("<script>alert('签核成功！');</script>");
//        }catch (Exception e){
            //out.println("<script>alert('发生错误,请联系管理员！'"+e.toString()+");history.back();</script>");
//        }finally {
           // out.close();
//        }

    }
    @RequestMapping("/formsignlist/{formtype}")
    public ModelAndView formSignList(@PathVariable(name = "formtype",required = false)String formtype, HttpSession session){
        ModelAndView mv = new ModelAndView("formsignlist");
        mv.addObject("formtype", formtype);
        return mv;
    }
    @RequestMapping("/getformlist")
    @ResponseBody
    public PageInfo<Sign> getFormList(HttpSession session, String formcode, String formtype, String account, String creatime, Integer currentPage, Integer pageSize){
        Login login = (Login)session.getAttribute("login");
        PageInfo<Sign> pageInfo = formService.getSignTableList(formcode, formtype, login.getAccount(), creatime,currentPage, pageSize);
        return pageInfo;
    }
    @RequestMapping("/getSignTime")
    @ResponseBody
    public List<Sign> getSignTime(String formcode){
        List<Sign> signList = formService.getSignTime(formcode);
        return signList;
    }
}