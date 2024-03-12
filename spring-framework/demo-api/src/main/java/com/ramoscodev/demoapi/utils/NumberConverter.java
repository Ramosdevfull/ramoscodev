package com.ramoscodev.demoapi.utils;

public class NumberConverter {

	public static boolean isNumeric(String number) {
		if(number == null) return false;
		//String vlrNb = number.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

	public static Double convertToDouble(String strValue) {
		if(strValue == null) {
			return 0D;
		}
		String vlrNb = strValue.replaceAll(",", ".");
		if(isNumeric( vlrNb)) return Double.parseDouble(vlrNb);
		return 0D;
	}
}
