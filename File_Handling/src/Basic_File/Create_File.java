package Basic_File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Create_File {
	public static void main(String[] args) throws IOException {
		
		Path path = Path.of("src/readme.txt");
		if(Files.exists(path)) {
			System.out.println("Already exist");
		}
		else {
			Files.createFile(path);
			System.out.println("This is create");
		}
		//create dir
		path = Path.of("./test");
		if(Files.notExists(path))
				Files.createDirectories(path);
	}
}
