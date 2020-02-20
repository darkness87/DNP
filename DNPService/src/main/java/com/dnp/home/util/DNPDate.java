package com.dnp.home.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @DESC
 * Date클래스를 상속받아서 Date관련된 처리를 수행하도록 만든 클래스
 *
 * Calendar.getInstance() 덕분에 block생기는 문제를 패치함.
 * 원리 : TimeZone과 Locale을 미리 구해 놓는다. 그리고 GregorianCalendar를 TimeZone과 Locale을 넘겨서 생성한다.
 * @author pblee@cnuglobal.com
 */

public class DNPDate extends Date implements Serializable {

	final static Logger logger = LogManager.getLogger(DNPDate.class);
	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_DATE_1969 = "1969.12.31";
	public static final String DEFAULT_DATE_1970 = "1970.01.01";

	public static final int DATE_TYPE = 1;
	public static final int TIME_TYPE = 2;
	public static final int FROM_MONTH_TYPE = 4;
	public static final int SECOND_TYPE = 5;

	public static final int SYSTEM = 0;
	public static final int USA = 1;
	public static final int KOR = 2;

	public static final int YEAR	= java.util.Calendar.YEAR;
	public static final int MONTH	= java.util.Calendar.MONTH;
	public static final int DATE	= java.util.Calendar.DATE;
	public static final int HOUR	= java.util.Calendar.HOUR;
	public static final int MINUTE	= java.util.Calendar.MINUTE;
	public static final int SECOND	= java.util.Calendar.SECOND;
	public static final int DAYS	= java.util.Calendar.DAY_OF_YEAR;

	//	출력 유형
	public static final int FORMAT_YYYYMMDD			= 0;
	public static final int FORMAT_YYYYMMDDHH24MISS	= 1;
	public static final int FORMAT_HOXPATTERN		= 2;
	public static final int FORMAT_YYMMDDHHMM		= 3;

	// 입력유형
	public static final int FIELD_TYPE_HDDATE_YYYYMMDD = 1;
	public static final int FIELD_TYPE_HDDATE_YYYYMMDDH24MI = 2;

	Calendar cal;

	int nHourOffset = 0;

	private static TimeZone timezone;
	private static Locale locale;
	// milisec 단위의 하루를 계산한 값
	// 24 * 60 * 60 * 1000
	public final static long	DAYMILISEC	= 86400000 ;

	static {
		timezone = TimeZone.getDefault();
		locale = Locale.getDefault();
	}

	public DNPDate() {
		cal = new GregorianCalendar(timezone, locale);
		cal.add(Calendar.HOUR, nHourOffset);
	}

	public DNPDate(long l) {
		cal = new GregorianCalendar(timezone, locale);
		cal.setTime(new Date(l + (long)nHourOffset * 60 * 60 * 1000));
	}

	public DNPDate(int nYear, int nMonth, int nDate, int nHrs, int nMin, int nSec)
	{
		cal = new GregorianCalendar(timezone, locale);
		cal.set(1900+nYear, nMonth, nDate, nHrs+nHourOffset, nMin, nSec);
	}

	public DNPDate(int nYear, int nMonth, int nDate, int nHrs, int nMin) {
		cal = new GregorianCalendar(timezone, locale);
		cal.set(1900+nYear, nMonth, nDate, nHrs + nHourOffset, nMin);
	}

	public DNPDate(int nYear, int nMonth, int nDate) {
		cal = new GregorianCalendar(timezone, locale);
		cal.set(1900 + nYear, nMonth, nDate, 0, 0, 0);
	}

	/**
	 * <pre>
	 * "07/04/1901 13:00 am"
	 * 과 같은 형태로 입력.
	 * "MM/DD/yyy HH:mm a"
	 * </pre>
	 * @param s
	 * @throws Exception
	 */
	public DNPDate(String s) throws Exception
	{
		cal = new GregorianCalendar(timezone, locale);
		//		cal.setTime(new Date(s));
		cal.setTime(DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.US).parse(s));
	}

	public void set(DNPDate date) {
		this.set(date.getTime()); //cal.set(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(),date.getSeconds());
	}

	public void set(long l) {
		cal.setTime(new Date(l + (long)nHourOffset * 60 * 60 * 1000));
	}

	public void set(int nYear, int nMonth, int nDate, int nHrs, int nMin, int nSec) {
		cal.set(1900 + nYear, nMonth, nDate, nHrs + nHourOffset, nMin, nSec);
	}

	public void set(int nYear, int nMonth, int nDate, int nHrs, int nMin) {
		cal.set(1900 + nYear, nMonth, nDate, nHrs + nHourOffset, nMin);
	}

	public void set(int nYear, int nMonth, int nDate) {
		cal.set(1900 + nYear, nMonth, nDate, 0, 0, 0);
	}

	public int getFullYear() {
		return ((int)cal.get(Calendar.YEAR));	
	}

	public int getYear() {
		return ((int)cal.get(Calendar.YEAR) - 1900);
	}

	public int getMonth() {
		return ((int)cal.get(Calendar.MONTH));
	}

	public int getDay() {
		return (((int)cal.get(Calendar.DAY_OF_WEEK) - 1));
	}

	public int getDays() {
		return ((int)cal.get(Calendar.DAY_OF_YEAR));
	}

	public int getDate() {
		return ((int)cal.get(Calendar.DATE));
	}

	public int getHours() {
		return ((int)cal.get(Calendar.HOUR_OF_DAY));
	}

	public int getMinutes() {
		return ((int)cal.get(Calendar.MINUTE));
	}

	public int getSeconds() {
		return ((int)cal.get(Calendar.SECOND));
	}

	public long getTime() {
		return (cal.getTime()).getTime();
	}

	public void setFullYear(int FullYear) {
		cal.set(Calendar.YEAR, FullYear);
	}

	public void setYear(int Year) {
		cal.set(Calendar.YEAR, 1900+Year);
	}

	public void setMonth(int Month) {
		cal.set(Calendar.MONTH, Month);
	}

	public void setDate(int Date) {
		cal.set(Calendar.DATE, Date);
	}

	public void setHours(int Hours) {
		cal.set(Calendar.HOUR_OF_DAY, Hours);
	}

	public void setMinutes(int Minute) {
		cal.set(Calendar.MINUTE, Minute);
	}

	public void setSeconds(int Second) {
		cal.set(Calendar.SECOND, Second);
	}

	public void setTime(long time) {
		cal.setTime(new Date(time));
	}

	public boolean after(DNPDate when) {
		return this.getTime() > when.getTime();
	}

	public boolean before(DNPDate when) {
		return this.getTime() < when.getTime();
	}

	public boolean equalDate(DNPDate when) {
		if(this.getYear() == when.getYear()
				&& this.getMonth() == when.getMonth()
				&& this.getDate() == when.getDate()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean equalDateTime(DNPDate when) {
		if (this.getYear() == when.getYear()
				&& this.getMonth() == when.getMonth()
				&& this.getDate() == when.getDate()
				&& this.getHours() == when.getHours()
				&& this.getMinutes() == when.getMinutes()) {
			return true;
		} else {
			return false;
		}
	}


	public String toSecString(int nType, int nFormat) {
		StringBuffer  sb = new StringBuffer(200);

		// 기본적으로 USA
		StringBuffer  tmp = new StringBuffer(200);
		String szDYear = ".";
		String szDMonth = ".";
		String szDDay = "";
		String szDHour = ":";
		String szDMinute = ":";
		String szDSecond = "";
		// 구분자 설정

		switch(nFormat) {
		/*
		case USA: szDYear = ".";
				  szDMonth = ".";
				  szDDay = "";
				  szDHour = ":";
				  szDMinute = ":";
				  szDSecond = "";
				  break;
		 */
		case KOR:
			szDYear = "년"; //EtcString.Year;
			szDMonth = "월"; //EtcString.Month;
			szDDay = "일"; //EtcString.Day;
			szDHour = "시"; //EtcString.Hour;
			szDMinute = "분"; //EtcString.Minute;
			szDSecond = "초"; //EtcString.Second;
			break;
		}
		switch(nType) {
		case DATE_TYPE :
			sb.append(Integer.toString(getYear() + 1900)).append(szDYear);//년
			tmp.append("0").append(Integer.toString(getMonth() + 1));
			sb.append((tmp.toString()).substring((tmp.toString()).length() - 2)).append(szDMonth);//월
			tmp.append("0").append(Integer.toString(getDate()));
			sb.append((tmp.toString()).substring((tmp.toString()).length() - 2)).append(szDDay);//일
			break;
		case TIME_TYPE :
			tmp.append("0").append(Integer.toString(getHours()));
			sb.append((tmp.toString()).substring((tmp.toString()).length() - 2)).append(szDHour);//시
			tmp.append("0").append(Integer.toString(getMinutes()));
			sb.append((tmp.toString()).substring((tmp.toString()).length() - 2));
			sb.append(szDMinute); //분
			sb.append(getSeconds());
			if (nFormat == KOR) {
				sb.append( szDSecond ); // 초
			}
			break;
		}
		return sb.toString();
	}

	public boolean isNull() {
		return toString().trim().equals("");
	}

	/**
	 * <pre>
	 * 1970년 이전년도 이면 true를 리턴한다.
	 * </pre>
	 * @return
	 * @since 2005. 12. 23.
	 * @author ziix
	 */
	public boolean isDefaultDate() {
		return this.getYear() <= 70;
	}

	public String toString( String format ) {
		// YYYY, MM, DD, HH24, MI, SS
		String	result = format;
		int	index = 0;

		if (result != null) {
			index = result.indexOf("YYYY");

			if (index != -1) {
				result = result.substring(0, index)+Integer.toString(getYear() + 1900) + result.substring(index + 4);
			}

			index = result.indexOf("YY");

			if (index != -1) {
				String tmp = Integer.toString(getYear() + 1900);
				result = result.substring(0, index) + tmp.substring(tmp.length() - 2) + result.substring(index + 2);
			}

			index = result.indexOf("MM");

			if (index != -1) {
				String	tmp = "0" + Integer.toString(getMonth()+1);
				result = result.substring(0, index) + tmp.substring(tmp.length()-2) + result.substring(index + 2);
			}

			index = result.indexOf("DD");

			if (index != -1) {
				String	tmp = "0" + Integer.toString(getDate());
				result = result.substring(0, index) + tmp.substring(tmp.length()-2) + result.substring(index + 2);
			}

			index = result.indexOf("D");

			if (index != -1) {
				result = result.substring(0, index) + Integer.toString(getDate()) + result.substring(index + 1);
			}

			index = result.indexOf("HH24");

			if (index != -1) {
				String	tmp = "0" + Integer.toString(getHours());
				result = result.substring(0, index) + tmp.substring(tmp.length() - 2) + result.substring(index + 4);
			}

			index = result.indexOf("MI");
			if (index != -1) {
				String	tmp = "0" + Integer.toString(getMinutes());
				result = result.substring(0, index) + tmp.substring(tmp.length() - 2) + result.substring(index + 2);
			}

			index = result.indexOf("M");

			if (index != -1) {
				result = result.substring(0, index) + Integer.toString(getMonth() + 1) + result.substring(index + 1);
			}

			index = result.indexOf("SS");

			if (index != -1) {
				String	tmp = "0" + Integer.toString(getSeconds());
				result = result.substring(0, index) + tmp.substring(tmp.length() - 2) + result.substring(index + 2);
			}

			index = result.indexOf("S");

			if (index != -1) {
				result = result.substring(0, index) + Integer.toString(getSeconds()) + result.substring(index + 1);
			}
		}
		return result;
	}

	public String toString(){
		return toString(DATE_TYPE + TIME_TYPE, USA, " ");
	}

	public String toString(int nType, int nFormat){
		return toString(nType, nFormat, " ");
	}

	public String toString(int nType, int nFormat, String SeperaterDateAndTime) {
		StringBuffer sb = new StringBuffer(200);

		// 기본적으로 USA
		StringBuffer tmp = new StringBuffer(200);
		String szDYear = ".";
		String szDMonth = ".";
		String szDDay = "";
		String szDHour = ":";
		String szDMinute = ":";
		String szDSecond = "";

		switch(nFormat) {
		case SYSTEM:
			szDYear = "";
			szDMonth = "";
			szDDay = "";
			szDHour = "";
			szDMinute = "";
			szDSecond = "";
			break;
		}

		switch (nType) {
		case FROM_MONTH_TYPE:// 4
			tmp.append("0").append(Integer.toString(getMonth() + 1));
			sb.append((tmp.toString()).substring((tmp.toString()).length() - 2)).append(szDMonth);
			tmp.append("0").append(Integer.toString(getDate()));
			sb.append((tmp.toString()).substring((tmp.toString()).length() - 2)).append(szDDay);
			break;
		case DATE_TYPE://
			sb.append(Integer.toString(getYear() + 1900)).append(szDYear); // 년
			tmp.append("0").append(Integer.toString(getMonth() + 1));
			sb.append((tmp.toString()).substring((tmp.toString()).length() - 2)).append(szDMonth); // 월
			tmp.append("0").append(Integer.toString(getDate()));
			sb.append((tmp.toString()).substring((tmp.toString()).length() - 2)).append(szDDay); // 일
			break;
		case TIME_TYPE: // 2
			tmp.append("0").append(Integer.toString(getHours()));
			sb.append((tmp.toString()).substring((tmp.toString()).length() - 2)).append(szDHour); // 시
			tmp.append("0").append(Integer.toString(getMinutes()));
			sb.append((tmp.toString()).substring((tmp.toString()).length() - 2)).append(szDMinute); // 분
			break;
		case SECOND_TYPE:// 5
			tmp.append("0").append(Integer.toString(getSeconds()));
			sb.append((tmp.toString()).substring((tmp.toString()).length() - 2)).append(szDSecond);// 초
			break;
		case FROM_MONTH_TYPE + TIME_TYPE: // 6
			sb.append(toString(FROM_MONTH_TYPE, nFormat)).append(SeperaterDateAndTime).append(toString(TIME_TYPE, nFormat));
		break;
		case DATE_TYPE + TIME_TYPE + SECOND_TYPE:// 8
			sb.append(toString(DATE_TYPE, nFormat))
			.append(SeperaterDateAndTime)
			.append(toString(TIME_TYPE, nFormat))
			.append(toString(SECOND_TYPE, nFormat));
		break;
		case FROM_MONTH_TYPE + TIME_TYPE + SECOND_TYPE:// 11
			sb.append(toString(FROM_MONTH_TYPE, nFormat))
			.append(SeperaterDateAndTime)
			.append(toString(TIME_TYPE, nFormat))
			.append(toString(SECOND_TYPE, nFormat));
		break;
		case DATE_TYPE + TIME_TYPE:// 3
		default:
			sb.append(toString(DATE_TYPE, nFormat)).append(SeperaterDateAndTime).append(toString(TIME_TYPE, nFormat));
		}

		if (sb.toString().indexOf(DEFAULT_DATE_1970 + " ") != -1
				|| sb.toString().indexOf(DEFAULT_DATE_1969 + " ") != -1) {
			return "";
		}

		return sb.toString();
	}

	public java.sql.Timestamp toSqlDate() {
		return toSqlTimestamp();
	}

	public java.sql.Timestamp toSqlTimestamp() {
		return new java.sql.Timestamp(getTime());	
	}

	public void add(int field, int amount) {
		cal.add(field, amount);
	}

	public String getString(int nFormat) {
		StringBuffer	sb = new StringBuffer();
		String			szTmp;

		switch (nFormat)
		{
		case FORMAT_YYYYMMDD:
			//	년
			sb.append(Integer.toString(getYear()+1900));
			//	월
			szTmp	= Integer.toString(getMonth()+1);

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp);
			//	일
			szTmp	= Integer.toString(getDate());

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp);

			return sb.toString();
		case FORMAT_HOXPATTERN:
			//  년
			sb.append((Integer.toString(getYear()+1900))).append("-");
			//  월
			szTmp = Integer.toString(getMonth()+1);

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp).append("-");
			//  일
			szTmp	= Integer.toString(getDate());

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp).append("T");
			//	시
			szTmp	= Integer.toString(getHours());

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp).append(":");
			//	분
			szTmp	= Integer.toString(getMinutes());

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp).append(":");
			//	초
			szTmp	= Integer.toString(getSeconds());

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp);

			return sb.toString();

		case FORMAT_YYMMDDHHMM:
			//	년
			sb.append(Integer.toString(getYear() + 1900).substring(2,4));
			//	월
			szTmp	= Integer.toString(getMonth() + 1);

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp);
			//	일
			szTmp	= Integer.toString(getDate());

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp);
			//	시
			szTmp	= Integer.toString(getHours());

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp);
			//	분
			szTmp	= Integer.toString(getMinutes());

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp);

			return sb.toString();

		case FORMAT_YYYYMMDDHH24MISS:
		default:
			//	년
			sb.append(Integer.toString(getYear()+1900));
			//	월
			szTmp	= Integer.toString(getMonth()+1);

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp);
			//	일
			szTmp	= Integer.toString(getDate());

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp);
			//	시
			szTmp	= Integer.toString(getHours());
			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp);
			//	분
			szTmp	= Integer.toString(getMinutes());

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp);
			//	초
			szTmp	= Integer.toString(getSeconds());

			if (szTmp.length() == 1) {
				sb.append("0");
			}

			sb.append(szTmp);

			return sb.toString();
		}
	}

	/**
	 * @DESC
	 * 입력된 날짜 문자열을 HDDate로 변환
	 * @param	szData	년.월.일
	 * @return	HDDate Object로
	 * @author
	 * @DB
	 */
	public static DNPDate ParseDate(String szDate) throws Exception {
		int nBegin = 0;
		int nEnd = 0;
		int nYear = 0;
		int nMonth = 0;
		int nDate = 0;

		try {
			nBegin = 0;
			nEnd = szDate.indexOf(".");
			nYear = Integer.parseInt(szDate.substring(nBegin, nEnd));
			nBegin = nEnd + ".".length();
			nEnd = szDate.indexOf(".", nBegin);
			nMonth = Integer.parseInt(szDate.substring(nBegin, nEnd));
			nBegin = nEnd + ".".length();
			nEnd = szDate.length();
			nDate = Integer.parseInt(szDate.substring(nBegin, nEnd));
		} catch (NumberFormatException e){
			logger.error(e.getMessage());
			return null;
		} catch(Exception e) {
			logger.error(e.getMessage());
			return null;
		}

		DNPDate date = new DNPDate((nYear - 1900), (nMonth - 1), nDate);
		return date;
	}

	/**
	 * @DESC
	 * 입력된 날짜 문자열을 HDDate로 변환
	 * @param	szData	년.월.일 시:분:초
	 * @return	HDDate Object로
	 * @author  Song, Dong Hyun
	 * @DB
	 */
	public static DNPDate ParseDateTime(String szDate) throws Exception {
		int nBegin = 0;
		int nEnd = 0;
		int nYear = 0;
		int nMonth = 0;
		int nDate = 0;
		int nHour = 0;
		int nMin = 0;
		int nSec = 0;
		try {
			nBegin = 0;
			nEnd = szDate.indexOf(".");
			nYear = Integer.parseInt(szDate.substring(nBegin, nEnd));
			nBegin = nEnd + ".".length();
			nEnd = szDate.indexOf(".", nBegin);
			nMonth = Integer.parseInt(szDate.substring(nBegin, nEnd));
			nBegin = nEnd + ".".length();
			nEnd = szDate.indexOf(" ", nBegin);
			nDate = Integer.parseInt(szDate.substring(nBegin, nEnd));

			nBegin = nEnd + " ".length();
			nEnd = szDate.indexOf(":", nBegin);
			nHour = Integer.parseInt(szDate.substring(nBegin, nEnd));

			nBegin = nEnd + ":".length();
			nEnd = szDate.indexOf(":", nBegin);
			nMin = Integer.parseInt(szDate.substring(nBegin, nEnd));

			nBegin = nEnd + ":".length();
			nEnd = szDate.length();
			nSec = Integer.parseInt(szDate.substring(nBegin, nEnd));
		} catch(NumberFormatException e){
			logger.error(e.getMessage());
			return null;
		} catch(Exception e) {
			logger.error(e.getMessage());
			return null;
		}
		DNPDate date = new DNPDate((nYear-1900), (nMonth-1), nDate, nHour, nMin, nSec);
		return date;
	}

	/**
	 * @DESC
	 * 입력된 날짜 문자열을 HDDate로 변환
	 * @param	szData	년월일 or 년월일시분
	 * @return	HDDate Object로
	 * @author  KHW
	 * @DB
	 */
	public static DNPDate getHDDateValue(String szValue, int nFormat) {
		DNPDate hdDate = new DNPDate(1970-1900, 0, 1);

		if ((nFormat == FIELD_TYPE_HDDATE_YYYYMMDDH24MI && szValue.length() == 12)
				|| (nFormat == FIELD_TYPE_HDDATE_YYYYMMDD && szValue.length() == 8)) {
			int[] nTimeElem = defaultTime(0, 0, 0);

			try	{
				nTimeElem[0] = Integer.parseInt(szValue.substring(0, 4));
				nTimeElem[1] = Integer.parseInt(szValue.substring(4, 6));
				nTimeElem[2] = Integer.parseInt(szValue.substring(6, 8));

				if (nFormat == FIELD_TYPE_HDDATE_YYYYMMDDH24MI) {
					nTimeElem[3] = Integer.parseInt(szValue.substring(8, 10));
					nTimeElem[4] = Integer.parseInt(szValue.substring(10, 12));
				}
			} catch(NumberFormatException e){
				logger.error(e.getMessage());
				nTimeElem[0] = 1970;
				nTimeElem[1] = 1;
				nTimeElem[2] = 1;
			} catch(Exception ex) {
				logger.error(ex.getMessage());
				nTimeElem[0] = 1970;
				nTimeElem[1] = 1;
				nTimeElem[2] = 1;
			}

			hdDate.set( nTimeElem[0] - 1900,
					nTimeElem[1] - 1,
					nTimeElem[2],
					nTimeElem[3],
					nTimeElem[4],
					nTimeElem[5]);
			nTimeElem  = null;
		}

		return hdDate;
	}

	protected static int[] defaultTime(int nHour, int nMin, int nSecond) {
		int[] defaultTimeSet = new int[6];

		defaultTimeSet[0] = 1970; 					// Year
		defaultTimeSet[1] = Calendar.JANUARY; 		// Month
		defaultTimeSet[2] = 1;						// Day 1
		defaultTimeSet[3] = nHour;					// Hour : 0 ~ 24 hr
		defaultTimeSet[4] = nMin;					// Minute
		defaultTimeSet[5] = nSecond;				// Second

		return 	defaultTimeSet;
	}

	/**
	 * @DESC
	 *	현재 날짜를 기준으로 하여, 몇일 전 날짜 혹은 몇일 이후 날짜를 얻는다.
	 *	nDiffDay가 -2를 가지면, 현재 날짜를 기준으로 하여 2일 전 날짜의 HDDate를 반환한다.
	 *	날짜만, 변경되며, 시간의 항목은 현재 날짜를 기준으로 반환된다.
	 * @param	nDiffDay	현재 날짜와의 차이 날짜
	 * @return	HDDate		nDiffDay의 차이를 계산한 HDDate
	 * @author	서국환
	 * @DB
	 **/
	public static DNPDate getNewDateFormCurrentTime(int nDiffDay) {
		return getNewDate(new DNPDate(), nDiffDay, -1 , -1 , -1 ) ;
	}

	/**
	 * @DESC
	 *	현재 날짜를 기준으로 하여, 몇일 전 날짜 혹은 몇일 이후 날짜를 얻는다.
	 *	nDiffDay가 -2를 가지면, 현재 날짜를 기준으로 하여 2일 전 날짜의 HDDate를 반환한다.
	 *	날짜는 nDiffDay에 의해서 구해지고, 해당 날짜의 시간과 분/초는 parameter에서 지정한 값으로 변경된다.
	 * @param	nDiffDay	현재 날짜와의 차이 날짜
	 * @param	nHour		원하는 시간
	 * @param	nMin		원하는 분
	 * @param	nSec		원하는 초
	 * @return	HDDate		nDiffDay의 차이를 계산한 HDDate
	 * @author	서국환
	 * @DB
	 **/
	public static DNPDate getNewDateFormCurrentTime(int nDiffDay, int nHour, int nMin, int nSec ) {
		return getNewDate(new DNPDate(), nDiffDay, nHour, nMin, nSec ) ;
	}

	/**
	 * @DESC
	 *	현재 날짜를 기준으로 하여, 몇일 전 날짜 혹은 몇일 이후 날짜를 얻는다.
	 *	nDiffDay가 -2를 가지면, 현재 날짜를 기준으로 하여 2일 전 날짜의 HDDate를 반환한다.
	 *	날짜는 nDiffDay에 의해서 구해지고, 해당 날짜의 시간과 분/초는 parameter에서 지정한 값으로 변경된다.
	 *	nHour 값이 -1 인, 경우에는 시간,분,초 값을 parameter에 의존하지 않고, 현재 시간을 기준으로 설정된다.
	 * @param	nDiffDay	현재 날짜와의 차이 날짜
	 * @param	nHour		원하는 시간
	 * @param	nMin		원하는 분
	 * @param	nSec		원하는 초
	 * @return	HDDate		nDiffDay의 차이를 계산한 HDDate
	 * @author	서국환
	 * @DB
	 **/
	private static DNPDate getNewDate (DNPDate hDate, int nDiffDay, int nHour, int nMin, int nSec )
	{
		long lCurrentTime = hDate.getTime() + DAYMILISEC * nDiffDay ;
		hDate.setTime ( lCurrentTime );
		DNPDate hFindDate = null ;

		if ( nHour == -1 ) {
			hFindDate = new DNPDate(hDate.getYear(), hDate.getMonth(), hDate.getDate(),
					hDate.getHours(), hDate.getMinutes(), hDate.getSeconds());
		} else {
			hFindDate = new DNPDate(hDate.getYear(), hDate.getMonth(), hDate.getDate(), nHour , nMin , nSec);
		}

		//		HDLog.printDebug ( "HDDate::getNewDate() , FindDate : " , hFindDate.toString() ) ;
		return hFindDate ;
	}

	public void setCapacity(int capacity) {
	}

	public int getCapacity() {
		return -1;
	}

	/**
	 * <pre>
	 * 9999.12.31 23:59:59
	 * </pre>
	 * @return
	 * @since 2005. 11. 16.
	 * @author ziix
	 */
	public DNPDate getMaxDate()
	{
		setYear(8099);
		setMonth(11);
		setDate(31);
		setHours(23);
		setMinutes(59);
		setSeconds(59);

		return this;
	}

	public static boolean validate(int year, int month, int day)
	{
		int monthDays [] = {31,28,31,30,31,30,31,31,30,31,30,31};

		if ((month < 1) || (month > 12)) {
			return false;
		}

		if ((month == 2) && isLeapYear(year)) {
			monthDays[1] = 29;
		}

		if ((day < 1) || (day > monthDays[month - 1])) {
			return false;
		}

		return true;
	}

	public static boolean isLeapYear(int year) {
		if ((year%4)==0) {
			if ((year%100)==0) {
				if ((year%400)==0) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

}