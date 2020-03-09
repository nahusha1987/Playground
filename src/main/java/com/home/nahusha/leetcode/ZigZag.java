package com.home.nahusha.leetcode;

/*class ZigZag {
    public String convert(String s, int numRows) {
        char[][] zigzag = new char[numRows][s.length()/2];
        int k = 0;
        for (int j = 0; j < s.length()/2; j++) {
            for (int i = 0; i < numRows; i++) {
                if (k < s.length())
                    zigzag[i][j] = s.charAt(k++);
                else
                    break;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length()/2; j++) {
                char c = zigzag[i][j];
                if (Character.isLetter(c))
                    sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
		ZigZag zz = new ZigZag();
		System.out.println(zz.convert("PAYPALISHIRING", 3));
	}
}*/

public class ZigZag {
	public static void main(String[] args) {
		ZigZag zz = new ZigZag();
		System.out.println(zz.convert("PAYPALISHIRING", 4));
		System.out.println(zz.convert("ABCD", 2));
		System.out.println(zz.convert("ABC", 2));
		System.out.println(zz.convert("shuffle", 3));
		System.out.println(zz.convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers",
2));
	}

	public String convert(String s, int numRows) {
		if (s.length() == 0 || s.length() == 1) return s;
		if ( numRows ==  1) return s;
		int cols = s.length() / 2 + 1;
		char[][] zigzag = new char[numRows][cols];
		int k = 0, i = 0;
		boolean goingDown = true;
		for (int j = 0; j < cols; j++) {
			while (k < s.length()) {
				if (goingDown) {
					if (k < s.length()) {
						zigzag[i++][j] = s.charAt(k++);
						if (i == numRows) {
							i-=2;
							if (i != 0)goingDown = false;
							break;
						}
					}
				} else {
					if (k < s.length()) {
						zigzag[i--][j] = s.charAt(k++);
						//i--;
						if (i <= 0) {
							i = 0;
							goingDown = true;
						}
						break;
					}
					break;
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int p = 0; p < numRows; p++) {
			for (int q = 0; q < cols; q++) {
				char c = zigzag[p][q];
				if (Character.isLetter(c))
					sb.append(c);
			}
		}
		return sb.toString();
	}
}