package com.jtw.main.unified.xml;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxTest
{
    public static void main(String[] args) {
        //锟斤拷取一锟斤拷SAXParserFactory锟斤拷实锟斤拷
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //通锟斤拷factory锟斤拷取SAXParser实锟斤拷
        try {
            SAXParser parser = factory.newSAXParser();
            //锟斤拷锟斤拷SAXParserHandler锟斤拷锟斤拷
//            DefaultHandler handler = new SAXParserHandler();
            DefaultHandler handler = new SaxHandler();
            parser.parse("d:\\jtw\\aa.xml", handler);
//            System.out.println("~！~！~！共有" + handler.getBookList().size()
//                    + "本书");
//            for (Book book : handler.getBookList()) {
//                System.out.println(book.getId());
//                System.out.println(book.getName());
//                System.out.println(book.getAuthor());
//                System.out.println(book.getYear());
//                System.out.println(book.getPrice());
//                System.out.println(book.getLanguage());
//                System.out.println("----finish----");
//            }
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
