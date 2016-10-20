package dr.web.create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 构建参数 {

	private String tableName;

	public 构建参数() {
	}

	public 构建参数(String tableName) {
		this.tableName = tableName;
	}

	public Map<String, String> 参数(Interface参数 module参数) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			if (this.tableName.indexOf("dr_") == 0) {
				if (!isKeyWord(this.tableName.substring(this.tableName.indexOf("dr_") + 3, this.tableName.length()))) {
					map.put("简化小写表名",
							this.tableName.substring(this.tableName.indexOf("dr_") + 3, this.tableName.length()));
				} else {
					map.put("简化小写表名", this.tableName);
				}
			} else if (this.tableName.indexOf("v2_") == 0) {
				if (!isKeyWord(this.tableName.substring(this.tableName.indexOf("v2_") + 3, this.tableName.length()))) {
					map.put("简化小写表名",
							this.tableName.substring(this.tableName.indexOf("v2_") + 3, this.tableName.length()));
				} else {
					map.put("简化小写表名", this.tableName);
				}
			} else if (this.tableName.indexOf("v3_") == 0) {
				if (!isKeyWord(this.tableName.substring(this.tableName.indexOf("v3_") + 3, this.tableName.length()))) {
					map.put("简化小写表名",
							this.tableName.substring(this.tableName.indexOf("v3_") + 3, this.tableName.length()));
				} else {
					map.put("简化小写表名", this.tableName);
				}
			}
			map.put("简化大写首字母表名", map.get("简化小写表名").substring(0, 1).toUpperCase()
					+ map.get("简化小写表名").substring(1, map.get("简化小写表名").length()));
			map.put("controller_package", module参数.getControllerPackage());
			map.put("service_package", module参数.getServicePackage());
			map.put("bean_package", module参数.getBeanPackage());
			map.put("mapper_filepath", module参数.getMapperFilepath());
			map.put("系统名称", 全局参数配置.系统名称);
			map.put("Author", 全局参数配置.Author);
			map.put("版本号", 全局参数配置.版本号);
			map.put("表名", this.tableName);

			map.put("enum_code", this.获取列的注释(tableName));

			List<String> 列名 = this.getColumnName();
			String 主键id = valite(列名.get(0));
			map.put("主键id", "{" + 主键id + "}");
			map.put("主键列名", 列名.get(0));
			System.out.println("获取列名：" + 列名);
			StringBuffer 查询的列 = new StringBuffer();
			StringBuffer 插入的列 = new StringBuffer();
			StringBuffer 批量插入的列 = new StringBuffer();
			StringBuffer 插入的结果 = new StringBuffer();
			StringBuffer 批量插入的结果 = new StringBuffer();
			StringBuffer 修改列 = new StringBuffer();
			StringBuffer 查询条件 = new StringBuffer();
			StringBuffer 删除条件 = new StringBuffer();

			for (int i = 0; i < 列名.size(); i++) {
				查询的列.append(map.get("简化小写表名") + "." + 列名.get(i) + " as " + valite(列名.get(i)));

				插入的列.append("<if test=\"" + valite(列名.get(i)) + " != null\">" + 列名.get(i) + ",</if>");
				插入的结果.append("<if test=\"" + valite(列名.get(i)) + " != null\">#{" + valite(列名.get(i)) + "},</if>");

				批量插入的列.append(列名.get(i));
				批量插入的结果.append("#{item." + valite(列名.get(i)) + "}");

				修改列.append("<if test=\"" + valite(列名.get(i)) + " != null\" >  " + 列名.get(i) + " = #{"
						+ valite(列名.get(i)) + "}, </if>");
				查询条件.append(" <if test=\"" + valite(列名.get(i)) + " != null and '' != " + valite(列名.get(i)) + "\" > AND "
						+ map.get("简化小写表名") + "." + 列名.get(i) + " = #{" + valite(列名.get(i)) + "}</if>");
				删除条件.append(" <if test=\"" + valite(列名.get(i)) + " != null and '' != " + valite(列名.get(i)) + "\" > AND "
						+ 列名.get(i) + " = #{" + valite(列名.get(i)) + "}</if>");

				if (i < 列名.size() - 1) {
					查询的列.append(", ");
					批量插入的列.append(",");
					批量插入的结果.append(",");
				}
			}

			if (查询的列.indexOf("cd_user") != -1) {
				查询的列.append(",(SELECT user.user_name FROM user WHERE user.id= " + map.get("简化小写表名")
						+ ".cd_user ) as cdUserName");
			}

			if (查询的列.indexOf("ud_user") != -1) {
				查询的列.append(",(SELECT user.user_name FROM user WHERE user.id= " + map.get("简化小写表名")
						+ ".ud_user ) as udUserName");
			}

			map.put("查询的列", 查询的列.toString());

			map.put("插入的列", 插入的列.toString());
			map.put("插入的结果", 插入的结果.toString());

			map.put("批量插入的列", 批量插入的列.toString());
			map.put("批量插入的结果", 批量插入的结果.toString());

			map.put("修改列", 修改列.toString());
			map.put("查询条件", 查询条件.toString());
			map.put("删除条件", 删除条件.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	private static String valite(String columName) {
		String result = "";
		if (columName.indexOf("_") > 0) {
			result = columName.substring(0, columName.indexOf("_"))
					+ columName.substring(columName.indexOf("_") + 1, columName.indexOf("_") + 2).toUpperCase()
					+ columName.substring(columName.indexOf("_") + 2, columName.length());
			return result;
		}
		if (result.indexOf("_") > 0) {
			result = result.substring(0, result.indexOf("_"))
					+ result.substring(result.indexOf("_") + 1, result.indexOf("_") + 2).toUpperCase()
					+ result.substring(result.indexOf("_") + 2, result.length());
			return result;
		}
		if (result.indexOf("_") > 0) {
			result = result.substring(0, result.indexOf("_"))
					+ result.substring(result.indexOf("_") + 1, result.indexOf("_") + 2).toUpperCase()
					+ result.substring(result.indexOf("_") + 2, result.length());
			return result;
		}
		return columName;
	}

	public List<String> getColumnName() {
		Connection conn = null;
		try {
			Class.forName(全局参数配置.classforname);
			if (conn == null || conn.isClosed()) {
				conn = (Connection) DriverManager.getConnection(全局参数配置.url, 全局参数配置.uid, 全局参数配置.pwd);
			}
			java.sql.Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM " + this.tableName);
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			List<String> 列名 = new ArrayList<String>();
			for (int i = 1; i <= columnCount; i++) {
				列名.add(rsmd.getColumnName(i));
			}
			return 列名;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String 获取列的注释(String tableName) {
		String sql = "SELECT  column_name, column_comment FROM information_schema.columns WHERE table_schema ='"
				+ 全局参数配置.db + "'  AND table_name = '" + tableName + "' ";

		Connection conn = null;
		try {
			Class.forName(全局参数配置.classforname);
			if (conn == null || conn.isClosed()) {
				conn = (Connection) DriverManager.getConnection(全局参数配置.url, 全局参数配置.uid, 全局参数配置.pwd);
			}
			java.sql.Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			StringBuffer enum_code = new StringBuffer();
			while (rs.next()) {
				String columnBak = (rs.getString(2).length() <= 0 ? rs.getString(1) : rs.getString(2));
				enum_code.append("/**" + columnBak + "*/");
				enum_code.append("public static final String " + valite(rs.getString(1)) + " = \""
						+ valite(rs.getString(1)) + "\" ;");
				enum_code.append("                                           ");

			}
			return enum_code.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 表关键字
	 */
	public static final String[] keywords = { "order", "user" };

	/**
	 * 
	 * TODO 方法作用：判断是否关键字
	 * 
	 * @param keyword
	 * @return
	 * @Author: 陈吉秋特
	 * @Date: 2016年5月13日 下午3:03:42
	 */
	public boolean isKeyWord(String keyword) {
		for (int i = 0; i < keywords.length; i++) {
			if (keyword.equals(keywords[i])) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		构建参数 构建参数_ = new 构建参数();
		System.out.println(构建参数_.获取列的注释("ecs_admin_user"));
	}
}
