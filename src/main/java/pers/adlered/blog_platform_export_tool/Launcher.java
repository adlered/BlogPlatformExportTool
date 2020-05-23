package pers.adlered.blog_platform_export_tool;

import pers.adlered.blog_platform_export_tool.module.ModuleService;
import pers.adlered.blog_platform_export_tool.module.TranslateResult;
import pers.adlered.blog_platform_export_tool.util.Decompress;
import pers.adlered.blog_platform_export_tool.util.XML;

import java.util.List;

/**
 * <h3>BlogPlatformExportTool</h3>
 * <p>博客平台导出器主方法.</p>
 *
 * @author : https://github.com/adlered
 * @date : 2020-05-14
 **/
public class Launcher {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        List<TranslateResult> list = run("CNBlogs");
        XML.printResult(list);
    }

    public static List<TranslateResult> run(String blogType) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Decompress decompress = new Decompress("file");
        decompress.run();
        Class<?> serviceClass = Class.forName("pers.adlered.blog_platform_export_tool.module." + blogType.toLowerCase() + "." + blogType.toUpperCase() + "ModuleServiceImpl");
        ModuleService moduleService = (ModuleService) serviceClass.newInstance();
        return moduleService.analyze();
    }
}
