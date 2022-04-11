package loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class beautifulCasePlus {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		for(int i =1; i<=n; i++){
			String numbers = br.readLine();
			String[] numbersArr=numbers.split(" ");
			
			int a = Integer.parseInt(numbersArr[0]);
			int b = Integer.parseInt(numbersArr[1]);
			
			bw.write("Case #"+i+": "+a+" + "+b+" = "+(a+b)+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
