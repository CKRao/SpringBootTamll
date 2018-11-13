package com.clarkrao.springboottmall.service;

import com.clarkrao.springboottmall.dao.CategoryDAO;
import com.clarkrao.springboottmall.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ClarkRao
 * @Date: 2018/11/13 23:11
 * @Description:
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    public List<Category> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }
}
