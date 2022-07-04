package io.blue.submarine.han.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.google.common.collect.Lists;
import io.blue.submarine.han.core.model.resident.ResidentInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * 居民信息服务接口实现类.
 *
 * @author shucunbin
 * @date 2022-02-06 19:09
 */
@Service
@Slf4j
public class ResidentInfoServiceImpl implements ResidentInfoService{
    @Override
    public List<ResidentInfo> readFromExcel() {
        List<ResidentInfo> residentInfoList = Lists.newArrayList();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("doc/用户信息_20220702.xls");
        EasyExcel.read(inputStream, ResidentInfo.class, new ReadListener<ResidentInfo>() {
            @Override
            public void invoke(ResidentInfo data, AnalysisContext context) {
                if (context.readRowHolder().getRowIndex() == 2) {
                    return;
                }
                log.info(">>>>>> 读取一行数据: {}", data);
                residentInfoList.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                log.info("数据读取完毕");
            }
        }).sheet().doRead();

        return residentInfoList;
    }
}
