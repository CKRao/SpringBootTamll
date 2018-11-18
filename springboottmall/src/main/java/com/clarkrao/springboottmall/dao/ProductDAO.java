package com.clarkrao.springboottmall.dao;

import com.clarkrao.springboottmall.pojo.Category;
import com.clarkrao.springboottmall.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: ClarkRao
 * @Date: 2018/11/18 19:06
 * @Description:
 */
public interface ProductDAO extends JpaRepository<Product,Integer> {

    Page<Product> findByCategory(Category category,Pageable pageable);
}
