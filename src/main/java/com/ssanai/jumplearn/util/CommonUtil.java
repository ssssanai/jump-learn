package com.ssanai.jumplearn.util;

public class CommonUtil {
	public static boolean isValidValue(String s) {
		if (
				s.contains("--")
						|| s.contains("#")
						|| s.contains("/*")
						|| s.contains("'")
						|| s.contains("\"")
						|| s.contains("$$")
		) {
			return false;
		} else {
			return true;
		}
	}
}
