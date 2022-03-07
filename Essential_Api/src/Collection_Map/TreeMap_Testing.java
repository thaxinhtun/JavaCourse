package Collection_Map;

import java.util.TreeMap;

public class TreeMap_Testing {
	public static void main(String[] args) {
		TreeMap<String, String> fileExtensions = new TreeMap<>();
		
		fileExtensions.put("java", ".java");
		fileExtensions.put("php", ".php");
		fileExtensions.put("c++", ".cpp");
		fileExtensions.put("html", ".html");
		fileExtensions.putIfAbsent("javascript", ".js");
		System.out.println(fileExtensions);
		
		fileExtensions.remove("c++");
		fileExtensions.forEach((k,v)->System.out.println(k + " => " + v));
	}
}
