package FileChannel_Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel_read_smallfile {
	public static void main(String[] args) {
		try(RandomAccessFile inputFile = new RandomAccessFile("Employee.txt", "r")) {
			//small file
			
			FileChannel channel = inputFile.getChannel();
				long fileSize = channel.size();
				// create buffer
				ByteBuffer buffer = ByteBuffer.allocate((int)fileSize);
				// read data from channel to buffer
				channel.read(buffer);
				// prepare to read data from buffer
				buffer.flip();
				String data = new String(buffer.array(),0,buffer.limit());
				System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
