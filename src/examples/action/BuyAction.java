package examples.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;





import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.annotation.tiger.StrutsAction;
import org.seasar.struts.annotation.tiger.StrutsActionForward;

import examples.dto.Book;
import examples.service.BookService;

/**
 *Xử lý các hành động trước khi đi đến trang hóa đơn
 *@author Cao.Tan
 *@version 1.0	 
 */
@StrutsAction(input = BuyAction.INVOICE)
public class BuyAction {

	//Đi đến trang hóa đơn nếu kiểm tra các tiến trình là đúng
	@StrutsActionForward
    public static final String INVOICE = "/bookInvoice.jsp";
	
	//Ở lại trang chi tiết sách vì có các sai sót
	@StrutsActionForward
    public static final String ERROR = "/bookDetail.jsp";
	
	Book book;
	HttpServletResponse res;
	public HttpServletResponse getRes() {
		return res;
	}


	public void setRes(HttpServletResponse res) {
		this.res = res;
	}

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
/**
 * Kiểm tra các tiến trình trước khi đi đến trang hóa đơn
 */
	public String goInvoice()
	{
		/**Biến soluongmua là input do người dùng nhập vào, nó cho biết người dùng muốn mua bao nhiêu cuốn trong đầu sách*/
		int soluongmua = 0;
		
		//try catch kiểm tra xem người dùng nhập vào soluongmua có đúng quy đinh hay không
		try {
			
			// số lượng mua được lấy về khi người dùng nhập vào
			soluongmua = Integer.parseInt(req.getParameter("soluongmua"));
		} catch (Exception e) {
			
			// vì người dùng nhập sai nên ta thiết lập lại các thông số cần thiết và trả người dùng về trang chi tiết sách
			int bookCode = Integer.parseInt(req.getParameter("masach"));
			
			// các lệnh phía dưới tương tự khi ta đi từ trang chủ sang chi tiết sách có thể tham khảo bên BookAction
	    	book = bookService.findByCode(bookCode) ;
	    	book.setTenloai(bookService.findTypeBook(bookCode));
	    	req.setAttribute("book", book);
	    	req.setAttribute("error", "Xin vui lòng nhập số");
			return ERROR;
		}
		/**Biến soluongcon là số lượng còn trong kho, ta dùng để so sánh với số lượng mua để xét tính hợp lệ trong thao tác của user */
		int soluongcon = Integer.parseInt(req.getParameter("soluongcon"));
		
		// nếu số lượng mua lớn hơn số lượng của đầu sách còn trong kho hay input của user là mua không sách thì ta báo lỗi
		if(soluongmua>soluongcon || soluongmua == 0)
		{

			int bookCode = Integer.parseInt(req.getParameter("masach"));
	    	book = bookService.findByCode(bookCode) ;
	    	book.setTenloai(bookService.findTypeBook(bookCode));
	    	req.setAttribute("book", book);
	    	req.setAttribute("error", "Bạn đã mua quá số lượng còn trong kho hay số lượng mua thấp hơn 1");
	   
	    	return ERROR;
		}
		
		// Tạo ra một list Book để chứa sách trong giỏ
		if(req.getSession().getAttribute("listbook") == null)
		{
			listBook = new ArrayList<Book>();
		
		}
		else
		{	
			listBook = (List<Book>)req.getSession().getAttribute("listbook");
		}
		
		int bookCode = Integer.parseInt(req.getParameter("masach"));
		
    	book = bookService.findByCode(bookCode) ;
    	
    	//set tổng số sách đã mua và tổng số tiền mua để chuẩn bị cho vào giỏ hàng
    	book.setSoluongmua(soluongmua);
    	book.setTongtienmua(soluongmua*Integer.parseInt(req.getParameter("giasach")));
    	
    	//cho sách vào trong listBook, listBook chính là sách trong giỏ của user 
    	listBook.add(book);
    	
    	//Đưa các thuộc tính này vào session
    	req.getSession().setAttribute("tongsach",soluongmua + (int)(req.getSession().getAttribute("tongsach")));
    	req.getSession().setAttribute("tongtien",(int)(req.getSession().getAttribute("tongtien"))+soluongmua*Integer.parseInt(req.getParameter("giasach")));
		req.getSession().setAttribute("listbook", listBook);
		
		return INVOICE;
	}
	
	
	/**Hàm này dùng cho user muốn xem giỏ hàng khi đang ở trang bất kỳ của ứng dụng*/
	public String viewInvoice()
	{
		if(req.getSession().getAttribute("listbook")==null)
		{

			listBook = new ArrayList<Book>();
			
		}
		else
		{
			listBook = (List<Book>)req.getSession().getAttribute("listbook");
			
		}
		req.getSession().setAttribute("listbook", listBook);
		return INVOICE;
	}

	
}
