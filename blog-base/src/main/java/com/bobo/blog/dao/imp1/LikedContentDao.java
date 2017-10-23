package com.bobo.blog.dao.imp1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bobo.blog.dao.BaseDao;
import com.bobo.blog.model.LikedContent;

@Repository("likedContentDao")
public class LikedContentDao extends BaseDao<LikedContent> {
	public int countLikedNum(int eassyId) {
		String hql = "select count(1) as totalNum from LikedContent l where l.eassyId = ?";
		Session session = getSession();
		Query<?> query = session.createQuery(hql);
		List<?> results = new ArrayList<>();
		results = query.setParameter(0, eassyId).getResultList();
		int total = Integer.parseInt(String.valueOf(results.get(0)));
		return total;
	}

	@Override
	public void save(LikedContent likedContent) {
		Session session = getSession();
		likedContent.setCreateTime(new Date());
		session.save(likedContent);
	}
	
	public String isLiked(int eassyId,int userId) {
		String hql = "select count(1) as totalNum from LikedContent l where l.eassyId = ? and l.userId = ?";
		Session session = getSession();
		Query<?> query = session.createQuery(hql);
		List<?> results = new ArrayList<>();
		results = query.setParameter(0, eassyId)
				.setParameter(1, userId)
				.getResultList();
		String isLiked = String.valueOf(results.get(0));
		return isLiked;
	}

	public void deleteByEssay(int essayId) {
		String hql = "delete from LikedContent c where c.essayId = ?";
		Session session = getSession();
		Query<LikedContent> query = session.createQuery(hql, LikedContent.class);
		query.setParameter(0, essayId).executeUpdate();
		
	}
	
}
