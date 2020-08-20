package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class b14889 {
	public int minA = Integer.MAX_VALUE;
	
	public void b14889(int n, int[][]ary, ArrayList<Integer> t1, ArrayList<Integer> t2, int T1ability, int T2ability, int person) {
		if(person==n) {
			//System.out.println("T1: " + T1ability + " T2: " + T2ability);
			minA = Math.min(minA, Math.abs(T1ability - T2ability));
			return;
		}
		
		ArrayList<Integer>T1 = new ArrayList();
		ArrayList<Integer>T2 = new ArrayList();

		T1.addAll(t1);
		T2.addAll(t2);
		
		boolean changedT1 = false;
		int newAbility = T1ability;
		if(T1.size()< n/2) {
			//능력치 추가
			for(int i=0;i<T1.size();i++) {
				newAbility += ary[T1.get(i)][person];
				newAbility += ary[person][T1.get(i)];
			}
			//T1에 추가
			T1.add(person);
			changedT1 = true;
			b14889(n, ary, T1, T2, newAbility, T2ability, person+1);
		}
		
		//초기화
		newAbility = T2ability;
		if(T1.size()>0 && changedT1 ==true)
			T1.remove(T1.size()-1);
		
		if(T2.size()< n/2) {
			//능력치 추가
			for(int i=0;i<T2.size();i++) {
				newAbility += ary[T2.get(i)][person];
				newAbility += ary[person][T2.get(i)];
			}
			//T2에 추가
			T2.add(person);
			b14889(n, ary, T1, T2, T1ability, newAbility, person+1);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [][]ary = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ary[i][j] = s.nextInt();
			}
		}
		
		ArrayList<Integer> t1 = new ArrayList();
		ArrayList<Integer> t2 = new ArrayList();
		
		b14889 b = new b14889();
		b.b14889(n, ary, t1, t2, 0, 0, 0);
		
		System.out.println(b.minA);
	}

}
