package com.clarkrao.springboottmall.controller;

import com.clarkrao.springboottmall.pojo.Property;
import com.clarkrao.springboottmall.service.PropertyService;
import com.clarkrao.springboottmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ClarkRao
 * @Date: 2018/11/18 15:19
 * @Description: Property-REST请求控制器
 */
@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/categories/{cid}/properties")
    public Page4Navigator<Property> list(@PathVariable("cid") int cid,
        @RequestParam(value = "start", defaultValue = "0") int start,
        @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;
        Page4Navigator<Property> page = propertyService.list(cid, start, size, 5);
        return page;
    }

    @GetMapping(value = "/properties/{id}")
    public Property get(@PathVariable("id") int id) throws Exception {
        Property property = propertyService.get(id);
        return property;
    }

    @PostMapping(value = "/properties")
    public Object add(@RequestBody Property property) throws Exception {
        propertyService.add(property);
        return property;
    }

    @DeleteMapping(value = "/properties/{id}")
    public String delete(@PathVariable("id")int id)throws Exception{
        propertyService.delete(id);
        return null;
    }

    @PutMapping("/properties")
    public Object update(@RequestBody Property property)throws Exception{
        propertyService.update(property);
        return property;
    }
}
