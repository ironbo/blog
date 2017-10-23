package com.bobo.blog.response;

import java.util.ArrayList;
import java.util.List;

public class Pagination extends DefaultCommandResponse {

	private int offset;// 偏移量，启示位置
	private int limit;// 限制条数，查询条数
	private int total;// 总条数
	private List<?> rows = new ArrayList<>();// 数据集

	public Pagination() {

	}

	public Pagination(int offset, int limit) {
		this.limit = limit;
		this.offset = offset;
	}

	/**
	 * 根据页数，创建分页实例
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	public static Pagination initWithPage(int page, int limit) {
		int offset = (page - 1) * limit;
		return new Pagination(offset, limit);
	}

	/**
	 * 根据偏移量创建分页实例
	 * 
	 * @param offset
	 * @param limit
	 * @return
	 */
	public static Pagination initWithOffset(int offset, int limit) {
		return new Pagination(offset, limit);
	}

	public int getOffset() {
		return offset;
	}

	public int getLimit() {
		return limit;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}