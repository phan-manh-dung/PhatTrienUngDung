package View;

import java.awt.Color;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultRowSorter;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JTabbedPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ConnectDatabase.database;
import DAO.KhachHang_DAO;
import Entity.KhachHang; 
public class ViewKhachHang extends JFrame {
  
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Color colorMenu = new Color(27, 64, 31);
	private JTextField textFieldName;
	private JTextField textFindId;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTable table;
	private JTable tableTK;
	private DefaultTableModel model;
	private DefaultTableModel modelTK;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					database.getInstance().connect();
					ViewKhachHang frame = new ViewKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewKhachHang() {
		KhachHang_DAO khachHangDAO = new KhachHang_DAO();
		List<KhachHang> khachHangs = khachHangDAO.getAllKhachHang();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color backgroundColor = new Color(239, 198, 87);
		JPanel pnlLoGo = new JPanel();
		pnlLoGo.setBounds(0, 0, 1239, 90);
		pnlLoGo.setBackground(new Color(210, 105, 30));
		contentPane.add(pnlLoGo);
		pnlLoGo.setLayout(null);
		// tiêu đề trên
		JLabel lblLoGo = new JLabel("TT SHOP");
		lblLoGo.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblLoGo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoGo.setBounds(594, 21, 148, 44);
		pnlLoGo.add(lblLoGo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 87, 199, 676);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		// các button bên trái
		JButton btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setForeground(Color.WHITE);
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnDangXuat.setBounds(10, 161, 85, 35);
		panel_1.add(btnDangXuat);
		btnDangXuat.setBackground(colorMenu);
		btnDangXuat.setFocusPainted(false);
		
		JButton btnCaNhan = new JButton("Cá Nhân");
		btnCaNhan.setForeground(Color.WHITE);
		btnCaNhan.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnCaNhan.setBounds(105, 161, 85, 35);
		btnCaNhan.setBackground(colorMenu);
		btnCaNhan.setFocusPainted(false);
		
		panel_1.add(btnCaNhan);
		
		JLabel lblNewLabel = new JLabel("Hồ Vĩnh Duy");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 206, 199, 25);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quản Lý");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 241, 199, 21);
		panel_1.add(lblNewLabel_1);
		
		JButton btnHoaDon = new JButton("Hoá Đơn");
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHoaDon.setBounds(0, 325, 199, 35);
		panel_1.add(btnHoaDon);
		btnHoaDon.setBackground(colorMenu);
		btnHoaDon.setForeground(Color.WHITE);
		btnHoaDon.setFocusPainted(false);
		
		JButton btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNhanVien.setBounds(0, 370, 199, 35);
		panel_1.add(btnNhanVien);
		btnNhanVien.setBackground(colorMenu);
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setFocusPainted(false);
		
		JButton btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnKhachHang.setBounds(0, 415, 199, 35);
		panel_1.add(btnKhachHang);
		btnKhachHang.setForeground(Color.BLACK);
		btnKhachHang.setFocusPainted(false);
		
		JButton btnSanPham = new JButton("Sản Phẩm");
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSanPham.setBounds(0, 460, 199, 35);
		panel_1.add(btnSanPham);
		btnSanPham.setBackground(colorMenu);
		btnSanPham.setForeground(Color.WHITE);
		btnSanPham.setFocusPainted(false);
		
		// phần ảnh ảnh dại diện
		JPanel pnlanhdaidien = new JPanel() {
			@Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);

		        int width = getWidth();
		        int height = getHeight();

		        // Tạo hình tròn
		        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, width, height);

		        // Làm cho góc của hình tròn trở nên bo tròn
		        Graphics2D g2d = (Graphics2D) g;
		        g2d.setClip(circle);

		        // Vẽ hình ảnh
		        ImageIcon icon = new ImageIcon(".\\IMG\\avatar.png");
		        Image img = icon.getImage();
		        g2d.drawImage(img, 0, 0, width, height, this);
		    }
		};
		pnlanhdaidien.setBounds(31, 10, 140, 140);
		pnlanhdaidien.setBackground(Color.ORANGE);
		panel_1.add(pnlanhdaidien);
		
		// tab menu khách hàng
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(201, 91, 983, 658);
		contentPane.add(tabbedPane);
		JPanel panel = new JPanel();
		tabbedPane.addTab("Khách Hàng ", null, panel, null);
		panel.setLayout(null);
		
		// tab menu thống kê
		JTabbedPane tabbedPane2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(201, 91, 983, 658);
		contentPane.add(tabbedPane);
		JPanel panel_thongKe = new JPanel();
		tabbedPane.addTab("Thống kê", null, panel_thongKe, null);
		panel_thongKe.setLayout(null);
		
		// combobox 
		JComboBox cbx_TK = new JComboBox();
		String choiceTK[] = {"Thống kê theo","Ngày","Tháng","Năm"};
		for(String cbx: choiceTK) {
			cbx_TK.addItem(cbx);
		}
		cbx_TK.setBounds(29, 24, 151, 22);
		panel_thongKe.add(cbx_TK);
		
		JLabel lblSoLuongKH = new JLabel("Chọn số lượng khách hàng");
		lblSoLuongKH.setBounds(29, 75, 182, 22);
		panel_thongKe.add(lblSoLuongKH);
		
		txtSoLuongKH = new JTextField();
		txtSoLuongKH.setBounds(221, 76, 103, 20);
		panel_thongKe.add(txtSoLuongKH);
		txtSoLuongKH.setColumns(10);
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setBackground(new Color(0, 255, 0));
		btnThongKe.setBounds(462, 75, 89, 23);
		panel_thongKe.add(btnThongKe);
		
		JButton btnXuatTK = new JButton("Xuất thống kê");
		btnXuatTK.setBackground(Color.GREEN);
		btnXuatTK.setBounds(813, 24, 127, 32);
		panel_thongKe.add(btnXuatTK);
		
		// chart của thống kê khách hàng
		
		JPanel panel_chart = new JPanel();
		panel_chart.setBounds(515, 128, 453, 374);
		panel_thongKe.add(panel_chart);
		
		   // Tạo bộ dữ liệu cho biểu đồ
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Category 1", "Value 1");
        dataset.addValue(20, "Category 2", "Value 2");
        dataset.addValue(15, "Category 3", "Value 3");

        // Tạo biểu đồ
        JFreeChart chart = ChartFactory.createBarChart(
                "Biểu đồ Hình Khối",
                "Danh mục",
                "Giá trị",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Tạo một ChartPanel để hiển thị biểu đồ
        ChartPanel chartPanel = new ChartPanel(chart);

        // Thêm ChartPanel vào panel_Chart
        panel_chart.add(chartPanel);
				
		
		// table thống kê khách hàng
		
		String rowTK[] = { "Mã Nhân Viên", "Tên Nhân Viên", "Hóa đơn đã lập" };
		model = new DefaultTableModel(rowTK, 0);
		String row1TK[] = { "NV001", "Dũng", "34" };
		model.addRow(row1TK);

		// xét màu cho hàng
		table = new JTable(model) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				// Đặt màu nền cho các dòng (trừ header)
				if (!isRowSelected(row)) {
					component.setBackground(row % 2 == 1 ? Color.WHITE : Color.LIGHT_GRAY); // Màu nền xen kẽ
				}
				return component;
			}
		};

		JScrollPane scrollPane1 = new JScrollPane(table);
		scrollPane1.setBounds(34, 134, 453, 368);
		panel_thongKe.add(scrollPane1);
		
		JLabel lblNewLabel_3 = new JLabel("Danh sách khách hàng có tổng tiền cao nhất");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(95, 540, 357, 22);
		panel_thongKe.add(lblNewLabel_3);
		
			
		/// các filter lọc củ khách hàng
		JLabel lblFilter = new JLabel("Lọc");
		lblFilter.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFilter.setBounds(10, 38, 49, 14);
		panel.add(lblFilter);
		
		// chooose filter
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(51, 35, 179, 22);
		panel.add(comboBox);
		String[] filter = { "Lọc Giới tính", "Nam", "Nữ" };
		for (String choice : filter) {
			comboBox.addItem(choice);
		}
		
		// label tìm tên
		JLabel lblFindName = new JLabel("Tìm theo tên");
		lblFindName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFindName.setBounds(270, 38, 92, 14);
		panel.add(lblFindName);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBackground((Color) null);
		// Lấy border mặc định
		Border border1 = textFieldName.getBorder();
		// Tạo border chỉ có dưới
		Border newBorder1 = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
		// Set border mới
		textFieldName.setBorder(newBorder1);
		textFieldName.setBounds(372, 38, 168, 20);
		panel.add(textFieldName);
		
		JLabel lblFindId = new JLabel("Tìm theo mã");
		lblFindId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFindId.setBounds(577, 38, 92, 14);
		panel.add(lblFindId);
		
		textFindId = new JTextField();
		textFindId.setColumns(10);
		textFindId.setBackground((Color) null);
		// Lấy border mặc định
		Border border = textFindId.getBorder();
		// Tạo border chỉ có dưới
		Border newBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
		// Set border mới
		textFindId.setBorder(newBorder);
		textFindId.setBounds(691, 36, 185, 20);
		panel.add(textFindId);
		
		// phần add khách hàng
		JPanel panel_KH = new JPanel();
		panel_KH.setLayout(null);
		panel_KH.setBounds(604, 86, 364, 533);
		panel.add(panel_KH);
		
		JLabel lblName = new JLabel("Họ Tên");
		lblName.setBounds(31, 119, 89, 14);
		panel_KH.add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(131, 116, 204, 20);
		panel_KH.add(txtName);
		
		// giới tính
		JLabel lblSex = new JLabel("Giới tính");
		lblSex.setBounds(31, 193, 89, 14);
		panel_KH.add(lblSex);
		
		JRadioButton rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setBounds(131, 189, 66, 23);
		panel_KH.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setBounds(206, 189, 66, 23);
		panel_KH.add(rdbtnFemale);
		
		ButtonGroup gioiTinh = new ButtonGroup();
		gioiTinh.add(rdbtnMale);
		gioiTinh.add(rdbtnFemale);
		
		// so điên thoại
		JLabel lblPhone = new JLabel("Số điện thoại");
		lblPhone.setBounds(31, 156, 89, 14);
		panel_KH.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(131, 153, 204, 20);
		panel_KH.add(txtPhone);
		
		JLabel lblAddress = new JLabel("Địa chỉ");
		lblAddress.setBounds(31, 227, 89, 14);
		panel_KH.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(131, 224, 204, 20);
		panel_KH.add(txtAddress);
		
		JButton btnConfirm = new JButton("Xác nhận");
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setBackground(Color.GREEN);
		btnConfirm.setBounds(131, 291, 99, 40);
		panel_KH.add(btnConfirm);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(10, 369, 99, 40);
		panel_KH.add(btnAdd);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBounds(131, 369, 99, 40);
		panel_KH.add(btnCancel);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(255, 369, 99, 40);
		panel_KH.add(btnDelete);
		
		// table
		String row[] = { "Mã Khách Hàng", "Họ Tên", "SDT", "Địa chỉ", "Giới tính" };
		model = new DefaultTableModel(row, 0);
		// xét màu cho hàng
		table = new JTable(model) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				// Đặt màu nền cho các dòng (trừ header)
				if (!isRowSelected(row)) {
					component.setBackground(row % 2 == 1 ? Color.WHITE : Color.LIGHT_GRAY); // Màu nền xen kẽ
				}
				return component;
			}
		};
		
		for (KhachHang khachHang : khachHangs) {
			String gioiTinh1 = khachHang.isGioiTinh() ? "Nam" : "Nữ";
		    model.addRow(new Object[]{
		        khachHang.getMaKhachHang(),
		        khachHang.getHoTen(),
		        khachHang.getSoDienThoai(),
		        khachHang.getDiaChi(),
		        gioiTinh1
		    });
		}
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 86, 594, 533);
		panel.add(scrollPane);
		
		// thêm data vào bảng table ------------------------
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lấy thông tin từ các trường nhập
				String maKH = "KH" + ViewKhachHang.hamTang(); // Điền mã KH theo logic của bạn
				String hoTen = txtName.getText();
				String sdt = txtPhone.getText();
				String diaChi = txtAddress.getText();
				String gioiTinh = rdbtnMale.isSelected() ? "Nam" : "Nữ";
				// Tạo một mảng chứa thông tin mới
				String newRow[] = { maKH, hoTen, sdt, diaChi, gioiTinh };
				// Thêm hàng mới vào bảng
				model.addRow(newRow);
				// Xóa nội dung các trường nhập
				txtName.setText("");
				txtPhone.setText("");
				txtAddress.setText("");
			}
		});
		// sửa dữ liệu trong bảng table
		btnConfirm.addActionListener((new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Lấy dòng được chọn trong bảng
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					String hoTen = txtName.getText();
					String sdt = txtPhone.getText();
					String diaChi = txtAddress.getText();
					String gioiTinh = rdbtnMale.isSelected() ? "Nam" : (rdbtnFemale.isSelected() ? "Nữ" : "");
					// Cập nhật dữ liệu trong bảng
					table.setValueAt(hoTen, selectedRow, 1);
					table.setValueAt(sdt, selectedRow, 2);
					table.setValueAt(diaChi, selectedRow, 3);
					table.setValueAt(gioiTinh, selectedRow, 4);
				} else {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn một dòng để sửa.", "Lỗi", selectedRow);
				}
			}
		}));
		// xóa khách hàng
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int confirm = JOptionPane.showConfirmDialog(contentPane, "Bạn có chắc chắn xóa");
					if (confirm == JOptionPane.YES_OPTION) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.removeRow(selectedRow);
						// xóa trong text
						txtName.setText("");
						txtPhone.setText("");
						txtAddress.setText("");
						gioiTinh.clearSelection();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn một dòng để xóa.", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
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

					txtName.setText(hoTen);
					txtPhone.setText(sdt);
					txtAddress.setText(diaChi);
					if (gioiTinh.equals("Nam")) {
						rdbtnMale.setSelected(true);
					} else if (gioiTinh.equals("Nữ")) {
						rdbtnFemale.setSelected(true);
					}
				}
			}
		});
		
		//---------------------------------
		
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
		
		// Code xu ly su kien
		btnHoaDon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Object o = e.getSource();
		    	if(o.equals(btnHoaDon)) {
		    		ViewHoaDon hd = new ViewHoaDon();
		            hd.setLocationRelativeTo(null);
		            hd.setVisible(true);
		            dispose();
		        }
		       
		    }
		});
		
		btnNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Object o = e.getSource();
		    	if(o.equals(btnNhanVien)) {
		    		ViewNhanVien1 nv = new ViewNhanVien1();
		    		nv.setLocationRelativeTo(null);
		    		nv.setVisible(true);
		            dispose();
		        }
		       
		    }
		});
		
		btnSanPham.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Object o = e.getSource();
		    	if(o.equals(btnSanPham)) {
		    		ViewSanPham sp = new ViewSanPham();
		    		sp.setLocationRelativeTo(null);
		    		sp.setVisible(true);
		            dispose();
		        }
		       
		    }
		});
	}
	static int count = 1;
	private JTextField txtSoLuongKH;
	private JTable table_1;
	static int hamTang() {
	    for (int i = 1; i < 100; i++) {
	        count++;
	    }
	    return count;
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

