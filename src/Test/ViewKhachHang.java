package Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultRowSorter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JRadioButton;

public class ViewKhachHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFindId;
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtKh;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textAddress;
	private ButtonGroup gioiTinh;

	private LoginInfo loginInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					ViewKhachHang frame = new ViewKhachHang(LoginInfo loginInfo);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewKhachHang(LoginInfo loginInfo) {
		// lấy thông tin loginInfo
		this.loginInfo = loginInfo; //phân biệt loginInfo ngoài với biến login nhận tham số
	    String role = loginInfo.getLoginRole();
	    //
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color backgroundColor = new Color(239, 198, 87);
		JPanel pnlLoGo = new JPanel();
		pnlLoGo.setBounds(0, 0, 1186, 90);
		pnlLoGo.setBackground(backgroundColor);
		contentPane.add(pnlLoGo);
		pnlLoGo.setLayout(null);

		JLabel lblLoGo = new JLabel("TT SHOP");
		lblLoGo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLoGo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoGo.setBounds(594, 21, 148, 44);
		pnlLoGo.add(lblLoGo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(-15, 87, 199, 625);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(60, 24, 90, 80);
		panel_1.add(panel);

		JButton btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setBounds(9, 118, 85, 21);
		panel_1.add(btnDangXuat);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(104, 118, 85, 21);
		panel_1.add(btnNewButton_1);

		JLabel lblNhanVien = new JLabel("Tên Nhân Viên");
		lblNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhanVien.setBounds(49, 162, 101, 13);
		panel_1.add(lblNhanVien);

		JLabel lblChucVu = new JLabel("Chức Vụ");
		lblChucVu.setBounds(82, 184, 45, 13);
		panel_1.add(lblChucVu);

		JButton btnBanHang = new JButton("Bán Hàng ");
		btnBanHang.setBounds(20, 297, 169, 21);
		panel_1.add(btnBanHang);

		JButton btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.setBounds(20, 338, 169, 21);
		panel_1.add(btnNhanVien);

		JButton btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.setBounds(20, 376, 169, 21);
		panel_1.add(btnKhachHang);

		JButton btnSanPham = new JButton("Sản Phẩm");
		btnSanPham.setBounds(20, 419, 169, 21);
		panel_1.add(btnSanPham);

//		// menu bar
//		JPanel panel_2 = new JPanel();
//		panel_2.setBounds(182, 87, 1004, 40);
//		contentPane.add(panel_2);
//		panel_2.setLayout(null);
//
//		JMenuBar menuBar = new JMenuBar();
//		JMenu mnKhachHang = new JMenu("Khách hàng");
//		// Tạo menu Thống kê
//		JMenu mnThongKe = new JMenu("Thống kê");
//		// Thêm menu vào menu bar
//		menuBar.add(mnKhachHang);
//		menuBar.add(mnThongKe);
//		// Thêm menu bar vào frame
//		menuBar.setBounds(115, 11, 106, 23);
//		setJMenuBar(menuBar);
//		panel_2.add(menuBar);

		// filter
		JLabel lblFilter = new JLabel("Lọc");
		lblFilter.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFilter.setBounds(207, 138, 49, 14);
		contentPane.add(lblFilter);

		// chooose filter
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(248, 135, 179, 22);
		contentPane.add(comboBox);
		String[] filter = { "Lọc Giới tính", "Nam", "Nữ" };
		for (String choice : filter) {
			comboBox.addItem(choice);
		}

		// label tìm tên
		JLabel lblFindName = new JLabel("Tìm theo tên");
		lblFindName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFindName.setBounds(467, 138, 92, 14);
		contentPane.add(lblFindName);

		textFieldName = new JTextField();
		textFieldName.setBounds(569, 138, 168, 20);
		textFieldName.setBackground(null);
		// Lấy border mặc định
		Border border1 = textFieldName.getBorder();
		// Tạo border chỉ có dưới
		Border newBorder1 = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
		// Set border mới
		textFieldName.setBorder(newBorder1);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		// label tìm mã
		JLabel lblFindId = new JLabel("Tìm theo mã");
		lblFindId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFindId.setBounds(774, 138, 92, 14);
		contentPane.add(lblFindId);

		textFindId = new JTextField();
		textFindId.setColumns(10);
		textFindId.setBounds(888, 136, 185, 20);
		
		textFindId.setBackground(null);
		// Lấy border mặc định
		Border border = textFindId.getBorder();
		// Tạo border chỉ có dưới
		Border newBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
		// Set border mới
		textFindId.setBorder(newBorder);
		contentPane.add(textFindId);

		// phần add khách hàng
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(636, 163, 364, 533);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblName = new JLabel("Họ Tên");
		lblName.setBounds(31, 119, 89, 14);
		panel_3.add(lblName);

		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(131, 116, 204, 20);
		panel_3.add(textName);

		// giới tính
		JLabel lblSex = new JLabel("Giới tính");
		lblSex.setBounds(31, 193, 89, 14);
		panel_3.add(lblSex);

		JRadioButton rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setBounds(131, 189, 66, 23);
		panel_3.add(rdbtnMale);

		JRadioButton rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setBounds(206, 189, 66, 23);
		panel_3.add(rdbtnFemale);

		ButtonGroup gioiTinh = new ButtonGroup();
		gioiTinh.add(rdbtnMale);
		gioiTinh.add(rdbtnFemale);

		// so điên thoại
		JLabel lblPhone = new JLabel("Số điện thoại");
		lblPhone.setBounds(31, 156, 89, 14);
		panel_3.add(lblPhone);

		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(131, 153, 204, 20);
		panel_3.add(textPhone);
		// address
		JLabel lblAddress = new JLabel("Địa chỉ");
		lblAddress.setBounds(31, 227, 89, 14);
		panel_3.add(lblAddress);

		textAddress = new JTextField();

		textAddress.setColumns(10);
		textAddress.setBounds(131, 224, 204, 20);
		panel_3.add(textAddress);

		// confirm
		JButton btnConfirm = new JButton("Xác nhận");
		btnConfirm.setBounds(131, 291, 99, 40);
		// Đặt màu nền cho button
		btnConfirm.setBackground(Color.GREEN);
		btnConfirm.setContentAreaFilled(false);
		panel_3.add(btnConfirm);

		// add
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(10, 369, 99, 40);
		panel_3.add(btnAdd);
		// cancel
		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBounds(131, 369, 99, 40);
		panel_3.add(btnCancel);
		// delete
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(255, 369, 99, 40);
		panel_3.add(btnDelete);
		// table

//		String row[] = { "Mã Khách Hàng", "Họ Tên", "SDT", "Địa chỉ", "Giới tính" };
//
//		model = new DefaultTableModel(row, 0);
//		model.addRow(row);
//		String row1[] = { "KH001", "Dũng", "034343", "12-QuangTrung", "Nữ" };
//		model.addRow(row1);
//		String row2[] = { "KH001", "Dũng", "034343", "12-QuangTrung", "Nam" };
//		model.addRow(row2);
//		String row3[] = { "KH002", "Hoang", "034343", "12-QuangTrung", "Nam" };
//		model.addRow(row3);
//		String row4[] = { "KH001", "Thái", "034343", "12-QuangTrung", "Nữ" };
//		model.addRow(row4);
//		// xét màu cho hàng
//		table = new JTable(model) {
//			@Override
//			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
//				Component component = super.prepareRenderer(renderer, row, column);
//				// Đặt màu nền cho các dòng (trừ header)
//				if (!isRowSelected(row)) {
//					component.setBackground(row % 2 == 1 ? Color.WHITE : Color.LIGHT_GRAY); // Màu nền xen kẽ
//				}
//				if (!isRowSelected(row)) { // căn giữa nội dung table
//					((DefaultTableCellRenderer) component).setHorizontalAlignment(SwingConstants.CENTER);
//				}
//				return component;
//			}
//		};
//		table.setBounds(182, 168, 639, 532);
//		JScrollPane pane = new JScrollPane(table);
//		contentPane.add(table);
//		contentPane.add(pane);
//		// thêm data vào bảng table
//		btnAdd.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// Lấy thông tin từ các trường nhập
//				String maKH = "KH" + ViewKhachHang.hamTang(); // Điền mã KH theo logic của bạn
//				String hoTen = textName.getText();
//				String sdt = textPhone.getText();
//				String diaChi = textAddress.getText();
//				String gioiTinh = rdbtnMale.isSelected() ? "Nam" : "Nữ";
//				// Tạo một mảng chứa thông tin mới
//				String newRow[] = { maKH, hoTen, sdt, diaChi, gioiTinh };
//				// Thêm hàng mới vào bảng
//				model.addRow(newRow);
//				// Xóa nội dung các trường nhập
//				textName.setText("");
//				textPhone.setText("");
//				textAddress.setText("");
//			}
//		});
//		// sửa dữ liệu trong bảng table
//		btnConfirm.addActionListener((new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				// Lấy dòng được chọn trong bảng
//				int selectedRow = table.getSelectedRow();
//				if (selectedRow != -1) {
//					String hoTen = textName.getText();
//					String sdt = textPhone.getText();
//					String diaChi = textAddress.getText();
//					String gioiTinh = rdbtnMale.isSelected() ? "Nam" : (rdbtnFemale.isSelected() ? "Nữ" : "");
//					// Cập nhật dữ liệu trong bảng
//					table.setValueAt(hoTen, selectedRow, 1);
//					table.setValueAt(sdt, selectedRow, 2);
//					table.setValueAt(diaChi, selectedRow, 3);
//					table.setValueAt(gioiTinh, selectedRow, 4);
//				} else {
//					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn một dòng để sửa.", "Lỗi", selectedRow);
//				}
//			}
//		}));
//		// xóa khách hàng
//		btnDelete.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int selectedRow = table.getSelectedRow();
//				if (selectedRow != -1) {
//					int confirm = JOptionPane.showConfirmDialog(contentPane, "Bạn có chắc chắn xóa");
//					if (confirm == JOptionPane.YES_OPTION) {
//						DefaultTableModel model = (DefaultTableModel) table.getModel();
//						model.removeRow(selectedRow);
//						// xóa trong text
//						textName.setText("");
//						textPhone.setText("");
//						textAddress.setText("");
//						gioiTinh.clearSelection();
//					}
//				} else {
//					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn một dòng để xóa.", "Lỗi",
//							JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		});
		// filter dữ liệu
		// sorter đang null thiết lập RowSorter để sắp xếp và lọc dữ liệu trong JTable
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
		table.setRowSorter(sorter);

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedFilter = (String) comboBox.getSelectedItem();

				if (selectedFilter != null && sorter != null) {

					if (selectedFilter.equals("Nam")) {
						sorter.setRowFilter(RowFilter.regexFilter("Nam", 4)); // Lọc theo cột "Giới tính"
					} else if (selectedFilter.equals("Nữ")) {
						sorter.setRowFilter(RowFilter.regexFilter("Nữ", 4)); // Lọc theo cột "Giới tính"
					} else {
						sorter.setRowFilter(null); // Hủy bỏ bất kỳ bộ lọc nào
					}
				}
			}
		});

		// tìm theo mã khách hàng

		textFindId.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				search();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				search();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});

		// tìm theo tên khách hàng

		textFieldName.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				searchByName();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				searchByName();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});

		// click vào bảng cập nhật dữ liệu lên text
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) { // Đảm bảo đã chọn một dòng
					String maKh = (String) table.getValueAt(selectedRow, 0);
					String hoTen = (String) table.getValueAt(selectedRow, 1);
					String sdt = (String) table.getValueAt(selectedRow, 2);
					String diaChi = (String) table.getValueAt(selectedRow, 3);
					String gioiTinh = (String) table.getValueAt(selectedRow, 4);

					// Hiển thị dữ liệu lên các trường nhập và radio button

					textName.setText(hoTen);
					textPhone.setText(sdt);
					textAddress.setText(diaChi);
					if (gioiTinh.equals("Nam")) {
						rdbtnMale.setSelected(true);
					} else if (gioiTinh.equals("Nữ")) {
						rdbtnFemale.setSelected(true);
					}
				}
			}
		});
		// xử lí sự kiện
		btnNhanVien.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (role.equals("admin")) {
					JOptionPane.showMessageDialog(contentPane, "Bạn đang là admin");
				}
				if (role.equals("nv")) {
					JOptionPane.showMessageDialog(contentPane, "Bạn đang là nv");
				}

			}
		});

	}

	// mã tăng tự động
	private static int maKh = 0;

	public static int hamTang() {
		maKh++;
		return maKh;
	}

	// search của mã
	private void search() {
		DefaultRowSorter<DefaultTableModel, Integer> sorter = (DefaultRowSorter<DefaultTableModel, Integer>) table
				.getRowSorter();
		TableRowSorter<? extends TableModel> rowSorter = (TableRowSorter<? extends TableModel>) sorter;
		String textToSearch = textFindId.getText();

		if (textToSearch.trim().length() == 0) {
			rowSorter.setRowFilter(null); // Hủy bỏ bộ lọc nếu trường tìm kiếm rỗng
		} else {
			// Lọc dựa trên nội dung của trường tìm kiếm và chỉ hiển thị các dòng thỏa mãn
			rowSorter.setRowFilter(RowFilter.regexFilter(textToSearch, 0)); // Tìm kiếm trong cột "Mã Khách Hàng" (cột
																			// 0)
		}
	}

	// search của ten
	private void searchByName() {
		DefaultRowSorter<DefaultTableModel, Integer> sorter = (DefaultRowSorter<DefaultTableModel, Integer>) table
				.getRowSorter();
		TableRowSorter<? extends TableModel> rowSorter = (TableRowSorter<? extends TableModel>) sorter;
		String nameToSearch = textFieldName.getText();

		if (nameToSearch.trim().length() == 0) {
			rowSorter.setRowFilter(null); // Hủy bỏ bộ lọc nếu trường tìm kiếm rỗng
		} else {
			// Lọc dựa trên nội dung của trường tìm kiếm và chỉ hiển thị các dòng thỏa mãn
			rowSorter.setRowFilter(RowFilter.regexFilter(nameToSearch, 1)); // Tìm kiếm trong cột "Họ Tên" (cột 1)
		}
	}

}