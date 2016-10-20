/*************************************************************************
 * @system name：  :智联家园通
 * @Author: 陈吉秋特 604969793@qq.com
 * @Date: 2014-6-29 下午02:29:12
 * @(c) Copyright 武汉慧民智联网络科技有限公司
 **************************************************************************/
package dr.web.create;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @包名 :com.tyyf.create
 * @文件名 :创建文件.java TODO 类作用：
 * @系统名称 : 中楚佳联
 * @Author: 陈吉秋特
 * @Date: 2015-7-22 下午04:53:41
 * @版本号 :v0.0.01
 */
public class 创建文件 {
	public static void 写入文件内容(String filePath, String code) {
		try {
			System.out.println("创建：" + filePath);
			File filename = new File(filePath);
			if (!filename.exists()) {
				filename.createNewFile();
			}

			FileOutputStream o = new FileOutputStream(filePath);
			o.write(code.getBytes("utf-8"));
			o.close();
		} catch (Exception e) {
			System.out.println("失败：" + filePath);
			e.printStackTrace();
		}

	}

	public void 创建文件(String table, Interface参数 module参数) {
		if (table.indexOf(module参数.getTableHead()) == 0) {
			System.out.println("执行：" + table);
			Map<String, String> 参数 = (new 构建参数(table)).参数(module参数);
			this.创建controller(参数, module参数);
			this.创建service(参数, module参数);
			this.创建serviceImpl(参数, module参数);
			this.创建mapper(参数, module参数);
			this.创建bean(参数, module参数);
		}
	}

	public void 创建bean(Map<String, String> 参数, Interface参数 module参数) {
		参数.put("模版内容", 创建文件.读取文件内容(全局参数配置.template_bean));
		参数.put("文件名称", 参数.get("简化大写首字母表名") + "Bean.java");
		参数.put("文件路径", module参数.getBeanFilepath() + 参数.get("文件名称"));
		模版内容替换并创建(参数);

	}

	public void 创建controller(Map<String, String> 参数, Interface参数 module参数) {
		参数.put("模版内容", 创建文件.读取文件内容(全局参数配置.template_controller));
		参数.put("文件名称", "Basis" + 参数.get("简化大写首字母表名") + "Controller.java");
		参数.put("文件路径", module参数.getControllerFilepath() + 参数.get("文件名称"));
		模版内容替换并创建(参数);

	}

	public void 创建service(Map<String, String> 参数, Interface参数 module参数) {
		参数.put("模版内容", 创建文件.读取文件内容(全局参数配置.template_serveice));
		参数.put("文件名称", "Basis" + 参数.get("简化大写首字母表名") + "Service.java");
		参数.put("文件路径", module参数.getServiceFilepath() + 参数.get("文件名称"));
		模版内容替换并创建(参数);

	}

	public void 创建serviceImpl(Map<String, String> 参数, Interface参数 module参数) {
		参数.put("模版内容", 创建文件.读取文件内容(全局参数配置.template_serveice_impl));
		参数.put("文件名称", "Basis" + 参数.get("简化大写首字母表名") + "ServiceImpl.java");
		参数.put("文件路径", module参数.getServiceFilepath() + "impl/" + 参数.get("文件名称"));
		模版内容替换并创建(参数);

	}

	public void 创建mapper(Map<String, String> 参数, Interface参数 module参数) {
		参数.put("模版内容", 创建文件.读取文件内容(全局参数配置.template_mapper));
		参数.put("文件名称", "basis_" + 参数.get("简化小写表名") + ".xml");
		参数.put("文件路径", module参数.getMapperFilepath() + 参数.get("文件名称"));
		模版内容替换并创建(参数);

	}

	public void 模版内容替换并创建(Map<String, String> 参数) {
		String 文件内容 = 参数.remove("模版内容");
		String 文件路径 = 参数.remove("文件路径");

		Iterator<Entry<String, String>> iter = 参数.entrySet().iterator();
		Entry<String, String> entry;
		while (iter.hasNext()) {
			entry = iter.next();
			文件内容 = 文件内容.replace("{" + entry.getKey() + "}", entry.getValue());
		}

		写入文件内容(文件路径, 文件内容);
	}

	public static String 读取文件内容(String filePath) {
		filePath = 创建文件.class.getResource("/").toString().replace("file:/", "") + filePath;
		try {
			File file = new File(filePath);
			Long filelength = file.length();
			byte[] filecontent = new byte[filelength.intValue()];
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();
			return new String(filecontent, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
