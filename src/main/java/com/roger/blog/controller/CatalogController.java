package com.roger.blog.controller;

import com.roger.blog.dao.CatalogMapper;
import com.roger.blog.model.Catalog;
import com.roger.blog.model.Page;
import com.roger.blog.model.PageList;
import com.roger.blog.model.json.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CatalogController {

    @Autowired
    CatalogMapper catalogMapper;


    @RequestMapping("/adminCatalog")
    public String adminCatalog(){
        return "admin/admin_catalogList";
    }


    @RequestMapping("/adminCatalogListByLimit")
    @ResponseBody
    public PageList adminCatalogListByLimit(Catalog catalog,Page page){
        List<Catalog> catalogList = catalogMapper.getCatalogLimit(catalog,page);
        int count = catalogMapper.getCatalogCount();
        PageList pageList = new PageList(count,catalogList);
        return pageList;
    }

    @RequestMapping("/adminCatalogAdd")
    public String adminCatalogAdd(){
        return "admin/admin_catalogAdd";
    }

    @RequestMapping("/adminAddCatalog")
    @ResponseBody
    public AjaxJson adminAddCatalog(Catalog catalog){
        AjaxJson json = new AjaxJson();
        try {
            catalogMapper.addCatalog(catalog);
            json.setSuccess(true);
        } catch (Exception e) {
            json.setMsg("保存失败");
            json.setSuccess(false);
        }
        return json;
    }

    @RequestMapping("/getAllCatalog")
    @ResponseBody
    public List<Catalog> getAllCatalog(){
        return catalogMapper.getAllCatalog();
    }
}
