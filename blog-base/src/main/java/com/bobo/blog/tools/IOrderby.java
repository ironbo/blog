package com.bobo.blog.tools;

public interface IOrderby {
	/**
	 * 降序查询
	 * @param name
	 * @return
	 */
	public IOrderby desc(String name);
	/***
	 * 生序查询
	 * @param name
	 * @return
	 */
	public IOrderby asc(String name);
}