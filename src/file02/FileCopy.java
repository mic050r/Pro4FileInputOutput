package file02;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// c:\Temp.test.txt 파일을 이용해서 testout.txt로 복사하는 프로그램을 작성
// FileReader 클래스와 FileWriter클래스를 사용해서 작성하시오
// 수행 평가 이런식으로
public class FileCopy {

	public static void main(String[] args) {
		String src = "c:\\Temp\\test.txt";
		String dest = "c:\\Temp\\testout.txt";
//		File src = new File("c:\\Temp\\test.txt");
//		File dest = new File("c:\\Temp\\testout.txt");
		int c;
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(dest);
			
			while ((c = fr.read()) != -1) { // fr은 "test.txt"에 있는 데이터를 한문자씩 읽음
				fw.write((char) c); // fw가 가리키는 "testout.txt" 파일에 출력한다.
			}
			fr.close();
			fw.close();
			System.out.println("복사가 잘 되어있음");
//			System.out.println(src.getPath()+"를"+dest.getPath()+"로 복사");
		} catch (IOException e) {
			System.out.println("파일 복사 오류");
		}
	}
}