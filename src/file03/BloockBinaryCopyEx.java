package file03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BloockBinaryCopyEx {

	public static void main(String[] args) {
		File src = new File("./src/file03/forest.jpg");
		File dest = new File("./src/file03/copy3forest.jpg");
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			byte[] buf = new byte[1024 * 10]; // 1024가 1KB, ---> 10KB 버퍼(임시 기억 공간)

			while (true) {
				int n = fi.read(buf); // fi가 가리키는 파일(forest.jpg)에서 데이터를 읽어서
				// 그 길이 값을 n에 저장하고, 그 길이 값을 n에 넘겨준다.
				// 그 길이 값을 n에 저장
				fo.write(buf, 0, n); // buf임시 기억공간에 있는 데이터를 0번째 인덱스부터
				// 시작하여 n길이 만큼의 데이터를 fo가 가리키는 파일 (copy3forest.jpg)에 출력한다. 예상 tp
				System.out.print("n=" + n + " buf.length=" + buf.length + "\n");
				if (n < buf.length) // 반복해서 10240바이트를 읽어서 n에 저장되어있기 때문에
					// flase가 되었는데 마지막에 읽은 데이터는 9129를 n에 저장되었기 때문에
					// true가 발생한다. 따라서 while문이 종료된다
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
