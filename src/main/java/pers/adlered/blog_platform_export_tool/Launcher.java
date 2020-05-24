package pers.adlered.blog_platform_export_tool;

import pers.adlered.blog_platform_export_tool.module.ModuleService;
import pers.adlered.blog_platform_export_tool.module.TranslateResult;
import pers.adlered.blog_platform_export_tool.util.Decompress;
import pers.adlered.blog_platform_export_tool.util.XML;

import java.io.File;
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
        List<TranslateResult> list = run("CNBlogs", "file");
        XML.printResult(list);
    }

    public static List<TranslateResult> run(String blogType, String dir) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        boolean mkdirResult = new File(dir).mkdirs();
        System.out.println("MKDIR " + dir + " " + mkdirResult);
        Decompress decompress = new Decompress(dir);
        decompress.run();
        Class<?> serviceClass = Class.forName("pers.adlered.blog_platform_export_tool.module." + blogType.toLowerCase() + "." + blogType.toUpperCase() + "ModuleServiceImpl");
        ModuleService moduleService = (ModuleService) serviceClass.newInstance();
        return moduleService.analyze();
    }
}
