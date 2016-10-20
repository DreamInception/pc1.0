package dr.web.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.util.StringUtils;

/**
 * 
 * @包名 :dr.web.common.utils
 * @文件名 :DrStringUtil.java TODO 类作用：字符串处理工具
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年4月9日 下午1:57:56
 * @版本号 :v0.0.01
 */
public class DrStringUtil {

	public static final String UTF8 = "UTF-8";
	public static final Charset CHARSET_UTF8 = Charset.forName(UTF8);

	/**
	 * 每位允许的字符
	 */
	private static final String POSSIBLE_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };

	public static final String random(int length) {
		char[] rs = new char[length];
		for (int i = 0; i < rs.length; i++) {
			rs[i] = hexDigits[(int) (Math.random() * 16)];
		}
		return new String(rs).toLowerCase();
	}

	private static String toHex(byte[] bs) {
		int j = bs.length;
		char rs[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++) {
			byte byte0 = bs[i];
			rs[k++] = hexDigits[byte0 >>> 4 & 0xf];
			rs[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(rs);
	}

	public final static String md5(byte[] bs) {
		try {
			MessageDigest o = MessageDigest.getInstance("MD5");
			o.update(bs);
			byte[] r = o.digest();
			return toHex(r);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public final static String sha1(byte[] bs) {
		try {
			MessageDigest o = MessageDigest.getInstance("SHA1");
			o.update(bs);
			byte[] r = o.digest();
			return toHex(r);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 处理要保护的数字
	 *
	 * @param number
	 *            需要处理的数字
	 * @param prefixIndex
	 *            从前数第几个开始保护 从1开始
	 * @param suffixIndex
	 *            从后数第几个开始保护
	 * @return
	 */
	public static String procHideNum(String number, int prefixIndex, int suffixIndex) {
		if (StringUtils.hasText(number)) {
			char[] cs = number.toCharArray();
			StringBuilder b = new StringBuilder();
			for (int i = 0; i < cs.length; i++) {
				if ((i >= 0 && i <= prefixIndex - 1) || (i >= cs.length - suffixIndex && i <= cs.length - 1)) {
					b.append(cs[i]);
				} else {
					b.append("*");
				}
			}
			number = b.toString();
		}
		return number;
	}

	/**
	 * 生产一个指定长度的随机字符串
	 *
	 * @param length
	 *            字符串长度
	 * @return
	 */
	public static String generateRandomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < length; i++) {
			sb.append(POSSIBLE_CHARS.charAt(random.nextInt(POSSIBLE_CHARS.length())));
		}
		return sb.toString();
	}

	// GENERAL_PUNCTUATION 判断中文的“号
	// CJK_SYMBOLS_AND_PUNCTUATION 判断中文的。号
	// HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，号
	private static final boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
	}

	public static final boolean isChinese(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isChinese(c)) {
				return true;
			}
		}
		return false;
	}

	public static final boolean isChineseCharacter(String chineseStr) {
		char[] charArray = chineseStr.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if ((charArray[i] >= 0x4e00) && (charArray[i] <= 0x9fbb)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @deprecated; 弃用。和方法isChineseCharacter比效率太低。
	 */
	public static final boolean isChineseCharacter_f2() {
		String str = "！？";
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i + 1).matches("[\\u4e00-\\u9fbb]+")) {
				return true;
			}
		}
		return false;
	}

	public static final int generateRandomInt(int start, int end) {
		Random random = new Random();
		return random.nextInt(end) % (end - start + 1) + start;
	}

	/**
	 * 获取输入流的MD5
	 *
	 * @param is
	 * @return
	 */
	public static final String getMD5Checksum(InputStream is) {
		byte[] b = new byte[0];
		try {
			b = createChecksum(is);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < b.length; i++) {
				result.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));// 加0x100是因为有的b[i]的十六进制只有1位
			}
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static byte[] createChecksum(InputStream is) throws IOException {
		byte[] buffer = new byte[1024];
		MessageDigest complete = null; // 如果想使用SHA-1或SHA-256，则传入SHA-1,SHA-256
		try {
			complete = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		int numRead;
		do {
			numRead = is.read(buffer); // 从文件读到buffer，最多装满buffer
			if (numRead > 0) {
				complete.update(buffer, 0, numRead); // 用读到的字节进行MD5的计算，第二个参数是偏移量
			}
		} while (numRead != -1);

		// is.close();
		return complete.digest();
	}

	/**
	 * 获取输入流的MD5
	 *
	 * @return
	 */
	public static final String getMD5Checksum(byte[] bytes) {
		try {
			byte[] b = createChecksum(bytes);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < b.length; i++) {
				result.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));// 加0x100是因为有的b[i]的十六进制只有1位
			}
			return result.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static byte[] createChecksum(byte[] bytes) throws IOException {
		MessageDigest complete = null; // 如果想使用SHA-1或SHA-256，则传入SHA-1,SHA-256
		try {
			complete = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		complete.update(bytes); // 用读到的字节进行MD5的计算

		return complete.digest();
	}

	/**
	 * 判断是否为空
	 * 
	 * @param str
	 * @return 空返回true, 反之返回false
	 */
	public static boolean isNull(String str) {
		return (str != null && !str.trim().equals("") && !str.trim().equals("null")) ? false : true;
	}

	/**
	 * 判断是否为空
	 * 
	 * @param obj
	 * @return 空返回true, 反之返回false
	 */
	public static boolean isObjNull(Object obj) {
		return (obj != null && !"".equals(obj)) ? false : true;
	}

	/**
	 * 把tab空白换成空格
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceAllByTab(String str) {
		return str.replaceAll("	", " ");
	}

	/**
	 * 把"-"空白换成""
	 * 
	 * @param DateStr
	 *            日期格式的字符串
	 * @return
	 */
	public static String replaceAllByDateStr(String DateStr) {
		return DateStr.replaceAll("-", "");
	}

	/**
	 * 验证参数是否有空值
	 * 
	 * @param params
	 * @return 有一个值为空则返回true,反之返回false
	 */
	public static boolean paramVerify(String... params) {
		if (params == null) {
			return true;
		}
		for (String value : params) {
			if (value == null || value.equals("")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 验证参数是否有空值
	 * 
	 * @param obj
	 * @return 有一个值为空则返回true,反之返回false
	 */
	public static boolean ObjectParamVerify(Object... obj) {
		if (obj == null) {
			return true;
		}
		for (Object value : obj) {
			if (value == null || value.equals("")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * TODO 方法作用：格式化数字格式(保留小数点后两位，不进行四舍五入)
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月15日 上午11:37:58
	 */
	public static String formatNumber(Double number) {
		DecimalFormat formater = new DecimalFormat("#0.00");
		String num = formater.format(number);
		return num;
	}
}
