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
    List<Map> getAll();

    String testWrite();

    String testTransaction();

    String testUpdate();
}
