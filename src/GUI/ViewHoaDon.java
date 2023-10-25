package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenu;

public class ViewHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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

		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color backgroundColor = new Color(239, 198, 87);
		JPanel pnlLoGo = new JPanel();
		pnlLoGo.setBounds(0, 0, 1151, 90);
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
		panel_1.setBounds(-15, 87, 199, 592);
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
		
		JLabel lblNewLabel = new JLabel("Tên Nhân Viên");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(49, 162, 101, 13);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Chức Vụ");
		lblNewLabel_1.setBounds(82, 184, 45, 13);
		panel_1.add(lblNewLabel_1);
		
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(194, 108, 957, 72);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(21, 24, 85, 21);
		panel_2.add(btnNewButton);
	}

}
