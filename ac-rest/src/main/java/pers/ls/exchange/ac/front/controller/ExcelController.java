package pers.ls.exchange.ac.front.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pers.ls.exchange.ac.front.util.ExcelUtil;

import java.io.IOException;
import java.util.List;

@RestController
public class ExcelController {

    @PostMapping("parseExcel")
    public List parseExcel(MultipartFile file) throws IOException, InstantiationException, IllegalAccessException {
        return ExcelUtil.readExcel(file.getInputStream(),Student.class);
    }
}
