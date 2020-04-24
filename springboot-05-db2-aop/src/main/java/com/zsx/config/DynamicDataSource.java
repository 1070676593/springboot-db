package com.zsx.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @CalssName: DynamicDataSource
 * @Author: zsx
 * @Date: 2020/4/23 16:40
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType.DataBaseType dataBaseType = DataSourceType.getDataBaseType();
        return dataBaseType;
    }
}
