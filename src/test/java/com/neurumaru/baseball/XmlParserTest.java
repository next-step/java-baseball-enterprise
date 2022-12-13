package com.neurumaru.baseball;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlParserTest {
    @Test
    void getDocumentTest() throws IOException {
        Document document = XmlParser.getDocument("Korean.xml");
        assertThat(document.getXmlVersion()).isEqualTo("1.0");
        assertThat(document.getXmlEncoding()).isEqualTo("UTF-8");
    }

    @Test
    void moveToTagTest() throws IOException {
        Document document = XmlParser.getDocument("Korean.xml");
        Node node = XmlParser.moveToTag(document, "LanguageData");
        assertThat(node.getNodeName()).isEqualTo("LanguageData");
    }

    @Test
    void transToHashMapTest() throws IOException {
        Document document = XmlParser.getDocument("Korean.xml");
        Node node = XmlParser.moveToTag(document, "LanguageData");
        Map<String, String> map = XmlParser.transToHashMap(node);
        assertThat(map.get("Baseball.RequestInputNumber")).isEqualTo("숫자를 입력해주세요 : ");
        assertThat(map.get("Baseball.Strike")).isEqualTo("{0} 스트라이크 ");
        assertThat(map.get("Baseball.Ball")).isEqualTo("{0}볼 ");
        assertThat(map.get("Baseball.Nothing")).isEqualTo("낫싱");
        assertThat(map.get("Baseball.GameTermination")).isEqualTo("{0}개의 숫자를 모두 맞히셨습니다! 게임 종료");
        assertThat(map.get("Baseball.Restart")).isEqualTo("게임을 새로 시작하려면 {0}, 종료하려면 {1}를 입력하세요");
    }
}
