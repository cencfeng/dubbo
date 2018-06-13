package com.cen.dubboconsumer.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cen.dubboapi.entity.Costform;
import com.cen.dubboapi.entity.FormDetail;
import com.cen.dubboapi.service.FormService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/costform")
public class FormController {
    @Reference
    private FormService formService;
    @Value("${file.upload.localpath}")
    private String uploadPath;
    @RequestMapping(value = "/uploadone",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam(value = "file",required = false)MultipartFile file,HttpServletRequest request) throws IOException {
        //JSONObject jsonObject = new JSONObject();
        String result = "failed";
        if(!file.isEmpty())
        {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String strDate = sdf.format(date);
            String fileName=file.getOriginalFilename();
            //System.out.println(fileName);
            fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
            //System.out.println(fileName);
            String newFilename=strDate+fileName;
            //String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
            //String path="D:/file/"+newFilename+"."+prefix;
            String localpath = uploadPath + newFilename;
            java.io.File f = new File(localpath);
            if(!f.getParentFile().exists()){
                f.getParentFile().mkdirs();
            }
            if(f.exists()){
                localpath = uploadPath + "1"+newFilename;
                f = new File(localpath);
            }
            file.transferTo(f);
            result = localpath;
        }
        result = JSON.toJSONString(result);
        return result;
    }
    @RequestMapping(value = "/prform")
    public String prform(HttpServletRequest request, Costform costform){
        String[] description = request.getParameterValues("description");
        String[] quantity = request.getParameterValues("quantity");
        String[] unitprice = request.getParameterValues("unitprice");
        String[] total = request.getParameterValues("total");
        String[] fileatta = request.getParameterValues("fileatta");
        StringBuilder sb = new StringBuilder();
        List<FormDetail> formDetailList = new ArrayList<FormDetail>();
        for(int i=0;i<description.length;i++){
            FormDetail formDetail = new FormDetail();
            formDetail.setPartno(i+1);
            formDetail.setDescription(description[i]);
            formDetail.setQuantity(quantity[i]);
            formDetail.setUnitprice(unitprice[i]);
            formDetail.setTotal(total[i]);
            formDetailList.add(formDetail);
        }
        for (int i = 0;i < fileatta.length; i++){
            if(i > 0) {
                sb.append(";"+fileatta[i] );
            }else{
                sb.append(fileatta[i]);
            }
        }
        costform.setAttaurl(sb.toString());
        formService.insertPrform(costform,formDetailList);
        //formService.insertPrDetail(formDetailList);
        return "prform";
    }
    @RequestMapping(value = "/createformcode")
    @ResponseBody
    public String createFormcode(String dept){
        String formcode = formService.getCodeByDept(dept);
        return formcode;
    }
}