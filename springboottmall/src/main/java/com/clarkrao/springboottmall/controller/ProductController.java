package com.clarkrao.springboottmall.controller;

import com.clarkrao.springboottmall.pojo.Product;
import com.clarkrao.springboottmall.service.CategoryService;
import com.clarkrao.springboottmall.service.ProductService;
import com.clarkrao.springboottmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author: ClarkRao
 * @Date: 2018/11/18 19:16
 * @Description:
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories/{cid}/products")
    public Page4Navigator<Product> list(@PathVariable("cid") int cid,
    @RequestParam(name = "start",defaultValue = "0") int start,
    @RequestParam(name = "size",defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;
        Page4Navigator<Product> page = productService.list(cid, start, size, 5);
        return page;
    }

    @GetMapping("/products/{id}")
    public Product get(@PathVariable("id") int id) throws Exception{
        Product product = productService.get(id);
        return product;
    }

    @PostMapping("/products")
    public Object add(@RequestBody Product product) {
        product.setCreateDate(new Date());
        productService.add(product);
        return product;
    }

    @DeleteMapping("/products/{id}")
    public String delete(@PathVariable("id") int id){
        productService.delete(id);
        return null;
    }

    @PutMapping("/products")
    public Object update(@RequestBody Product product) {
        productService.update(product);
        return product;
    }
}
