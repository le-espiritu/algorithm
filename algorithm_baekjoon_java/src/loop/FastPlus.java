package loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class FastPlus {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<num; i++) {
			String numbers = bf.readLine();
			String arr[]=numbers.split(" ");
			
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			bw.write(a+b+"\n");
			
		}
		bf.close();
		bw.flush();
		bw.close();

	}

}
