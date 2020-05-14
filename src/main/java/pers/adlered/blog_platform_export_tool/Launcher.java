package pers.adlered.blog_platform_export_tool;

import pers.adlered.blog_platform_export_tool.util.Decompress;

/**
 * <h3>BlogPlatformExportTool</h3>
 * <p>博客平台导出器主方法.</p>
 *
 * @author : https://github.com/adlered
 * @date : 2020-05-14
 **/
public class Launcher {
    public static void main(String[] args) {
        Decompress decompress = new Decompress("file");
        decompress.run();
    }
}
