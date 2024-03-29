package com.mzk.demo.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Miaozhenkai
 */
@Slf4j
public class DynamicDataSourceHolder {

    /**
     * ThreadLocal保证线程安全
     */
    private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    public static final String DB_MASTER = "master";
    public static final String DB_SLAVE = "slave";

    public static String getDbType() {
        String db = contextHolder.get();
        if (db == null) {
            //如果db为空，连接DB_MASTER，它即支持读也支持写。
            db = DB_MASTER;
        }
        return db;
    }

    /**
     * 设置线程的dbType
     * @param str
     */
    public static void setDbType(String str) {
        log.info("所使用的数据源为：" + str);
        contextHolder.set(str);
    }

    /**
     * 清理连接类型
     */
    public static void clearDBType() {
        contextHolder.remove();
    }

}
