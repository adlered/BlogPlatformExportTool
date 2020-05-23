package pers.adlered.blog_platform_export_tool.module;

import java.io.File;

public interface ModuleService {

    void init(File file);

    TranslateResult analyze();
}
