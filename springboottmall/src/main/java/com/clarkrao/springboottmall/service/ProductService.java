package com.clarkrao.springboottmall.service;

import com.clarkrao.springboottmall.dao.ProductDAO;
import com.clarkrao.springboottmall.pojo.Category;
import com.clarkrao.springboottmall.pojo.Product;
import com.clarkrao.springboottmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @Author: ClarkRao
 * @Date: 2018/11/18 19:08
 * @Description:
 */
@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private CategoryService categoryService;

    public void add(Product product) {
        productDAO.save(product);
    }

    public void delete(int id) {
        productDAO.delete(id);
    }

    public Product get(int id) {
        return productDAO.findOne(id);
    }

    public void update(Product product) {
        productDAO.save(product);
    }

    public Page4Navigator<Product> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Product> page = productDAO.findByCategory(category, pageable);
        return new Page4Navigator<Product>(page, navigatePages);
    }
}
