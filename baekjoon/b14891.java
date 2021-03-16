package CodingTest.baekjoon;
import java.io.*;
import java.util.*;
public class b14891 {

	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] gear = new char[4][8];
		int[] gearIndex = new int[4];
		
		for(int i=0;i<4;i++) gear[i] = in.readLine().toCharArray();
		
		int K = stoi(in.readLine());
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int g = stoi(st.nextToken()) - 1;
			int turnDir = stoi(st.nextToken());
			
			visited = new boolean[8];
			turnGear(gear, gearIndex, g, turnDir);
		}
		int point = 0;
		for(int i=0;i<4;i++) {
			//System.out.println(gear[i][gearIndex[i]]);
			if(gear[i][gearIndex[i]] == '1')
				point += Math.pow(2, i);
		}
		
		System.out.println(point);
	}
	
	static void turnGear(char[][] gear, int[]gearIndex, int g, int turnDir) {
		visited[g] = true;
		// 왼쪽 움직일 수 있으면 왼쪽 톱니바퀴로 가기
		if(g-1 >= 0) {
			//System.out.println(g +" leftSide " + (g-1) +": "+gear[g-1][getRight(gearIndex[g-1])]+"  - " + gear[g][getLeft(gearIndex[g])]);
			//System.out.println(g +" leftSide " + (g-1) +": "+getRight(gearIndex[g-1])+"  - " + getLeft(gearIndex[g]));
			if(gear[g-1][getRight(gearIndex[g-1])] != gear[g][getLeft(gearIndex[g])]&&!visited[g-1]) {
				turnGear(gear, gearIndex, g-1, turnDir==-1?1:-1);
			}
		}
		// 오른쪽 움직일 수 있으면 오른쪽 톱니바퀴로 가기
		if(g+1 < 4) {
			if(gear[g][getRight(gearIndex[g])] != gear[g+1][getLeft(gearIndex[g+1])]&&!visited[g+1]) {
				turnGear(gear, gearIndex, g+1, turnDir==-1?1:-1);
			}
		}
		// 자기 자신 돌리기
		if(turnDir == -1)
			gearIndex[g] = (gearIndex[g]+1)%8;
		else
			gearIndex[g] = (gearIndex[g]+7)%8;
	}
	
	static int getRight(int g) {
		return (g+2)%8;
	}
	static int getLeft(int g) {
		return (g+6)%8;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
