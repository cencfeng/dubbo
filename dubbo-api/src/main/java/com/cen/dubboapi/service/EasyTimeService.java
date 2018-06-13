package com.cen.dubboapi.service;

import com.cen.dubboapi.entity.Article;
import com.cen.dubboapi.entity.Dept;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EasyTimeService {
    PageInfo<Article> getJoke(Integer currentPage, Integer pageSize);
    void invokPython();
}
