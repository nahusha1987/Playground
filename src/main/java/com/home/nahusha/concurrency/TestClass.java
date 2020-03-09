package com.home.nahusha.concurrency;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class TestClass {
	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		// PrintWriter wr = new PrintWriter(System.out);
		// long n = Long.parseLong(br.readLine().trim());
		long n = 100;
		long out_ = FindBigNum(n);
		System.out.println(out_);
		// wr.println(out_);
		// wr.close();
		// br.close();
	}

	static long FindBigNum(long n) {
		// Write your code here
		if (n == 0)
			return 1;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i <= n; i++) {
			sb.append(convertToBinary(i));
		}
		return convertToDecimal(sb.toString());
	}

	static String convertToBinary(int n) {
		int rem;
		String x = "";
		while (n > 0) {
			rem = n % 2;
			n = n / 2;
			x = rem + x;
		}
		return x;
	}

	static long convertToDecimal(String s) {
        BigInteger sum = BigInteger.ZERO;
        int base = 1;
        for (int i = s.length()-1; i>=0; i--) {
            if (s.charAt(i) == '1') {
                BigInteger x = BigInteger.valueOf(Integer.parseInt(String.valueOf(s.charAt(i))));    
                BigInteger tmp = x.multiply(BigInteger.valueOf(base));
                sum = sum.add(tmp);
            }
            base = base * 2;
        }
        return sum.mod(BigDecimal.valueOf(Math.pow(10,9) + 7).toBigInteger()).longValue();
    
    }
}