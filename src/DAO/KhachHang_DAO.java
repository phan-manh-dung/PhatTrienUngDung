package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ConnectDatabase.database;
import ConnectDatabase.database;
import Entity.KhachHang;

public class KhachHang_DAO {
	public static void main(String[] args) {
		KhachHang_DAO dao = new KhachHang_DAO();
	    dao.getAllKhachHang();
	}
	public List<KhachHang> getAllKhachHang(){
		
		List<KhachHang> ls = new ArrayList<KhachHang>();
		database.getInstance();
		Connection con = database.getConnection();
		try {
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {

				ls.add(new KhachHang(rs.getString("maKhachHang"),rs.getString("hoTen"), rs.getString("soDienThoai"), false, rs.getString("diaChi")));
			}
			for (KhachHang khachHang : ls) {
			    System.out.println("Mã Khách Hàng: " + khachHang.getMaKhachHang());
			    System.out.println("Họ Tên: " + khachHang.getHoTen());
			    System.out.println("Số Điện Thoại: " + khachHang.getSoDienThoai());
			    System.out.println("Địa Chỉ: " + khachHang.getDiaChi());
			    System.out.println("=================================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}
		
		private void close(PreparedStatement stmt) {
			if(stmt != null)
				try {
					stmt.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
		}
}
