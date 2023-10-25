package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class ViewAddNhanVien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private ButtonGroup gioiTinh;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	ViewAddNhanVien frame = new ViewAddNhanVien();
				//	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // đóng k ảnh hường tới fram cũ
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewAddNhanVien() {
		//
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdd = new JLabel("THÊM NHÂN VIÊN");
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdd.setBounds(248, 27, 199, 38);
		contentPane.add(lblAdd);
		
		JLabel lblImg = new JLabel("ảnh");
		lblImg.setBounds(24, 92, 187, 196);
		contentPane.add(lblImg);
		// upload ảnh
		JButton btnUpload = new JButton("Tải lên");
		btnUpload.setBounds(70, 327, 109, 38);
		contentPane.add(btnUpload);
		// mã nhân viên
		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNV.setBounds(282, 102, 103, 14);
		contentPane.add(lblMaNV);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(410, 100, 187, 20);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);
		// tên nhân viên
		JLabel lblName = new JLabel("Tên nhân viên");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(282, 138, 103, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(410, 136, 187, 20);
		contentPane.add(txtName);
		//email
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(282, 170, 103, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(410, 168, 187, 20);
		contentPane.add(txtEmail);
		// giới tính
		JLabel lblSex = new JLabel("Giới tính");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSex.setBounds(282, 204, 103, 14);
		contentPane.add(lblSex);
		
		JRadioButton rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setBounds(432, 201, 54, 23);
		rdbtnMale.setBackground(new Color(245, 245, 220) );
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setBounds(543, 201, 54, 23);
		rdbtnFemale.setBackground(new Color(245, 245, 220) );
		contentPane.add(rdbtnFemale);
		
		ButtonGroup gioiTinh = new ButtonGroup();
		gioiTinh.add(rdbtnMale);
		gioiTinh.add(rdbtnFemale);
		// số điện thoại
		JLabel lblPhone = new JLabel("Số điện thoại");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhone.setBounds(282, 241, 103, 14);
		contentPane.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(410, 239, 187, 20);
		contentPane.add(txtPhone);
		// chức vụ
		JLabel lblRole = new JLabel("Chức vụ");
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRole.setBounds(282, 274, 103, 14);
		contentPane.add(lblRole);
	
		JComboBox cobRole = new JComboBox();
		cobRole.setBounds(410, 266, 187, 22);
		contentPane.add(cobRole);
		
		String[] arrRole = {"Chọn chức vụ","Nhân viên quản lí","Nhân viên bán hàng"};
		for(String choice : arrRole) {
			cobRole.addItem(choice);
		}
		
		//button thêm
		JButton btnAdd = new JButton("Xác nhận");
		btnAdd.setBounds(410, 327, 109, 38);
		contentPane.add(btnAdd);
		
	}
}
