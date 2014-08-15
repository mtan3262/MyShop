
package examples.action;


import java.io.Console;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.struts.annotation.tiger.StrutsAction;
import org.seasar.struts.annotation.tiger.StrutsActionForward;

import examples.dto.Book;
import examples.service.BookService;

/**
 * @author taedium
 * 
 */
@StrutsAction(input = BookAction.DETAIL)
public class BookAction {

    @StrutsActionForward
    public static final String DETAIL = "/bookDetail.jsp";
    
    private Book books;
	private List<Book> book;
	private HttpServletRequest res;

	BookService bookservice;
  
    
	public HttpServletRequest getRes() {
		return res;
	}


	public void setRes(HttpServletRequest res) {
		this.res = res;
	}

    public Book getBooks() {
		return books;
	}


	public void setBooks(Book books) {
		this.books = books;
	}


    public List<Book> getBook() {
		return book;
	}


	public void setBook(List<Book> book) {
		this.book = book;
	}

    
    @Binding(bindingType = BindingType.MUST)
	public void setBookService(BookService bookService) {
		this.bookservice = bookService;
	}
	

    public String goDetail() {
    	 
    	int bookCode = Integer.parseInt(res.getParameter("masach"));
    	books = bookservice.findByCode(bookCode) ;
    	books.setTenloai(bookservice.findTypeBook(bookCode));
    	res.setAttribute("book", books);
        return DETAIL;
    }
}
