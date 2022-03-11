package File_read;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Read_Buffer {
	public static void main(String[] args) {
		Path path = Path.of("Employee.txt");
		
		try(BufferedReader reader = Files.newBufferedReader(path)) {
			String line = null;
			List<String> list = new ArrayList<>();
			
			while((line = reader.readLine()) != null) {
				String temp = line.toLowerCase();
				if(temp.contains("aung"))
					list.add(line);
			}
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
