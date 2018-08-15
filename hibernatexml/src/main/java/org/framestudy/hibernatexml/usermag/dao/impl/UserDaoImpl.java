package org.framestudy.hibernatexml.usermag.dao.impl;

import java.util.List;
import java.util.Map;

import org.framestudy.hibernatexml.bean.PagerBean;
import org.framestudy.hibernatexml.bean.UserBean;
import org.framestudy.hibernatexml.usermag.dao.IUserDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * 用户持久层实现类
 * 
 * @author puxubo
 *
 */
@Repository
public class UserDaoImpl implements IUserDao {

	private Session session;

	@Override
	public void saveUserBean(UserBean user) {
		// TODO Auto-generated method stub
		session.save(user);
	}

	@Override
	public void updateUserBean(UserBean user) {
		// TODO Auto-generated method stub
		session.update(user);
	}

	@Override
	public void deleteUserBean(UserBean user) {
		// TODO Auto-generated method stub
		session.delete(user);
	}

	@Override
	public UserBean getUserBeanById(Long id) {
		// TODO Auto-generated method stub
		return (UserBean) session.get(UserBean.class, id);
	}

	@Override
	public UserBean loadUserBeanById(Long id) {
		// TODO Auto-generated method stub
		return (UserBean) session.load(UserBean.class, id);
	}

	@Override
	public List<?> listUserBeanByUserNameAndLoginName(String userName, String loginName) {
		// TODO Auto-generated method stub
		// 按照参数位置传值方案（起始位置:0）
		/*
		 * String hql =
		 * "from UserBean as u where u.userName like CONCAT(?,'%') and u.loginName = ?";
		 * //hibernate query language 面向对象 Query query = session.createQuery(hql);//预编译
		 * query.setString(0, userName); query.setString(1, loginName); return
		 * query.list();
		 */

		// 按照参数别名的方式来完成传值
		String hql = "from UserBean as u where u.userName like CONCAT(:userName,'%') and u.loginName = :loginName";
		Query query = session.createQuery(hql);// 预编译
		query.setString("userName", userName);
		query.setString("loginName", loginName);

		return query.list();

	}

	@Override
	public List<?> listUserBeanByObject(UserBean user) {
		// TODO Auto-generated method stub
		String hql = "from UserBean as u where u.userName like CONCAT(:userName,'%') and u.loginName = :loginName";
		Query query = session.createQuery(hql);// 预编译
		query.setProperties(user);
		return query.list();
	}

	@Override
	public List<?> listUserBeanByParams(Map params) {
		// TODO Auto-generated method stub
		// 不推荐（缺陷：需要过多的维护构造函数）
		// String hql = "select new UserBean(u.id,u.userName) from UserBean as u where
		// u.userName like CONCAT(:userName,'%') and u.loginName = :loginName";

		String hql = "select new map(u.id as id,u.userName as userName) from UserBean as u where u.userName like CONCAT(:userName,'%') and u.loginName = :loginName";
		Query query = session.createQuery(hql);// 预编译
		query.setProperties(params);
		return query.list();
	}

	@Override
	public PagerBean listUserBeanByParams2PagerBean(Map params, PagerBean pager) {
		// TODO Auto-generated method stub
		// -----------------查询满足条件的总条数------------------
		String hql = "select count(*) from UserBean as u where u.userName like CONCAT(:userName,'%') and u.loginName = :loginName";
		Query query = session.createQuery(hql);// 预编译
		query.setProperties(params);

		// 根据id得类型，来定义总条数的类型
		long totalRows = (long) query.uniqueResult();// 总条数
		List<?> datas = null;
		if (totalRows != 0) {
			// -----------------查询具体的数据------------------
			hql = "select new map(u.id as id,u.userName as userName) from UserBean as u where u.userName like CONCAT(:userName,'%') and u.loginName = :loginName";
			query = session.createQuery(hql);// 预编译
			query.setProperties(params);

			query.setFirstResult(pager.getIndex());// 分页的起始位置
			query.setMaxResults(pager.getRows());// 分页的每页行数
			datas = query.list();// 具体的数据
		}
		pager.setTotalRows((int) totalRows);
		pager.setDatas(datas);
		return pager;
	}

	@Override
	public PagerBean listUserBeanByParmas2PagerBean4CriteriaDemo(Map params, PagerBean pager) {
		// TODO Auto-generated method stub
		// from UserBean
		Criteria criteria = session.createCriteria(UserBean.class);
		// ----------添加查询条件----------
		criteria.add(Restrictions.like("userName", params.get("userName").toString(), MatchMode.START)); // where
																											// asdfsadf
		criteria.add(Restrictions.eq("loginName", params.get("loginName").toString()));
		criteria.add(Restrictions.between("id", 20L, 60L));
		criteria.addOrder(Order.desc("createTime"));
		// ----------添加查询条件 end----------
		// ----------添加统计投影--------------
		criteria.setProjection(Projections.rowCount());

		// 根据id得类型，来定义总条数的类型,得到满足条件的总条数
		long totalRows = (long) criteria.uniqueResult();
		List<?> datas = null;
		if (totalRows != 0) {
			criteria.setProjection(null);// 去掉统计投影
			criteria.setFirstResult(pager.getIndex());// 分页的起始位置
			criteria.setMaxResults(pager.getRows());// 分页的每页行数
			datas = criteria.list();
		}

		pager.setTotalRows((int) totalRows);
		pager.setDatas(datas);
		return pager;
	}

	@Override
	public List<?> listUserBeanByIdcard(String idcard) {
		// TODO Auto-generated method stub
		//left join fetch 代表将"被关联对象"，作为关联对象的属性，而不需要作为一个需要被返回的独立对象
//		String hql = "From UserBean as u left join fetch u.userInfo as ui where ui.idCard like CONCAT(?,'%') ";
		//但是如果需要实现按需查询，需要去掉fetch
		String hql = "select new map(u.userName as userName,ui.idCard as idCard) From UserBean as u left join u.userInfo as ui where ui.idCard like CONCAT(?,'%')";
		
		Query query = session.createQuery(hql).setCacheable(true);
		query.setString(0, idcard);
		return query.list();
	}

}
