/**
 *	包名:	dr.web.basis.controller
 *	文件名:	LoginController.java
 *	描述:	登录相关操作
 *	创建人:	陈吉秋特
 *	创建时间:	2016-3-16下午5:00:00
 *	版权:	2016 xx版权所有
 */
package dr.web.basis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dr.web.basis.service.BasisBankService;
import dr.web.common.base.BaseController;
import dr.web.common.bean.Json;


/**
 * 
 * @包名 :dr.web.basis.controller
 * @文件名 :BasisBankController.java
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2015-3-28下午2:08:37
 * @版本号 :v0.0.01
 */
@Controller
@RequestMapping(value = "/basisBank")
public class BasisBankController extends BaseController {
	
	@Autowired
	BasisBankService basisBankService;

	/**
	 * TODO 方法作用：物理删除一条记录（数据库不留记录）
	 * 
	 * @Author: 自动生成
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public void delete() {
		this.getResult().putAll(this.operateResult(basisBankService.delete(this.getParam())));
		this.responseData(this.getResult());
	}


	/**
	 * TODO 方法作用：物理批量删除（数据库不留记录）
	 * 
	 * @Author: 自动生成
	 */
	@RequestMapping(value = "deleteAll")
	@ResponseBody
	public void deleteAll() {
		this.getResult().putAll(this.operateResult(basisBankService.deleteAll(this.getParam())));
		this.responseData(this.getResult());
	}


	/**
	 * TODO 方法作用：根据条件查询全部
	 * 
	 * @Author: 自动生成
	 */
	@RequestMapping(value = "findAllList")
	@ResponseBody
	public void findAllList() {
		super.responseData(basisBankService.findAllList(this.getParam()));
	}


	/**
	 * TODO 方法作用：根据条件分页查询记录
	 * 
	 * @Author: 自动生成
	 */
	@RequestMapping(value = "findPageList")
	@ResponseBody
	public void findPageList() {
		this.json = new Json(basisBankService.count(this.getParam()), basisBankService.findPageList(this.getParam()));
		super.responseData(json);
	}


	/**
	 * TODO 方法作用：根据条件查询一条记录
	 * 
	 * @Author: 自动生成
	 */
	@RequestMapping(value = "findById")
	@ResponseBody
	public void findById() {
		super.responseData(basisBankService.findById(this.getParam()));

	}


	/**
	 * TODO 方法作用：添加一条记录
	 * 
	 * @Author: 自动生成
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public void save() {
		this.getResult().putAll(this.operateResult(basisBankService.save(this.getParam())));
		this.responseData(this.getResult());
	}


	/**
	 * TODO 方法作用：批量添加记录
	 * 
	 * @Author: 自动生成
	 */
	@RequestMapping(value = "saveAll")
	@ResponseBody
	public void saveAll() {
		this.getResult().putAll(this.operateResult(basisBankService.saveAll(this.getParam())));
		this.responseData(this.getResult());
	}


	/**
	 * TODO 方法作用：修改一条记录
	 * 
	 * @Author: 自动生成
	 */
	@RequestMapping(value = "update")
	@ResponseBody
	public void update() {
		this.getResult().putAll(this.operateResult(basisBankService.update(this.getParam())));
		this.responseData(this.getResult());
	}

}
