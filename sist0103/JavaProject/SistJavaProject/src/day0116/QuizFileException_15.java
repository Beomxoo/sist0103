package day0116;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class QuizFileException_15 {

	public static void fileRead() {
		String fName = "C:\\sist0103\\file\\fruitshop.txt";
		FileReader fr = null; //메서드에서는 자동초기화되지않아서 null로 초기화해야함
		BufferedReader br = null;
		int cnt = 0;

		try {
			fr = new FileReader(fName);
			br = new BufferedReader(fr);

			System.out.println("**과일입고목록**");
			System.out.println();
			System.out.println("번호\t과일명\t수량\t단가\t총금액");
			System.out.println("-----------------------------------");
			while (true) {
				String s = br.readLine();
				if (s == null) {
					break;
				}
				cnt++;
				/*String[] data = s.split(",");
				// 배열갯수만큼 출력 */
				StringTokenizer st = new StringTokenizer(s, ",");
                String[] data = new String[st.countTokens()];
                int index = 0;
                while (st.hasMoreTokens()) {
                    data[index] = st.nextToken();
                    index++;
                }
				int tot = Integer.parseInt(data[1]) * Integer.parseInt(data[2]);
				System.out.println(cnt + "\t" + data[0] + "\t" + data[1] + "\t" + data[2] + "\t" + tot);
				//String sang = st.nextToken();
				//int su = Integer.parseInt(st.nextToken().trim());
				//int dan = Integer.parseInt(st.nextToken().trim());
				//int total= su*dan;
				

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileRead();
	}

}
