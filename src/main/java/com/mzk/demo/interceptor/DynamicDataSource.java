package com.mzk.demo.interceptor;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author zar
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDbType();
    }

}
