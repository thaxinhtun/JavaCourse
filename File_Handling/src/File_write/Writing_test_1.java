package File_write;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Writing_test_1 {
	public static void main(String[] args) throws IOException {
		List<String> cities = List.of("Yangon","Mandalay","Pyin Oo Lwin","Insein","Hledan","Hlaing");
		Path path = Path.of("city_datal.txt");
		Files.write(path,cities);
		System.out.println("Write success");
		
		Files.write(path, "Monywa".getBytes(),StandardOpenOption.APPEND);

		
	}
}
