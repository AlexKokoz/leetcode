package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001410_HTMLEntityParser {
	public String entityParser(String text) {
		Map<String, String> map = new HashMap<>();
		map.put("&quot;", "\"");
		map.put("&apos;", "'");
		map.put("&amp;", "&");
		map.put("&gt;", ">");
		map.put("&lt;", "<");
		map.put("&frasl;", "/");
		for (String key : map.keySet())
			text = text.replaceAll(key, map.get(key) + "\\}\\{");
		text = text.replaceAll("\\}\\{", "");
		return text;
	}
}
