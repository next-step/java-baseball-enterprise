package com.neurumaru.baseball;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;

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
}
