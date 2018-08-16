package com.cen.dubboapi.service;

import com.cen.dubboapi.entity.*;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface FormService {
   void insertPrform(Costform costform, List<FormDetail> formDetailList, Login login);
   String getCodeByDept(String dept);
   int insertAtta(Atta atta, byte[] filedata) throws IOException;
   int delAttaBykey(long keyid);
   List<Sign> getSignInfor(String account);
   Sign getSignByFormcode(String formcode);
   List<Map<String, Object>> getSignsum(String account);
   PageInfo<Sign> getPrList(Integer currentPage, Integer pageSize,String formtype, String account);
   List<Costform> getPrformInfor(String formcode);
   List<Atta> getAtta(String formcode);
   int signForm(String formcode,String information);
   PageInfo<Sign> getSignTableList(String formcode, String formtype, String account, String creatime, Integer currentPage, Integer pageSize);
   List<Sign> getSignTime(String formcode);
   //void insertPrDetail(List<FormDetail> formDetailList);
}
