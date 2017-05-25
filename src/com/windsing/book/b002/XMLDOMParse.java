package com.windsing.book.b002;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static java.lang.System.out;

/**
 * Created by FC on 2017/4/14.
 */
public class XMLDOMParse {
    static File f = new File("./source/b02.xml");
    static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    // 获取节点
    static void test001() {

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(f);

            Element root = document.getDocumentElement();

            out.println("root节点：" + root);
            out.println("root节点TagName：" + root.getTagName());

            NodeList childNodes = root.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node child = childNodes.item(i);
                //去掉空白符
                if (child instanceof Element) {
//                    out.println(child);
                    out.println(((Element) child).getTagName());

                    Text text = (Text) child.getFirstChild();
                    String s = text.getData().trim();
                    out.println(s);

                }

            }

            Node firstChild = root.getFirstChild();
            out.println("firstChild" + firstChild);// 空白文本
            Element next_ele = (Element) firstChild.getNextSibling(); //获取下一个兄弟节点
            out.println(next_ele.getTagName());

            Text text = (Text) next_ele.getFirstChild();
            out.println("文本：" + text.getData());


            Node lastChild = root.getLastChild();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取节点属性
    public static void test002() throws Exception {

        DocumentBuilder buider = factory.newDocumentBuilder();
        Document doc = buider.parse(f);

        Element root = doc.getDocumentElement();

        Node node_name = root.getFirstChild().getNextSibling();

        NamedNodeMap name_attributes = node_name.getAttributes();
        for (int i = 0; i < name_attributes.getLength(); i++) {
            Node n = name_attributes.item(i);
            System.out.println(n);
        }
    }

    public static void main(String[] args) throws Exception {
        test002();
    }
}
