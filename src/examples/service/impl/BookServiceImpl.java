package examples.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.framework.container.factory.S2ContainerFactory;

import examples.dao.BookDao;
import examples.dao.CustomerDao;
import examples.dao.InvoiceDao;
import examples.dto.Book;
import examples.dto.InvoiceDto;
import examples.service.BookService;
/**
*
*@author Cao.Tan
*@version 1.0	 
*/
public class BookServiceImpl implements BookService {
	@Resource
	private BookDao bookDao;
	
	@Resource
	private InvoiceDao invoiceDao;
	
	@Resource
	private CustomerDao customerDao;

	/**Lấy tất cả sách trong bảng sách*/
	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookDao.getAllBook();
	}
	
	/**Lấy ra sách dựa vào mã sách*/
	@Override
	public Book findByCode(int MaSach) {
		
		return bookDao.findByCode(MaSach);
	}

	/**Lấy ra tên loại sách dựa vào mã loại sách*/
	@Override
	public String findTypeBook(int MaSach) {
		// TODO Auto-generated method stub
		return bookDao.findTypeBook(MaSach);
	}

	
	/**Lấy ra tất cả hóa đơn của một khách hàng dựa trên mã khách hàng*/
	@Override
	public ArrayList<InvoiceDto> getAll(String MaKhachHang) {
		return invoiceDao.getAll(MaKhachHang);
		// TODO Auto-generated method stub
	
	}

	/**Lấy ra mã của khách hàng dựa trên tên khách*/
	@Override
	public String getMaKhach(String TenKhach) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerCode(TenKhach);
	}
	
	/**Lấy ra tất cả hóa đơn có trong bảng hóa đơn*/
	@Override
	public ArrayList<InvoiceDto> getTotal() {
		// TODO Auto-generated method stub
		return invoiceDao.getTotal();
	}

	/**Cập nhật một quyển sách dựa trên mã sách*/
	@Override
	public void updateBook(int MaSach) {
		// TODO Auto-generated method stub
		bookDao.updateBook(MaSach);
	}

}


	



	
	


