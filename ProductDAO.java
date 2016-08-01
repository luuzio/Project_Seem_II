package dao;

import java.util.List;
import org.hibernate.SessionFactory;
import entities.Category;
import entities.Product;

public class ProductDAO extends AbstractModel<Product> {
	private SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

	public ProductDAO() {
		super(Product.class);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductByName(String name) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			return sessionFactory.getCurrentSession().createQuery("Select p from Product p where p.name like :name")
					.setParameter("name", "%" + name + "%").list();
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProductByCategory(Category category) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			return sessionFactory.getCurrentSession().createQuery("Select p from Product p where p.category = :category")
					.setParameter("category", category).list();
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		try {

			Product product = new Product();
			product.setName("Tét 4");
			product.setCategory(new CategoryDAO().find(1));
			new ProductDAO().create(product);
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
