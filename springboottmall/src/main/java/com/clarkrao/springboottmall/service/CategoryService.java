package com.clarkrao.springboottmall.service;

import com.clarkrao.springboottmall.dao.CategoryDAO;
import com.clarkrao.springboottmall.pojo.Category;
import com.clarkrao.springboottmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page4Navigator<Category> list(int start,int size,int navigatePages){
        Page4Navigator<Category> page4Navigator;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page pageFromJPA = categoryDAO.findAll(pageable);
        page4Navigator = new Page4Navigator<>(pageFromJPA, navigatePages);
        return page4Navigator;
    }

    public List<Category> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }

    public void add(Category category){
        categoryDAO.save(category);
    }

    public void delete(int id){
        categoryDAO.delete(id);
    }

    public Category get(int id){
        Category category = categoryDAO.findOne(id);
        return category;
    }

    public void update(Category category){
        categoryDAO.save(category);
    }
}
