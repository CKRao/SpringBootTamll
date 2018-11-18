package com.clarkrao.springboottmall.dao;

import com.clarkrao.springboottmall.pojo.Category;
import com.clarkrao.springboottmall.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: ClarkRao
 * @Date: 2018/11/18 15:07
 * @Description:
 */
public interface PropertyDAO extends JpaRepository<Property,Integer> {
    /**
     * 通过Category查找Property
     * @param category
     * @param pageable
     * @return
     */
    Page<Property> findByCategory(Category category, Pageable pageable);
}
