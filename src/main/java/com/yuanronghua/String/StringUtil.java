package com.yuanronghua.String;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Some methods of processing String
 * 
 * @author wb-yuanronghua
 *
 */
public class StringUtil {
	/**
	 * <h1>CASE_SENSITIVE</h1> </code>不区分大小写 匹配<code>
	 */
	public final static String CASE_INSENSITIVE = "CASE_INSENSITIVE";
	/**
	 * <h1>CASE_SENSITIVE</h1> </code>区分大小写匹配<code>
	 */
	public final static String CASE_SENSITIVE = "CASE_SENSITIVE";

	/**
	 * 在匹配字符串加前�??后缀
	 * 
	 * @param sourceString
	 * @param replaceString
	 * @param prefixString
	 * @param suffixString
	 * @param CASE_SENSITIVE
	 *            (<code>StringUtil.CASE_INSENSITIVE 不区分大小写;</code>
	 *            <code>StringUtil.CASE_SENSITIVE 区分大小写/code>)
	 * @return String
	 */
	public static String replaceConTent(String sourceString,
			String replaceString, String prefixString, String suffixString,
			String CASE_SENSITIVE) {
		StringBuffer conTent = new StringBuffer();
		Map<String, String> muli = new HashMap<String, String>();

		if (CASE_SENSITIVE.equals(CASE_INSENSITIVE)) {
			Matcher mather = Pattern.compile(replaceString,
					Pattern.CASE_INSENSITIVE).matcher(sourceString);
			while (mather.find()) {
				String matherString = mather.group();
				if (muli.get(matherString) == null) {
					muli.put(matherString, matherString);
					conTent = new StringBuffer();
					conTent.append(prefixString).append(matherString)
							.append(suffixString);
					sourceString = sourceString.replaceAll(matherString,
							conTent.toString());
				}
			}
			return sourceString;
		} else {
			conTent.append(prefixString).append(replaceString)
					.append(suffixString);
			return sourceString.replaceAll(replaceString, conTent.toString());
		}
	}
}
