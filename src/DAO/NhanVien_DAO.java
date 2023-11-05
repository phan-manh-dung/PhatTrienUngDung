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
import Entity.NhanVien;

public class NhanVien_DAO {
	private byte[] hinhAnh;
//	public static void main(String[] args) {
//		NhanVien_DAO dao = new NhanVien_DAO();
//		dao.getAllNhanVien();
//	}

	public List<NhanVien> getAllNhanVien() {
		List<NhanVien> ls = new ArrayList<NhanVien>();
		database.getInstance();
		Connection con = database.getConnection();
		try {
			String sql = "Select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				ls.add(new NhanVien(rs.getString("maNhanVien"), rs.getString("hoTen"), rs.getDate("ngaySinh"),
						rs.getBoolean("gioiTinh"), rs.getString("canCuoc"), rs.getString("soDienThoai"),
						rs.getString("diaChi"), rs.getString("chucVu"),rs.getString("hinhAnh")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public void addNhanVien(NhanVien nv) {
		Connection con = database.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO NhanVien (maNhanVien, hoTen, ngaySinh, gioiTinh, canCuoc, soDienThoai, diaChi, chucVu,hinhAnh ) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, nv.getMaNhanVien());
			stmt.setString(2, nv.getTenNhanVien());
			stmt.setDate(3, new java.sql.Date(nv.getNgaySinh().getTime()));
			stmt.setBoolean(4, nv.isGioiTinh());
			stmt.setString(5, nv.getCanCuoc());
			stmt.setString(6, nv.getSoDienThoai());
			stmt.setString(7, nv.getDiaChi());
			stmt.setString(8, nv.getChucVu());
			stmt.setString(9, nv.getHinhAnh());

			int rowsAffected = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
	}

	public void deleteNhanVien(String maNhanVien) {
		try {
			Connection con = database.getConnection();
			String sql = "DELETE FROM NhanVien WHERE maNhanVien = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maNhanVien);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//
	public void updateNhanVien(NhanVien nv) {
	    Connection con = database.getConnection();
	    PreparedStatement stmt = null;
	    try {
	        String sql = "UPDATE NhanVien SET hoTen = ?, ngaySinh = ?, gioiTinh = ?, canCuoc = ?, soDienThoai = ?, diaChi = ?, chucVu = ?, hinhAnh = null WHERE maNhanVien = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, nv.getTenNhanVien());
	        stmt.setDate(2, new java.sql.Date(nv.getNgaySinh().getTime()));
	        stmt.setBoolean(3, nv.isGioiTinh());
	        stmt.setString(4, nv.getCanCuoc());
	        stmt.setString(5, nv.getSoDienThoai());
	        stmt.setString(6, nv.getDiaChi());
	        stmt.setString(7, nv.getChucVu());
	        stmt.setString(8, nv.getMaNhanVien());
	        int rowsAffected = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(stmt);
	    }
	}


	private void close(PreparedStatement stmt) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
