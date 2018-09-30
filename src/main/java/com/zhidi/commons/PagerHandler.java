package com.zhidi.commons;

import java.util.List;

public class PagerHandler<T> {

	private Integer pageNumber = 1; // ��ǰҳ��
	private Integer pageSize = 10; // һҳ��ʾ����
	private Integer totalRows = 0; // �ܼ�¼��
	private Integer totalPage = 0; // ��ҳ��

	private List<T> data;
	
	public PagerHandler() {
		super();
	}

	public PagerHandler(Integer pageNumber, Integer pageSize) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		// �Ե�ǰҳ�������ЧУ��
		if (pageNumber <= 0) {
			pageNumber = 1;
		}
		if (pageNumber > totalPage) {
			pageNumber = totalPage;
		}
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
		getTotalPage();
	}

	public Integer getTotalPage() {
		// ������ҳ��
		if (pageSize != 0) {
			totalPage = (totalRows + pageSize - 1) / pageSize;
		}
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
