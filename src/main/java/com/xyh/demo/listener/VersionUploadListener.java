package com.xyh.demo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONObject;
import com.xyh.demo.domain.po.YbsVersionInfoPo;
import com.xyh.demo.mapper.YbsVersionInfoPoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@Scope("prototype")
public class VersionUploadListener extends AnalysisEventListener<YbsVersionInfoPo> {
    private final YbsVersionInfoPoMapper versionInfoPoMapper;

    private List<YbsVersionInfoPo> list = new ArrayList<>();

    @Override
    public void invoke(YbsVersionInfoPo ybsVersionInfoPo, AnalysisContext analysisContext) {
        if(ybsVersionInfoPo.getVersion()!=null){
            list.add(ybsVersionInfoPo);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        list.forEach(x->{
            if(versionInfoPoMapper.insertSelective(x)<=0){
                log.error("数据【{}】导入失败", JSONObject.toJSON(x));
            }
        });
    }
}
