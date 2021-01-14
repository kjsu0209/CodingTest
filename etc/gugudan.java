import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		System.out.print("단=");
		int n = sc.nextInt();
		
		for(int i=1;i<10;i++) {
			for(int j=2;j<=n;j++) {
				System.out.printf("%d*%d=%2d  ", j, i, j*i);
			}
			System.out.println();
		}
	}

}
