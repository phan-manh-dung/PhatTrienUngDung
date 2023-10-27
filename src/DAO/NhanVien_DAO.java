package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectDatabase.database;
import Entity.KhachHang;
import Entity.NhanVien;

public class NhanVien_DAO {
	public static void main(String[] args) {
		NhanVien_DAO dao = new NhanVien_DAO();
	    dao.getAllNhanVien();
	}
public List<NhanVien> getAllNhanVien(){
		
		List<NhanVien> ls = new ArrayList<NhanVien>();
		database.getInstance();
		Connection con = database.getConnection();
		try {
			String sql = "Select * from NhanVien";
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {

				ls.add(new NhanVien(rs.getString("maNhanVien"), rs.getString("hoTen"), rs.getDate("ngaySinh"), false,rs.getString("canCuoc"), 
						rs.getString("soDienThoai"),rs.getString("diaChi"), rs.getString("chucVu"), rs.getString("hinhAnh")));
			}
//			for (NhanVien nhanVien : ls) {
//			    System.out.println("Mã Khách Hàng: " + nhanVien.getMaNhanVien());
//			    System.out.println("Họ Tên: " + nhanVien.getTenNhanVien());
//			    System.out.println("Số Điện Thoại: " + khachHang.getSoDienThoai());
//			    System.out.println("Địa Chỉ: " + khachHang.getDiaChi());
//			    System.out.println("=================================");
//			}
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
