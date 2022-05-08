package com.util;

import com.controller.BaseController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class ControllerUtil extends BaseController {

    public static String uploadImgFile(HttpServletRequest request, MultipartFile multipartFile){
        String originalFilename = multipartFile.getOriginalFilename();
        ServletContext servletContext = request.getServletContext();
        String imgPath = servletContext.getRealPath("/img/");
        String realPath = imgPath+originalFilename;
        File file = createFile(realPath);
        String contextPath = servletContext.getContextPath();
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contextPath+"/img/"+originalFilename;

    }

    //方法重载
    public static File createFile(String path,String filename){
        File file = new File(path, filename);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    //方法重载
    public static File createFile(String realPath){
        File file = new File(realPath);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static Integer checkPageNum(Integer pageNum){
        if (pageNum <=0 ){
            pageNum=1;
            return pageNum;
        }else {
            return pageNum;
        }
    }
}
