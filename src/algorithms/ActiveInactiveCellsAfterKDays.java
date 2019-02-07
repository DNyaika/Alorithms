package algorithms;

import java.util.Arrays;
/**
Given a binary array of size n where n > 3. A true (or 1) value in the array means active 
and false (or 0) means inactive. Given a number k, the task is to find count of active and inactive cells after k days.
After every day, status of i’th cell becomes active if left and right cells are not same and inactive if left and right cell are same (both 0 or both 1).
Since there are no cells before leftmost and after rightmost cells, 
the value cells before leftmost and after rightmost cells is always considered as 0 (or inactive).
 */

public class ActiveInactiveCellsAfterKDays {

	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 1, 0, 1, 0, 1};

		int days = 3;
		computeActiveInactive(arr, days);
	}

	public static void computeActiveInactive(int[] arr, int days) {
		int beforeLeftMost = 0;
		int afterRightMost = 0;
		int[] buffer = new int[arr.length];
		int d=0;

		for (int day = 0; day < days; day++) {
			d=day;
				
			if ((beforeLeftMost == 0 && arr[1] == 0)) {
				if(day>0 && buffer[0] == 1){
					buffer[0]=0;
				}
			} else if ((beforeLeftMost == 0 && arr[1] == 1)) {
				buffer[0] = 1;
			}
			for (int i = 0; i < arr.length; i += 2) {
				int buff = i + 2;
				int i_buff = i;
				if (i >= 2) {
					buff = buff - 1;
					i_buff = i - 1;
				}
				
				int targetIndex = (i + buff) / 2;
				if ((arr[i_buff] == 0 && arr[buff] == 1) || (arr[i_buff] == 1 && arr[buff] == 0)) {
						buffer[targetIndex] = 1;
				}else if((arr[i_buff] == 0 && arr[buff] == 0) || (arr[i_buff] == 1 && arr[buff] == 1)){
					if(day>0 && buffer[targetIndex] == 1){
						buffer[targetIndex]=0;
					}
				}
			}
			if (afterRightMost == 0 && arr[arr.length - 2] == 0) {
				if(day>0 && buffer[arr.length - 1] == 1){
					buffer[arr.length - 1]=0;
				}
			} else if ((afterRightMost == 0 && arr[arr.length - 2] == 1)) {
				buffer[arr.length - 1] = 1;
			}
			
			arr =buffer;
			buffer = new int[arr.length];
			System.out.println("Day "+d+" "+Arrays.toString(arr));
		}
	}

}
