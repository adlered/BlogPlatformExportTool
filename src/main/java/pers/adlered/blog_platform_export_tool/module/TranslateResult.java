package pers.adlered.blog_platform_export_tool.module;

import java.util.Date;

/**
 * <h3>BlogPlatformExportTool</h3>
 * <p>转换后格式化的内容</p>
 *
 * @author : https://github.com/adlered
 * @date : 2020-05-23
 **/
public class TranslateResult {
    private Date date;
    private String author;
    private String title;
    private String articleContent;

    public TranslateResult(Date date, String author, String title, String articleContent) {
        this.date = date;
        this.author = author;
        this.title = title;
        this.articleContent = articleContent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }
}
