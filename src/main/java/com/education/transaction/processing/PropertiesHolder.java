package com.education.transaction.processing;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesHolder {

    private Map<String,String> properties;

    public PropertiesHolder(String fileName) {
        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream(fileName);
        try {
            prop.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties = new HashMap<>();
        Enumeration<?> e = prop.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = prop.getProperty(key);
            properties.put(key, value);
        }
    }

    public String getProperty(String key){
        return properties.get(key);
    }
}
