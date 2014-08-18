package examples.dto;

import java.sql.Date;

import org.seasar.dao.annotation.tiger.Bean;

/**
 *Các field trong bảng hóa đơn
 *@author Cao.Tan
 *@version 1.0	 
 */
@Bean(table = "HoaDon")
public class InvoiceDto {
	
	private int sohoadon;
	private String makhachhang;
	private String ngayxuat;
	private int tongtien;
	
	
	public int getSohoadon() {
		return sohoadon;
	}
	public void setSohoadon(int sohoadon) {
		this.sohoadon = sohoadon;
	}
	public String getMakhachhang() {
		return makhachhang;
	}
	public void setMakhachhang(String makhachhang) {
		this.makhachhang = makhachhang;
	}
	
	public String getNgayxuat() {
		return ngayxuat;
	}
	public void setNgayxuat(String ngayxuat) {
		this.ngayxuat = ngayxuat;
	}
	public int getTongtien() {
		return tongtien;
	}
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
	

}
