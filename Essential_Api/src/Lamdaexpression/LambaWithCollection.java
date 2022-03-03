package Lamdaexpression;

import java.util.List;

public class LambaWithCollection {
	public static void main(String[] args) {
		List<String> languages = List.of("HTML","JavaScript","CSS","Java","PHP");
		
		languages.forEach(s-> System.out.println(s));
		
		System.out.println("*********");
		
		languages.forEach(lang->{
			if(lang.contains("Java"))
				System.out.println(lang);
		});
	}
	
}
