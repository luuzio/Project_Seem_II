package view;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import dao.CategoryDAO;
import dao.ProductDAO;
import entities.Category;
import entities.ConvertFile;
import entities.FileTypeFilter;
import entities.Product;
import entities.ScaleImage;

public class IFr_ProductAdd extends JInternalFrame {

	static IFr_ProductAdd productAdd = null;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelPhoto;
	private JButton buttonBrowser;
	private JSeparator separator;
	private JLabel labelChooserPhoto;
	private JLabel jLabelFormName;
	private JTextField textFieldName;
	private JComboBox<String> comboBoxCategory;
	private JSpinner spinnerQuantity;
	private JCheckBox checkBoxSpecials;
	private JCheckBox checkBoxStatus;
	private JScrollPane scrollPane;
	private JTextArea textAreaDescription;
	private JLabel jLabelQuantity;
	private JLabel jLabelName;
	private JLabel jLabelCategory;
	private JLabel jLabelPrice;
	private JLabel jLabelDescription;
	private JButton buttonAdd;
	private JButton jButtonUpdate;
	private JSpinner spinnerPrice;

	private File file;
	private int productID;

	public IFr_ProductAdd() {
		setClosable(true);
		initialize();
		fillDataToComboBox(new CategoryDAO().findAll());
	}

	private void initialize() {
		setBounds(100, 100, 859, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		labelPhoto = new JLabel("IMAGE");
		labelPhoto.setForeground(new Color(255, 215, 0));
		labelPhoto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		labelPhoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		labelPhoto.setBounds(479, 11, 354, 330);
		contentPane.add(labelPhoto);

		buttonBrowser = new JButton("Browser...");
		buttonBrowser.addActionListener(a -> jButtonBrowserAction());
		buttonBrowser.setBorder(new EmptyBorder(2, 2, 2, 2));
		buttonBrowser.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonBrowser.setForeground(new Color(255, 215, 0));
		buttonBrowser.setBounds(479, 351, 145, 40);
		contentPane.add(buttonBrowser);

		separator = new JSeparator();
		separator.setForeground(Color.CYAN);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(456, 11, 2, 380);
		contentPane.add(separator);

		labelChooserPhoto = new JLabel("Choose a photo...");
		labelChooserPhoto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelChooserPhoto.setForeground(new Color(255, 215, 0));
		labelChooserPhoto.setBorder(new EmptyBorder(0, 5, 0, 0));
		labelChooserPhoto.setBounds(634, 351, 199, 40);
		contentPane.add(labelChooserPhoto);

		jLabelFormName = new JLabel("Product info :");
		jLabelFormName.setForeground(new Color(255, 215, 0));
		jLabelFormName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jLabelFormName.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelFormName.setBounds(139, 10, 165, 20);
		contentPane.add(jLabelFormName);

		textFieldName = new JTextField();
		textFieldName.setForeground(new Color(255, 215, 0));
		textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldName.setBounds(139, 49, 285, 30);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);

		comboBoxCategory = new JComboBox<String>();
		comboBoxCategory.setForeground(new Color(255, 215, 0));
		comboBoxCategory.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBoxCategory.setBounds(139, 90, 285, 30);
		contentPane.add(comboBoxCategory);

		spinnerQuantity = new JSpinner();
		spinnerQuantity.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerQuantity.setForeground(new Color(255, 215, 0));
		spinnerQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spinnerQuantity.setBounds(364, 131, 60, 30);
		contentPane.add(spinnerQuantity);

		checkBoxSpecials = new JCheckBox(" Specials ");
		checkBoxSpecials.setForeground(new Color(255, 215, 0));
		checkBoxSpecials.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		checkBoxSpecials.setBounds(139, 167, 130, 30);
		contentPane.add(checkBoxSpecials);

		checkBoxStatus = new JCheckBox(" In Of Stock ");
		checkBoxStatus.setForeground(new Color(255, 215, 0));
		checkBoxStatus.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		checkBoxStatus.setBounds(294, 167, 130, 30);
		contentPane.add(checkBoxStatus);

		jLabelQuantity = new JLabel("Quantity :");
		jLabelQuantity.setForeground(new Color(255, 215, 0));
		jLabelQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		jLabelQuantity.setBounds(294, 131, 60, 30);
		contentPane.add(jLabelQuantity);

		jLabelName = new JLabel("Name :");
		jLabelName.setForeground(new Color(255, 215, 0));
		jLabelName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		jLabelName.setBounds(26, 49, 103, 30);
		contentPane.add(jLabelName);

		jLabelCategory = new JLabel("Category :");
		jLabelCategory.setForeground(new Color(255, 215, 0));
		jLabelCategory.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		jLabelCategory.setBounds(26, 90, 103, 30);
		contentPane.add(jLabelCategory);

		jLabelPrice = new JLabel("Price :");
		jLabelPrice.setForeground(new Color(255, 215, 0));
		jLabelPrice.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		jLabelPrice.setBounds(26, 131, 103, 30);
		contentPane.add(jLabelPrice);

		jLabelDescription = new JLabel("Description :");
		jLabelDescription.setForeground(new Color(255, 215, 0));
		jLabelDescription.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		jLabelDescription.setBounds(26, 204, 103, 30);
		contentPane.add(jLabelDescription);

		buttonAdd = new JButton("ADD");
		buttonAdd.addActionListener(a -> jButtonAddAction());
		buttonAdd.setForeground(new Color(255, 215, 0));
		buttonAdd.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		buttonAdd.setBorder(new EmptyBorder(2, 2, 2, 2));
		buttonAdd.setBounds(10, 351, 103, 40);
		contentPane.add(buttonAdd);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 204, 285, 136);
		contentPane.add(scrollPane);

		textAreaDescription = new JTextArea();
		scrollPane.setViewportView(textAreaDescription);
		textAreaDescription.setBorder(new EmptyBorder(5, 10, 5, 10));
		textAreaDescription.setForeground(new Color(255, 215, 0));
		textAreaDescription.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textAreaDescription.setLineWrap(true);
		textAreaDescription.setWrapStyleWord(true);

		jButtonUpdate = new JButton("UPDATE");
		jButtonUpdate.addActionListener(a -> jButtonUpdateAction());
		jButtonUpdate.setForeground(new Color(255, 215, 0));
		jButtonUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jButtonUpdate.setBorder(new EmptyBorder(2, 2, 2, 2));
		jButtonUpdate.setBounds(10, 351, 103, 40);
		contentPane.add(jButtonUpdate);

		spinnerPrice = new JSpinner();
		spinnerPrice.setModel(new SpinnerNumberModel(new Long(0), new Long(0), null, new Long(100)));
		spinnerPrice.setForeground(new Color(255, 215, 0));
		spinnerPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spinnerPrice.setBounds(139, 131, 130, 30);
		contentPane.add(spinnerPrice);
	}

	// Load data when this frame run

	protected void loadProduct(int productID) {
		Product product = new ProductDAO().find(productID);
		textFieldName.setText(product.getName());
		spinnerPrice.setValue(product.getPrice().longValue());
		textAreaDescription.setText(product.getDescription());
		checkBoxSpecials.setSelected(product.getSpecials());
		checkBoxStatus.setSelected(product.getStatus());
		comboBoxCategory.setSelectedItem(product.getCategory().getName());
		labelPhoto.setText("");
		if (null != product.getPhoto()) {
			labelPhoto.setIcon(new ImageIcon(ScaleImage.getImageScaledByByteFile(product.getPhoto(),
					labelPhoto.getWidth() - 20, labelPhoto.getHeight() - 20)));
			labelChooserPhoto.setText("Choose other photo...");
		}
		spinnerQuantity.setValue(product.getQuantity());
		this.productID = productID;

	}

	private void fillDataToComboBox(List<Category> categories) {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		categories.forEach(c -> defaultComboBoxModel.addElement(c.getName()));
		comboBoxCategory.setModel(defaultComboBoxModel);
	}

	// Reset data after add
	protected void resetData() {
		textFieldName.setText("");
		textAreaDescription.setText("");
		spinnerQuantity.setValue(0);
		spinnerPrice.setValue((long) 0);
		labelPhoto.setText("IMAGE");
		labelPhoto.setIcon(null);
		labelChooserPhoto.setText("Choose a photo...");
		comboBoxCategory.setSelectedIndex(0);
		checkBoxSpecials.setSelected(false);
		checkBoxStatus.setSelected(false);
		file = null;
		productID = -1;

	}

	// Events

	protected void jButtonAddAction() {
		try {
			Product product = new Product();
			product.setName(textFieldName.getText());
			product.setCategory(new CategoryDAO().getCategoryByName((String) comboBoxCategory.getSelectedItem()));
			product.setPrice(BigDecimal.valueOf((long) spinnerPrice.getValue()));
			product.setQuantity((int) spinnerQuantity.getValue());
			if (null != file)
				product.setPhoto(ConvertFile.getFileConverted(file.getAbsolutePath()));
			product.setDescription(textAreaDescription.getText());
			product.setSpecials(checkBoxSpecials.isSelected());
			product.setStatus(checkBoxStatus.isSelected());
			new ProductDAO().create(product);
			JOptionPane.showMessageDialog(null, "Added");
			resetData();
			if (null != IFr_ProductList.productList)
				IFr_ProductList.productList.loadData();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fail");
			e.printStackTrace();
		}

	}

	protected void jButtonBrowserAction() {
		JFileChooser jFileChooser = new JFileChooser("C:\\");
		jFileChooser.setDialogTitle("Choose photo :");
		jFileChooser.setMultiSelectionEnabled(false);
		jFileChooser.setFileFilter(new FileTypeFilter(".jpeg", "JPEG"));
		jFileChooser.setFileFilter(new FileTypeFilter(".gif", "GIF"));
		jFileChooser.setFileFilter(new FileTypeFilter(".png", "PNG"));
		jFileChooser.setFileFilter(new FileTypeFilter(".jpg", "JPG"));
		int result = jFileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = jFileChooser.getSelectedFile();
			String path = file.getAbsolutePath();
			ImageIcon imageIcon = new ImageIcon(
					ScaleImage.getImageScaledByPath(path, labelPhoto.getWidth() - 20, labelPhoto.getHeight() - 20));
			labelPhoto.setIcon(imageIcon);
			labelPhoto.setText("");
			labelChooserPhoto.setText(file.getName());
		}
	}

	protected void jButtonUpdateAction() {
		try {
			ProductDAO productDAO = new ProductDAO();
			Product product = productDAO.find(productID);
			product.setName(textFieldName.getText());
			product.setCategory(new CategoryDAO().getCategoryByName((String) comboBoxCategory.getSelectedItem()));
			product.setPrice(BigDecimal.valueOf((long) spinnerPrice.getValue()));
			product.setQuantity((int) spinnerQuantity.getValue());
			if (null != file)
				product.setPhoto(ConvertFile.getFileConverted(file.getAbsolutePath()));
			product.setDescription(textAreaDescription.getText());
			product.setSpecials(checkBoxSpecials.isSelected());
			product.setStatus(checkBoxStatus.isSelected());
			productDAO.update(product);
			JOptionPane.showMessageDialog(null, "Updated");
			resetData();
			this.dispose();
			if (null != IFr_ProductList.productList)
				IFr_ProductList.productList.loadData();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fail");
			e.printStackTrace();
		}
	}

	protected void setActionForm(int action) {
		if (0 == action) {
			jButtonUpdate.setVisible(false);
			buttonAdd.setVisible(true);
			this.setTitle("Add New Product :");
		} else {
			jButtonUpdate.setVisible(true);
			buttonAdd.setVisible(false);
			this.setTitle("Update Product :");
		}
	}

}
