package com.example.springbootdb02thymeleafs.dbmap;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.HashSet;
import java.util.Set;

/**
 * @CalssName: DbmapDialect
 * @Author: zsx
 * @Date: 2020/4/7 17:20
 **/
public class DbmapDialect extends AbstractProcessorDialect {
    //定义方言名称
    private static final String DIALECT_NAME="dbmap";

    public DbmapDialect() {
        //设置自定义方言与"方言处理器"优先级相同
        super(DIALECT_NAME, "thSys", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        Set<IProcessor> processors=new HashSet<IProcessor>();
        processors.add(new DbmapProcessor(dialectPrefix));
        processors.add(new StandardXmlNsTagProcessor(TemplateMode.HTML, dialectPrefix));
        return processors;
    }


}
