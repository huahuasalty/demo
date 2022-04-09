package com.xyh.demo.serivce.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.xyh.demo.domain.po.YbsVersionInfoPo;
import com.xyh.demo.domain.po.YbsVersionInfoPoExample;
import com.xyh.demo.listener.VersionUploadListener;
import com.xyh.demo.mapper.YbsVersionInfoPoMapper;
import com.xyh.demo.serivce.VersionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class VersionServiceImpl implements VersionService {

    private final YbsVersionInfoPoMapper versionInfoPoMapper;
    private final VersionUploadListener versionUploadListener;
    @Override
    public List<YbsVersionInfoPo> queryList() {
        return null;
    }

    @Override
    public void exportExcel() {
        YbsVersionInfoPoExample example = new YbsVersionInfoPoExample();
        example.createCriteria().andDelFlagEqualTo(0);
        example.setOrderByClause(" id");
        List<YbsVersionInfoPo> list = versionInfoPoMapper.selectByExample(example);
        String fileName = "version.xlsx";
        log.info("当前项目根目录地址：【{}】",String.valueOf(new File(this.getClass().getResource("/").getPath())));
        String basepath = this.getClass().getResource("/").getPath();
        String filePath = new File(basepath).getParentFile().getPath()+"/doc/" +fileName;
        try {
            log.info("导出地址为：【{}】",filePath);
            if(!new File(filePath).exists()){
                new File(filePath).getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(new File(filePath));
            ExcelWriter excelWriter = EasyExcel.write(out, YbsVersionInfoPo.class).build();
            WriteSheet writeSheet = EasyExcelFactory.writerSheet("版本消息").build();
            excelWriter.write(list, writeSheet);
            /// 千万别忘记finish 会帮忙关闭流
            excelWriter.finish();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void importExcel(MultipartFile file) {
        try {
            ExcelReaderBuilder read = EasyExcel.read(file.getInputStream(), YbsVersionInfoPo.class, versionUploadListener);
            read.sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

