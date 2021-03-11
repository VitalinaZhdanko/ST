package com.zhdanko.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OperationWithXml {

    public static void createXml(String filename) throws ParserConfigurationException, TransformerException, FileNotFoundException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("coordinates");

        Element point1 = document.createElement("point");
        Element x1 = document.createElement("x");
        Text textX1 = document.createTextNode("30");
        Element y1 = document.createElement("y");
        Text textY1 = document.createTextNode("25");


        Element point2 = document.createElement("point");
        Element x2 = document.createElement("x");
        Text textX2 = document.createTextNode("20");
        Element y2 = document.createElement("y");
        Text textY2 = document.createTextNode("15");

        Element point3 = document.createElement("point");
        Element x3 = document.createElement("x");
        Text textX3 = document.createTextNode("10");
        Element y3 = document.createElement("y");
        Text textY3 = document.createTextNode("5");

        document.appendChild(root);
        root.appendChild(point1);
        root.appendChild(point2);
        root.appendChild(point3);

        point1.setAttribute("unit", "cm");
        point1.appendChild(x1);
        x1.appendChild(textX1);
        point1.appendChild(y1);
        y1.appendChild(textY1);

        point2.setAttribute("unit", "mm");
        point2.appendChild(x2);
        x2.appendChild(textX2);
        point2.appendChild(y2);
        y2.appendChild(textY2);

        point3.setAttribute("unit", "px");
        point3.appendChild(x3);
        x3.appendChild(textX3);
        point3.appendChild(y3);
        y3.appendChild(textY3);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(filename)));

    }

    public static void printXml(String filename) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(filename);

            Node root = document.getDocumentElement();
            System.out.println(root.getNodeName());

            NodeList points = root.getChildNodes();

            for (int i = 0; i < points.getLength(); i++) {
                Node point = points.item(i);
                if (point.getNodeType() != Node.TEXT_NODE) {
                    retrieveXmlChildNodes(point);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void retrieveXmlChildNodes(final Node point) {
        NodeList pointChildNodes = point.getChildNodes();
        for (int j = 0; j < pointChildNodes.getLength(); j++) {
            Node pointText = pointChildNodes.item(j);
            if (pointText.getNodeType() != Node.TEXT_NODE) {
                System.out.print(pointText.getNodeName() + " = " + pointText.getChildNodes().item(0).getTextContent()
                        + " " + ((Element) point).getAttribute("unit") + ", ");
            }
        }

        System.out.println(" ");
    }

    public static void createHtml(String xmlFile, String xsltFile, String htmlFile) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File(xsltFile));
        Transformer transformer = factory.newTransformer(xslt);
        Source xml = new StreamSource(new File(xmlFile));
        transformer.transform(xml, new StreamResult(new File(htmlFile)));
    }
}
