package com.zsx.config;

/**
 * @CalssName: DataSourceType
 * @Author: zsx
 * @Date: 2020/4/23 16:42
 **/
public class DataSourceType {
    public enum DataBaseType{
        DATA1,DATA2
    }
    private static final ThreadLocal<DataBaseType> TYPE = new ThreadLocal<DataBaseType>();

    //设置数据源类型
    public static void setDataBaseType(DataBaseType dataBaseType){
        if(dataBaseType == null){
            throw new NullPointerException();
        }
        System.out.println("将当前数据源改为：" + dataBaseType);
        TYPE.set(dataBaseType);
    }

    //获取数据源类型
    public static DataBaseType getDataBaseType(){
        DataBaseType dataBaseType = TYPE.get() == null ? DataBaseType.DATA1 : TYPE.get();
        System.out.println("获取当前数据源类型：" + dataBaseType);
        return dataBaseType;
    }
    public static void clearDataBaseType(){
        TYPE.remove();
    }
}
