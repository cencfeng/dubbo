package com.cen.dubboprovider.mapper;
import com.cen.dubboapi.entity.Costform;
import com.cen.dubboapi.entity.CreateFormCode;
import com.cen.dubboapi.entity.FormDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FormMapper {
    void insertPrform(Costform costform);
    void insertPrDetail(List<FormDetail> formDetailList);
    void insertSign(String formtype);
    CreateFormCode getCodeByDept(@Param("dept") String dept,@Param("formtype")String formtype);
}
