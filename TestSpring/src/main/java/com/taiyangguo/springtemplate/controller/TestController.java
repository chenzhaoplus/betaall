package com.taiyangguo.springtemplate.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import com.taiyangguo.springtemplate.utils.CsvUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: cz
 * @Date: 2021/4/23
 * @Description:
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping(value = "/sendMessage")
    public String sendMessage() throws Exception {
        log.info("[test success]");
        return "success";
    }

    @GetMapping(value = "/gbk")
    public String gbk(HttpServletResponse resp) throws Exception {
        log.info("[gbk]");
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", String.format("attachment;fileName=Excel输出-%s.csv", DateUtil.now()));
        //resp.setCharacterEncoding(CharsetUtil.GBK);

        String pathname = "C:\\Users\\chenz\\Desktop\\utf8.csv";
        File file = new File(pathname);
        List<List<String>> list = CsvUtil.readCsv(pathname);

        //try (ServletOutputStream out = resp.getOutputStream()) {
        try (OutputStreamWriter out = new OutputStreamWriter( resp.getOutputStream(), CharsetUtil.GBK)) {
            for (List<String> cols : list) {
                String data = StringUtils.join(cols, ",") + "\n";
                String gbk = new String(data.getBytes(CharsetUtil.GBK), CharsetUtil.GBK);
                //IOUtils.write(gbk, out);
                out.write(gbk);
            }
            out.flush();
        }

        return "success";
    }

}
