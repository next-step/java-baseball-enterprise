package com.neurumaru.baseball;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlParserTest {
    @Test
    void getDocumentTest() throws IOException {
        Document document = XmlParser.getDocument("Korean.xml");
        assertThat(document.getXmlVersion()).isEqualTo("1.0");
        assertThat(document.getXmlEncoding()).isEqualTo("UTF-8");
    }
}
