/*************************************************************************
 * @system name：  :上海景源金服PC端
 * @Author: 陈吉秋特 604969793@qq.com
 * @Date: 2016年5月4日 下午4:53:38
 * @(c) Copyright 上海景源金融信息服务有限公司
**************************************************************************/

package unit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import dr.web.basis.bean.UserBean;
import dr.web.basis.bean.User_recommendBean;
import dr.web.basis.bean.User_sourceBean;
import dr.web.basis.service.BasisUserService;
import dr.web.basis.service.BasisUser_recommendService;
import dr.web.basis.service.BasisUser_sourceService;
import dr.web.common.utils.DateUtil;
import dr.web.common.utils.DrStringUtil;

/**
 * @包名 :java
 * @文件名 :TestAccess.java TODO 类作用：
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年5月4日 下午4:53:38
 * @版本号 :v2.0.0-16010508
 */
public class TestAccess {

	@Autowired
	BasisUser_sourceService basisUser_sourceService;
	@Autowired
	BasisUserService basisUserService;
	@Autowired
	BasisUser_recommendService basisUser_recommendService;
	
	/**
	 * 
	 * TODO 方法作用：测试注册
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月4日 下午5:13:26
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAccess() {
		String source = "tiyan";
		String recommend = "13818683654";
		if (!StringUtils.hasText(source)) {
			source = "";
		}
		Map<String, Object> sourceMap = new HashMap<>();
		sourceMap.put(User_sourceBean.userId, 1);
		sourceMap.put(User_sourceBean.sourceFrom, source);
		sourceMap.put(User_sourceBean.clientFrom, "pc");
		basisUser_sourceService.save(sourceMap);
		// 推荐关系
		if (StringUtils.hasText(recommend)) {
			Map<String, Object> param = new HashMap<>();
			param.put(UserBean.userTelephone, recommend);
			List<Map<String, Object>> userList = (List<Map<String, Object>>) basisUserService.findAllList(param);
			param = userList.get(0);
			if (DrStringUtil.isNull(param.get(UserBean.userId).toString()) == false
					&& !recommend.equals(param.get(UserBean.userTelephone))) {
				Map<String, Object> user = new HashMap<String, Object>();
				user.put(User_recommendBean.userId, 1);
				user.put(User_recommendBean.recommendId, 5952);
				user.put(User_recommendBean.createdDt, DateUtil.nowDate("yyyy-MM-dd"));
				basisUser_recommendService.save(user);
			}
		}
		System.out.println("运行完毕");
	}
}
