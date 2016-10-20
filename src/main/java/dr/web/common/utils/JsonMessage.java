package dr.web.common.utils;

import java.util.ArrayList;
import java.util.List;

public class JsonMessage {

	private boolean success = true; // 处理是否成功

	private String errMsg; // 处理消息

	private int total; // 查询条数

	private List<? extends Object> rows = new ArrayList<Object>(); // 查询结果列表

	public JsonMessage(String msg) {
		this(true, msg);
	}

	public JsonMessage(boolean success, String msg) {
		this.success = success;
		this.setErrMsg(msg);
	}

	public JsonMessage(int total, List<?> rows) {
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

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String msg) {
		this.errMsg = msg;
	}
}
