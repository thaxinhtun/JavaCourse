package File_write;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class write_Buffer {
	public static void main(String[] args) {
		Path path = Path.of("test/tester.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(path)){
			writer.write("\"BufferedWriter is the simplest way of writing textual data to a File");
			writer.write("\nIt buffers characters to improve performance.");
			writer.newLine();
			writer.write("As it buffers before writing, ");
			writer.flush();
			writer.write("so it results in less IO operations.");
			System.out.println("Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
