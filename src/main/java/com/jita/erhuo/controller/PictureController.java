package com.jita.erhuo.controller;

import com.jita.erhuo.common.HttpResult;
import com.jita.erhuo.common.PictureType;
import com.jita.erhuo.form.PictureItem;
import com.jita.erhuo.service.GoodsPictureService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by guitar on 15/2/1.
 */
@Controller
@RequestMapping("/picture")
public class PictureController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoodsPictureService goodsPictureService;

    @ResponseBody
    @RequestMapping(value = "/goods",method = RequestMethod.POST)
    public HttpResult<String> uploadGoodsPic(HttpServletRequest request){

        PictureItem picItem = new PictureItem();
        String picKey = UUID.randomUUID().toString();
        picItem.setId(picKey);
        picItem.setType(PictureType.GOODS);
        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
        try {
            List<FileItem> files = fileUpload.parseRequest(request);
            for(FileItem item:files){
                if(!item.isFormField()){
                    try {
                        picItem.setData(item.getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    if(item.getFieldName().equals("name")){
                        picItem.setOriginalName(item.getString());
                    }else if(item.getFieldName().equals("type")){
                        picItem.setType(item.getString());
                    }
                }
            }
            goodsPictureService.saveGoodsPic(picItem);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return HttpResult.OK(picKey);
    }

    @RequestMapping(value = "/goods/{size}/{key}",method = RequestMethod.GET)
    public void showGoodsPic(@PathVariable String key,@PathVariable String size,HttpServletResponse res){
        try {
            PictureItem pictureItem = goodsPictureService.getGoodsPic(key, size);
            InputStream inputStream = pictureItem.getData();
            BufferedInputStream br = new BufferedInputStream(inputStream);

            res.reset();
            res.setContentType(pictureItem.getType()); //设置返回的文件类型
            OutputStream os = res.getOutputStream();

            byte[] buf = new byte[1024];
            int len = 0;

            while((len = br.read(buf)) > 0){
                os.write(buf,0,len);
            }
            br.close();
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
