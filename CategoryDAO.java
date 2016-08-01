package dao;

import org.hibernate.SessionFactory;
import entities.Category;

public class CategoryDAO extends AbstractModel<Category> {
	private SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

	public CategoryDAO() {
		super(Category.class);
	}

	public Category getCategoryByName(String name) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			return (Category) sessionFactory.getCurrentSession()
					.createQuery("Select c From Category c where c.name = :name").setParameter("name", name).uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}

}
