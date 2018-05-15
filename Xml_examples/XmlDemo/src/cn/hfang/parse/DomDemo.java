package cn.hfang.parse;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
			TransformerFactoryConfigurationError, TransformerException {
		/**
		 * DOM解析步骤
		 * 
		 * 创建解析器工厂 
		 * 获取解析器 
		 * 利用解析器取得Document对象 
		 * 获取具体节点
		 */

		// 创建解析器工厂
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// 获取解析器
		DocumentBuilder db = dbf.newDocumentBuilder();

		// 利用解析器取得Document对象
		Document doc = db.parse("src/student.xml");

		// 获取具体节点
		//test1(doc);

		// DOM修改元素
		//test2(doc);

		// 添加DOM节点
		//test3(doc);
		
		//删除DOM节点
		//test4(doc);
		
		//设置元素属性
		test5(doc);

	}

	static void test5(Document doc) throws TransformerException {
		Node stu = doc.getElementsByTagName("student").item(1);
		
		Element element = (Element)stu;
		
		element.setAttribute("number", "s005");
		
		// 从内存写到文档做同步操作
		Transformer tf = TransformerFactory.newInstance().newTransformer();
								
		tf.transform(new DOMSource(doc), new StreamResult("src/student.xml"));

	}

	static void test4(Document doc) throws TransformerException {
		Node addNode = doc.getElementsByTagName("address").item(0);
		
		addNode.getParentNode().removeChild(addNode);
		
		// 从内存写到文档做同步操作
		Transformer tf = TransformerFactory.newInstance().newTransformer();
						
	    tf.transform(new DOMSource(doc), new StreamResult("src/student.xml"));

	}

	static void test3(Document doc) throws TransformerException {
		Element addElement = doc.createElement("address");

		addElement.setTextContent("Address 1");
		
		Node stuNode = doc.getElementsByTagName("student").item(0);
		
		stuNode.appendChild(addElement);
		
		// 从内存写到文档做同步操作
		Transformer tf = TransformerFactory.newInstance().newTransformer();
				
	    tf.transform(new DOMSource(doc), new StreamResult("src/student.xml"));


	}

	static void test2(Document doc) throws TransformerFactoryConfigurationError, TransformerException {
		
		NodeList agelist = doc.getElementsByTagName("age");
		
		Node ageNode = agelist.item(0);
		
		ageNode.setTextContent("30");

		// 从内存写到文档做同步操作
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		
		tf.transform(new DOMSource(doc), new StreamResult("src/student.xml"));

	}

	static void test1(Document doc) {

		NodeList namelist = doc.getElementsByTagName("name");
		
		Node nameNode = namelist.item(0);
		
		System.out.println(nameNode.getTextContent());

	}

}
