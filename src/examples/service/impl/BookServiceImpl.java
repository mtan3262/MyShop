package examples.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.framework.container.factory.S2ContainerFactory;

import examples.dao.BookDao;
import examples.dto.Book;
import examples.service.BookService;

public class BookServiceImpl implements BookService {
	@Resource
	private BookDao bookDao;

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookDao.getAllBook();
	}

	@Override
	public String getName(int empno) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Book findByCode(int MaSach) {
		
		return bookDao.findByCode(MaSach);
	}

	@Override
	public String findTypeBook(int MaSach) {
		// TODO Auto-generated method stub
		return bookDao.findTypeBook(MaSach);
	}

	@Override
	public void updateBook(int MaSach) {
		// TODO Auto-generated method stub
		bookDao.updateBook(MaSach);
	}




	
	

}
