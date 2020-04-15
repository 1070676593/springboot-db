package com.example.springbootdb02thymeleafs.tag;


import com.example.springbootdb02thymeleafs.entity.DbMap;
import com.example.springbootdb02thymeleafs.service.DbMapService;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.List;

/**
 * 自定义each标签，用来取dbMap用的列表，并循环显示<br />
 * <xmp>
 * <select db:each="shArea" db:orderBy="asc" db:temp="<option value='{key}'>{}</option>">输出内容列表被包含在本标签中，temp为内容模版，可为空</select>
 * </xmp>
 * <br />
 * <xmp>
 * <dbMap db:each="test" db:temp="<option value='{key}'>{}</option>">输出内容列表，temp为内容模版，可为空</dbMap>
 * </xmp>
 * @author lin
 * @date 2019/9/2 18:09
 */
public class DbMapEachTagProcessor extends AbstractAttributeTagProcessor {
    private static final String TEXT_ATTRIBUTE  = "each";
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
    public DbMapEachTagProcessor(String dialectPrefix) {
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
        DbMapService dbMap = SpringContextUtil.getBean("dbMapServiceImpl");
        // 获取标签上的属性each
        String example = tag.getAttributeValue("db:each");
        // 获取标签上的属性example

        // srpingboot处理标签体时是直接把内容给忽略掉了
        // 暂时解决不了标签体内容被忽略的问题，所以只能加了个字段处理了
        String temp = tag.getAttributeValue("db:temp");
        // 获取排序的字段
        String orderBy = tag.getAttributeValue("db:orderBy");

        // 查数据
        List<DbMap> list = dbMap.getExample(example);

        // 如果有值，则判断是否要排序
        if(orderBy != null && orderBy.length() > 0) {
            // 是否是升序
            boolean isAsc = "asc".equals(orderBy.toLowerCase());
            // 排序
            list.sort((a, b) -> (a.getSeq() - b.getSeq()) * (isAsc ? 1 : -1));
        }
        // 大概计算sb的长度。感觉意义不是很大，StringBuilder可能少复制几次而已
        int length = list.size() * 10;
        if(temp != null) {
            length += temp.length() * list.size();
        }
        // 用于统计大括号的问题
        int count = 0;
        // 保存生成的结果
        StringBuilder sb = new StringBuilder(length);
        if(temp == null) {
            // 如果没有设置模版，则原样输出
            for (DbMap map : list) {
                sb.append(map.getValue());
            }
        } else {
            // 把模版转成char数组，效率
            char[] tc = temp.toCharArray();
            for (DbMap map : list) {
                // 标识是否是参数键的开始
                boolean flag = false;
                // 存键
                StringBuilder key = new StringBuilder();
                for(char c : tc) {

                    if(c == '{') {
                        count++;
                        flag = true;
                        continue;
                    } else if(c == '}') {
                        // 当遇到右括号的时候，直接处理key
                        count--;
                        flag = false;
                        // 取出key
                        String tKey = key.toString().toLowerCase();
                        if(tKey.length() == 0) {
                            sb.append(map.getValue());
                        } else if("example".equals(tKey)) {
                            sb.append(map.getExample());
                        } else if("key".equals(tKey)) {
                            sb.append(map.getKey());
                        } else if("seq".equals(tKey)) {
                            sb.append(map.getSeq());
                        } else if("remark".equals(tKey)) {
                            sb.append(map.getRemark());
                        }
                        // 请空key
                        key.delete(0, key.length());
                        continue;
                    }
                    if(flag) {
                        // 拼接参数时去掉空格
                        if(c == ' ') {
                            continue;
                        }
                        key.append(c);
                    } else {
                        // 拼接模版内容
                        sb.append(c);
                    }
                }
                if(count != 0) {
                    // 括号数量不匹配，直接结束
                    break;
                }
            }
        }

        // 删除属性
        structureHandler.removeAttribute("db:temp");
        structureHandler.removeAttribute("db:orderBy");

        if(count > 0) {
            // 少了右括号
            String tagStr = tag.toString();
            structureHandler.replaceWith("<xmp>" + tagStr + "===>少了" + count + "个右括号</xmp>", false);
        } else if(count < 0) {
            // 少了左括号
            String tagStr = tag.toString();
            structureHandler.replaceWith("<xmp>" + tagStr + "===>少了" + (count * -1) + "个左括号</xmp>", false);
        } else {
            // 获取标签名
            String tagName = tag.getElementCompleteName();
            if ("dbmap".equals(tagName.toLowerCase())) {
                // 替换当前标签
                structureHandler.replaceWith(sb.toString(), false);
            } else {
                // 保留当前标签
                structureHandler.setBody(sb.toString(), false);
            }
        }
    }
}