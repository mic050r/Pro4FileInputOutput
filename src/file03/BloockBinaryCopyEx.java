package file03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BloockBinaryCopyEx {

	public static void main(String[] args) {
		File src = new File("./src/file03/forest.jpg");
		File dest = new File("./src/file03/copyforest.jpg");
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			byte[] buf = new byte[1024 * 10];

			while (true) {
				int n = fi.read(buf);
				fo.write(buf, 0, n);
				if (n < buf.length)
					break;
			}
			fo.close();
			fi.close();
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");
		} catch (IOException e) {
			System.out.println("파 일복사 오류");
		}
	}
}
