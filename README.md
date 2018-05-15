# 关于XML的基础学习笔记  
[XML实例完整CODE](/Xml_examples/XmlDemo/)
## XML 作用

* 程序的配置文件
* 数据交换：不同语言之间用来交换数据
* 小型数据库
***

## XML 基本语法 [基本语法](/Xml_examples/BasicGrammer.xml) 

#### 文档声明

* <?xml version="1.0" encoding="utf-8" standalone="no"?>
    * xml文档声明必须在第一行
    * xml区分大小写
    * version属性 --> xml文档的版本
    * encoding属性 --> xml文档使用的字符集编码
    * standalone="no" --> 有约束

#### xml元素

* 格式良好的xml文档必须仅有一个根元素
* 不能以数字开头
* 不能存在空格

#### 转义字符和CDATA  
转义字符的可读性很差,使用CDATA区不需要使用转义字符  

## XML 约束

XML文档按照一定的约束创建元素及属性

***
#### **dtd约束**

* 三种方式引用dtd  
      [dtdDemo1](/Xml_examples/dtdDemo1.xml)  
      [refdtd.dtd](/Xml_examples/refdtd.dtd)
    * 直接在xml文档中写dtd 
    * 引用.dtd文件
    * 引用网络上的远程.dtd

* 使用ELEMENT声明元素: <!ELEMENT 元素名 元素类型或内容>  
    [dtdDemo2](/Xml_examples/dtdDemo2.xml) 
    * 元素类型: ANY 或者 EMPTY
    * 元素内容: 文本数据 或者 子元素
    * 元素出现次数: "?" --> 0~1次，"*" --> 0~n次，"+" --> 1~n次
    * 枚举子元素: <!ELEMENT 元素名 (子元素1|子元素2|子元素3|...)> 任意一个子元素，可以在后面加上元素出现次数, "?","*",和"+"。

* 属性约束
    * 基本格式: [dtdDemo3](/Xml_examples/dtdDemo3.xml) 

***
#### **schema约束**  
[SchemaDemo1](/Xml_examples/SchemaDemo1.xml)  
[Schema1](/Xml_examples/Schema1.xsd)  

* 特性: 
    * 扩充了数据类型，可以自定义数据类型。
    * 支持元素的继承 - Object-Oriented
    * 属性组

* 数据类型
    * 基本数据类型
    * 扩展数据类型
    * 用户自定义数据类型

**元素**

* Schema  
[SchemaDemo2](/Xml_examples/SchemaDemo2.xml)  
[Schema2](/Xml_examples/Schema2.xsd)  
    * .xsd以schema作为根节点
    * xmlns约束当前xml的命名空间
    * targetNamespace  

* 属性 attribute  
[SchemaDemo2](/Xml_examples/SchemaDemo2.xml)  
[Schema2](/Xml_examples/Schema2.xsd)  
    * name: 属性名称
    * type: 属性类型
    * ref: 外部属性的引用
    * use: 是否必填

* simpleType  
[simpleType.xml](/Xml_examples/simpleType.xml)  
[simpleType.xsd](/Xml_examples/simpleType.xsd)  

* complexType  
[complexType.xml](/Xml_examples/complexType.xml)  
[complexType.xsd](/Xml_examples/complexType.xsd)  

## XML 解析

* XML文档结构：树形结构
    * 文档节点: Document xml文件
    * 元素节点: Element 使用<>的标签
    * 属性节点: Attributr 属性名="属性值"
    * 文本节点: Text 元素中的内容


* DOM解析: 文档对象模型
    * 加载过程中一次性加载完毕形成一个Document对象
    * 代码操作内存中的Document对象
    * 需要同步操作
    * 若XML文件过大，内存溢出

* [DOM解析步骤](/Xml_examples/XmlDemo/src/cn/hfang/parse/DomDemo.java)
    * 创建解析器工厂
    * 获取解析器
    * 利用解析器取得Document对象
    * 获取具体节点

* [dom4j 解析](/Xml_examples/XmlDemo/src/cn/hfang/parse/dom4jDemo.java)
    
