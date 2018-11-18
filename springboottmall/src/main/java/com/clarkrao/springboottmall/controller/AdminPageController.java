package com.clarkrao.springboottmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ClarkRao
 * @Date: 2018/11/13 23:14
 * @Description: 后台页面跳转控制器
 */
@Controller
public class AdminPageController {
    //category
    @GetMapping(value = "/admin")
    public String admin(){
        return "redirect:admin_category_list";
    }

    @GetMapping(value = "/admin_category_list")
    public String listCategory(){
        return "admin/listCategory";
    }

    @GetMapping(value = "/admin_category_edit")
    public String editCategory(){
        return "admin/editCategory";
    }
    //order
    @GetMapping(value="/admin_order_list")
    public String listOrder(){
        return "admin/listOrder";

    }
    //product
    @GetMapping(value="/admin_product_list")
    public String listProduct(){
        return "admin/listProduct";

    }

    @GetMapping(value="/admin_product_edit")
    public String editProduct(){
        return "admin/editProduct";

    }
    //productImage
    @GetMapping(value="/admin_productImage_list")
    public String listProductImage(){
        return "admin/listProductImage";

    }

    //property
    @GetMapping(value="/admin_property_list")
    public String listProperty(){
        return "admin/listProperty";

    }

    @GetMapping(value="/admin_property_edit")
    public String editProperty(){
        return "admin/editProperty";

    }
    //propertyValue
    @GetMapping(value="/admin_propertyValue_edit")
    public String editPropertyValue(){
        return "admin/editPropertyValue";

    }
    //user
    @GetMapping(value="/admin_user_list")
    public String listUser(){
        return "admin/listUser";

    }

}
