package function;

//백준 4673번 문제 - 셀프넘버  

public class SelfNumber {	
	public static void main(String[] args) {
		boolean[] arr = new boolean[10001];
		for(int i =1; i<10001; i++) {
			int result = d(i); // 생성자가있는 수를 찾음 
			
			if(result<10001) {
				arr[result]=true; // 생성자가 있는 수를 인덱스로 활용 
			}
			
		}
		for(int j=1; j<10001; j++) {
			if(!arr[j]) { // 인덱스를 통해 생성자가 없는 수를 찾는다. 
				System.out.println(j);
			}
		}

	}
	public static int d(int num) {
		int sum=num;
		while(num!=0) {
			sum=sum+(num%10); // 나머지 연산을 통해 첫째 자리 수를 구한다.
			num=num/10; // 10을 나누어 첫째 자리를 없앤다. 
		}
		return sum;
	}


}
