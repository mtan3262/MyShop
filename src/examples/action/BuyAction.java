package examples.action;

import java.util.ArrayList;
import java.util.List;




import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.annotation.tiger.StrutsAction;
import org.seasar.struts.annotation.tiger.StrutsActionForward;

import examples.dto.Book;
import examples.service.BookService;


@StrutsAction(input = BuyAction.INVOICE)
public class BuyAction {

	@StrutsActionForward
    public static final String INVOICE = "/bookInvoice.jsp";
	
	Book book;

	HttpServletRequest req;

	@Resource
	BookService bookService;
	
	List<Book> listBook;
	
	public void setBook(Book book) {
		this.book = book;
	}


	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}

	public Book getBook() {
		return book;
	}

	public List<Book> getListBook() {
		return listBook;
	}
	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public String goInvoice()
	{
		
		if(req.getSession().getAttribute("listbook")==null)
		{
			System.out.println("=======================");
			System.out.println("=======================");
			System.out.println("========CHUA CO=========");
			System.out.println("=======================");
			System.out.println("=======================");
			listBook = new ArrayList<Book>();
			
		}
		else
		{
			listBook = (List<Book>)req.getSession().getAttribute("listbook");
			System.out.println("=======================");
			System.out.println("=======================");
			System.out.println("========CO ROI=========");
			System.out.println("=======================");
			System.out.println("=======================");
			
		}
		int bookCode = Integer.parseInt(req.getParameter("masach"));
    	book = bookService.findByCode(bookCode) ;

    	listBook.add(book);

    	req.getSession().setAttribute("tongsach",1 + (int)(req.getSession().getAttribute("tongsach")));
    	req.getSession().setAttribute("tongtien",(int)(req.getSession().getAttribute("tongtien"))+Integer.parseInt(req.getParameter("giasach")));
		req.getSession().setAttribute("listbook", listBook);
		return INVOICE;
	}

	
}
