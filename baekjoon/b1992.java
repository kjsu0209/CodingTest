package CodingTest.baekjoon;
import java.util.*;
import java.io.*;
public class b1992 {
	
	static StringBuilder sb;
	static char[][] quad;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		quad = new char[N][N];
		
		for(int i=0;i<N;i++) {
			quad[i] = in.readLine().toCharArray();
		}
		
		sb = new StringBuilder();
		
		pressQuad(0, 0, N);
		
		System.out.println(sb);
	}

	static void pressQuad(int row, int col, int width) {
		// 기저조건: 해당 범위의 내용물이 전부 같으면 버퍼에 넣고 종료
		char checkResult = checkCanPress(row, col, width);
		if(checkResult != '2') {
			sb.append(checkResult);
			return;
		}
		
		// 4개 영역으로 나눠서 호출
		sb.append("(");
		pressQuad(row, col, width/2);
		pressQuad(row, col+width/2, width/2);
		pressQuad(row+width/2, col, width/2);
		pressQuad(row+width/2, col+width/2, width/2);
		sb.append(")");
	}
	
	static char checkCanPress(int row, int col, int width) {
		char a = quad[row][col];
		for(int i=row;i<row+width;i++) {
			for(int j=col;j<col+width;j++) {
				if(a!=quad[i][j]) return '2';
			}
		}
		
		return a;
	}
}
