package com.bobo.blog.dao.imp1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bobo.blog.dao.BaseDao;
import com.bobo.blog.model.Comment;
import com.bobo.blog.response.Pagination;

@Repository("commentDao")
public class CommentDao extends BaseDao<Comment> {

	public int countCommentNum(int eassyId) {
		String hql = "select count(1) as totalNum from Comment c where c.essayId = ?";
		Session session = getSession();
		Query<?> query = session.createQuery(hql);
		List<?> results = new ArrayList<>();
		results = query.setParameter(0, eassyId).getResultList();
		int total = Integer.parseInt(String.valueOf(results.get(0)));
		return total;
	}

	public void getAll(Pagination pagination, int essayId) {
		String hql = "from Comment c where c.essayId = ?";
		Session session = getSession();
		Query<Comment> query = session.createQuery(hql, Comment.class);
		List<Comment> list = query.setMaxResults(pagination.getLimit()).setFirstResult(pagination.getOffset())
				.setParameter(0, essayId).getResultList();
		pagination.setRows(list);
	}

	@Override
	public void save(Comment comment) {
		Session session = getSession();
		comment.setCreateTime(new Date());
		session.save(session);
	}

	public void deleteByEssay(int essayId) {
		String hql = "delete from Comment c where c.essayId = ?";
		Session session = getSession();
		Query<Comment> query = session.createQuery(hql, Comment.class);
		query.setParameter(0, essayId).executeUpdate();
	}
}
