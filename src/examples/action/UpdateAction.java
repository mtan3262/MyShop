package examples.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;







import javax.servlet.http.HttpServletRequest;







import org.seasar.struts.annotation.tiger.StrutsAction;
import org.seasar.struts.annotation.tiger.StrutsActionForward;









import java.sql.Statement;

import examples.dto.Book;
import examples.service.BookService;

/**
 *Update dữ liệu xuống DB 
 *@author Cao.Tan
 *@version 1.0	 
 */
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
	
	/** Update dữ liệu xuống DB*/
	public String goUpdate()
    {
		//Lấy các dữ liệu từ session xuống để chuẩn bị insert một hóa đơn mới
		book = (List<Book>)res.getSession().getAttribute("listbook");
    	String user = (String)res.getSession().getAttribute("user");
    	int tongtien = (Integer)res.getSession().getAttribute("tongtien");
    	
    	/**2 biến được tạo nhầm mục đích lấy ra ngày hiện tại*/
    	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    	Date today = Calendar.getInstance().getTime(); 
    	
    	//Giảm số lượng sách khi nó đã được mua
    	for (int i = 0; i < book.size(); i++) {
    		try {
    		int t = book.get(i).getSoluongmua();
    		while(t>0)
    		{
    			//Lấy ra cuốn sách dựa trên mã sách để tính hành cập nhật số lượng sách trong kho
    				bookService.updateBook(book.get(i).getMasach());
        			t -= 1;
			
    		}} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
    	// Set lại các session sau khi đã thanh toán xong
    	listBook = new ArrayList<Book>();
    	res.getSession().setAttribute("tongsach", 0);
    	res.getSession().setAttribute("tongtien", 0);
    	res.getSession().setAttribute("listbook", listBook);
    	
    	//Insert hoa don vao database
    	updateInvoice(bookService.getTotal().size()+1, bookService.getMaKhach(user),df.format(today),tongtien);
    	
   
    	return UPDATE;
    }
	
	/**Tạo kết nối database và tạo một hóa đơn mới*/
	public void updateInvoice(int maso, String makhach, String ngayxuat, int tongtien)
	{
		Connection conn = null;
		 try { 
			 Class.forName("org.postgresql.Driver");
			 conn = (Connection) DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/myshoponline", "postgres",
						"admin");
	           
	          
	            Statement st = (Statement) conn.createStatement(); 
	            String sql = "INSERT INTO \"HoaDon\" VALUES ('"+makhach+ "',"+tongtien+","+maso+",'"+ngayxuat+"')";
	            st.executeUpdate(sql); 
	            conn.close(); 
	        } catch (Exception e) { 
	            System.err.println("Got an exception! "); 
	            System.err.println(e.getMessage()); 
	        } 
	}
}
