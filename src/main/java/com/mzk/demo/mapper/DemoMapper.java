package com.mzk.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @program: read_and_write_separation_demo
 * @description: read_and_write_separation_demo interface
 * @author: miaozhenkai
 * @create: 2019-10-15 17:39
 */
@Mapper
public interface DemoMapper {

    List<Map> testRead();

    int testInsert(Map map);
}
