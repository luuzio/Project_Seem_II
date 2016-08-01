package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.CategoryDAO;
import dao.ProductDAO;
import entities.Category;
import entities.Product;
import entities.ScaleImage;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class IFr_ProductList extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	static IFr_ProductList productList = null;

	private JTextField textFieldSearch;
	private JComboBox<String> comboBoxCategory;
	private JLabel labelNewLabel;
	private JLabel labelPhoto;
	private JScrollPane scrollPane;
	private JTable tableProductList;
	private JPanel panel;
	private JTextField textFieldPrice;
	private JTextField textFieldQuantity;
	private JTextField textFieldStatus;
	private JTextField textFieldSpecials;
	private JButton buttonDelete;
	private JButton buttonEdit;
	private JButton buttonAdd;
	private JScrollPane scrollPane_1;
	private JTextArea textAreaDescription;
	private JLabel labelNewLabel_2;
	private JLabel labelQuantity;
	private JLabel labelInOfStock;
	private JLabel labelSpecials;

	public IFr_ProductList() {
		intialize();
		loadData();
	}

	private void intialize() {
		setClosable(true);
		setBounds(100, 100, 856, 549);
		getContentPane().setLayout(null);

		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				textFieldSearchKeyReleased();
			}
		});
		textFieldSearch.setForeground(new Color(255, 215, 0));
		textFieldSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldSearch.setBorder(new EmptyBorder(0, 5, 0, 5));
		textFieldSearch.setBounds(107, 11, 230, 20);
		getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);

		comboBoxCategory = new JComboBox<String>();
		comboBoxCategory.addActionListener(a -> comboBoxCategoryActionPerformed());
		comboBoxCategory.setForeground(new Color(255, 215, 0));
		comboBoxCategory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxCategory.setBounds(347, 11, 170, 20);
		getContentPane().add(comboBoxCategory);

		labelNewLabel = new JLabel("Product Name :");
		labelNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelNewLabel.setForeground(new Color(255, 69, 0));
		labelNewLabel.setBounds(10, 14, 97, 14);
		getContentPane().add(labelNewLabel);

		labelPhoto = new JLabel("PHOTO");
		labelPhoto.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelPhoto.setForeground(new Color(255, 215, 0));
		labelPhoto.setBorder(UIManager.getBorder("TextField.border"));
		labelPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		labelPhoto.setBounds(527, 11, 303, 303);
		getContentPane().add(labelPhoto);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 507, 272);
		getContentPane().add(scrollPane);

		tableProductList = new JTable();
		tableProductList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				tableProductListMousePressed();
				if (0 <= tableProductList.getSelectedRow()) {
					buttonEdit.setEnabled(true);
					buttonDelete.setEnabled(true);
				} else {
					buttonEdit.setEnabled(false);
					buttonDelete.setEnabled(false);
				}
			}
		});
		tableProductList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableProductList.setForeground(new Color(255, 215, 0));
		tableProductList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableProductList
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "#", "Product  Name", "Category" }) {
					private static final long serialVersionUID = 1L;
					Class<?>[] columnTypes = new Class[] { String.class, String.class, String.class };

					public Class<?> getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		tableProductList.getColumnModel().getColumn(0).setPreferredWidth(25);
		tableProductList.getColumnModel().getColumn(1).setPreferredWidth(280);
		tableProductList.getColumnModel().getColumn(2).setPreferredWidth(150);
		scrollPane.setViewportView(tableProductList);

		panel = new JPanel();
		panel.setBounds(527, 325, 303, 140);
		getContentPane().add(panel);
		panel.setLayout(null);

		textFieldPrice = new JTextField();
		textFieldPrice.setEditable(false);
		textFieldPrice.setForeground(new Color(255, 215, 0));
		textFieldPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldPrice.setBorder(null);
		textFieldPrice.setBounds(119, 11, 155, 20);
		panel.add(textFieldPrice);
		textFieldPrice.setColumns(10);

		textFieldQuantity = new JTextField();
		textFieldQuantity.setEditable(false);
		textFieldQuantity.setForeground(new Color(255, 215, 0));
		textFieldQuantity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldQuantity.setBorder(null);
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(119, 42, 155, 20);
		panel.add(textFieldQuantity);

		textFieldStatus = new JTextField();
		textFieldStatus.setEditable(false);
		textFieldStatus.setForeground(new Color(255, 215, 0));
		textFieldStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldStatus.setBorder(null);
		textFieldStatus.setColumns(10);
		textFieldStatus.setBounds(119, 73, 155, 20);
		panel.add(textFieldStatus);

		textFieldSpecials = new JTextField();
		textFieldSpecials.setEditable(false);
		textFieldSpecials.setForeground(new Color(255, 215, 0));
		textFieldSpecials.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldSpecials.setBorder(null);
		textFieldSpecials.setColumns(10);
		textFieldSpecials.setBounds(119, 104, 155, 20);
		panel.add(textFieldSpecials);

		labelNewLabel_2 = new JLabel("Price :");
		labelNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelNewLabel_2.setForeground(new Color(255, 69, 0));
		labelNewLabel_2.setBounds(33, 14, 76, 14);
		panel.add(labelNewLabel_2);

		labelQuantity = new JLabel("Quantity :");
		labelQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelQuantity.setForeground(new Color(255, 69, 0));
		labelQuantity.setBounds(33, 45, 76, 14);
		panel.add(labelQuantity);

		labelInOfStock = new JLabel("In Of Stock :");
		labelInOfStock.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelInOfStock.setForeground(new Color(255, 69, 0));
		labelInOfStock.setBounds(33, 76, 76, 14);
		panel.add(labelInOfStock);

		labelSpecials = new JLabel("Specials :");
		labelSpecials.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelSpecials.setForeground(new Color(255, 69, 0));
		labelSpecials.setBounds(33, 107, 76, 14);
		panel.add(labelSpecials);

		buttonDelete = new JButton("DELETE");
		buttonDelete.addActionListener(a -> buttonDeleteActionPerformed());
		buttonDelete.setForeground(new Color(255, 215, 0));
		buttonDelete.setBorder(null);
		buttonDelete.setBounds(741, 476, 89, 30);
		getContentPane().add(buttonDelete);

		buttonEdit = new JButton("EDIT");
		buttonEdit.addActionListener(a -> buttonEditActionPerformed());
		buttonEdit.setForeground(new Color(255, 215, 0));
		buttonEdit.setBorder(null);
		buttonEdit.setBounds(635, 476, 89, 30);
		getContentPane().add(buttonEdit);

		buttonAdd = new JButton("ADD");
		buttonAdd.addActionListener(a -> buttonAddActionPerformed());
		buttonAdd.setForeground(new Color(255, 215, 0));
		buttonAdd.setBorder(null);
		buttonAdd.setBounds(527, 476, 89, 30);
		getContentPane().add(buttonAdd);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 325, 507, 183);
		getContentPane().add(scrollPane_1);

		textAreaDescription = new JTextArea();
		textAreaDescription.setForeground(new Color(255, 215, 0));
		textAreaDescription.setBorder(new EmptyBorder(5, 5, 5, 5));
		textAreaDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaDescription.setWrapStyleWord(true);
		textAreaDescription.setLineWrap(true);
		scrollPane_1.setViewportView(textAreaDescription);
	}

	// load data when run

	public void loadData() {
		fillDataToComboBox(new CategoryDAO().findAll());
		fillDataToTable(new ProductDAO().findAll());
	}

	protected void fillDataToComboBox(List<Category> categories) {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("All Category");
		categories.forEach(c -> defaultComboBoxModel.addElement(c.getName()));
		comboBoxCategory.setModel(defaultComboBoxModel);
	}

	protected void fillDataToTable(List<Product> products) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) tableProductList.getModel();
		defaultTableModel.setRowCount(0);
		products.forEach(p -> defaultTableModel.addRow(new Object[] { p.getId(), p.getName(), p.getCategory().getName() }));
		tableProductList.setModel(defaultTableModel);
		buttonEdit.setEnabled(false);
		buttonDelete.setEnabled(false);
	}

	protected void buttonAddActionPerformed() {
		if (null == IFr_ProductAdd.productAdd || IFr_ProductAdd.productAdd.isClosed()) {
			IFr_ProductAdd.productAdd = new IFr_ProductAdd();
			IFr_ProductAdd.productAdd.setVisible(true);
			IFr_ProductAdd.productAdd.setActionForm(0);
			getDesktopPane().add(IFr_ProductAdd.productAdd);
			IFr_ProductAdd.productAdd.toFront();
		} else
			IFr_ProductAdd.productAdd.toFront();
	}

	protected void buttonEditActionPerformed() {
		if (null == IFr_ProductAdd.productAdd || IFr_ProductAdd.productAdd.isClosed()) {
			IFr_ProductAdd.productAdd = new IFr_ProductAdd();
			IFr_ProductAdd.productAdd.setVisible(true);
			IFr_ProductAdd.productAdd.setActionForm(1);
			IFr_ProductAdd.productAdd.loadProduct((int) tableProductList.getValueAt(tableProductList.getSelectedRow(), 0));
			getDesktopPane().add(IFr_ProductAdd.productAdd);
			IFr_ProductAdd.productAdd.toFront();
		} else
			IFr_ProductAdd.productAdd.toFront();
	}

	protected void buttonDeleteActionPerformed() {
		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Are you sure ?", "Delete confirm dialog: ",
				JOptionPane.YES_NO_CANCEL_OPTION)) {
			try {
				ProductDAO productDAO = new ProductDAO();
				productDAO.delete(productDAO.find(tableProductList.getValueAt(tableProductList.getSelectedRow(), 0)));
				JOptionPane.showMessageDialog(null, "Deleted");
				loadData();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Fail! Check the binding again");
			}
		}
	}

	protected void tableProductListMousePressed() {
		Product product = new ProductDAO().find(tableProductList.getValueAt(tableProductList.getSelectedRow(), 0));
		textFieldPrice.setText(String.valueOf(product.getPrice()));
		textFieldQuantity.setText(String.valueOf(product.getQuantity()));
		textFieldStatus.setText(String.valueOf(product.getStatus()));
		textFieldSpecials.setText(String.valueOf(product.getSpecials()));
		textAreaDescription.setText(product.getDescription());
		if (null != product.getPhoto()) {
			labelPhoto.setText("");
			labelPhoto.setIcon(new ImageIcon(ScaleImage.getImageScaledByByteFile(product.getPhoto(), 298, 298)));
		} else {
			labelPhoto.setText("PHOTO");
			labelPhoto.setIcon(null);
		}

	}

	protected void comboBoxCategoryActionPerformed() {
		if (0 < comboBoxCategory.getSelectedIndex())
			fillDataToTable(new ProductDAO()
					.getProductByCategory(new CategoryDAO().findAll().get(comboBoxCategory.getSelectedIndex() - 1)));
		else
			fillDataToTable(new ProductDAO().findAll());
	}

	protected void textFieldSearchKeyReleased() {
		if ("".equals(textFieldSearch))
			fillDataToTable(new ProductDAO().findAll());
		else
			fillDataToTable(new ProductDAO().getProductByName(textFieldSearch.getText()));
	}
}
