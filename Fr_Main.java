package view;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Fr_Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JDesktopPane desktopPane;
	private JMenu menuProduct;
	private JMenu menuProfile;
	private JMenuItem menuItemChangeProfile;
	private JMenuItem menuItemProductList;
	private JMenuItem menuItemProductAdd;

	public static void main(String[] args) {

		new Fr_Main().setVisible(true);
	}

	public Fr_Main() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 594);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuProduct = new JMenu("Product");
		menuProduct.setMnemonic('P');
		menuBar.add(menuProduct);

		menuItemProductList = new JMenuItem("Product list");
		menuItemProductList.addActionListener(a -> menuItemActionPerformed());
		menuProduct.add(menuItemProductList);

		menuItemProductAdd = new JMenuItem("Add new product");
		menuItemProductAdd.addActionListener(a -> menuItemProductAddActionPerformed());
		menuProduct.add(menuItemProductAdd);

		menuProfile = new JMenu("Profile");
		menuProfile.setMnemonic('o');
		menuBar.add(menuProfile);

		menuItemChangeProfile = new JMenuItem("Change profile");
		menuItemChangeProfile.addActionListener(a -> menuItemChangeProfileActionPerformed());
		menuProfile.add(menuItemChangeProfile);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(desktopPane,
				GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(desktopPane,
				GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);
	}

	private void menuItemActionPerformed() {
		if (null == IFr_ProductList.productList || IFr_ProductList.productList.isClosed()) {
			IFr_ProductList.productList = new IFr_ProductList();
			IFr_ProductList.productList.setVisible(true);
			desktopPane.add(IFr_ProductList.productList);
			IFr_ProductList.productList.toFront();
		} else
			IFr_ProductList.productList.toFront();
	}

	protected void menuItemProductAddActionPerformed() {
		if (null == IFr_ProductAdd.productAdd || IFr_ProductAdd.productAdd.isClosed()) {
			IFr_ProductAdd.productAdd = new IFr_ProductAdd();
			IFr_ProductAdd.productAdd.setVisible(true);
			IFr_ProductAdd.productAdd.setActionForm(0);
			desktopPane.add(IFr_ProductAdd.productAdd);
			IFr_ProductAdd.productAdd.toFront();
		} else
			IFr_ProductAdd.productAdd.toFront();
	}

	protected void menuItemChangeProfileActionPerformed() {
		if (null == IFr_ProfileChange.profileChange || IFr_ProfileChange.profileChange.isClosed()) {
			IFr_ProfileChange.profileChange = new IFr_ProfileChange();
			IFr_ProfileChange.profileChange.setVisible(true);
			desktopPane.add(IFr_ProfileChange.profileChange);
			IFr_ProfileChange.profileChange.toFront();
		} else
			IFr_ProfileChange.profileChange.toFront();
	}
}
