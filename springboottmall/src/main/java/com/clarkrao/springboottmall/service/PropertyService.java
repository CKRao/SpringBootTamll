package com.clarkrao.springboottmall.service;

import com.clarkrao.springboottmall.dao.PropertyDAO;
import com.clarkrao.springboottmall.pojo.Category;
import com.clarkrao.springboottmall.pojo.Property;
import com.clarkrao.springboottmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @Author: ClarkRao
 * @Date: 2018/11/18 15:09
 * @Description:
 */
@Service
public class PropertyService {
    @Autowired
    private PropertyDAO propertyDAO;
    @Autowired
    private CategoryService categoryService;

    public void add(Property property) {
        propertyDAO.save(property);
    }

    public void delete(int id) {
        propertyDAO.delete(id);
    }

    public Property get(int id) {
        return propertyDAO.findOne(id);
    }

    public void update(Property property){
        propertyDAO.save(property);
    }

    public Page4Navigator<Property> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);

        Page<Property> pageFromJPA = propertyDAO.findByCategory(category, pageable);

        return new Page4Navigator<Property>(pageFromJPA, navigatePages);
    }
}
