# BlogPlatformExportTool

博客园、Typecho 等博客平台的通用导出工具  
这个项目是为 [菠萝博客](https://github.com/adlered/bolo-solo) 项目写的轮子，支持将博客平台的备份文件提取并解析为数组，方便进行导出操作。  

# 用法

将项目打包为 Jar，导入到你的项目当中。  

首先，要在你的项目根目录下创建一个指定名称的目录（这里设置为根目录 temp 文件夹下的 file 文件夹）  
将博客平台导出的备份文件放到该目录中  
将该项目打包为 jar 包，引入到你的项目中（[这里有已经打包好的提供下载](https://github.com/adlered/BlogPlatformExportTool/releases)）  
在项目中输入代码：  

```
List<TranslateResult> list = run("CNBlogs", "temp/file");
```

方法解释：  

```
run(String blogType, String dir)
```
blogType：以哪个平台的博客备份文件进行解析，目前支持 CNBlogs（博客园）
file：备份文件暂时存放的位置，你需要在项目根目录下创建同名文件夹，将备份的文件放进入，然后执行该方法对其进行导出

```
List<TranslateResult> list
```
TranslateResult 类为其中一篇文章的 Bean 方法，遍历 List，执行 TranslateResult 类的方法来获得每篇文章的导出详情
遍历示例：

```
for (TranslateResult i : result) {
    System.out.println("标题：" +  i.getTitle());
    System.out.println("作者：" + i.getAuthor());
    System.out.println("日期：" + i.getDate());
    System.out.println("链接：" + i.getLink());
    System.out.println("正文：" + i.getArticleContent());
}
```

另外还提供一个方便调试的方法，直接在控制台打印 run(String blogType, String dir) 方法导出的内容:  
```
XML.printResult(list);
```
