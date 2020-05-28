package com.home.nahusha.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HtmlEntityParser {
	public String entityParser(String text) {
        Map<String, String> spcl = new HashMap<>();
        spcl.put("&quot;", "\"");
        spcl.put("&apos;", "\'");
        spcl.put("&amp;", "&");
        spcl.put("&frasl;", "/");
        spcl.put("&gt;", ">");
        spcl.put("&lt;", "<");
        /*spcl.forEach((k,v) -> {
        text.replace(k, v);
        System.out.println(text);});*/
        for (Map.Entry<String,String> entry : spcl.entrySet()) {
        	text = text.replace(entry.getKey(), entry.getValue());
        }
        return text;
    }
	
	public static void main(String[] args) {
		HtmlEntityParser hep =  new HtmlEntityParser();
		System.out.println(hep.entityParser("&amp; is an HTML entity but &ambassador; is not."));
		System.out.println("&amp; is an HTML entity but &ambassador; is not.".replace("&amp;", "&"));
	}
}
