spring-schema 
==============
自定义标签
   
### 步骤

    1.创作一个XML图表来描述自定义元素
    2.写一个NamespaceHandler实现
    3.写对应的BeanDefinitionParser实现
    4.用Spring注册以上组件Handler&Schema
    

### intro
    
    1.resources/META-INF 创建一个 xxx.xsd schema文件
    2.NamespaceHandler 编码 
    
    NamespaceHandler 解析所有指定命名空间的元素
    * init() NamespaceHandler初始化 handler使用前被调用
    ·parse() Spirng遇到顶级元素是调用
    ·decorate() Spring遇到属性或者不同命名空间嵌套元素调用
    
    3.BeanDefinitionParser编码
    
    BeanDefinitionParser：处理自定义顶级标签
        NamespaceHandler遇到匹配解析元素时调用
    
    4.注册 handler 和 schema
        都放置在应用的 META-INF 目录 spring解析会自动抽取分布在各个Jar包此目录的文件
        
        META-INF/spring.handlers :XML Schema URIs同命名空间处理类的映射
            http\://www.mycompany.com/schema/myns=org.springframework.samples.xml.MyNamespaceHandler
        note:':'字符是Java属性格式中的有效分隔符 因此':'符号在URI中需要用反斜杠进行转义
        META-INF/spring.schemas : XML Schema ClassPath位置映射 Spring 将会搜索 schema 在ClassPath
            http\://www.mycompany.com/schema/myns/myns.xsd=org/springframework/samples/xml/myns.xsd
    
    5.测试

reference : [官网链接](https://docs.spring.io/spring/docs/5.0.4.RELEASE/spring-framework-reference/core.html#xml-custom)
