// 0:12
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean[] has31 = {true, false, true, false, true, false, true, true, false, true, false, true}; 
		
		for(int tc=1;tc<=T;tc++) {
			String input = sc.next();
			String year = input.substring(0,4);
			String month = input.substring(4,6);
			String date = input.substring(6,8);

			boolean isLeapYear = false;
			// check month
			if(Integer.parseInt(month)>12 || Integer.parseInt(month)<1) {
				System.out.println("#"+tc+" -1");
				continue;
			}
			/*
			//check leapyear
			if(Integer.parseInt(year)%4 == 0) {
				isLeapYear = true;
			}
			*/
			//check date
			if(isLeapYear) {
				if(month.equals("02")) {
					if(Integer.parseInt(date)>29 || Integer.parseInt(date)<1) {
						System.out.println("#"+tc+" -1");
						continue;
					}
				}else {
					if(has31[Integer.parseInt(month)]) {
						if(Integer.parseInt(date)>31 || Integer.parseInt(date)<1) {
							System.out.println("#"+tc+" -1");
							continue;
						}
					}else {
						if(Integer.parseInt(date)>30 || Integer.parseInt(date)<1) {
							System.out.println("#"+tc+" -1");
							continue;
						}
					}
					
				}
				
			}else {
				if(month.equals("02")) {
					if(Integer.parseInt(date)>28 || Integer.parseInt(date)<1) {
						System.out.println("#"+tc+" -1");
						continue;
					}
				}else {
					if(has31[Integer.parseInt(month)]) {
						if(Integer.parseInt(date)>31 || Integer.parseInt(date)<1) {
							System.out.println("#"+tc+" -1");
							continue;
						}
					}else {
						if(Integer.parseInt(date)>30 || Integer.parseInt(date)<1) {
							System.out.println("#"+tc+" -1");
							continue;
						}
					}
					
				}
			}
			
			
			System.out.println("#"+tc+" "+year+"/"+month+"/"+date);
		}
	}

}
