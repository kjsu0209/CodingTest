// 2: 00
package CodingTest.swexpert;
import java.io.*;
import java.util.*;
public class t_5650 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			//  입력
			int N = in.nextInt();
			Map<Integer, int[]> wormhole= new HashMap<>(); // 인덱스 : 좌표 1, 좌표 2
			int[][] board= new int[N+2][N+2];
			for(int i=0;i<N+1;i++) {
				board[i][0] = 5;
				board[0][i] = 5;
				board[i][N+1] = 5;
				board[N+1][i] = 5;
			}
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					board[i][j] = in.nextInt();
					if(board[i][j] >= 6) {
						int[] arr = new int[4];
						arr[0] = i;
						arr[1] = j;
						if(wormhole.containsKey(board[i][j])) {
							arr[2] = wormhole.get(board[i][j])[0];
							arr[3] = wormhole.get(board[i][j])[1];
						}
						wormhole.put(board[i][j], arr);
					}
				}
			}
			// 핀볼 출발지가 될 수 있는 좌표 찾기
			int[][]dir = {{-1, 0},{0,1},{1,0},{0,-1}};
			
			int maxPoint = 0;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(board[i][j] == 0) {
						for(int d=0;d<4;d++) {
							boolean isStart = true;
							int head = d;
							// 핀볼 동서남북 방향으로 출발
							int posR = i;
							int posC = j;
							int point = 0;
							while(true) {
								// System.out.println(posR + " "+posC +" ) " + board[posR][posC]);
								// 종료 1: 핀볼이 출발 위치로 돌아올 때
								if(!isStart && posR == i && posC == j) {
									break;
								}
								isStart = false;

								// 종료 2: 브랙홀에 빠질 때
								if(board[posR][posC] == -1) {
									break;
								}
								
								// 웜홀이면 웜홀 이동
								if(board[posR][posC] >= 6) {
									int[] arr = wormhole.get(board[posR][posC]);
									if(arr[0] == posR && arr[1] == posC) {
										posR = arr[2];
										posC = arr[3];
									}
									else {
										posR = arr[0];
										posC = arr[1];
									}
								}
								
								// 블럭이면 방향 바꾸기
								if(board[posR][posC] == 1) {
									if(head == 0 || head == 1) {
										// 반대 방향
										head = (head+2)%4;
									}
									else if(head == 2) {
										// 90도 오른쪽
										head = (head+3)%4;
									}
									else if(head == 3){
										// 90도 
										head = (head+1)%4;
									}
									point++;
								}
								else if(board[posR][posC] == 2) {
									if(head == 2 || head == 1) {
										// 반대 방향
										head = (head+2)%4;
									}
									else if(head == 3) {
										// 90도 오른쪽
										head = (head+3)%4;
									}
									else if(head == 0){
										// 90도 
										head = (head+1)%4;
									}
									point++;
								}
								else if(board[posR][posC] == 3) {
									if(head == 2 || head == 3) {
										// 반대 방향
										head = (head+2)%4;
									}
									else if(head == 0) {
										// 90도 오른쪽
										head = (head+3)%4;
									}
									else if(head == 1){
										// 90도 
										head = (head+1)%4;
									}
									point++;
								}
								else if(board[posR][posC] == 4) {
									if(head == 0 || head == 3) {
										// 반대 방향
										head = (head+2)%4;
									}
									else if(head == 2) {
										// 90도 오른쪽
										head = (head+1)%4;
									}
									else if(head == 1){
										// 90도 
										head = (head+3)%4;
									}
									point++;
								}
								else if(board[posR][posC] == 5) {
									head = (head+2)%4;
									point++;
								}
								
								
								int newR = posR + dir[head][0];
								int newC = posC + dir[head][1];
								
								posR = newR;
								posC = newC;
								
							}
							maxPoint = Math.max(maxPoint, point);
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+maxPoint);
			
		}
		
	}

}
