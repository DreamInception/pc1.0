/**   
 * Copyright (c) 2015, 多肉 All rights reserved
 */
package dr.web.common.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * @author chenbing
 * @date 2014-1-2
 * @version V1.0.0
 */

public class PageImpl<T> implements Page<T>, Serializable {

	private static final long serialVersionUID = 867755909294344406L;

	private final List<T> content = new ArrayList<T>();
	private Pageable pageable;
	private final long total;

	/**
	 * Constructor of {@code PageImpl}.
	 * 
	 * @param content
	 *            the content of this page
	 * @param pageable
	 *            the paging information
	 * @param total
	 *            the total amount of items available
	 */
	public PageImpl(List<T> content, Pageable pageable, long total) {

		if (null == content) {
			throw new IllegalArgumentException("Content must not be null!");
		}

		this.content.addAll(content);
		this.total = total;
		this.pageable = pageable;
	}

	/**
	 * Creates a new {@link PageImpl} with the given content. This will result
	 * in the created {@link RpcPage} being identical to the entire {@link List}
	 * .
	 * 
	 * @param content
	 */
	public PageImpl(List<T> content) {

		this(content, null, (null == content) ? 0 : content.size());
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public int getNumber() {

		return pageable == null ? 0 : pageable.getPageNumber();
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public int getSize() {

		return pageable == null ? 0 : pageable.getPageSize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public int getTotalPages() {

		return getSize() == 0 ? 0 : (int) Math.ceil((double) total / (double) getSize());
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public int getNumberOfElements() {

		return content.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public long getTotalElements() {

		return total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public boolean hasPreviousPage() {

		return getNumber() > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public boolean isFirstPage() {

		return !hasPreviousPage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public boolean hasNextPage() {

		return ((getNumber() + 1) * getSize()) < total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public boolean isLastPage() {

		return !hasNextPage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public Iterator<T> iterator() {

		return content.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public List<T> getContent() {

		return Collections.unmodifiableList(content);
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public boolean hasContent() {

		return !content.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public Sort getSort() {

		return pageable == null ? null : pageable.getSort();
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	@Override
	public String toString() {

		String contentType = "UNKNOWN";

		if (content.size() > 0) {
			contentType = content.get(0).getClass().getName();
		}

		return String.format("Page %s of %d containing %s instances", getNumber(), getTotalPages(), contentType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PageImpl<?>)) {
			return false;
		}

		PageImpl<?> that = (PageImpl<?>) obj;

		boolean totalEqual = this.total == that.total;
		boolean contentEqual = this.content.equals(that.content);
		boolean pageableEqual = this.pageable == null ? that.pageable == null : this.pageable.equals(that.pageable);

		return totalEqual && contentEqual && pageableEqual;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	@Override
	public int hashCode() {

		int result = 17;

		result = 31 * result + (int) (total ^ total >>> 32);
		result = 31 * result + (pageable == null ? 0 : pageable.hashCode());
		result = 31 * result + content.hashCode();

		return result;
	}

	/**
	 * @return the pageable
	 */
	public Pageable getPageable() {
		return pageable;
	}

	/**
	 * @param pageable
	 *            the pageable to set
	 */
	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

}
