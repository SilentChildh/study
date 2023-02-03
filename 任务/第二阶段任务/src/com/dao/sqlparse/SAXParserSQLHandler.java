package com.dao.sqlparse;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 该xml文件解析器，会顺序读取所有的字符。<br/>
 * 要求文档中的每种sql语句标签只能存在一对，即每次修改sql语句，都应该在同一标签下修改元素值，而不能新增sql标签。
 */
public class SAXParserSQLHandler extends DefaultHandler {
    //用于保存读取到的元素值
    private String value;
    private String select;
    private String insert;
    private String update;
    private String delete;


    @Override
    public void endElement (String uri, String localName, String qName)
            throws SAXException
    {
        //找到对应的sql语句，就添加到map中，有多条同类型语句，就通过arrayList来存放
        if(qName.equals("select")) {
            select = value;
        }
        else if(qName.equals("insert")) {
            insert = value;
        }
        else if(qName.equals("update")) {
            update = value;
        }
        else if(qName.equals("delete")) {
            delete = value;
        }
    }

    @Override
    public void characters (char ch[], int start, int length)
            throws SAXException
    {
        //得到元素值
        value = new String(ch, start, length);
    }


    public String getSelect() {
        return select;
    }

    public String getInsert() {
        return insert;
    }

    public String getUpdate() {
        return update;
    }

    public String getDelete() {
        return delete;
    }
}
