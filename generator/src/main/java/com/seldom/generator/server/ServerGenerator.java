package com.seldom.generator.server;

import com.seldom.generator.util.FreemarkerUtil;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServerGenerator {
    //    static String toPath = "generator/src/main/java/com/seldom/generator/test/";
    static String MODULE = "business";
    static String toServicePath = "server/src/main/java/com/seldom/server/service/";
    static String toControllerPath = MODULE + "/src/main/java/com/seldom/" + MODULE + "/controller/admin/";

    public static void main(String[] args) throws IOException, TemplateException {
        String Domain = "Section";
        String domain = "section";
        String tableName = "Section";
        String module = MODULE;
        Map<String, Object> map = new HashMap<>();
        map.put("Domain", Domain);
        map.put("domain", domain);
        map.put("tableName", tableName);
        map.put("module", module);

        // 生成 service
        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generator(toServicePath + Domain + "Service.java", map);

        // 生成 controller
        FreemarkerUtil.initConfig("controller.ftl");
        FreemarkerUtil.generator(toControllerPath + Domain + "Controller.java", map);
    }
}
