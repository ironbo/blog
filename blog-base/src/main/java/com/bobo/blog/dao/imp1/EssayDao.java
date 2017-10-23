package com.bobo.blog.dao.imp1;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bobo.blog.dao.BaseDao;
import com.bobo.blog.model.Essay;
import com.bobo.blog.response.Pagination;

@Repository("essayDao")
public class EssayDao extends BaseDao<Essay> {

	public void getAll(Pagination pagination) {
		String hql = "from Essay e where e.isShare = 0";
		Session session = getSession();
		Query<Essay> query = session.createQuery(hql, Essay.class);
		List<Essay> list = query.setMaxResults(pagination.getLimit()).setFirstResult(pagination.getOffset())
				.getResultList();
		pagination.setRows(list);
	}

	@Override
	public void save(Essay essay) {
		Session session = getSession();
		essay.setCreateTime(new Date());
		session.save(essay);
	}

	@Override
	public void update(Essay essay) {
		Session session = getSession();
		essay.setUpdateTime(new Date());
		session.update(essay);
	}

}
