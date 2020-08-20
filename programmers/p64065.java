package programmers;

import java.util.*;

public class p64065 {
	public int[] solution(String s) {
        int[] answer = {};
        ArrayList arr = new ArrayList(); //최종
        ArrayList list = new ArrayList(); //임시
        StringBuffer sb = new StringBuffer();
        ArrayList checked = new ArrayList();
        for(int i=1;i<s.length()-1;i++){
            char ch = s.charAt(i);
            if(ch == '{'){
                sb.setLength(0);
            }
            else if(ch == '}'){
                String str = sb.toString();
                list.add(Integer.parseInt(str));
                sb.setLength(0);
                if(arr.size() > list.size()){
                    int []newlist = new int[arr.size()]; 
                    int last = list.size();
                    System.out.println("last = "+last);
                    boolean check = false;
                    //checked에서 확정된거 저장
                    int minchecked = -1;

                    Collections.sort(checked);
                    System.out.println("checkedsize : " + checked.size());
                    for(int k=0;k<checked.size()-1;k++){
                    	if(k != (int)checked.get(k)) {
                    		if((int)checked.get(k) == 0){
                                minchecked = 0;
                            }
                    		break;
                    	}
                        if((int)checked.get(k) + 1 != (int)checked.get(k+1)){
                            if((int)checked.get(k) == 0){
                                minchecked = 0;
                            }
                            break;
                        }
                        System.out.println("checked " + checked.get(k) + ", " + checked.get(k+1));
                        minchecked++;
                    }
                    System.out.println("minchecked: " + minchecked);
                    checked.add(last-1);

                    for(int k=0;k<=minchecked;k++) {
                    	newlist[k] = (int)arr.get(k);
                    }
                    for(int k=0;k<list.size();k++){
                        for(int l=0;l<newlist.length;l++){
                            if(newlist[l] == (int)list.get(k)){
                                check = true;
                            }
                        }
                        if(check == false) {
                             newlist[++minchecked] = (int)list.get(k);
                        	
                        }
                        check = false;
                    }
                    for(int k=0;k<arr.size();k++){
                        for(int l=0;l<newlist.length;l++){
                            if(newlist[l] == (int)arr.get(k)){
                                check = true;
                            }
                        }
                        if(check == false) {
                        	if(last < newlist.length) {
                                newlist[last++] = (int)arr.get(k);
                        	}else {
                                newlist[last++ - 1] = (int)arr.get(k);
                        	}
                        }
                        check = false;
                    }
                    arr.clear();
                    for(int k=0;k<newlist.length;k++){
                        arr.add(newlist[k]);
                        System.out.println(newlist[k]);
                    }
                }else{
                    int []newlist = new int[list.size()];
                    int last = arr.size();
                    if(arr.size()== 0){
                        checked.add(list.size()-1);
                    }else{
                        checked.add(last);
                    }
                    System.out.println("last = "+last);

                    boolean check = false;
                    for(int k=0;k<arr.size();k++){
                        newlist[k] = (int)arr.get(k);
                    }
                    for(int k=0;k<list.size();k++){
                        for(int l=0;l<newlist.length;l++){
                            if(newlist[l] == (int)list.get(k)){
                                check = true;
                            }
                        }
                        if(check == false) {
                        	
                        	if(last < newlist.length) {
                                newlist[last++] = (int)list.get(k);
                        	}else {
                                newlist[last++ - 1] = (int)list.get(k);
                        	}
                        }
                        check = false;
                    }
                    arr.clear();
                    for(int k=0;k<newlist.length;k++){
                        arr.add(newlist[k]);
                        System.out.println(newlist[k]);
                    }
                }
                list.clear();
            }
            else if(ch ==',' && sb.length()>0){
                String str = sb.toString();
                list.add(Integer.parseInt(str));
                sb.setLength(0);
            }
            else{
                //숫자일 경우
                sb.append(ch);
            }
        }
        answer = new int[arr.size()];
        for(int k=0;k<arr.size();k++){
            System.out.print(" " + arr.get(k));
            answer[k] = (int)arr.get(k);
        }
        
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p64065 p = new p64065();
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		//String s = "{{20,111},{111}}";
		//String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		p.solution(s);
	}

}
