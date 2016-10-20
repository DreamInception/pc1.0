/**
 *	包名:	com.xx.common.util
 *	文件名:	JSON.java
 *	描述:	数据以easyui需要的格式进行封装 list类型
 *	创建人:	qss
 *	创建时间:	2014-5-7下午3:53:54
 *	版权:	2014 xx版权所有
 */
package dr.web.common.bean;

import java.util.List;

public class Json {
	private int total;
	private List<?> rows;

	public Json() {
	}

	public Json(Integer total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
