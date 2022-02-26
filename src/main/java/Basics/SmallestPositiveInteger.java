package Basics;

public class SmallestPositiveInteger {
	
	public static boolean search(int [] arr, int search) {
		for(int i = 0;i< arr.length ; i++){
            if(search == arr[i]){
                return true;
            } 
        }
		return false;
	}
	
	public void name() {
		int A[] = {-1,-3} ;
		
		 boolean run = true ;
	        int smallestPositiveInteger = 0;

	        while(run){
	        	smallestPositiveInteger++;
	        	run = search(A,smallestPositiveInteger);
	        	
	        }
	        
	        //run = search(A,5);
	        System.out.println(smallestPositiveInteger);
	}
	
	public static int oddSum(int x) {
		int sum =0 ;
		while(x>0) {
			int rem = x%10;
			if(!(rem %2 ==0)) {
				sum+=rem ;
			}
			x= x/10 ;
		}		
		
		
		if(sum%2 == 0) {
			return -1;
		}else {
			return 1 ;
		}
	}
	
	public static int noOfVowels(String S) {
		int num = 0;
		for(int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if(ch == 'a'||ch == 'e'||ch == 'i'||ch == 'o' || ch == 'u') {
				num++ ;
			}
		}
		return num;
	}

	public static int squreCubes(int[] Array) {
		int sum = 0;
		int sumSqure = 0;
		int sumCube = 0;
		
		for(int i=0;i<Array.length;i++) {
			if(!(i%2 == 0)) {
				sumSqure = sumSqure + (Array[i]*Array[i]);
			}
			else {
				sumCube =sumCube + (Array[i]*Array[i]*Array[i]);
			}
		}
		
		sum = sumCube+ sumSqure ;
		
		return sum ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//oddSum(52315);
		//noOfVowels("Shivanii")
		int[] array = {1,4,3};
		
		int result = squreCubes(array);
		System.out.println(result);
	}

}
