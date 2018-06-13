package com.cen.dubboapi.service;

import com.cen.dubboapi.entity.Costform;
import com.cen.dubboapi.entity.FormDetail;

import java.util.List;

public interface FormService {
   void insertPrform(Costform costform, List<FormDetail> formDetailList);
   String getCodeByDept(String dept);
   //void insertPrDetail(List<FormDetail> formDetailList);
}
