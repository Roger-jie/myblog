package com.roger.blog.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roger.blog.model.json.AjaxJson;
import com.roger.blog.util.DateUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @Value("${web.upload-path}")
    private String webUploadPath;

    //获取日期，方便创建日期文件夹
    private static String dateString = DateUtils.getDate("yyyy-MM-dd");
    /**
     * markdown文件上传功能
     * @param request
     * @param response
     * @param attach
     */
    @RequestMapping(value="/uploadfile",method= RequestMethod.POST)
    public void upload(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach){
        try {
            uploadFile(request, response, attach);

            //下面response返回的json格式是editor.md所限制的，规范输出就OK
            response.getWriter().write( "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"/" + dateString + attach.getOriginalFilename() + "\"}" );
        } catch (Exception e) {
            try {
                response.getWriter().write( "{\"success\":0}" );
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @RequestMapping(value="/uploadImgs",method= RequestMethod.POST)
    @ResponseBody
    public AjaxJson uploadImgs(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file", required = false) MultipartFile attach){
        AjaxJson json = new AjaxJson();
        try {
            uploadFile(request, response, attach);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("src", "/"+dateString +"/"+attach.getOriginalFilename());
            json.setData(map);
        } catch (IOException e) {
            e.printStackTrace();
            json.setCode(1);
        }
    return json;
    }

    private void uploadFile(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "editormd-image-file", required = false) MultipartFile attach) throws IOException {
        request.setCharacterEncoding( "utf-8" );
        response.setHeader( "Content-Type" , "text/html" );
        String rootPath = webUploadPath + dateString;
        /**
         * 文件路径不存在则需要创建文件路径
         */
        File filePath = new File(rootPath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }

        //最终文件名
        File realFile = new File(rootPath+File.separator+attach.getOriginalFilename());
        FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);
    }


}
