package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JOptionPane;

import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JRadioButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ConnectDatabase.database;
import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import Entity.KhachHang;
import Entity.NhanVien; 
public class ViewNhanVien1 extends JFrame {
	private Color colorMenu = new Color(27, 64, 31);
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtKh;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textAddress;
	private ButtonGroup gioiTinh;

	private JTextField textFieldName;
	private JTextField textFindId;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtChucVu;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	
					ViewNhanVien1 frame = new ViewNhanVien1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	
			}
		});
	}

	public ViewNhanVien1() {

		NhanVien_DAO nhanVienDao = new NhanVien_DAO();
		List<NhanVien> nhanViens = nhanVienDao.getAllNhanVien();
		
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

		JLabel lblLoGo = new JLabel("TT SHOP");
		lblLoGo.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblLoGo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoGo.setBounds(594, 21, 148, 44);
		pnlLoGo.add(lblLoGo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 87, 199, 613);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

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
		btnNhanVien.setForeground(Color.BLACK);
		btnNhanVien.setFocusPainted(false);

		JButton btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnKhachHang.setBounds(0, 415, 199, 35);
		panel_1.add(btnKhachHang);
		btnKhachHang.setBackground(colorMenu);
		btnKhachHang.setForeground(Color.WHITE);
		btnKhachHang.setFocusPainted(false);

		JButton btnSanPham = new JButton("Sản Phẩm");
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSanPham.setBounds(0, 460, 199, 35);
		panel_1.add(btnSanPham);
		btnSanPham.setBackground(colorMenu);
		btnSanPham.setForeground(Color.WHITE);
		btnSanPham.setFocusPainted(false);

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

		// tab menu
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(201, 91, 983, 658);
		contentPane.add(tabbedPane);
		JPanel panel_khachHang = new JPanel();
		tabbedPane.addTab("Khách Hàng", null, panel_khachHang, null);
		panel_khachHang.setLayout(null);

		// tab menu thống kê
		JTabbedPane tabbedPane2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(201, 91, 983, 658);
		contentPane.add(tabbedPane);
		JPanel panel_thongKe = new JPanel();
		tabbedPane.addTab("Thống kê", null, panel_thongKe, null);
		panel_thongKe.setLayout(null);

		JComboBox comboBox_1 = new JComboBox();
		String[] choice1 = { "Xuất hóa đơn", "Theo ngày", "Theo tháng", "Theo năm" };
		for (String dataCbx : choice1) {
			comboBox_1.addItem(dataCbx);
		}
		comboBox_1.setBounds(34, 21, 141, 22);
		panel_thongKe.add(comboBox_1);

		JButton btnNewButton = new JButton("Thống kê");
		btnNewButton.setBounds(389, 15, 121, 28);
		panel_thongKe.add(btnNewButton);
		JButton btnXutThngK = new JButton("Xuất thống kê");
		btnXutThngK.setBounds(810, 15, 121, 28);
		panel_thongKe.add(btnXutThngK);

		// panel chart
		JPanel panel_Chart = new JPanel();
		panel_Chart.setBounds(516, 125, 439, 377);
		panel_thongKe.add(panel_Chart);
		panel_khachHang.setLayout(null);

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
        panel_Chart.add(chartPanel);

		// table thống kê

		String row[] = { "Mã Nhân Viên", "Tên Nhân Viên", "Hóa đơn đã lập" };
		model = new DefaultTableModel(row, 0);
		String row1[] = { "NV001", "Dũng", "34" };
		model.addRow(row1);
		String row2[] = { "NV002", "Duy", "55" };
		model.addRow(row2);
		String row3[] = { "NV003", "Duy", "85" };
		model.addRow(row3);

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

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(34, 125, 432, 377);
		panel_thongKe.add(scrollPane);

		// title danh sách

		JLabel lblNewLabel_3 = new JLabel("Bảng danh sách hóa đơn đã lập");
		lblNewLabel_3.setForeground(new Color(220, 20, 60));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(137, 518, 202, 28);
		panel_thongKe.add(lblNewLabel_3);

		// button them xoa sua
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(0, 128, 0));
		btnAdd.setBounds(21, 19, 100, 30);
		panel_khachHang.add(btnAdd);

		// chooose filter
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(224, 23, 154, 22);
		panel_khachHang.add(comboBox);

		JLabel lblLoc = new JLabel("Lọc");
		lblLoc.setBounds(172, 27, 38, 14);
		panel_khachHang.add(lblLoc);
		String[] filter = { "Lọc Giới tính", "Nam", "Nữ" };
		for (String choice : filter) {
			comboBox.addItem(choice);
		}
		// label tìm tên
		JLabel lblFindName = new JLabel("Tìm theo tên");
		lblFindName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFindName.setBounds(408, 26, 92, 14);
		panel_khachHang.add(lblFindName);

		textFieldName = new JTextField();
		textFieldName.setBounds(510, 25, 146, 20);
		textFieldName.setColumns(10);

		textFieldName.setBackground(null);
		Border border = textFieldName.getBorder();
		Border newBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
		textFieldName.setBorder(newBorder);
		panel_khachHang.add(textFieldName);
		// label tìm mã
		JLabel lblFindId = new JLabel("Tìm theo mã");
		lblFindId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFindId.setBounds(678, 26, 92, 14);
		panel_khachHang.add(lblFindId);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(null);
		Border border1 = textField_1.getBorder();
		Border newBorder1 = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
		textField_1.setBorder(newBorder1);
		textField_1.setBounds(776, 29, 146, 20);
		panel_khachHang.add(textField_1);

		// panel-----------------------------------------------
		JPanel panel_chua_san_pham = new JPanel();
		panel_chua_san_pham.setBounds(21, 86, 936, 490);
		panel_khachHang.add(panel_chua_san_pham);
		panel_chua_san_pham.setLayout(null);

	//	 for (int i = 1; i <= 10; i++) {
		JPanel panel_NV = new JPanel();
		panel_NV.setBounds(0, 0, 913, 369);
		panel_chua_san_pham.add(panel_NV);
		panel_NV.setLayout(null);

		for(NhanVien nhanVien:nhanViens) {
		String gioiTinh1 = nhanVien.isGioiTinh() ? "Nam" : "Nữ";
			
		JLabel lblNewLabel_2 = new JLabel("ảnh");
		lblNewLabel_2.setBounds(10, 11, 116, 118);
		panel_NV.add(lblNewLabel_2);

		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setBounds(149, 11, 107, 21);
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_NV.add(lblMaNV);

		JLabel lblTenNV = new JLabel("Tên nhân viên");
		lblTenNV.setBounds(149, 50, 107, 21);
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_NV.add(lblTenNV);

		JLabel lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setBounds(149, 90, 107, 21);
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_NV.add(lblChucVu);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(266, 12, 143, 20);
		panel_NV.add(txtMaNV);
		txtMaNV.setColumns(10);

		txtTenNV = new JTextField();
		txtTenNV.setBounds(266, 51, 143, 20);
		txtTenNV.setColumns(10);
		panel_NV.add(txtTenNV);

		txtChucVu = new JTextField();
		txtChucVu.setBounds(266, 91, 143, 20);
		txtChucVu.setColumns(10);
		panel_NV.add(txtChucVu);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setBounds(10, 140, 95, 21);
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_NV.add(lblGioiTinh);

		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setBounds(10, 172, 101, 21);
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_NV.add(lblSDT);

		JLabel lblEmail = new JLabel("Căn cước");
		lblEmail.setBounds(10, 204, 95, 21);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_NV.add(lblEmail);

		txtSDT = new JTextField();
		txtSDT.setBounds(113, 173, 143, 20);
		txtSDT.setColumns(10);
		panel_NV.add(txtSDT);

		txtEmail = new JTextField();
		txtEmail.setBounds(113, 204, 143, 20);
		txtEmail.setColumns(10);
		panel_NV.add(txtEmail);
		
		// Đặt dữ liệu từ nhân viên vào các JTextField
	    txtMaNV.setText(nhanVien.getMaNhanVien());
	    txtTenNV.setText(nhanVien.getTenNhanVien());
	    txtChucVu.setText(nhanVien.getChucVu());
	    txtSDT.setText(nhanVien.getSoDienThoai());
	    txtEmail.setText(nhanVien.getCanCuoc());
		}
		// kết thúc for
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(301, 152, 108, 31);
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.setBackground(new Color(255, 215, 0));
		panel_NV.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(301, 205, 108, 31);
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(255, 0, 0));
		panel_NV.add(btnXoa);

		JButton btnReset = new JButton("Reset Pass");
		btnReset.setBounds(301, 258, 108, 31);
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(50, 205, 50));
		panel_NV.add(btnReset);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setBounds(105, 136, 69, 23);
		panel_NV.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnN = new JRadioButton("Nữ");
		rdbtnN.setBounds(187, 136, 69, 23);
		panel_NV.add(rdbtnN);
		
		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgySinh.setBounds(10, 236, 95, 21);
		panel_NV.add(lblNgySinh);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(113, 235, 143, 20);
		panel_NV.add(textField_2);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblaCh.setBounds(10, 268, 95, 21);
		panel_NV.add(lblaCh);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(113, 269, 143, 20);
		panel_NV.add(textField_3);
	//	 }
		//------------------------------
		/// một nhân viên
		// chèn avatar
		// try {
//			BufferedImage image = ImageIO.read(new File(".\\IMG\\avatar.png"));
//			BufferedImage resizedImage = new BufferedImage(labelWidth, labelHeight, image.getType());	
//			Graphics2D g = resizedImage.createGraphics();	
//			g.drawImage(image, 0, 0, labelWidth, labelHeight, null);
//			g.dispose();	
//			ImageIcon icon = new ImageIcon(resizedImage);

		// sự kiện add nhân viên
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewAddNhanVien viewNV = new ViewAddNhanVien();
				viewNV.setLocationRelativeTo(null);
				viewNV.setVisible(true);
			}
		});

		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnKhachHang)) {
					ViewKhachHang hd = new ViewKhachHang();
					hd.setLocationRelativeTo(null);
					hd.setVisible(true);
					dispose();
				}

			}
		});

		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnHoaDon)) {
					ViewHoaDon hd = new ViewHoaDon();
					hd.setLocationRelativeTo(null);
					hd.setVisible(true);
					dispose();
				}

			}
		});

		btnSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnSanPham)) {
					ViewSanPham sp = new ViewSanPham();
					sp.setLocationRelativeTo(null);
					sp.setVisible(true);
					dispose();
				}

			}
		});

//		}catch(IOException e) {
//			e.printStackTrace();

	}
}
