package com.bobo.blog.dao;

public interface AbstractDao<T> {
	public T get(int id, Class<T> t);

	public void save(T t);

	public void update(T t);

	public void delete(T t);
}
