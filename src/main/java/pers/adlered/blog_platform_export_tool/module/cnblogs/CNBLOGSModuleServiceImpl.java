package pers.adlered.blog_platform_export_tool.module.cnblogs;

import com.sun.syndication.feed.synd.*;
import pers.adlered.blog_platform_export_tool.module.ModuleService;
import pers.adlered.blog_platform_export_tool.module.TranslateResult;
import pers.adlered.blog_platform_export_tool.util.XML;

import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>BlogPlatformExportTool</h3>
 * <p>博客园导入模块</p>
 *
 * @author : https://github.com/adlered
 * @date : 2020-05-23
 **/
public class CNBLOGSModuleServiceImpl implements ModuleService {

    @Override
    public List<TranslateResult> analyze() {
        List<TranslateResult> list = new ArrayList<>();
        List<String> fileList = XML.getAvailableFiles();
        for (String i : fileList) {
            File file = new File(i);
            try {
                XmlReader xmlReader = new XmlReader(file);
                SyndFeedInput syndFeedInput = new SyndFeedInput();
                SyndFeed syndFeed = syndFeedInput.build(xmlReader);
                List<SyndEntryImpl> entries = syndFeed.getEntries();
                for (SyndEntryImpl j : entries) {
                    TranslateResult translateResult = new TranslateResult();
                    translateResult.setAuthor(j.getAuthor());
                    translateResult.setArticleContent(j.getDescription().getValue());
                    translateResult.setLink(j.getLink());
                    translateResult.setTitle(j.getTitle().trim());
                    translateResult.setDate(j.getPublishedDate());
                    list.add(translateResult);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
