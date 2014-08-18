package examples.dao;

import java.util.ArrayList;

import org.seasar.dao.annotation.tiger.S2Dao;

import examples.dto.InvoiceDto;

/**
 *Thao tác với bản hóa đơn trong cơ sở dữ liệu
 *@author Cao.Tan
 *@version 1.0	 
 */
@S2Dao(bean = InvoiceDto.class)
public interface InvoiceDao {
	
	public ArrayList<InvoiceDto> getAll(String TenKhachHang);
	
	public ArrayList<InvoiceDto> getTotal();
}
