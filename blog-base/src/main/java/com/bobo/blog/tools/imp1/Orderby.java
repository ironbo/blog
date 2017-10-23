package com.bobo.blog.tools.imp1;

import java.util.ArrayList;
import java.util.List;

import com.bobo.blog.tools.IOrderby;


public class Orderby implements IOrderby {
	private final static String ORDER_BY_DESC = "desc";
	private final static String ORDER_BY_ASC = "asc";
	private List<String> descNames = new ArrayList<String>();
	private List<String> ascNames = new ArrayList<String>();;
	String order;

	private Orderby(){}

	private Orderby(String order) {
		this.order = order;
	}

	public static Orderby getOrderByAsc() {
		return new Orderby(ORDER_BY_ASC);
	}

	public static Orderby getOrderByDesc() {
		return new Orderby(ORDER_BY_DESC);
	}

	@Override
	public IOrderby desc(String name) {
		descNames.add(name);
		return this;
	}

	@Override
	public IOrderby asc(String name) {
		ascNames.add(name);
		return this;
	}

	public String toString() {
		String desc = getString(order, descNames);
		String asc = getString(order, ascNames);
		if (order.equalsIgnoreCase(ORDER_BY_ASC) && asc != null) {
			return "order by " + asc + (desc != null ? desc : "");
		}
		if (order.equalsIgnoreCase(ORDER_BY_DESC) && desc != null) {
			return "order by " + desc + (asc != null ? asc : "");
		}
		return null;

	}

	public String getString(String desc, List<String> names) {
		StringBuilder sb = new StringBuilder();
		for (String name : names) {
			sb.append(",").append(name);
		}
		if (sb.length() > 0) {
			sb.append(" ").append(desc);
			return sb.substring(1);
		}

		return null;

	}
}
