package dr.web.account.service.impl;

import dr.web.account.service.AccountService;
import dr.web.account.service.TicketService;
import dr.web.common.base.InterfaceServiceImpl;
import dr.web.common.dao.DaoMethod;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 * @包名 :dr.web.account.service.impl
 * @文件名 :AccountServiceImpl.java TODO 类作用：
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月29日 下午8:52:25
 * @版本号 :v0.0.01
 */
@Service(value = "ticketServiceI")
public class TicketServiceImpl extends InterfaceServiceImpl<Map<String, Object>> implements TicketService {

	public static final String nameSpace = "ticket";

	@Override
	public String getNamespace() {
		// TODO Auto-generated method stub
		return nameSpace;
	}

	/**
	 * 
	 * TODO 方法作用：获取最后登录时间与地址
	 * 
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年3月29日 下午9:08:49
	 */
	@Override
	public Map<String, Object> findById(Map<String, Object> user) {
		return dao.findById(nameSpace, DaoMethod.FIND_BYID, user);
	}
}
