package com.dnp.home.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@SuppressWarnings({"rawtypes", "unchecked"})
public class DumpPublisher implements Serializable {
	final static Logger logger = LogManager.getLogger(DumpPublisher.class);
	private static final long serialVersionUID = 1L;
	static final String STR_NULL = "__NULL__";
	
	public static String dumpParameterForIBatis(Object param) {
		StringBuffer result = new StringBuffer();

		if (param != null) {
			if (param instanceof HashMap) {
				HashMap map = (HashMap) param;
				Iterator keySetIter = map.keySet().iterator();
				Object key = null;
				while (keySetIter.hasNext()) {
					key = keySetIter.next();
					result.append("Key [").append(key.toString()).append("]\t: Value [").append(map.get(key)).append("]\n");
				}
			} else if (param instanceof ArrayList) {
				ArrayList list = (ArrayList) param;
				for (int i = 0, iEnd = list.size(); i < iEnd; i++) {
					result.append("index [").append(i).append("]\t: Value [").append(list.get(i)).append("]\n");
				}
			} else {
				result.append("param : Value [").append(dumpToString(param)).append("]\n");
			}
		}
		
		return result.toString();
	}
	
	public static void dump(Object obj) {
		StringBuilder sbDump = new StringBuilder(200);
		getDumpToBuf(sbDump, obj);
		logger.debug(sbDump.toString());
	}
	
	public static String dumpToString(Object obj) {
		StringBuilder sbDump = new StringBuilder(200);
		getDumpToBuf(sbDump, obj);
		return sbDump.toString();
	}
	
	public static <E> String dumpFromListToString(List<E> list) {
		StringBuilder result = new StringBuilder();
		int index = 0;
		for (Object obj : list) {
			result.append("[" + index++ + "] = ").append(getDumpToString(obj)).append("\n");
		}
		return result.toString();
	}
	
	public static void getDumpToBuf(StringBuilder sbDump, Object obj) {	
		if (null == sbDump) return;
		sbDump.append(getDumpToString(obj));
	}

	private static String getDumpToString(Object obj) {
		StringBuilder sbDump = new StringBuilder();
		
		if (null == obj) {
			sbDump.append("[DumpPublisher.getDumpToBuf] Given Object is NULL Object");
			return "";	
		}

		Class fieldType = null;
		Class dumpableClass = obj.getClass();
		Field[] fields = dumpableClass.getDeclaredFields(); //getFields(); // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
		int nNumField = fields.length;

		sbDump.append("Class(").append(dumpableClass.getName()).append(")\n");

		try {
			Object field = null;
			for(int i = 0; i < nNumField; i++) {
				fields[i].setAccessible(true); // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
				fieldType = fields[i].getType(); // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED

				if (fieldType == byte.class) {
					byte[] b = new byte[1]; 
					b[0] = fields[i].getByte(obj);
					sbDump.append(fields[i].getName()) // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
						  .append("\t[")
						  .append(new String(b)) // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
						  .append("]\n");
				} else if (fieldType == char.class) {
					sbDump.append(fields[i].getName()) // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
						  .append("\t[")
						  .append(fields[i].getChar(obj)) // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
						  .append("]\n");
				} else if (fieldType == short.class) {
					String fieldName = fields[i].getName(); // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
					if(!fieldName.startsWith("CID")) {
						sbDump.append(fieldName)
							  .append("\t[")
							  .append(fields[i].getShort(obj)) // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
							  .append("]\n");
					}
				} else if (fieldType == int.class) {
					String fieldName = fields[i].getName(); // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
					if (!fieldName.startsWith("CID")) {
						ArrayList arrHex = new ArrayList();
						arrHex.add("ulApprovalType");
						arrHex.add("ulApprovalStatus");

						if (arrHex.contains(fieldName)) {
							String hex = Integer.toHexString(fields[i].getInt(obj));
							sbDump.append(fields[i].getName()) // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
								  .append("\t[HEX:")
								  .append("0x");
							for(int j = 0; j < (8-hex.length()); j++)
								sbDump.append("0");
							sbDump.append(hex)
								  .append("]\n");
						} else {
							sbDump.append(fields[i].getName()) // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
								  .append("\t[")
								  .append(fields[i].getInt(obj)) // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
								  .append("]\n");
						}
					}
				} else if (fieldType == String.class) {
					field = fields[i].get(obj); // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
					sbDump.append(fields[i].getName()).append("\t["); // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
					if (field != null) {
						sbDump.append((String) field);
					} else {
						sbDump.append(STR_NULL);
					}
					sbDump.append("]\n");
				} else if(fieldType == Date.class) {
					field = fields[i].get(obj); // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
					sbDump.append(fields[i].getName()).append("\t["); // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
					if (field != null) {
						sbDump.append(((Date) field).toString());
					} else {
						sbDump.append(STR_NULL);
					}
					sbDump.append("]\n");
				} else if (fieldType == HashMap.class) {
					field = fields[i].get(obj); // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
					sbDump.append(fields[i].getName()).append("\t["); // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
					if (field != null) {
						sbDump.append(dumpMap((HashMap) field));
					} else {
						sbDump.append(STR_NULL);
					}
					sbDump.append("]\n");
				} else if (fieldType == boolean.class) {
					sbDump.append(fields[i].getName()).append("\t[").append(fields[i].getBoolean(obj)).append("]\n"); // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
				}
//				else if (fieldType == OrgID.class) {
//					field = fields[i].get(obj); // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
//					sbDump.append(fields[i].getName()).append("\t["); // parasoft-suppress SECURITY.WSC.APIBS "trusted code"  //FIXED
//					if (field != null) {
//						sbDump.append(((OrgID) field).getID());
//					} else {
//						sbDump.append(STR_NULL);
//					}
//					sbDump.append("]\n");
//				}
			}
		} catch(NullPointerException e){
			logger.error(e.getMessage());
			return "";
		} catch(Exception ex) {
			logger.error(ex.getMessage());
			return "";
		}
		
		return sbDump.toString();
	}
	
	public static String dumpMap(Map map)	{
		StringBuffer sbDump = new StringBuffer(200);
		if (null != map) {
			Iterator keySetIter = map.keySet().iterator();
			while (keySetIter.hasNext()) {
				Object key = keySetIter.next();
				sbDump.append("Key [")
					  .append(key.toString())
					  .append("]\t: Value [")
					  .append(map.get(key))
					  .append("]\n");
			}
		} else {
			sbDump.append(STR_NULL);
		}
		return sbDump.toString();
//		System.out.println(sbDump.toString());
	}
}