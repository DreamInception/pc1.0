package dr.web.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 
 * @包名 :dr.web.common.constant
 * @文件名 :InterfaceConstant.java 
 * TODO 类作用：
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年4月22日 下午6:20:51
 * @版本号   :v1.0.0-16010415
 */
@Configuration
@PropertySource("classpath:prop/settings.properties")
public class InterfaceConstant {

	// PC接口本地环境
	@Value("${ip}")
	private String ip;

	// 加息券列表正式环境
	@Value("${ticket_list}")
	private String ticket_list;
	
	//淘宝Ip查询接口
	public static String sinaIpInterface = "http://ip.taobao.com/service/getIpInfo.php";

	// 远程接口常量
	/**
	 * 用户手机号码登录时检查是否允许登录
	 */
	public static String loginCheckForPhone = "loginCheckForPhone";

	/**
	 * 发送手机短信验证码
	 */
	public static String smsCaptchaSend = "smsCaptchaSend";

	/**
	 * 设置用户手机号码
	 */
	public static String setPhone = "setPhone";

	/**
	 * 设置用户登录密码或交易密码
	 */
	public static String setPwd = "setPwd";

	/**
	 * 校验登录密码或交易密码
	 */
	public static String checkPwd = "checkPwd";

	/**
	 * 向某手机号码发送验证码
	 */
	public static String smsCaptchaVerify = "smsCaptchaVerify";

	/**
	 * 用户手机注册时创建新用户
	 */
	public static String createUserByPhone = "createUserByPhone";

	/**
	 * 账户数据
	 */
	public static String account = "account";

	/**
	 * 绑定银行卡
	 */
	public static String bindBankCard = "bindBankCard";

	/**
	 * 验证绑卡验证短信
	 */
	public static String bindBankCardVerify = "bindBankCardVerify";

	/**
	 * 实名验证, 判断用户提供的身份证号码和姓名是否相符
	 */
	public static String verifyRealName = "verifyRealName";

	/**
	 * 提现
	 */
	public static String withdraw = "withdraw";

	/**
	 * 解绑银行卡
	 */
	public static String unbindBankCard = "unbindBankCard";

	/**
	 * 购买产品
	 */
	public static String order = "order";

	/**
	 * 充值
	 */
	public static String deposit = "deposit";

	/**
	 * 充值短信验证
	 */
	public static String depositVerify = "depositVerify";

	/**
	 * 产品列表
	 */
	public static String products = "products";

	/**
	 * 资产列表
	 */
	public static String assets = "assets";
	
	public static String getDepositUrl = "getDepositUrl";

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTicket_list() {
		return ticket_list;
	}

	public void setTicket_list(String ticket_list) {
		this.ticket_list = ticket_list;
	}

}
