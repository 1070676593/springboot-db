package com.example.springbootdb02thymeleafs.tag;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.HashSet;
import java.util.Set;

/**
 * 定义方言
 * @author lin
 * @date 2019/9/1 13:49
 */
public class DbMapDialect extends AbstractProcessorDialect {
    /** 定义方言名称*/
    private static final String DIALECT_NAME = "dbMap";

    public DbMapDialect() {
        //设置自定义方言与"方言处理器"优先级相同
        super(DIALECT_NAME, "db", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        Set<IProcessor> processors = new HashSet<>();
        processors.add(new DbMapTextTagProcessor(dialectPrefix));
        processors.add(new DbMapEachTagProcessor(dialectPrefix));
        processors.add(new StandardXmlNsTagProcessor(TemplateMode.HTML, dialectPrefix));
        return processors;
    }
}
