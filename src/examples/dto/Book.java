
package examples.dto;

import java.io.Serializable;
import java.sql.Date;

import org.seasar.dao.annotation.tiger.Bean;

/**
 *Các field của sách trong cơ sở dữ liệu và các field khác khi người dùng mua sách  
 *@author Cao.Tan
 *@version 1.0	 
 */

@Bean(table = "Sach")
public class Book implements Serializable{

	private int soluongmua;
	private int tongtienmua;
	public int getTongtienmua() {
		return tongtienmua;
	}
	public void setTongtienmua(int tongtienmua) {
		this.tongtienmua = tongtienmua;
	}
	public int getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(int soluongmua) {
		this.soluongmua = soluongmua;
	}
	private String maloai;
    private String tensach;
    private int giasach;
    private int masach;
    private String tacgia;
    private int soluong;
    private String tenloai;
    
    public String getTenloai() {
		return tenloai;
	}
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	public int getMasach() {
		return masach;
	}
	public void setMasach(int masach) {
		this.masach = masach;
	}
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}

	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public int getGiasach() {
		return giasach;
	}
	public void setGiasach(int giasach) {
		this.giasach = giasach;
	}
	
	

}
