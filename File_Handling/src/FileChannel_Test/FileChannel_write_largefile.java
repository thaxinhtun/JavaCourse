package FileChannel_Test;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel_write_largefile {
	public static void main(String[] args) {

		try (RandomAccessFile file = new RandomAccessFile("data1.txt", "rw")){
			String largeData = "Many data .....";
			// Get file channel
			FileChannel channel = file.getChannel();
			
			// Get direct byte buffer access
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 4096 * 8);
			
			//Write the content using put methods
			 buffer.put(largeData.getBytes());
			 System.out.println("success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
