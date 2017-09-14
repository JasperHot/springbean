package com.java.maven.test.trial1;

import java.util.HashMap;
import java.util.Map;

public class TrimCN {
	public static void main(String[] args) throws Exception {
		String str = "我a爱中华abc我爱传智def";
		// String str = "我ABC汉";
		int num = trimGBK(str.getBytes("GBK"), 6);
		System.out.println(str.substring(0, num));

		for (Byte chr : str.getBytes("GBK")) {
			System.out.println(chr + "\n");
		}

		printStatisitc("中国aadf的111萨bbb菲的zz萨菲");

	}

	public static int trimGBK(byte[] buf, int n) {
		int num = 0;
		boolean bChineseFirstHalf = false;
		for (int i = 0; i < n; i++) {
			if (buf[i] < 0 && !bChineseFirstHalf) {
				bChineseFirstHalf = true;
			} else {
				num++;
				bChineseFirstHalf = false;
			}
		}
		return num;
	}

	public static void printStatisitc(String content) {
		Map<String, Integer> dictionary = new HashMap<>();
		for (int i = 0; i < content.length(); i++) {
			char c = content.charAt(i);
			Integer num = dictionary.get(Character.toString(c));
			if (num == null)
				num = 1;
			else
				num++;
			dictionary.put(Character.toString(c), num);
		}
		for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
