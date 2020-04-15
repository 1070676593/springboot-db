package com.example.springbootdb02thymeleafs.tag;


import com.example.springbootdb02thymeleafs.service.DbMapService;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.Optional;


/**
 * 用来取dbMap中的单个记录
 * <xmp>
 *     <dbMap db:example="test" db:key="test">这是一个自定义的标签，只输出内容</dbMap>
 * </xmp>
 * <br />
 * <xmp>
 *     <div db:example="test" db:key="test">这是一个自定义的标签，输出的内容被包含在本标签中，可加样式</div>
 * </xmp>
 *
 * @Author lin
 * @Date 2019/9/1 13:41
 */
public class DbMapTextTagProcessor extends AbstractAttributeTagProcessor {
    private static final String TEXT_ATTRIBUTE  = "key";
    private static final int PRECEDENCE = 10000;

    /**
     templateMode: 模板模式，这里使用HTML模板。
     dialectPrefix: 标签前缀。即xxx:text中的xxx。
     elementName：匹配标签元素名。举例来说如果是div，则我们的自定义标签只能用在div标签中。为null能够匹配所有的标签。
     prefixElementName: 标签名是否要求前缀。
     attributeName: 自定义标签属性名。这里为text。
     prefixAttributeName：属性名是否要求前缀，如果为true，Thymeeleaf会要求使用text属性时必须加上前缀，即xxx:text。
     precedence：标签处理的优先级，此处使用和Thymeleaf标准方言相同的优先级。
     removeAttribute：标签处理后是否移除自定义属性。
     */
    public DbMapTextTagProcessor(String dialectPrefix) {
        super(
                TemplateMode.HTML,
                dialectPrefix,
                null,
                false,
                TEXT_ATTRIBUTE,
                true,
                PRECEDENCE,
                true);
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName,
                             String attributeValue, IElementTagStructureHandler structureHandler) {
        // final IEngineConfiguration configuration = context.getConfiguration();
        // final IStandardExpressionParser parser = StandardExpressions.getExpressionParser(configuration);
        // final IStandardExpression expression = parser.parseExpression(context, attributeValue);
        // final String title = (String) expression.execute(context);
        DbMapService dbMap = SpringContextUtil.getBean("dbMapServiceImpl");
        // 获取标签上的属性key
        String key = tag.getAttributeValue("db:key");
        // 获取标签上的属性example
        String example = tag.getAttributeValue("db:example");
        example = Optional.ofNullable(example).orElse("default");
        // 查数据
        String value = dbMap.get(key, example);

        // 删除属性
        structureHandler.removeAttribute("db:example");

        // 获取标签名
        String tagName = tag.getElementCompleteName();

        if("dbmap".equals(tagName.toLowerCase())) {
            // 替换当前标签
            structureHandler.replaceWith(value, false);
        } else {
            // 保留当前标签
            structureHandler.setBody(value, false);
        }
    }
}

