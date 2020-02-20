package com.dnp.home.util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dnp.home.common.PropertyMessage;
import com.dnp.home.consts.ExceptionConst;
import com.dnp.home.exception.DNPException;
import com.dnp.home.vo.ListVO;
import com.dnp.home.vo.ResponseDataVO;


public class StringUtil {
	static Logger log = LogManager.getLogger(StringUtil.class);

	public static String newLineToBR (String text) {
		String nText = text.replaceAll("(?i)\n","<br>");
		return nText;
	}

	public static String UniToKSC(String str) {
		if (str == null) {
			return null;
		}

		String str2 = null;
		try {
			str2 = new String(str.getBytes("8859_1"), "KSC5601");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
			return null;
		}

		return str2;
	}

	public static String lastIndexSubstring(String s, String suffix) {
		if (s.endsWith(suffix)) {
			return s.substring(0, s.lastIndexOf(suffix));
		}
		return null;
	}

	public static boolean isEmptyString(String s) {
		if (s.equals("") || s.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isNullCheck(String s) {
		if (s == null || s.equals("null") || s.equals("NULL") || s.equals("")) {
			return true;
		}
		return false;
	}

	public static String convertNullToBlank(String s) {
		return converNullToParticularCharater(s, "");
	}

	public static String converNullToParticularCharater(String text, String particularChar) {
		if (isNullCheck(text))
			return particularChar;
		else
			return text;
	}

	public static boolean isStringInSet(String needle, String... strSet) {
		if (needle == null) {
			return false;
		}
		for (String s : strSet) {
			if (s == null) {
				continue;
			}
			if (s.equals(needle)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isEqual(String str1, String str2) {
		return str1.toLowerCase().equals(str2.toLowerCase());
	}

	public static double sTod(String s, double r) {
		try {
			double l = Double.parseDouble(s);
			return l;
		} catch (NumberFormatException e){
			log.error(e.getMessage());
			return r;
		} catch (Exception e) {
			log.error(e.getMessage());
			return r;
		}
	}

	public static int sToi(String s, int r) {
		try {
			int l = Integer.parseInt(s);
			return l;
		} catch (NumberFormatException e){
			log.error(e.getMessage());
			return r;
		} catch (Exception e) {
			log.error(e.getMessage());
			return r;
		}
	}

	public static boolean sTob(String s, boolean r) {
		try {
			boolean b = Boolean.parseBoolean(s);
			return b;
		} catch (NumberFormatException e){
			log.error(e.getMessage());
			return r;
		} catch (Exception e) {
			log.error(e.getMessage());
			return r;
		}
	}

	public static String replace(String str,
			HashMap<String, String> replacements) {
		Set<String> keys = replacements.keySet();

		for (String key : keys) {
			str = str.replaceAll("\\[\\$" + key + "\\$\\]", replacements
					.get(key));
		}
		return str;
	}

	public static String getSQLIN(int size) {
		String whereIN = "";
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				whereIN = "?";
			} else {
				whereIN += ",?";
			}
		}
		return "(" + whereIN + ")";
	}


	public static String decimalFormat(double d, String format) {
		DecimalFormat decimalFormat = new DecimalFormat(format);
		return decimalFormat.format(d).toString();
	}

	public static String convertBrackets(String str) {
		str = convertNullToBlank(str);
		if (str.matches("<(?:.|\\s)*?>")) {
			str = str.replace("<", "&lt;");
			str = str.replace(">", "&gt;");
		}
		return str;
	}

	public static String omitString(String str, int omitSize) {
		if (isNullCheck(str)) {
			return "";
		}
		int charAt = 0;
		double realCnt = 0;
		int i;

		for (i = 0; realCnt < omitSize; i++) {
			if(i >= str.length()){
				return str.substring(0, i);				
			}
			charAt = str.charAt(i);
			if ((charAt >= 48 && charAt <= 57)
					|| (charAt >= 97 && charAt <= 122)) {
				realCnt += 0.5;
			} else if(charAt >= 65 && charAt <= 90){
				realCnt += 0.8;
			}
			else {
				realCnt += 1;
			}
		}
		return str.substring(0, i) + "...";
	}

	public static String[] getTokens(String line, String delimiter) {
		int count = 0;
		String str = line;
		int position = 0;

		while ((position = str.indexOf(delimiter)) != -1) {
			count++;
			str = str.substring(position + delimiter.length());
		}

		if (!"".equals(str)) {
			count++;
		}

		String[] return_val = new String[count];
		str = line;
		count = 0;
		while ((position = str.indexOf(delimiter)) != -1) {
			if (position != 0) {
				return_val[count++] = str.substring(0, position);
			} else {
				return_val[count++] = "";
			}

			str = str.substring(position + delimiter.length());
		}

		if (!"".equals(str)) {
			return_val[count] = str;
		}

		return return_val;
	}

	public static String toString(Object obj) {
		if (obj != null)
			return obj.toString();

		return "";
	}

	public static Object returnNull(String s) {
		if (s == "" || s.equalsIgnoreCase("null")) {
			return null;
		} else {
			return s;
		}
	}

	public static String convertList2String(List<String> list, String division) {

		StringBuilder param = new StringBuilder();

		for(String s: list) {
			param.append(division);
			param.append(s);	
		}

		if(param.length() > division.length()) {
			param.delete(0, division.length());
		}
		return param.toString();
	}

	// ex) byte '3'을 String "3"으로 변환
	public static String convertBytetoString(byte b) {
		return String.valueOf(b - (byte) '0');
	}

	// ex) String "3"을 byte '3'으로 변환
	public static byte convertStringtoByte(String str) {
		return (byte) ((byte) Byte.valueOf(str) + (byte) '0');
	}

	public static ListVO convertListToObject(List<?> object) throws DNPException {
		ListVO listVO = new ListVO();
		List<ResponseDataVO> list = new ArrayList<ResponseDataVO>();

		try {
			if (object != null) {
				Object obj = object.get(0);
				if (!(obj instanceof ResponseDataVO)) {
					throw new DNPException(9999, "[" + object + "] 해당 객체는 ResponseDataVO를 상속받지 않은 객체이므로 사용하실 수 없습니다.");
				}

				for(int i=0; i<object.size(); i++) {
					list.add((ResponseDataVO)object.get(i));
				}

				listVO.setDataList(list);
				listVO.setTotalCount(list.size());
			}
		} catch(IndexOutOfBoundsException e) {
			log.error(e.getMessage());
			listVO = new ListVO();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new DNPException(9999, "해당 객체는 ResponseDataVO를 상속받지 않은 객체이므로 사용하실 수 없습니다.");
		}

		return listVO;
	}

	public static String encodeUnicode(String str) {
		StringBuffer ostr = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			// 유니코드로 변환할 필요가 있는 문자열인지 판단 
			if ((ch >= 0x0020) && (ch <= 0x007e)) {
				ostr.append(ch); // 아닌 경우.
			} else { // 변경해야 하는 경우.
				ostr.append("\\u");
				String hex = Integer.toHexString(str.charAt(i) & 0xFFFF); // 문자의 Hex 값

				// 네 자리를 맞추기 위해 0 추가
				for (int j = 0; j < 4 - hex.length(); j++) {
					ostr.append("0");
				}

				ostr.append(hex.toLowerCase());
			}
		}

		return new String(ostr);
	}

	public static String decodeUnicode(String unicode){
		StringBuffer str = new StringBuffer();

		for(int i= unicode.indexOf("\\u") ; i > -1 ; i = unicode.indexOf("\\u")){
			str.append(unicode.substring(0, i));
			str.append(String.valueOf((char)Integer.parseInt(unicode.substring(i + 2, i + 6) ,16)));
			unicode = unicode.substring( i +6);
		}

		str.append(unicode);

		return str.toString();
	}

	/**
	 * <pre>
	 * date의 유효성을 판단한다.
	 * date가 'yyyy.MM.DD' 패턴인지 확인 하여 유효성을 검사한다.
	 * </pre>
	 * @param dateName 날짜형의 이름
	 * @param date 날짜 스트링
	 * @throws DNPException
	 */
	public static String validationDate(String dateName, String date) throws DNPException {
		int resultCode = ExceptionConst.VALIDATION_COMMON;
		String resultMessage = PropertyMessage.getCodeMessage(ExceptionConst.VALIDATION_COMMON);

		if ("".equals(date)) {
			resultCode = ExceptionConst.VALIDATION_DATE;
			resultMessage = PropertyMessage.getCodeMessage(ExceptionConst.VALIDATION_DATE
					, dateName, date);

			throw new DNPException(resultCode, resultMessage);
		} else if (date.split("\\.")[0].length() != 4) {
			resultCode = ExceptionConst.VALIDATION_DATE;
			resultMessage = PropertyMessage.getCodeMessage(ExceptionConst.VALIDATION_DATE);

			throw new DNPException(resultCode, resultMessage);
		} else if (date.split("\\.")[1].length() != 2) {
			resultCode = ExceptionConst.VALIDATION_DATE;
			resultMessage = PropertyMessage.getCodeMessage(ExceptionConst.VALIDATION_DATE);

			throw new DNPException(resultCode, resultMessage);
		} else if (date.split("\\.")[2].length() != 2) {
			resultCode = ExceptionConst.VALIDATION_DATE;
			resultMessage = PropertyMessage.getCodeMessage(ExceptionConst.VALIDATION_DATE);

			throw new DNPException(resultCode, resultMessage);
		}

		return date;
	}

//	public static native void dosdir();
//	public static native void dosecho(byte[] ret);
//	static {
//		Native.register("/jnidll.dll");
//	}
/*
	public interface CInterface extends Library {
		public static class Data extends Structure {
			public static class ByValue extends Data implements Structure.ByValue {}
			public static class ByReference extends Data implements Structure.ByReference {};

			public int t;
			public byte[] mid = new byte[11];
			public short a;
			@Override
			protected List<String> getFieldOrder() {
				return Arrays.asList(new String[] {"t", "mid", "a"});
			}
		}
		public Data.ByValue getData();
	}

	public static void main(String[] args) throws Exception {
		final CInterface ci = (CInterface)Native.loadLibrary("jni", CInterface.class);
		final CInterface.Data.ByValue data = ci.getData();
//		System.setProperty("java.class.path", value);
		System.out.println("[java]" + data.t + ", " + data.a);
		System.out.println("[java]" + new String(data.mid, Charset.forName("UTF-8")));
	}
*/
}