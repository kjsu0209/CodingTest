package CodingTest.swexpert.d4;
import java.io.*;
import java.util.*;
public class d4_1251_prim {

	static int N;
	static int[][] islands;
	static double E;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N = stoi(in.readLine());
			islands = new int[N][2];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++) {
				islands[i][0] = stoi(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++) {
				islands[i][1] = stoi(st.nextToken());
			}
			
			E = Double.parseDouble(in.readLine());
			
			
			System.out.println("#"+tc+" "+prim());
		}
	}
	
	
	// Prim 알고리즘
	static long prim() {
		double [][] adjMatrix = new double[N][N];
		boolean[] visited = new boolean[N];
		
		double[] minEdge = new double[N]; //최소 가중치 배열
		
		// 인접 행렬 만들기
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				
				adjMatrix[i][j] = getEnvFee(getDist(islands[i], islands[j]));
			}
			
			minEdge[i] = Double.MAX_VALUE;
		}
		
		// 출발지점 0으로 정하기
		double result = 0;
		minEdge[0] = 0;
		
		for(int i=0;i<N;i++) {
			// 연결되지 않은 섬 중 최소 비용인 섬 찾기
			double min = Double.MAX_VALUE;
			int minVertex = 0;
			for(int j=0;j<N;j++) {
				if(!visited[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			
			result += min;
			visited[minVertex] = true;
			
			// 최소비용인 섬에서 다른 섬까지의 비용이 섬 비용의 최솟값인지 확인 후 갱신
			for(int j=0;j<N;j++) {
				if(!visited[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]) {
					minEdge[j] = adjMatrix[minVertex][j];
				}
			}
		}
		
		return Math.round(result); // (long) (result+0.5)
	}
	
	// 섬과 섬 사이의 거리 구하는 메서드
	static double getDist(int[] o1, int[] o2) {
		return Math.sqrt(Math.pow((o1[0]-o2[0]), 2) + Math.pow((o1[1]-o2[1]), 2));
	}
	
	// 환경 부담금 구하는 메서드
	static double getEnvFee(double len) {
		return E * Math.pow(len, 2);
	}
	
	// 문자열 정수로 만드는 메서드
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
