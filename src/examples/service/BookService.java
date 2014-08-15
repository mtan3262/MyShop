package examples.service;

import java.util.List;

import examples.dto.Book;





public interface BookService {
	  

	   
	    public String getName(int empno);
	    
	    public List<Book> getAllBook();
	    
	    public Book findByCode(int MaSach);
	    
	    public String findTypeBook(int MaSach);
	    
	    public void updateBook(int MaSach);
//	    public List findByCategoryPagerCondition(CategoryPagerCondition dto);

}
