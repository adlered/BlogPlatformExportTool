package pers.adlered.blog_platform_export_tool.module.cnblogs;

import pers.adlered.blog_platform_export_tool.module.ModuleService;
import pers.adlered.blog_platform_export_tool.module.TranslateResult;

import java.io.File;

/**
 * <h3>BlogPlatformExportTool</h3>
 * <p>博客园导入模块</p>
 *
 * @author : https://github.com/adlered
 * @date : 2020-05-23
 **/
public class CNBLOGSModuleServiceImpl implements ModuleService {
    File file = null;

    @Override
    public void init(File file) {
        this.file = file;
    }

    @Override
    public TranslateResult analyze() {
        System.out.println("hello world");
        return null;
    }
}
