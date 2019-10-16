package com.mzk.demo.service.implenent;

import com.mzk.demo.mapper.DemoMapper;
import com.mzk.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: read_and_write_separation_demo
 * @description: read_and_write_separation_demo
 * @author: miaozhenkai
 * @create: 2019-10-15 09:17
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    DemoMapper demoMapper;

    @Override
    public List<Map> testRead() {
        List l = demoMapper.testRead();
        return l;
    }

    @Override
    public String testWrite() {
        Map map = new HashMap();
        map.put("name", 123);
        int i = demoMapper.testInsert(map);
        return String.valueOf(i);
    }

    /**
     * 测试事务能否正常工作
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public String testTransaction(){
        Map map = new HashMap();
        map.put("name", 123999);
        int i = demoMapper.testInsert(map);
        throw new RuntimeException("测试事务");
        //return String.valueOf(i);
    }

    @Override
    public String testUpdate() {
        Map map = new HashMap();
        map.put("id", "1");
        map.put("name", "mzkmzk");
        int i = demoMapper.testUpdate(map);
        return String.valueOf(i);
    }

    @Override
    public String testDelete(int param) {
        Map map = new HashMap();
        map.put("id", param);
        int i = demoMapper.testDelete(map);
        return String.valueOf(i);
    }

}
