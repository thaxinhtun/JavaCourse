package FileChannel_Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel_write_smallfile {
	public static void main(String[] args) {
		String data = """
				FileChannel can be faster than
				Standard I/O if you're dealing with large files.
				""";

		try (RandomAccessFile inputFile = new RandomAccessFile("data.txt", "rw");
				FileChannel fileChannel = inputFile.getChannel()){
			
			//create byte buffer with sufficient capacity;
			byte[] byteData = data.getBytes();
			ByteBuffer buffer = ByteBuffer.allocate(byteData.length);
			
			// transfer data to the buffer
			buffer.put(byteData);
			
			// read data from buffer to prepare for channel write
			buffer.flip();
			
			// write sequence of byte to the channel from the buffer
			fileChannel.write(buffer);
			System.out.println("success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
