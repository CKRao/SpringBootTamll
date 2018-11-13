package com.clarkrao.springboottmall.controller;

import com.clarkrao.springboottmall.pojo.Category;
import com.clarkrao.springboottmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ClarkRao
 * @Date: 2018/11/13 23:17
 * @Description:
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/categories")
    public List<Category> list() throws Exception{
        return categoryService.list();
    }
}
