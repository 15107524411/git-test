package com.ldc.my.shop.web.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UploadController {
    private static final String FILE_UPLOAD_PATH = "static" + File.separator + "upload";

    @ResponseBody
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Map<String,Object> upload(MultipartFile imgfile,MultipartFile[] editorFiles  ,HttpServletRequest request) {
        HashMap<String, Object> map = Maps.newHashMap();
        /**
         * dropzone上传
         */
        if (imgfile != null){
            map.put("filePath",write(request,imgfile));
            System.out.println(map.get("filePath"));
        }
        //wangEdritor上传
        else {
            ArrayList<String> list = Lists.newArrayList();
            for ( MultipartFile editorFile:editorFiles){
                list.add(write(request,editorFile));
            }
            map.put("errno", 0);
            map.put("data",list);

        }
            return map;
    }

    /**
     * 写文件
     * @param request
     * @param multipartFile
     * @return 文件路径
     */
    private String write(HttpServletRequest request, MultipartFile multipartFile) {
        // 获取上传路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String filePath = realPath + FILE_UPLOAD_PATH;

        // 先判断上传路径是否存在
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }

        // 获取文件名后缀
        String name = multipartFile.getOriginalFilename();
        String suffix = name.substring(name.lastIndexOf("."));
        String filename = UUID.randomUUID().toString().replace("-", "") + suffix;
        File uploadFile = new File(filePath + File.separator + filename);

        try {
            multipartFile.transferTo(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.format("%s://%s:%s/%s/%s", request.getScheme(), request.getServerName(), request.getServerPort(), FILE_UPLOAD_PATH, filename);
    }
}
