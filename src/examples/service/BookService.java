package examples.service;

import java.util.ArrayList;
import java.util.List;

import examples.dto.Book;
import examples.dto.InvoiceDto;




/**
*Các thao tác dịch vụ
*@author Cao.Tan
*@version 1.0	 
*/
public interface BookService {
	  
	  
	    
	    public List<Book> getAllBook();
	    
	    public Book findByCode(int MaSach);
	    
	    public String findTypeBook(int MaSach);
	    
	    public void updateBook(int MaSach);
	    
	    public ArrayList<InvoiceDto>  getAll(String MaKhachHang);
	    
	    public ArrayList<InvoiceDto> getTotal();
	    
	    public String getMaKhach(String TenKhach);
//	    public List findByCategoryPagerCondition(CategoryPagerCondition dto);

}
