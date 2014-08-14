
package examples.action;


import java.util.List;

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
    public static final String DETAIL = "/bookdetail.jsp";
    
    private Book books;
	private List<Book> book;

	BookService bookservice;
    private BookForm bookForm;
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
	

    public void setBookForm(BookForm bookForm) {
        this.bookForm = bookForm;
    }
	
    public String goDetail() {
    	 
    	books = bookservice.findByName(bookForm.getTensach()) ;
        return DETAIL;
    }
}
