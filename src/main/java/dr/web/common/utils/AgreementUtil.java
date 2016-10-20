package dr.web.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dr.web.basis.bean.AgreementBean;
import dr.web.basis.service.BasisAgreementService;

/**
 * 
 * @包名 :dr.web.common.utils
 * @文件名 :AgreementUtil.java TODO 类作用：服务协议
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年4月13日 上午10:43:43
 * @版本号 :v0.0.01
 */
@Controller
@RequestMapping("agreement")
public class AgreementUtil {
	
	@Autowired
	BasisAgreementService basisAgreementService;

	/**
	 * 
	 * TODO 方法作用：根据id获取服务协议
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年4月13日 上午10:43:58
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/agreement/{id}")
	public String agreement(@PathVariable("id") String agreementId, Model model) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(AgreementBean.agreementId, agreementId);
		Map<String, Object> agreement = (Map<String, Object>) basisAgreementService.findById(param);
		model.addAttribute("txt", agreement.get(AgreementBean.agreementContent));
		return "common/agreement";
	}
}
