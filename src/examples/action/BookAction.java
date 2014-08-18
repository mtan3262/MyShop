
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
 *Xử lý các hành động để chuyển người dùng sang trong chi tiết sách 
 *@author Cao.Tan
 *@version 1.0	 
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
	
    /**
     * Các xử lý trước khi đưa người dùng đến trang chi tiết sách
     * 
     */
    public String goDetail() {
    	 /** Biến bookCode để lấy mã sách cần xem chi tiết dựa trên parameter masach của request*/
    	int bookCode = Integer.parseInt(res.getParameter("masach"));
    	/** books là biến của class Book, dựa vào mã sách phía trên ta truy vấn xuống DB để lấy cuốn sách cần xem chi tiết*/
    	books = bookservice.findByCode(bookCode) ;
    	
    	//Dựa vào mã sách trong bảng sách, ta lấy tên loại sách trong bảng loại sách
    	books.setTenloai(bookservice.findTypeBook(bookCode));
    	
    	//Trả về quyển sách đã lấy lên từ DB và đi tới màn hình chi tiết sách
    	res.setAttribute("book", books);
    	res.setAttribute("error", "vẫn còn hàng");
        return DETAIL;
    }
}
