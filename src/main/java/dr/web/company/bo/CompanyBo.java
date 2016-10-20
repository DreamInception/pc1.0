package dr.web.company.bo;

import java.io.Serializable;

public class CompanyBo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 391130585709720364L;
	private String pdtIds;
	
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPdtIds() {
		return pdtIds;
	}
	public void setPdtIds(String pdtId) {
		this.pdtIds = pdtId;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	private Integer source;
}
