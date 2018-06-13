package com.cen.dubboprovider.impl;

import com.cen.dubboapi.entity.Costform;
import com.cen.dubboapi.entity.CreateFormCode;
import com.cen.dubboapi.entity.FormDetail;
import com.cen.dubboapi.service.FormService;
import com.cen.dubboprovider.mapper.FormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//@Service
public class FormServiceImpl implements FormService {
    @Autowired
    private FormMapper formMapper;

    @Override
    @Transactional
    public void insertPrform(Costform costform,List<FormDetail> formDetailList) {

        formMapper.insertPrform(costform);
        formMapper.insertPrDetail(formDetailList);
        formMapper.insertSign("PR");
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
}
