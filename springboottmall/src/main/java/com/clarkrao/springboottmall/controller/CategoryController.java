package com.clarkrao.springboottmall.controller;

import com.clarkrao.springboottmall.pojo.Category;
import com.clarkrao.springboottmall.service.CategoryService;
import com.clarkrao.springboottmall.util.ImageUtil;
import com.clarkrao.springboottmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: ClarkRao
 * @Date: 2018/11/13 23:17
 * @Description: REST请求控制器
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/categories")
    public Page4Navigator<Category> list(@RequestParam(value = "start", defaultValue = "0")
        int start, @RequestParam(value = "size", defaultValue = "10") int size) throws Exception{
        start = start < 0 ? 0 : start;
        //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        Page4Navigator<Category> page = categoryService.list(start, size, 5);
        return page;
    }

    @PostMapping(value = "/categories")
    public Object add(Category category, MultipartFile image, HttpServletRequest request) throws IOException {
        categoryService.add(category);
        saveOrUpdateImageFile(category, image, request);
        return category;
    }

    private void saveOrUpdateImageFile(Category category, MultipartFile image, HttpServletRequest request) throws IOException {
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder, category.getId() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @DeleteMapping(value = "/categories/{id}")
    public String delete(@PathVariable("id") int id,HttpServletRequest request) throws Exception{
        categoryService.delete(id);
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder, id + ".jpg");
        file.delete();
        return null;
    }

    @GetMapping(value = "/categories/{id}")
    public Category get(@PathVariable("id")int id){
        Category category = categoryService.get(id);
        return category;
    }

    @PutMapping(value = "/categories/{id}")
    public Object update(Category category,MultipartFile image,HttpServletRequest request)
            throws Exception{
        String name = request.getParameter("name");
        category.setName(name);
        categoryService.update(category);

        if (null != image) {
            saveOrUpdateImageFile(category,image,request);
        }

        return category;
    }
}
