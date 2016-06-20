/**
 * 
 */
package org.fd.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * <pre>
 * 字符串工具类。
 * </pre>
 * 
 * @author SaMa.Han guoqiang.han@foxmail.com
 * @version 1.00.00
 * 
 *          <pre>
 * 修改记录
 *    修改后版本:     修改人：  	修改日期:     修改内容:
 * </pre>
 */
public class StringUtil {

	public static final String[] EMPTY_STRING_ARRAY = new String[0];
	private static final Pattern INT_PATTERN = Pattern.compile("^\\d+$");
	private static final Pattern NUMBER_PATTERN = Pattern.compile("-?[0-9]+.?[0-9]+");
	public static final char UNDERLINE = '_';

	public static boolean isBlank(String str) {
		if (str == null || str.length() == 0)
			return true;
		return false;
	}

	/**
	 * 是否空字符串 is empty string.
	 * 
	 * @param str
	 *            source string.
	 * @return is empty.
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.length() == 0)
			return true;
		return false;
	}

	/**
	 * 是否是非空字符串 is not empty string.
	 * 
	 * @param str
	 *            source string.
	 * @return is not empty.
	 */
	public static boolean isNotEmpty(String str) {
		return str != null && str.length() > 0;
	}

	/**
	 * 两个字符串是否相等
	 * 
	 * @param s1
	 * @param s2
	 * @return equals
	 */
	public static boolean isEquals(String s1, String s2) {
		if (s1 == null && s2 == null)
			return true;
		if (s1 == null || s2 == null)
			return false;
		return s1.equals(s2);
	}

	/**
	 * 是否是数字类型（整数） is integer string.
	 * 
	 * @param str
	 * @return is integer
	 */
	public static boolean isInteger(String str) {
		if (str == null || str.length() == 0)
			return false;
		return INT_PATTERN.matcher(str).matches();
	}

	/**
	 * 是否是数字类型（整数，负数，小数点） is integer string.
	 * 
	 * @param str
	 * @return is integer
	 */
	public static boolean isNumber(String str) {
		if (str == null || str.length() == 0)
			return false;
		return NUMBER_PATTERN.matcher(str).matches();
	}

	public static int parseInteger(String str) {
		if (!isInteger(str))
			return 0;
		return Integer.parseInt(str);
	}

	/**
	 * 确定指定字符是否允许在Java标识符的第一个字符。 字符可以为Java标识符当且仅当下面的一个条件为真： isLetter(ch) 返回 true
	 * getType(ch) 返回 LETTER_NUMBER ch是一个货币符号(如“$”) ch是连接标点字符(如“_”)。
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isJavaIdentifier(String s) {
		if (isEmpty(s) || !Character.isJavaIdentifierStart(s.charAt(0))) {
			return false;
		}
		for (int i = 1; i < s.length(); i++) {
			if (!Character.isJavaIdentifierPart(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * values是否包含value
	 * 
	 * @param values
	 * @param value
	 * @return contains
	 */
	public static boolean isContains(String[] values, String value) {
		if (isNotEmpty(value) && values != null && values.length > 0) {
			for (String v : values) {
				if (value.equals(v)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 字符串是否由数字组成
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isDigit(str.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 将目标字符串中的某个字符更换为对应from下标的to字符串中的字符，没有则删除该字符
	 * 如 ：ABCDEFGHIGKLMN, 'BDHL', '123'
	 * 转换后：A1C2EFG3IGKMN
	 * 当TO参数比from参数长时，多出来的字符无效
	 * @param src
	 *            source string.
	 * @param from
	 *            src char table.
	 * @param to
	 *            target char table.
	 * @return String.
	 */
	public static String translat(String src, String from, String to) {
		if (isEmpty(src))
			return src;
		StringBuilder sb = null;
		int ix;
		char c;
		for (int i = 0, len = src.length(); i < len; i++) {
			c = src.charAt(i);
			ix = from.indexOf(c);
			if (ix == -1) {
				if (sb != null)
					sb.append(c);
			} else {
				if (sb == null) {
					sb = new StringBuilder(len);
					sb.append(src, 0, i);
				}
				if (ix < to.length())
					sb.append(to.charAt(ix));
			}
		}
		return sb == null ? src : sb.toString();
	}

	/**
	 * 将字符串分割成数组
	 * 
	 * @param ch
	 *            char.
	 * @return string array.
	 */
	public static String[] split(String str, char ch) {
		List<String> list = null;
		char c;
		int ix = 0, len = str.length();
		for (int i = 0; i < len; i++) {
			c = str.charAt(i);
			if (c == ch) {
				if (list == null)
					list = new ArrayList<String>();
				list.add(str.substring(ix, i));
				ix = i + 1;
			}
		}
		if (ix > 0)
			list.add(str.substring(ix));
		return list == null ? EMPTY_STRING_ARRAY : (String[]) list.toArray(EMPTY_STRING_ARRAY);
	}

	/**
	 * 连接字符串，将字符串数组转换为一个字符串
	 * 
	 * @param array
	 *            String array.
	 * @return String.
	 */
	public static String join(String[] array) {
		if (array.length == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (String s : array)
			sb.append(s);
		return sb.toString();
	}

	/**
	 * 连接字符串，将字符串数组转换为一个字符串，用split参数分割
	 * 
	 * @param array
	 *            String array.
	 * @param split
	 *            split
	 * @return String.
	 */
	public static String join(String[] array, char split) {
		if (array.length == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				sb.append(split);
			sb.append(array[i]);
		}
		return sb.toString();
	}

	/**
	 * 连接字符串，将字符串数组转换为一个字符串，用split参数分割
	 * 
	 * @param array
	 *            String array.
	 * @param split
	 *            split
	 * @return String.
	 */
	public static String join(String[] array, String split) {
		if (0 == array.length)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				sb.append(split);
			sb.append(array[i]);
		}
		return sb.toString();
	}

	/**
	 * 连接字符串，将字符串集合转换为一个字符串，用split参数分割
	 * 
	 * @param array
	 *            String array.
	 * @param split
	 *            split
	 * @return String.
	 */
	public static String join(Collection<String> coll, String split) {
		if (coll.isEmpty())
			return "";

		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (String s : coll) {
			if (isFirst)
				isFirst = false;
			else
				sb.append(split);
			sb.append(s);
		}
		return sb.toString();
	}
	
	/**
	 * 将骆驼命名的参数转换为分小写并以split分割
	 * 如:aaaBbbCcc 以下划线转换后 aaa_bbb_ccc
	 * @param camelName
	 * @param split
	 * @return
	 */
	public static String camelToSplitName(String camelName, String split) {
		if (camelName == null || camelName.length() == 0) {
			return camelName;
		}
		StringBuilder buf = null;
		for (int i = 0; i < camelName.length(); i++) {
			char ch = camelName.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				if (buf == null) {
					buf = new StringBuilder();
					if (i > 0) {
						buf.append(camelName.substring(0, i));
					}
				}
				if (i > 0) {
					buf.append(split);
				}
				buf.append(Character.toLowerCase(ch));
			} else if (buf != null) {
				buf.append(ch);
			}
		}
		return buf == null ? camelName : buf.toString();
	}
	
	/**
	 * 将以下划线连接的字符串转换为骆驼命名
	 * 如aa_bb_cc 转换后 aaBbCc
	 * @param param
	 * @return
	 */
	public static String underlineToCamel(String param) {
		if (isEmpty(param)) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (c == UNDERLINE) {
				if (++i < len) {
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 将以下划线连接的字符串转换为骆驼命名
	 * 如aa_bb_cc 转换后 aaBbCc
	 * @param param
	 * @return
	 */
	public static String underlineToCamelSub(String param) {
		if (isEmpty(param)) {
			return "";
		}
		StringBuilder sb = new StringBuilder(param);
		Matcher mc = Pattern.compile("_").matcher(param);
		int i = 0;
		while (mc.find()) {
			int position = mc.end() - (i++);
			// String.valueOf(Character.toUpperCase(sb.charAt(position)));
			sb.replace(position - 1, position + 1, sb.substring(position, position + 1).toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 对数组字符串中的元素作为key，判断是否匹配，如aafff是否匹配aa*,bb*
	 * @param arrKeys
	 * @param strParam
	 * @return
	 */
	public static int getIndexByKeys(String strKeys,String strParam) {
		int intIndex =-1;
		if( strKeys==null || "".equals(strKeys) ){
			return -1;
		}
		String[] arrKeys =strKeys.split(",");
		for(String strTemp : arrKeys){
			int intIndexNew =strParam.indexOf(strTemp);
			
			if( intIndexNew>intIndex ){
				intIndex =intIndexNew;
			}
		}
		return intIndex;
	}
	
	/**
	 * 获取随机机键值
	 * @param charLength 随机字母长数
	 * @return 格式：时间+随机字母
	 */
	public static String getRandomKey(Integer charLength){
		if(null == charLength || 3 > charLength){
			return null;
		}
		Long time = new Date().getTime();
		String chars = "abcdefghijklmnopqrstuvwxyz";
		chars += chars.toUpperCase();
		String randomKey = time.toString();
		for (int i = 0; i < charLength; i++) {
			randomKey += chars.charAt(new Random().nextInt(52));
		}
		return randomKey;
	}

	private StringUtil() {
	}
	
	public static void main(String[] args){
		
		System.out.println(StringUtil.underlineToCamelSub("aa_bab_cbcc_ded"));
		System.out.println(StringUtil.getIndexByKeys("aa,bb", "bbfff"));
	}
}
