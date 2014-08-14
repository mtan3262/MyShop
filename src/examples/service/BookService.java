package examples.service;

import java.util.List;

import examples.dto.Book;





public interface BookService {
	  

	   
	    public String getName(int empno);
	    
	    public List<Book> getAllBook();
	    
	    public Book findByCode(int MaSach);
//	    public List findByCategoryPagerCondition(CategoryPagerCondition dto);

}
