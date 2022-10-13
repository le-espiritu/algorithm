package function;
// 백준 15596번 문제 - 정수 N개의 합을 구하는 함수 작성  

public class SumOfN {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public long sum(int[] a) {
		long sum =0;
		for(int i =0; i<a.length; i++) {
			sum=sum+a[i];
		}
		return sum;
	}

}
