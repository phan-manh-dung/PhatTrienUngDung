package Entity;

import java.util.Date;

public class HoaDon {
	private String maHoaDon;
	private Date ngayLapHoaDon;
	private int thue;
	private String maKhachHang;
	private String maNhanVien;
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}
	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	public int getThue() {
		return thue;
	}
	public void setThue(int thue) {
		this.thue = thue;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public HoaDon(String maHoaDon, Date ngayLapHoaDon, int thue, String maKhachHang, String maNhanVien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.thue = thue;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", thue=" + thue + ", maKhachHang="
				+ maKhachHang + ", maNhanVien=" + maNhanVien + "]";
	}
	
	
}
