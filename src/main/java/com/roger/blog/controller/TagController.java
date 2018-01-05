package com.roger.blog.controller;

import com.roger.blog.dao.TagMapper;
import com.roger.blog.model.Tag;
import com.roger.blog.model.json.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TagController {

    @Autowired
    TagMapper tagMapper;

    @RequestMapping("/getAllTag")
    @ResponseBody
    public AjaxJson getAllTag(){
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setSuccess(true);
        try {
            List<Tag> list = tagMapper.getAllTag();
            ajaxJson.setData(list);
        } catch (Exception e) {
            e.getMessage();
            ajaxJson.setSuccess(false);
        }
        return ajaxJson;
    }
}
