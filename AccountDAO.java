package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import entities.Account;
import entities.Role;

public class AccountDAO extends AbstractModel<Account> {
	private SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

	public AccountDAO() {
		super(Account.class);
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAccountsByUsername(String username) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			Query query = sessionFactory.getCurrentSession()
					.createQuery("Select a from Account a where a.username like :username");
			query.setParameter("username", "%" + username + "%");
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAccountsByRole(Role role) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			Query query = sessionFactory.getCurrentSession().createQuery("Select a from Account a where a.role = :role");
			query.setParameter("role", role);
			return query.list();
		} catch (Exception e) {
			return null;
		}
	}

	public Account login(String username, String password) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			Query query = sessionFactory.getCurrentSession()
					.createQuery("Select a from Account a where a.username = :username " + "and a.password = :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			return (Account) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}

}
