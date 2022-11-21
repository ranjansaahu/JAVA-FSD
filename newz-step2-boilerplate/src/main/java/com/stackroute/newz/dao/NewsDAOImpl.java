package com.stackroute.newz.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.newz.model.News;

/*
 * This class is implementing the NewsDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
@Repository
@Transactional
public class NewsDAOImpl implements NewsDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	@Autowired
	SessionFactory sessionFactory;

	public NewsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Save the news in the database(news) table.
	 */
	public boolean addNews(News news) {
		if (news.getName() == null || news.getName() == "" || news.getAuthor() == null || 
			news.getAuthor() == "" || news.getContent() == null || news.getContent() == "" || 
			news.getDescription() == null || news.getDescription() == "")
			return false;
		else {
			sessionFactory.getCurrentSession().save(news);
		    return true;
		}
	}

	/*
	 * retrieve all existing news sorted by created Date in descending order(showing
	 * latest news first)
	 */
	public List<News> getAllNews() {
		return sessionFactory.getCurrentSession().createQuery("from News order by newsId desc").list();
	}

	/*
	 * retrieve specific news from the database(news) table
	 */
	public News getNewsById(int newsId) {
		News search = (News) sessionFactory.getCurrentSession()
				      .createQuery("from News where newsId=" + newsId).uniqueResult();
		return search;
	}

	public boolean updateNews(News news) {
		if (news.getName() == null || news.getName() == "" || news.getAuthor() == null || 
				news.getAuthor() == "" || news.getContent() == null || news.getContent() == "" || 
				news.getDescription() == null || news.getDescription() == "")
				return false;
			else {
				sessionFactory.getCurrentSession().update(news);
			    return true;
			}
	}

	/*
	 * Remove the news from the database(news) table.
	 */
	public boolean deleteNews(int newsId) {
		News target = getNewsById(newsId);
		sessionFactory.getCurrentSession().delete(target);
		return true;
			
	}
}