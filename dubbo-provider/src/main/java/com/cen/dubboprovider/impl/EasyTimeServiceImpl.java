package com.cen.dubboprovider.impl;

import com.cen.dubboapi.entity.Article;
import com.cen.dubboapi.service.EasyTimeService;
import com.cen.dubboprovider.mapper.EasyTimeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

//@Service
public class EasyTimeServiceImpl implements EasyTimeService {
    @Autowired
    private EasyTimeMapper easyTimeMapper;
    @Override
    public PageInfo<Article> getJoke( Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Article> articleList = easyTimeMapper.getJoke();
        PageInfo<Article> pageInfo = new PageInfo<>(articleList);
        return pageInfo;
    }

    @Override
    public void invokPython() {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("D:\\alltxt\\mytest.py");

        //PyFunction function = (PyFunction)interpreter.get("my_test",PyFunction.class);
        //PyObject pyobject = function.__call__(new PyString("huzhiwei"),new PyString("25"));
    }
}
