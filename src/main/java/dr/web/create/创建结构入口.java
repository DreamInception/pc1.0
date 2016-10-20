package dr.web.create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @包名 :dr.web.create
 * @文件名 :创建结构入口.java 
 * TODO 类作用：
 * @系统名称 : 上海景源金服PC端
 * @Author: 陈吉秋特
 * @Date: 2016年3月17日 上午10:09:56
 * @版本号   :v0.0.01
 */
public class 创建结构入口 {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// 创建连接
			Class.forName(全局参数配置.classforname);
			if (conn == null || conn.isClosed()) {
				conn = (Connection) DriverManager.getConnection(全局参数配置.url, 全局参数配置.uid, 全局参数配置.pwd);
			}

			// 获取所有的表
			java.sql.Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("show tables");
			List<String> tableList = new ArrayList<String>();
			while (rs.next()) {
				tableList.add(rs.getString(1));
			}
			// (new 创建文件()).创建文件("shop_orderinfo", new 参数Shop());
			for (int i = 0; i < tableList.size(); i++) {
				(new 创建文件()).创建文件(tableList.get(i), new 参数user());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
