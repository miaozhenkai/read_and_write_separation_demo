package com.mzk.demo.service;

import java.util.List;
import java.util.Map;

/**
 * @program: read_and_write_separation_demo
 * @description: read_and_write_separation_demo interface
 * @author: miaozhenkai
 * @create: 2019-10-15 09:16
 */
public interface DemoService {
    /**
     * 测试读
     * @return
     */
    List<Map> testRead();

    /**
     * 测试写
     * @return
     */
    String testWrite();

    /**
     * 测试事务
     * @return
     */
    String testTransaction();

    /**
     * 测试更新
     * @return
     */
    String testUpdate();

    /**
     * 测试删除
     * @return
     */
    String testDelete(int param);
}
