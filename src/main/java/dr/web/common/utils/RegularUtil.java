package dr.web.common.utils;

public class RegularUtil {
	//电话号码正则
	public static String TELEPHONE = "(13\\d|14[57]|15[^4,\\D]|17[678]|18\\d)\\d{8}|170[059]\\d{7}";
	
	//密码正则，区分大小写
	public static String PWD = "^[0-9a-zA-Z]{1,16}$";
}
