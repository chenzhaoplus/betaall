package com.taiyangguo.springtemplate.utils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.util.CollectionUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CsvUtil {

    @SneakyThrows(FileNotFoundException.class)
    public static List<List<String>> readCsv(String filePath) {
        return readCsv(new FileInputStream(filePath));
    }

    public static List<List<String>> readCsv(InputStream is) {
        try (InputStream is0 = is) {
            List<String> lines = IOUtils.readLines(is0);
            if (CollectionUtils.isEmpty(lines)) {
                return new ArrayList<>();
            }
            return lines.stream().map(line -> {
                String[] lineArr = line.split(",");
                List<String> cols = new ArrayList<>();
                Arrays.stream(lineArr).forEach(col -> cols.add(onDoubleQuotation(col)));
                return cols;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("读取csv文件失败：", e);
            return new ArrayList<>();
        }
    }

    public static String onDoubleQuotation(String s) {
        return s.contains(",") ? "\"" + s + "\"" : s;
    }

}
