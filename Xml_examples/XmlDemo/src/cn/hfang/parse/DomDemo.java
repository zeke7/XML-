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
		 * DOM��������
		 * 
		 * �������������� 
		 * ��ȡ������ 
		 * ���ý�����ȡ��Document���� 
		 * ��ȡ����ڵ�
		 */

		// ��������������
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// ��ȡ������
		DocumentBuilder db = dbf.newDocumentBuilder();

		// ���ý�����ȡ��Document����
		Document doc = db.parse("src/student.xml");

		// ��ȡ����ڵ�
		//test1(doc);

		// DOM�޸�Ԫ��
		//test2(doc);

		// ���DOM�ڵ�
		//test3(doc);
		
		//ɾ��DOM�ڵ�
		//test4(doc);
		
		//����Ԫ������
		test5(doc);

	}

	static void test5(Document doc) throws TransformerException {
		Node stu = doc.getElementsByTagName("student").item(1);
		
		Element element = (Element)stu;
		
		element.setAttribute("number", "s005");
		
		// ���ڴ�д���ĵ���ͬ������
		Transformer tf = TransformerFactory.newInstance().newTransformer();
								
		tf.transform(new DOMSource(doc), new StreamResult("src/student.xml"));

	}

	static void test4(Document doc) throws TransformerException {
		Node addNode = doc.getElementsByTagName("address").item(0);
		
		addNode.getParentNode().removeChild(addNode);
		
		// ���ڴ�д���ĵ���ͬ������
		Transformer tf = TransformerFactory.newInstance().newTransformer();
						
	    tf.transform(new DOMSource(doc), new StreamResult("src/student.xml"));

	}

	static void test3(Document doc) throws TransformerException {
		Element addElement = doc.createElement("address");

		addElement.setTextContent("Address 1");
		
		Node stuNode = doc.getElementsByTagName("student").item(0);
		
		stuNode.appendChild(addElement);
		
		// ���ڴ�д���ĵ���ͬ������
		Transformer tf = TransformerFactory.newInstance().newTransformer();
				
	    tf.transform(new DOMSource(doc), new StreamResult("src/student.xml"));


	}

	static void test2(Document doc) throws TransformerFactoryConfigurationError, TransformerException {
		
		NodeList agelist = doc.getElementsByTagName("age");
		
		Node ageNode = agelist.item(0);
		
		ageNode.setTextContent("30");

		// ���ڴ�д���ĵ���ͬ������
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		
		tf.transform(new DOMSource(doc), new StreamResult("src/student.xml"));

	}

	static void test1(Document doc) {

		NodeList namelist = doc.getElementsByTagName("name");
		
		Node nameNode = namelist.item(0);
		
		System.out.println(nameNode.getTextContent());

	}

}
