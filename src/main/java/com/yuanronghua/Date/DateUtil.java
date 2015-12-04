package com.yuanronghua.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Some methods of processing time
 * 
 * @author wb-yuanronghua
 *
 */
public class DateUtil {
	/**
	 * <h1>pattern</h1> </code>yyyy-MM-dd HH:mm:ss.SSS<code>
	 */
	public static SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss.SSS");

	/**
	 * <h1>pattern</h1> </code>yyyy-MM-dd'T'HH:mm:ss.SSS'Z'<code>
	 */
	public static SimpleDateFormat formatUTC = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	/**
	 * 
	 * @param UTCDateString
	 *            (yyyy-MM-dd'T'HH:mm:ss.SSS'Z')
	 * @return String GMT8DateString(yyyy-MM-dd HH:mm:ss.SSS)
	 */
	public static String getDateFromUTCToGMT8(String UTCDateString) {

		Date date = new Date();
		try {
			date = formatUTC.parse(UTCDateString);
		} catch (ParseException e) {
			// Don't need deal ParseException;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, 8);
		return format.format(calendar.getTime());
	};

	/**
	 * 
	 * @param GMT8DateString
	 *            (yyyy-MM-dd HH:mm:ss.SSS)
	 * @return String UTCDateString(yyyy-MM-dd'T'HH:mm:ss.SSS'Z')
	 */
	public static String getDateFromGMT8ToUTC(String GMT8DateString) {

		Date date = new Date();
		try {
			date = format.parse(GMT8DateString);
		} catch (ParseException e) {
			// Don't need deal ParseException;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, -8);
		return formatUTC.format(calendar.getTime());
	};

}
