package com.cen.dubboprovider.impl;

import com.cen.dubboapi.entity.*;
import com.cen.dubboapi.service.FormService;
import com.cen.dubboprovider.mapper.FormMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


//@Service
public class FormServiceImpl implements FormService {
    @Autowired
    private FormMapper formMapper;
    @Override
    @Transactional
    public void insertPrform(Costform costform, List<FormDetail> formDetailList, Login login) {
        Date date = new Date();
        formMapper.insertPrform(costform);//写入总表
        formMapper.insertPrDetail(formDetailList);//写入明细表
        List<Signorder> signorderList = formMapper.seletSignOrder(costform);//从签核顺序表中获取信息
        List<Sign> signList = new ArrayList<Sign>();
        for(Signorder signorder : signorderList){
            Sign sign = new Sign();
            sign.setFormtype(signorder.getFormtype());
            sign.setFormcode(costform.getFormcode());
            sign.setCheckname(signorder.getSignname());
            sign.setUsername(signorder.getUsername());
            sign.setSignorder(signorder.getSignorder());
            sign.setAccount(signorder.getAccount());
            if(signorder.getSignorder() == 1){
                sign.setChecktime(date);
                sign.setActive("2");
                sign.setAccount(login.getAccount());
                sign.setInformation(costform.getDelivery());
            }
            else if(signorder.getSignorder() == 2){
                sign.setActive("1");
            }else{
                sign.setActive("0");
            }
            signList.add(sign);
        }
        formMapper.insertSign(signList);//写入签核表
        formMapper.updateFormcode(costform.getFormtype(),costform.getDept());//更新单号生成表+1
    }

    @Override
    public String getCodeByDept(String dept) {
        CreateFormCode createFormCode = formMapper.getCodeByDept(dept,"PR");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String strserial = createFormCode.getSerial();
        Integer codeno = createFormCode.getCodeno();
        String strCondeNo = String.format("%03d", codeno);
        String formcode = createFormCode.getSerial() + "-" + createFormCode.getDept() + sdf.format(date).substring(2) + "-" + strCondeNo;
        return formcode;
    }

    @Override
    public int insertAtta(Atta atta, byte[] filedata) throws IOException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = sdf.format(date);
        //System.out.println(fileName);
        //String prefix = atta.getAttaname().substring(atta.getAttaname().lastIndexOf("//")+1);
        String prefix = atta.getAttaname().substring(atta.getAttaname().lastIndexOf("."));
        //System.out.println(fileName);
        String newFilename=strDate+prefix;
        //String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
        //String path="D:/file/"+newFilename+"."+prefix;
        String serverPath = atta.getAttaurl() + newFilename;
        //System.out.println(serverPath);
        java.io.File f = new File(serverPath);
        if(!f.getParentFile().exists()){
            f.getParentFile().mkdirs();
        }
        if(f.exists()){
            serverPath = atta.getAttaurl() + "1"+newFilename;
            f = new File(serverPath);
        }
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);
            bos.write(filedata);
        }catch (Exception e){

        }finally {
            fos.close();
            bos.close();
        }
        //file.transferTo(f);
        atta.setAttaurl(serverPath);
        int i = formMapper.insertAtta(atta);
        if(i > 0){
            return atta.getId();
        }else {
            return i;
        }
        //System.out.println(i);
        //System.out.println(atta.getId());
    }

    @Override
    public int delAttaBykey(long keyid) {
        return formMapper.delAttaBykey(keyid);
    }

    @Override
    public List<Sign> getSignInfor(String account) {
         return formMapper.getSignInfor(account);
    }

    @Override
    public Sign getSignByFormcode(String formcode) {
        return formMapper.getSignByFormcode(formcode);
    }

    @Override
    public List<Map<String, Object>> getSignsum(String account) {
        return formMapper.getSignsum(account);
    }

    @Override
    public PageInfo<Sign> getPrList(Integer currentPage, Integer pageSize, String formtype, String account) {
        PageHelper.startPage(currentPage,pageSize);
        List<Sign> signList = formMapper.getPrList(formtype, account);
        PageInfo<Sign> pageInfo = new PageInfo<Sign>(signList);
        return pageInfo;
    }

    @Override
    public List<Costform> getPrformInfor(String formcode) {
        return formMapper.getPrformInfor(formcode);
    }

    @Override
    public List<Atta> getAtta(String formcode) {
        return formMapper.getAtta(formcode);
    }

    @Override
    public int signForm(String formcode, String information) {
        int i = formMapper.signForm(formcode, information);
        return i;
    }

    @Override
    public PageInfo<Sign> getSignTableList(String formcode, String formtype, String account, String creatime,Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Sign> signList = new ArrayList<>();
        Sign sign = new Sign();
        if(!(formcode.equals("".toString()))){
        //if(formcode != null){
             sign = formMapper.getSignByFormcode(formcode);
             signList.add(sign);
        }else{
            signList = formMapper.getSignTableList(formcode, formtype, account, creatime);
        }
        PageInfo<Sign> pageInfo = new PageInfo<Sign>(signList);
        return pageInfo;
    }

    @Override
    public List<Sign> getSignTime(String formcode) {
        return formMapper.getSignTime(formcode);
    }
}
