package com.clarkrao.springboottmall.controller;

import com.clarkrao.springboottmall.pojo.Category;
import com.clarkrao.springboottmall.service.CategoryService;
import com.clarkrao.springboottmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Page4Navigator<Category> list(@RequestParam(value = "start", defaultValue = "0")
        int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        start = start < 0 ? 0 : start;
        //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        Page4Navigator<Category> page = categoryService.list(start, size, 5);
        return page;
    }
}
