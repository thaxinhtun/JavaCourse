package FileChannel_Test;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileChannel_read_largefile {
	public static void main(String[] args) {
		try (FileChannel channel = FileChannel.open(Path.of("employee.txt"),
				StandardOpenOption.READ)){
			
			int bufferSize = 20;
			if(bufferSize > channel.size())
			bufferSize = (int) channel.size();
			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
			
			while(channel.read(buffer) > 0) { // if reach end-of-file, return -1
			 buffer.flip(); // Flip the buffer before we can read data from it
			 String data = new String(buffer.array(),0,buffer.limit());
			 System.out.println("Content: " + data);
			 buffer.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
