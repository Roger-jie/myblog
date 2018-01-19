package com.roger.blog.controller;

import com.alibaba.fastjson.JSON;
import com.roger.blog.dao.TagMapper;
import com.roger.blog.model.Tag;
import com.roger.blog.model.json.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TagController {

    @Autowired
    TagMapper tagMapper;

    @RequestMapping("/getListTag")
    @ResponseBody
    public AjaxJson getListTag(){
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

    @RequestMapping("/getAutocompleteTag")
    @ResponseBody
    public JSON getAutocompleteTag(){
        List<Tag> list = tagMapper.getAllTag();
        List<Map<String,Object>> jsonList = new ArrayList<>();
        Map<String,Object> map ;
        for (Tag tag : list) {
            map = new HashMap<>();
            map.put("value",tag.getName());
            jsonList.add(map);
        }
        JSON json = (JSON) JSON.toJSON(jsonList);
        return json;
    }
}
