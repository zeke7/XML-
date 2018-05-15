package cn.hfang.parse;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class dom4jDemo {

	public static void main(String[] args) throws DocumentException, IOException {

		// 读取所有学生信息
		test1();

		// 添加元素
		test2();
		
		
		
	}
	
	static void test2() throws IOException, DocumentException {
		SAXReader reader = new SAXReader();

		Document doc = reader.read("src\\cn\\hfang\\parse\\student.xml");

		// 获取根元素
		Element rootElement = doc.getRootElement();
		
		Element newStu = rootElement.addElement("student").addAttribute("number", "a003");
		
		newStu.addElement("name").setText("Curry");
		newStu.addElement("age").setText("28");
		newStu.addElement("sex").setText("Male");
		
		//进行读写
		// Pretty print the document to System.out
        OutputFormat format = OutputFormat.createPrettyPrint();
        Writer wr = new OutputStreamWriter(new FileOutputStream("src\\cn\\hfang\\parse\\student.xml"),"UTF-8");
        XMLWriter writer = new XMLWriter(wr, format);
        writer.write(doc);
		wr.close();
	}

	static void test1() throws DocumentException {
		SAXReader reader = new SAXReader();

		Document doc = reader.read("src\\cn\\hfang\\parse\\student.xml");

		// 获取根元素
		Element rootElement = doc.getRootElement();

		// 读取所有学生信息
		List<Element> stuList = rootElement.elements("student");

		// 遍历元素
		for (Element stuEle : stuList) {
			String name = stuEle.elementText("name");
			String age = stuEle.elementText("age");
			String gender = stuEle.elementText("gender");
			String num = stuEle.attributeValue("number");
			System.out.println(name);
			System.out.println(age);
			System.out.println(gender);
			System.out.println(num);
			System.out.println("------------");
		}
	}
}
