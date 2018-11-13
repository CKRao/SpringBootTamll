package com.clarkrao.springboottmall.dao;

import com.clarkrao.springboottmall.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: ClarkRao
 * @Date: 2018/11/13 23:09
 * @Description:
 */
public interface CategoryDAO extends JpaRepository<Category,Integer> {
}
