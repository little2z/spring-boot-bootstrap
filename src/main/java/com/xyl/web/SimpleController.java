package com.xyl.web;

import com.xyl.config.MailConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

@Slf4j
@Controller
public class SimpleController {

    @Value("${spring.application.name}")
    private String appName;


    @Autowired
    private  MailConfigProperties mailConfigProperties;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("appName", appName);
        return "index";
    }

//    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/mail")
    @ResponseBody
    public String getMailConfigProperties(){

        return mailConfigProperties.toString();
    }

    @GetMapping("/exception")
    public String testException(){
        throw new RuntimeException("测试异常");
    }

    @ResponseBody
    @RequestMapping("/testReq")
    public String testPost(HttpServletRequest request){

        log.info("request url {}", request.getRequestURL());
        log.info("request uri {}", request.getRequestURI());

        log.info("request QueryString:{}", request.getQueryString());
        try {
            log.info("request body:{}", getInputStreamAsString(request));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }


    private String getInputStreamAsString(HttpServletRequest request) throws IOException {

        int length = request.getContentLength();
        if (length <= 0){
            return null;
        }

        if (request.getContentType().contains("application/x-www-form-urlencoded")){
            //表单方式

            Enumeration<String> enumeration =  request.getParameterNames();
            String element = null;
            while (enumeration.hasMoreElements()){

                element = enumeration.nextElement();

                System.out.println(element);
                System.out.println(request.getParameter(element));
            }

            return null;

        }

        //body体方式
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(length);
        byte[] bytes = new byte[1024*1024];

        int len;
        InputStream inputStream = request.getInputStream();
        try {

            while((len = inputStream.read(bytes)) > 0){
                outputStream.write(bytes, 0, len);
            }
            outputStream.flush();
            return outputStream.toString();
        } finally {

            if (inputStream != null){
                inputStream.close();
            }
        }
    }

}
