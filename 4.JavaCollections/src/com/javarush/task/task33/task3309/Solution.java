package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* 
Комментарий внутри xml
*/

@XmlRootElement
public class Solution {
    @XmlElement(name = "second")
    String[] second = {"1","2","3"};


    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
    StringWriter writer = new StringWriter();

    JAXBContext context = JAXBContext.newInstance(obj.getClass());

    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);



    marshaller.marshal(obj, writer);

    String result = writer.toString();


    String tag = "<" + tagName + ">";
    result = result.replaceAll(tag, "<!--" + comment + "-->" + tag);

        //System.out.println(result);
        return result;
    }

    public static void main(String[] args) throws JAXBException {

    toXmlWithComment(new Solution(),"second", "comment");
    }
}
