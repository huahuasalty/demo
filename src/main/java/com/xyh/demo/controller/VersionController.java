package com.xyh.demo.controller;

import com.xyh.demo.common.BaseResponse;
import com.xyh.demo.serivce.VersionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/version")
@RequiredArgsConstructor
public class VersionController {
    private final VersionService versionService;

    @PostMapping("/exportExcel")
    public BaseResponse exportExcel(){
        versionService.exportExcel();
        return BaseResponse.success();
    }

    @PostMapping("/importExcel")
    public BaseResponse importExcel(MultipartFile file){
        versionService.importExcel(file);
        return BaseResponse.success();
    }
}
