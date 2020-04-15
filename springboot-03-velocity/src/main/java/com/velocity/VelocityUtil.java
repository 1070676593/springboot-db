package com.velocity;



import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class VelocityUtil {

    @Resource
    Velocity velocity;


    public Model createIdentityInfoVelocity(Model model) {
        VelocityContext context = new VelocityContext();
        context.put("item", "info123456");
        return model.addAttribute("div_identityInfo", velocity.getIdentityInfo().merge(context));
    }

    public Model number(Model model) {
        VelocityContext context = new VelocityContext();
        context.put("item", "number123456");
        return model.addAttribute("div_number", velocity.getNumber().merge(context));
    }


}
