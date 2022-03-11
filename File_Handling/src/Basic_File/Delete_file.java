package Basic_File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Delete_file {
	public static void main(String[] args) throws IOException {
//		Path path = Path.of("src/readme.txt");
//		
//		boolean deleted = Files.deleteIfExists(path);
//		if(deleted)
//			System.out.println("File deleted");
//		else
//			System.out.println("Does not exist");
		Path path = Path.of("E:\\JavaFiletest\\files");
//		if(Files.deleteIfExists(path))
//			System.out.println("Dir deleted");
//		else
//			System.out.println("No dir");
		if(Files.exists(path)){
			Files.walk(path)
			.map(p ->p.toFile())
			.forEach(f -> f.delete());
			
		Files.delete(path);
		System.out.println("File deleted");
		}
	}
}
