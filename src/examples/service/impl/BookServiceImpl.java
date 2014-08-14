package examples.service.impl;

import java.util.List;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.framework.container.factory.S2ContainerFactory;

import examples.dao.BookDao;
import examples.dto.Book;
import examples.service.BookService;

public class BookServiceImpl implements BookService {
	
	private BookDao bookDao;
	
	
	
	
	@Binding(bindingType = BindingType.MUST)
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

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
	public Book findByName(String name) {
		
		return bookDao.findByName(name);
	}




	
	

}
