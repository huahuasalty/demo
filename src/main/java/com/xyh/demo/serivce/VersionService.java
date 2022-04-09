package com.xyh.demo.serivce;

import com.xyh.demo.domain.po.YbsVersionInfoPo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VersionService {
    List<YbsVersionInfoPo> queryList();

    void exportExcel();

    void importExcel(MultipartFile file);

}
