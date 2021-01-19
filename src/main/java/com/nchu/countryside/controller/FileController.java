package com.nchu.countryside.controller;

import com.nchu.countryside.domain.entity.JsonResult;
import com.sun.deploy.net.HttpResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * @program: countryside
 * @author: Xing guo ning
 * @description：
 * @Date: 2021-01-19 14:40
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @PostMapping("/upLoads")
    @ApiOperation(value = "文件上传")
    public JsonResult upLode(MultipartFile upload, HttpServletRequest req) throws IOException {
        log.info("文件开始上传");
        //先获取到要上传文件的目录
        String path  = req.getSession().getServletContext().getRealPath("/uploads");
        // 创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()) {
            file.mkdirs();
        }
        // 获取到上传文件的名称
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        // 把文件的名称唯一化
        filename = uuid+"_"+filename;
        // 上传文件
        upload.transferTo(new File(file,filename));
        return new JsonResult().ok();
    }

    @PostMapping("/downFile")
    @ApiOperation(value = "文件下载")
    public void download(@RequestParam String fileName , HttpServletResponse response, HttpServletRequest req){

        //先获取到要下载文件的目录
        String path  = req.getSession().getServletContext().getRealPath("/uploads");
        ////待下载文件名
        //String fileName = "1.png";
        //设置为png格式的文件
        response.setHeader("content-type", "image/png");
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName+".pdf");
        byte[] buff = new byte[1024];
        //创建缓冲输入流
        BufferedInputStream bis = null;
        OutputStream outputStream = null;

        try {
            outputStream = response.getOutputStream();

            //这个路径为待下载文件的路径
            bis = new BufferedInputStream(new FileInputStream(new File(path +"/"+ fileName+".pdf")));
            int read = bis.read(buff);

            //通过while循环写入到指定了的文件夹中
            while (read != -1) {
                outputStream.write(buff, 0, buff.length);
                outputStream.flush();
                read = bis.read(buff);
            }
        } catch ( IOException e ) {
            e.printStackTrace();

        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
