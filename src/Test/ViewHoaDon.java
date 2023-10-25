package Test;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

public class ViewHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMaKH;
	private JTextField textFieldHoTen;
	private JTextField textFieldGioiTinh;
	private JTextField textFieldNgaySinh;
	private JTextField txtHd;
	private JTextField textFieldMaNV;
	private JTextField textFieldTenNV;
	private JTextField textFieldNgayLapHD;
	private JTable tableSanPham;
	private DefaultTableModel modelSanPham;
	private JTextField textFieldTimTheoTen;
	private JTextField textFieldTimTheoMa;
	private JTable tableHoaDon;
	private DefaultTableModel modelHoaDon;
	private JTable tableHDDaLap;
	private DefaultTableModel modelHDDaLap;
	private JTable tableChiTietHD;
	private DefaultTableModel modelChiTietHD;
	private JTextField textFieldSoLuong;
	private JTextField textFieldTongTien;
	private JTextField textField_1;
	private JTextField textFieldMaHD;
	private JTextField textField_MaKH;
	private JTextField textField_TenKH;
	private JTextField textField_NgaySinh;
	private JTextField textField_SDT;
	private JTextField textField_TenNV;
	private JTextField textField_NgayHD;
	private JTextField textFieldTongTien2;
	private JTextField textTimTheoTen;
	private JTextField textTimTheoSDT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewHoaDon frame = new ViewHoaDon();
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
	public ViewHoaDon() {
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
		panel_1.setBounds(-15, 87, 199, 808);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(60, 24, 90, 80);
		panel_1.add(panel);
		
		JButton btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setBounds(9, 118, 101, 21);
		panel_1.add(btnDangXuat);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(114, 118, 85, 21);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Hồ Vĩnh Duy");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(49, 162, 101, 13);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quản Lý");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(60, 185, 68, 13);
		panel_1.add(lblNewLabel_1);
		
		JButton btnBanHang = new JButton("Hoá Đơn");
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
		
		// Code Tab
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(186, 92, 998, 657);
		contentPane.add(tabbedPane);
		
		// Code Tab1
		JPanel panelTab1 = new JPanel();
		tabbedPane.addTab("Lập Hoá Đơn", null, panelTab1, null);
		panelTab1.setLayout(null);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 268, 629);
		panelTab1.add(panelLeft);
		panelLeft.setLayout(null);
		
		JPanel panelThongTinKH = new JPanel();
		panelThongTinKH.setBackground(new Color(255, 255, 204));
		panelThongTinKH.setBounds(10, 11, 254, 292);
		panelLeft.add(panelThongTinKH);
		panelThongTinKH.setLayout(null);
		
		JButton btnThemKH = new JButton("Thêm mới KH ");
		btnThemKH.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnThemKH.setBounds(10, 5, 106, 35);
		panelThongTinKH.add(btnThemKH);
		
		JLabel lblThongTinKH = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblThongTinKH.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinKH.setBounds(37, 51, 166, 39);
		panelThongTinKH.add(lblThongTinKH);
		
		JButton btnTaoHD = new JButton("Tạo Hoá Đơn");
		btnTaoHD.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnTaoHD.setBounds(133, 5, 106, 35);
		panelThongTinKH.add(btnTaoHD);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setBounds(10, 101, 97, 14);
		panelThongTinKH.add(lblSDT);
		
		JComboBox comboBoxSDT = new JComboBox();
		comboBoxSDT.setEditable(true);
		comboBoxSDT.setModel(new DefaultComboBoxModel(new String[] {"123", "123", "3454"}));
		comboBoxSDT.setSelectedIndex(2);
		comboBoxSDT.setBounds(106, 97, 118, 22);
		panelThongTinKH.add(comboBoxSDT);
		
		JLabel lblMaKH = new JLabel("Mã KH:");
		lblMaKH.setBounds(10, 136, 97, 14);
		panelThongTinKH.add(lblMaKH);
		
		JLabel lblHoTen = new JLabel("Họ Tên:");
		lblHoTen.setBounds(10, 167, 97, 14);
		panelThongTinKH.add(lblHoTen);
		
		JLabel lblGioiTnh = new JLabel("Giới Tính:");
		lblGioiTnh.setBounds(10, 198, 97, 14);
		panelThongTinKH.add(lblGioiTnh);
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
		lblNgaySinh.setBounds(10, 232, 97, 14);
		panelThongTinKH.add(lblNgaySinh);
		
		textFieldMaKH = new JTextField();
		textFieldMaKH.setBounds(106, 133, 118, 20);
		panelThongTinKH.add(textFieldMaKH);
		textFieldMaKH.setColumns(10);
		
		textFieldHoTen = new JTextField();
		textFieldHoTen.setColumns(10);
		textFieldHoTen.setBounds(106, 164, 118, 20);
		panelThongTinKH.add(textFieldHoTen);
		
		textFieldGioiTinh = new JTextField();
		textFieldGioiTinh.setColumns(10);
		textFieldGioiTinh.setBounds(106, 195, 118, 20);
		panelThongTinKH.add(textFieldGioiTinh);
		
		textFieldNgaySinh = new JTextField();
		textFieldNgaySinh.setColumns(10);
		textFieldNgaySinh.setBounds(106, 229, 118, 20);
		panelThongTinKH.add(textFieldNgaySinh);
		
		JPanel panelHD = new JPanel();
		panelHD.setBackground(new Color(255, 255, 204));
		panelHD.setBounds(10, 307, 254, 322);
		panelLeft.add(panelHD);
		panelHD.setLayout(null);
		
		txtHd = new JTextField();
		txtHd.setHorizontalAlignment(SwingConstants.CENTER);
		txtHd.setText("HD202319080001");
		txtHd.setBounds(48, 39, 141, 27);
		panelHD.add(txtHd);
		txtHd.setColumns(10);
		
		JLabel lblMaNV = new JLabel("Mã Nhân Viên:");
		lblMaNV.setBounds(10, 90, 97, 14);
		panelHD.add(lblMaNV);
		
		JLabel lblTenNV = new JLabel("Tên Nhân Viên:");
		lblTenNV.setBounds(10, 135, 97, 14);
		panelHD.add(lblTenNV);
		
		JLabel lblNgayLapHD = new JLabel("Ngày Lập HĐ:");
		lblNgayLapHD.setBounds(10, 179, 97, 14);
		panelHD.add(lblNgayLapHD);
		
		JButton btnHuHd = new JButton("Huỷ HD");
		btnHuHd.setBounds(58, 230, 118, 35);
		panelHD.add(btnHuHd);
		
		textFieldMaNV = new JTextField();
		textFieldMaNV.setColumns(10);
		textFieldMaNV.setBounds(111, 87, 118, 20);
		panelHD.add(textFieldMaNV);
		
		textFieldTenNV = new JTextField();
		textFieldTenNV.setColumns(10);
		textFieldTenNV.setBounds(111, 132, 118, 20);
		panelHD.add(textFieldTenNV);
		
		textFieldNgayLapHD = new JTextField();
		textFieldNgayLapHD.setColumns(10);
		textFieldNgayLapHD.setBounds(111, 176, 118, 20);
		panelHD.add(textFieldNgayLapHD);
		
		JPanel panelRight = new JPanel();
		panelRight.setBounds(273, 0, 720, 629);
		panelTab1.add(panelRight);
		panelRight.setLayout(null);
		
		JPanel panelSanPham = new JPanel();
		panelSanPham.setBackground(new Color(255, 255, 204));
		panelSanPham.setBounds(0, 11, 710, 290);
		panelRight.add(panelSanPham);
		panelSanPham.setLayout(null);
		
		JLabel lblSanPham = new JLabel("SẢN PHẨM");
		lblSanPham.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSanPham.setHorizontalAlignment(SwingConstants.CENTER);
		lblSanPham.setBounds(10, 11, 104, 33);
		panelSanPham.add(lblSanPham);
		
		String row[] = {"Mã Sản Phẩm", "Tên sản phẩm", "Mô tả", "Màu sắc", "Xuất sứ", "Giá bán", "Nhà Cung Cấp"};
		modelSanPham = new DefaultTableModel(row,0);
		String row1[] = {"SP001","Áo Thun Trắng","Áo Thun Trắng","Trắng","Việt Nam","1000","ELISE"};
		modelSanPham.addRow(row1);
		
		tableSanPham = new JTable(modelSanPham);
		
		JScrollPane scrollPane = new JScrollPane(tableSanPham);
		scrollPane.setBounds(10, 55, 573, 224);
		panelSanPham.add(scrollPane);
		
		JLabel lblTimTen = new JLabel("Tìm theo tên:");
		lblTimTen.setBounds(148, 21, 88, 14);
		panelSanPham.add(lblTimTen);
		
		textFieldTimTheoTen = new JTextField();
		textFieldTimTheoTen.setBounds(226, 18, 114, 20);
		panelSanPham.add(textFieldTimTheoTen);
		textFieldTimTheoTen.setColumns(10);
		
		JLabel lblTimMa = new JLabel("Tìm theo mã:");
		lblTimMa.setBounds(371, 21, 88, 14);
		panelSanPham.add(lblTimMa);
		
		textFieldTimTheoMa = new JTextField();
		textFieldTimTheoMa.setColumns(10);
		textFieldTimTheoMa.setBounds(469, 18, 114, 20);
		panelSanPham.add(textFieldTimTheoMa);
		
		JLabel lblChiTiet = new JLabel("CHỌN CHI TIẾT");
		lblChiTiet.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTiet.setBounds(593, 123, 107, 14);
		panelSanPham.add(lblChiTiet);
		
		JLabel lblKichThuoc = new JLabel("Kích thước");
		lblKichThuoc.setBounds(587, 162, 73, 14);
		panelSanPham.add(lblKichThuoc);
		
		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setBounds(587, 203, 54, 14);
		panelSanPham.add(lblSoLuong);
		
		JComboBox comboBoxKichThuoc = new JComboBox();
		comboBoxKichThuoc.setEditable(true);
		comboBoxKichThuoc.setBounds(651, 158, 54, 22);
		panelSanPham.add(comboBoxKichThuoc);
		
		JButton btnThemSP = new JButton("Thêm");
		btnThemSP.setBounds(611, 243, 89, 36);
		panelSanPham.add(btnThemSP);
		
		textFieldSoLuong = new JTextField();
		textFieldSoLuong.setBounds(651, 200, 54, 20);
		panelSanPham.add(textFieldSoLuong);
		textFieldSoLuong.setColumns(10);
		
		JLabel labelIMGSP = new JLabel();
		ImageIcon imageSP = new ImageIcon(".\\IMG\\Áo-Polp-Nam.png");
		labelIMGSP.setIcon(imageSP);
		
		JPanel panelIMGSP = new JPanel();
		panelIMGSP.setBounds(593, 11, 107, 100);
		panelIMGSP.add(labelIMGSP);
		panelSanPham.add(panelIMGSP);
		
		JPanel panelHoaDon = new JPanel();
		panelHoaDon.setLayout(null);
		panelHoaDon.setBackground(new Color(255, 255, 204));
		panelHoaDon.setBounds(0, 306, 710, 323);
		panelRight.add(panelHoaDon);
		
		JLabel lblThongTinHD = new JLabel("<html>THÔNG TIN<br>HOÁ ĐƠN</html>");
		lblThongTinHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThongTinHD.setBounds(0, 31, 97, 39);
		panelHoaDon.add(lblThongTinHD);
		
		String rowHD[] = {"Tên sản phẩm", "Màu sắc", "Đơn vị", "Giá bán", "Kích thước", "Số lượng", "Thành Tiền"};
		modelHoaDon = new DefaultTableModel(rowHD,0);
		String rowHD1[] = {"Áo Thun Trắng","Trắng","Cái","147.000 VND","5","1","147.000 VND"};
		modelHoaDon.addRow(rowHD1);
		
		tableHoaDon = new JTable(modelHoaDon);
		
		JScrollPane scrollPaneHD = new JScrollPane(tableHoaDon);
		scrollPaneHD.setBounds(96, 28, 604, 201);
		panelHoaDon.add(scrollPaneHD);
		
		JButton btnXoaSP = new JButton("Xoá");
		btnXoaSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaSP.setBounds(10, 168, 79, 39);
		panelHoaDon.add(btnXoaSP);
		
		JLabel lblTongTien = new JLabel("Tổng Tiền:");
		lblTongTien.setForeground(Color.BLUE);
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongTien.setBounds(10, 254, 113, 39);
		panelHoaDon.add(lblTongTien);
		
		textFieldTongTien = new JTextField();
		textFieldTongTien.setBounds(121, 265, 96, 23);
		panelHoaDon.add(textFieldTongTien);
		textFieldTongTien.setColumns(10);
		
		JLabel lblVND = new JLabel("VNĐ");
		lblVND.setHorizontalAlignment(SwingConstants.CENTER);
		lblVND.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVND.setBounds(227, 265, 56, 24);
		panelHoaDon.add(lblVND);
		
		JButton btnCho = new JButton("Chờ");
		btnCho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCho.setBounds(314, 255, 89, 39);
		panelHoaDon.add(btnCho);
		
		JButton btnDanhSachCho = new JButton("Danh sách chờ");
		btnDanhSachCho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDanhSachCho.setBounds(413, 255, 135, 39);
		panelHoaDon.add(btnDanhSachCho);
		
		JButton btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThanhToan.setBounds(558, 255, 142, 39);
		panelHoaDon.add(btnThanhToan);
		
		// Code Tab2
		JPanel panelTab2 = new JPanel();
		tabbedPane.addTab("Hoá Đơn Đã Lập", null, panelTab2, null);
		panelTab2.setLayout(null);
		
		JPanel panelLeft2 = new JPanel();
		panelLeft2.setBackground(new Color(255, 255, 204));
		panelLeft2.setBounds(0, 0, 352, 629);
		Border rightBorder = BorderFactory.createMatteBorder(0, 0, 0, 5, Color.BLACK);
		panelLeft2.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 102, 0)));
		panelTab2.add(panelLeft2);
		panelLeft2.setLayout(null);
		
		JLabel lblChiTietHD = new JLabel("Chi tiết hoá đơn");
		lblChiTietHD.setForeground(Color.BLUE);
		lblChiTietHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChiTietHD.setBounds(87, 11, 168, 56);
		panelLeft2.add(lblChiTietHD);
		
		JLabel lblMaHD = new JLabel("Mã hoá đơn");
		lblMaHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaHD.setBounds(23, 89, 81, 14);
		panelLeft2.add(lblMaHD);
		
		JLabel lblMaKH2 = new JLabel("Mã khách hàng");
		lblMaKH2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaKH2.setBounds(23, 127, 95, 14);
		panelLeft2.add(lblMaKH2);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng");
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenKH.setBounds(23, 165, 110, 14);
		panelLeft2.add(lblTenKH);
		
		JLabel lblNgaySinh2 = new JLabel("Ngày sinh");
		lblNgaySinh2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgaySinh2.setBounds(23, 203, 81, 14);
		panelLeft2.add(lblNgaySinh2);
		
		JLabel lblSDT2 = new JLabel("Số điện thoại");
		lblSDT2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSDT2.setBounds(23, 243, 95, 14);
		panelLeft2.add(lblSDT2);
		
		JLabel lblNV = new JLabel("Nhân viên");
		lblNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNV.setBounds(23, 283, 81, 14);
		panelLeft2.add(lblNV);
		
		JLabel lblNgayLapHD2 = new JLabel("Ngày lập HĐ");
		lblNgayLapHD2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayLapHD2.setBounds(23, 323, 81, 14);
		panelLeft2.add(lblNgayLapHD2);
		
		JLabel lblTongTien2 = new JLabel("Tổng tiền");
		lblTongTien2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTongTien2.setBounds(23, 366, 81, 14);
		panelLeft2.add(lblTongTien2);
		
		textFieldMaHD = new JTextField();
		textFieldMaHD.setEditable(false);
		textFieldMaHD.setBackground(UIManager.getColor("CheckBox.background"));
		textFieldMaHD.setBorder(null);
		textFieldMaHD.setBounds(168, 87, 116, 20);
		panelLeft2.add(textFieldMaHD);
		textFieldMaHD.setColumns(10);
		
		textField_MaKH = new JTextField();
		textField_MaKH.setEditable(false);
		textField_MaKH.setColumns(10);
		textField_MaKH.setBorder(null);
		textField_MaKH.setBackground(SystemColor.menu);
		textField_MaKH.setBounds(168, 125, 116, 20);
		panelLeft2.add(textField_MaKH);
		
		textField_TenKH = new JTextField();
		textField_TenKH.setEditable(false);
		textField_TenKH.setColumns(10);
		textField_TenKH.setBorder(null);
		textField_TenKH.setBackground(SystemColor.menu);
		textField_TenKH.setBounds(168, 163, 116, 20);
		panelLeft2.add(textField_TenKH);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setEditable(false);
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBorder(null);
		textField_NgaySinh.setBackground(SystemColor.menu);
		textField_NgaySinh.setBounds(168, 201, 116, 20);
		panelLeft2.add(textField_NgaySinh);
		
		textField_SDT = new JTextField();
		textField_SDT.setEditable(false);
		textField_SDT.setColumns(10);
		textField_SDT.setBorder(null);
		textField_SDT.setBackground(SystemColor.menu);
		textField_SDT.setBounds(168, 241, 116, 20);
		panelLeft2.add(textField_SDT);
		
		textField_TenNV = new JTextField();
		textField_TenNV.setEditable(false);
		textField_TenNV.setColumns(10);
		textField_TenNV.setBorder(null);
		textField_TenNV.setBackground(SystemColor.menu);
		textField_TenNV.setBounds(168, 281, 116, 20);
		panelLeft2.add(textField_TenNV);
		
		textField_NgayHD = new JTextField();
		textField_NgayHD.setEditable(false);
		textField_NgayHD.setColumns(10);
		textField_NgayHD.setBorder(null);
		textField_NgayHD.setBackground(SystemColor.menu);
		textField_NgayHD.setBounds(168, 321, 116, 20);
		panelLeft2.add(textField_NgayHD);
		
		textFieldTongTien2 = new JTextField();
		textFieldTongTien2.setEditable(false);
		textFieldTongTien2.setColumns(10);
		textFieldTongTien2.setBorder(null);
		textFieldTongTien2.setBackground(SystemColor.menu);
		textFieldTongTien2.setBounds(168, 360, 116, 20);
		panelLeft2.add(textFieldTongTien2);
		
		JButton btnXoaHD = new JButton("Xoá");
		btnXoaHD.setBounds(46, 420, 87, 46);
		panelLeft2.add(btnXoaHD);
		
		JButton btnInHD = new JButton("In hoá đơn");
		btnInHD.setBounds(189, 420, 95, 46);
		panelLeft2.add(btnInHD);
		
		JPanel panelRight2 = new JPanel();
		panelRight2.setBackground(new Color(255, 255, 204));
		panelRight2.setBounds(352, 0, 641, 629);
		panelTab2.add(panelRight2);
		panelRight2.setLayout(null);
		
		String rowHDDL[] = {"Mã hoá đơn","Mã khách hàng","Tên khách hàng", "Ngày sinh","Số điện thoại","Nhân viên", "Ngày lập HĐ","Tổng Tiền"};
		modelHDDaLap = new DefaultTableModel(rowHDDL,0);
		String rowHDDL1[] = {"HD202313130001","KH202302030001","Trương Văn Tuấn","17/03/1998","Phạm Đức Tài","17/03/2023","147.000 VND"};
		for(int i =0; i<50;i++) {
			modelHDDaLap.addRow(rowHDDL1);
		}
		
		tableHDDaLap = new JTable(modelHDDaLap);
		
		JScrollPane scrollPaneHDDL = new JScrollPane(tableHDDaLap);
		scrollPaneHDDL.setBounds(0, 36, 641, 352);
		panelRight2.add(scrollPaneHDDL);
		
		JLabel lblSapXep = new JLabel("Sắp xếp theo");
		lblSapXep.setHorizontalAlignment(SwingConstants.CENTER);
		lblSapXep.setBounds(10, 11, 75, 14);
		panelRight2.add(lblSapXep);
		
		JComboBox comboBoxSapXep = new JComboBox();
		comboBoxSapXep.setBounds(84, 7, 121, 22);
		panelRight2.add(comboBoxSapXep);
		
		JLabel lblTmTheoTen = new JLabel("Tìm theo tên");
		lblTmTheoTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmTheoTen.setBounds(226, 11, 78, 14);
		panelRight2.add(lblTmTheoTen);
		
		textTimTheoTen = new JTextField();
		textTimTheoTen.setBounds(303, 8, 113, 20);
		panelRight2.add(textTimTheoTen);
		textTimTheoTen.setColumns(10);
		
		JLabel lblTmTheoTenSDT = new JLabel("Tìm theo SDT");
		lblTmTheoTenSDT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmTheoTenSDT.setBounds(437, 11, 75, 14);
		panelRight2.add(lblTmTheoTenSDT);
		
		textTimTheoSDT = new JTextField();
		textTimTheoSDT.setColumns(10);
		textTimTheoSDT.setBounds(518, 8, 113, 20);
		panelRight2.add(textTimTheoSDT);
		
		JLabel lblCTHD = new JLabel("CHI TIẾT HOÁ ĐƠN");
		lblCTHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCTHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblCTHD.setBounds(275, 399, 132, 14);
		panelRight2.add(lblCTHD);
		
		String rowCTHD[] = {"Tên sản phẩm", "Màu sắc", "Đơn vị", "Giá bán", "Kích thước", "Số lượng", "Thành Tiền"};
		modelChiTietHD = new DefaultTableModel(rowCTHD,0);
		String rowCTHD1[] = {"Áo Thun Trắng","Trắng","Cái","147.000 VND","5","1","147.000 VND"};
		modelChiTietHD.addRow(rowCTHD1);
		String rowCTHD2[] = {"Đồng hồ nam","Đen","Cái","1.547.000 VND","No","1","1.547.000 VND"};
		modelChiTietHD.addRow(rowCTHD2);
		
		tableChiTietHD = new JTable(modelChiTietHD);
		
		JScrollPane scrollPaneCTHD = new JScrollPane(tableChiTietHD);
		scrollPaneCTHD.setBounds(0, 424, 641, 205);
		panelRight2.add(scrollPaneCTHD);
		
//		textField_1 = new JTextField();
//		textField_1.setBackground(UIManager.getColor("CheckBox.background"));
//		textField_1.setColumns(10);
//		textField_1.setBorder(null);
//		textField_1.setBounds(738, 128, 186, 21);
//		panelTab2.add(textField_1);
		
		// Code Tab3
		JPanel panelTab3 = new JPanel();
		tabbedPane.addTab("Thống Kê Doanh Thu", null, panelTab3, null);
		
		Color backgroundColorSapXep = new Color(226, 240, 222);
		
		// Code xu ly event
		btnInHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
		    	if(o.equals(btnInHD)) {
		    		ViewThanhToan viewTT = new ViewThanhToan();
		    		viewTT.setLocationRelativeTo(null);
		    		viewTT.setVisible(true);
		        }
			}
		});
	}
}
