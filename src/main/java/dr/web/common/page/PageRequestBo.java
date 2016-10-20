/**   
 * Copyright (c) 2015, 多肉 All rights reserved
 */
package dr.web.common.page;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @Description
 * @author chenbing
 * @date 2014-1-2
 * @version V1.0.0
 */

public class PageRequestBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int page;
	private int size;
	private String sortProps;
	private String sortDirection;

	public PageRequest initPageRequest() {
		if (StringUtils.hasText(this.sortProps)) {
			if (StringUtils.isEmpty(this.sortDirection)) {
				this.sortDirection = Sort.Direction.ASC.toString();
			}
			return new PageRequest(this.page-1, this.size, Sort.Direction.fromString(this.sortDirection),
					this.sortProps.split(","));
		}
		return new PageRequest(this.page-1, this.size);
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the sortProps
	 */
	public String getSortProps() {
		return sortProps;
	}

	/**
	 * @param sortProps
	 *            the sortProps to set
	 */
	public void setSortProps(String sortProps) {
		this.sortProps = sortProps;
	}

	/**
	 * @return the sortDirection
	 */
	public String getSortDirection() {
		return sortDirection;
	}

	/**
	 * @param sortDirection
	 *            the sortDirection to set
	 */
	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}

}
