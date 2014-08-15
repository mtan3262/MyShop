package examples.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.seasar.struts.annotation.tiger.StrutsAction;
import org.seasar.struts.annotation.tiger.StrutsActionForward;

import examples.dto.Book;
import examples.service.BookService;

@StrutsAction(input = UpdateAction.UPDATE)
public class UpdateAction {
	

    @StrutsActionForward
    public static final String UPDATE = "/bookFinish.jsp";
    
    List<Book> book;
    List<Book> listBook;
   
	HttpServletRequest res;
    BookService bookService;
    
    public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public void setRes(HttpServletRequest res) {
		this.res = res;
	}
	public List<Book> getBook() {
		return book;
	}
	public void setBook(ArrayList<Book> book) {
		this.book = book;
	}
	public String goUpdate()
    {
    	book = (ArrayList)res.getSession().getAttribute("listbook");
    	
    	System.out.println("======="+book.size()+"=======");
    	System.out.println("======="+book.get(0).getTacgia()+"========");
    	
    	for (int i = 0; i < book.size(); i++) {
    		
			bookService.updateBook(book.get(i).getMasach());
		}
    	listBook = new ArrayList<Book>();
    	res.getSession().setAttribute("tongsach", 0);
    	res.getSession().setAttribute("tongtien", 0);
    	res.getSession().setAttribute("listbook", listBook);
   
    	return UPDATE;
    }

}
