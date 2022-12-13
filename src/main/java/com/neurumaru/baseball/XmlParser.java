package com.neurumaru.baseball;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XmlParser {
    public static Document getDocument(String filename) throws IOException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(filename);
        } catch (ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public static Node moveToTag(Document document, String tag) throws IOException {
        NodeList nodeList = document.getElementsByTagName(tag);
        if (nodeList.getLength() == 0) {
            throw new IOException();
        }
        return nodeList.item(0);
    }

    public static Map<String, String> transToHashMap(Node node) {
        NodeList nodeList = node.getChildNodes();
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);
            map.put(childNode.getNodeName(), childNode.getTextContent());
        }
        return map;
    }
}
