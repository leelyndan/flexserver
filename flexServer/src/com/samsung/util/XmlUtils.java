package com.samsung.util;

import com.thoughtworks.xstream.XStream;

public class XmlUtils
{
    public static String object2Xml(Object obj)
    {
        
        return new XStream().toXML(obj);
    }
}
