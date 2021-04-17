package CodingTest.etc;

import java.util.*;
import java.io.*;
public class algoStudyFileGenerator {
	
	static final String userName = "김정수";

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// 문제 개수 입력 받기
		System.out.print("문제 개수 입력 : ");
		int N = sc.nextInt();
		System.out.println();

		// 
		for(int i=0;i<N;i++) {
			String type = "bj";
			System.out.print("문제 번호 : ");
			String num = sc.next();
			System.out.println();
			System.out.print("문제 이름 : ");
			String title = sc.next();
			System.out.println();

			// 복사할 파일 경로
			String filePath = "C:\\SSAFY\\work_algo\\algo_practice\\src\\CodingTest\\baekjoon\\b" + num+".java";
			
			// 복사한 파일을 저장할 위치 + 파일 이름
			String newFilePath = "C:\\SSAFY\\work_algo\\algo_study\\src\\"+type+"_"+num+"_"+title+"_"+ userName +".java";
			
			
			File f = new File(filePath);
			File newF = new File(newFilePath);
			
			FileInputStream fis = null;
			FileOutputStream fos = null;
			try {
				 fis = new FileInputStream(f);
				 fos = new FileOutputStream(newF);
			}catch(FileNotFoundException e) {
				System.out.println("해당 파일이 존재하지 않습니다...");
				continue;
			}

			try {
				int fileByte = 0;
				while((fileByte = fis.read()) != -1) {
					fos.write(fileByte);
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("파일 입출력 실패");
			}finally {
				fis.close();
				fos.close();
				System.out.println("성공적으로 파일을 생성했습니다. - " + num);
			}
			
			
		}
	}

}
