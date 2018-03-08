package com.lss.girls.controller;

import com.lss.girls.util.DFSClient;
import com.lss.girls.util.FastFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Magic
 * @date 11:22 2018/2/28
 * @description
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private DFSClient dfsClient;

    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file,String key,String value) throws IOException, MyException {
        FastFile fastFile = new FastFile();
        String fileName = file.getOriginalFilename();
        fileName = fileName.substring(fileName.lastIndexOf(".")+1);
        fastFile.setContent(file.getBytes());
        fastFile.setExtName(fileName.substring(fileName.lastIndexOf(".")+1));
        fastFile.setPairs(new NameValuePair[]{new NameValuePair(key,value)});
        String result = dfsClient.uploadFile(fastFile);
        return result;
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(String fileId,String specFileName) throws IOException, MyException {
        String extName = fileId.substring(fileId.lastIndexOf("."));
        byte[] content = dfsClient.downloadFile(fileId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment",new String(specFileName.getBytes(),"iso-8859-1")+extName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(content,headers, HttpStatus.CREATED);
    }


}
