package br.com.erudio.converters;

public class NumberConverter {
	
	public static Integer convertToInteger(String strNumber) {
		if(strNumber == null) return 0;
		String number = strNumber;
		if (isNumeric(number)) return Integer.parseInt(strNumber);
		return 0;
	}

	public static Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		//BR 10,25 US 10.25
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	public static boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
