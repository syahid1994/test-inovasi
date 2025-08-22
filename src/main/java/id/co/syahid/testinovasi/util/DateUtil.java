package id.co.syahid.testinovasi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	static String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	static String yyyyMMdd = "yyyy-MM-dd";
	
	public static Date fullDate(String strDate) throws ParseException {
		return new SimpleDateFormat(yyyyMMddHHmmss).parse(strDate);
	}
	
	public static String fullDate(Date date) throws ParseException {
		return new SimpleDateFormat(yyyyMMddHHmmss).format(date);
	}
}
