package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ConnectDatabase.database;
import Entity.HoaDon;
import Entity.NhanVien;

public class HoaDon_DAO {

    
    public int getNhanVienNhieuHoaDonNhatTheoThang(int nam, int thang) {
        List<NhanVien> danhSachNhanVien = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int soLuongHoaDon = 0;

        try {
            connection = database.getConnection();
            String sql = "SELECT TOP 1 maNhanVien, COUNT(maHoaDon) AS soHoaDon "
                    + "FROM HoaDon "
                    + "WHERE YEAR(ngayLapHoaDon) = ? AND MONTH(ngayLapHoaDon) = ? "
                    + "GROUP BY maNhanVien "
                    + "ORDER BY soHoaDon DESC";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, nam);
            statement.setInt(2, thang);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNhanVien(resultSet.getString("maNhanVien"));
                danhSachNhanVien.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
        }

        return soLuongHoaDon;
    }
    
//    public Map<String, Object> getNhanVienNhieuHoaDonNhatTheoNgay(int nam, int thang, int ngay) {
//    	 Map<String, Object> result = new HashMap<>();
//        List<NhanVien> danhSachNhanVien = new ArrayList<>();
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        int tongSoHoaDon = 0;
//        try {
//            connection = database.getConnection();
//            String sql = "SELECT maNhanVien, COUNT(maHoaDon) AS soHoaDon "
//                    + "FROM HoaDon "
//                    + "WHERE YEAR(ngayLapHoaDon) = ? AND MONTH(ngayLapHoaDon) = ? AND DAY(ngayLapHoaDon) = ? "
//                    + "GROUP BY maNhanVien "
//                    + "ORDER BY soHoaDon DESC";
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1, nam);
//            statement.setInt(2, thang);
//            statement.setInt(3, ngay);
//            resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                NhanVien nhanVien = new NhanVien();
//                nhanVien.setMaNhanVien(resultSet.getString("maNhanVien"));
//                danhSachNhanVien.add(nhanVien);
//                int soLuongHoaDon = resultSet.getInt("soHoaDon");
//                tongSoHoaDon += soLuongHoaDon; // Cộng dồn số hóa đơn vào tổng
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            close(statement);
//        }
//        System.out.println("Tổng số hóa đơn theo ngày: " + tongSoHoaDon); // In ra tổng số hóa đơn
//        return danhSachNhanVien; // Trả về tổng số hóa đơn
//    }
//    
    
    public String getTenNhanVienFromMaNhanVien(String maNhanVien) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String hoTen = null;

        try {
            connection = database.getConnection();
            String sql = "SELECT hoTen FROM NhanVien WHERE maNhanVien = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, maNhanVien);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                hoTen = resultSet.getString("hoTen");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
        }

        return hoTen;
    }
    
    public int getSoLuongHoaDonTheoNam(String maNhanVien, int nam) {
        int soLuongHoaDon = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = database.getConnection();
            String sql = "SELECT COUNT(maHoaDon) AS soHoaDon "
                    + "FROM HoaDon "
                    + "WHERE YEAR(ngayLapHoaDon) = ? AND maNhanVien = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, nam);
            statement.setString(2, maNhanVien);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                soLuongHoaDon = resultSet.getInt("soHoaDon");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
        }

        return soLuongHoaDon;
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
