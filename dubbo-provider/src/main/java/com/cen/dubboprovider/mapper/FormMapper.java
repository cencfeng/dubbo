package com.cen.dubboprovider.mapper;
import com.cen.dubboapi.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface FormMapper {
    void insertPrform(Costform costform);
    void insertPrDetail(List<FormDetail> formDetailList);
    int insertSign(List<Sign> signList);
    //int insertAtta(@Param("formcode") String formcode, @Param("attaurl") String attaurl);
    int insertAtta(Atta atta);
    int delAttaBykey(long keyid);
    int updateFormcode(@Param("formtype") String formtype,@Param("dept") String dept);
    List<Signorder> seletSignOrder(Costform costform);
    CreateFormCode getCodeByDept(@Param("dept") String dept,@Param("formtype")String formtype);
    List<Sign> getSignInfor(String account);
    List<Map<String, Object>> getSignsum(String account);
    List<Sign> getPrList(@Param("formtype") String formtype, @Param("account") String account);
    List<Costform> getPrformInfor(String formcode);
    List<Atta> getAtta(String formcdoe);
    Sign getSignByFormcode(String formcode);
    int signForm(@Param("formcode") String formcode, @Param("information")String information);
    List<Sign> getSignTableList(@Param("formcode")String formcode, @Param("formtype")String formtype, @Param("account")String account, @Param("creatime")String creatime);
    List<Sign> getSignTime(String formcode);
}
