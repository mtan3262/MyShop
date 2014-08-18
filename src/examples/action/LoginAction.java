package examples.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.seasar.struts.annotation.tiger.StrutsAction;
import org.seasar.struts.annotation.tiger.StrutsActionForward;








import examples.dto.Book;
import examples.form.LoginForm;
import examples.service.BookService;
import examples.service.LoginService;
/**
 *Xử lý các thông tin user đưa vào form Login để đưa user vào trang chủ, khởi tạo session cho user 
 *@author Cao.Tan
 *@version 1.0	 
 */
@StrutsAction(input = LoginAction.SUCCESS)
public class LoginAction {
	
	//Đưa user đén trang chủ nếu các thông tin nhập vào đúng username, password
	@StrutsActionForward
    public static final String SUCCESS = "/bookHome.jsp";
	
	//Trả về lại trang Login nếu nhập sai thông tin đăng nhập
	@StrutsActionForward
	public static final String FAILURE = "/login.jsp";
	

	@Resource
	private LoginService loginService;
	@Resource
	private BookService	bookService;

	private LoginForm loginForm;
	private List<Book> book;
	private List<Book> listbook;


	 public List<Book> getListbook() {
		return listbook;
	}

	public void setListbook(List<Book> listbook) {
		this.listbook = listbook;
	}

	public void setBook(List<Book> book) {
		}

	private HttpServletRequest req;
	

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setAddForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

   


	/**Xử lý các thông tin của user trước khi vào trang chủ*/
	public String execute()
    {
    	// Kiểm tra xem nhập đúng thông tin của user không
    	if(loginService.CheckLogin(loginForm))
    		{
    			// Khi đã nhập đúng ta khởi tạo các session
    			req.getSession().setAttribute("listbook", null);
    			req.getSession().setAttribute("user", loginForm.getUsername());
    			req.getSession().setAttribute("tongsach", 0);
    			req.getSession().setAttribute("tongtien", 0);
    			
    			
    			//Lấy sách lên để chuẩn bị show ra trang chủ
    			book = bookService.getAllBook();
    
    			return SUCCESS;
    		}
    	else{
    		
    		//Khi nhập sai thì user ở lại trang chủ
    		loginForm.setPassword("");
    		loginForm.setUsername("");
    		return FAILURE;
    	}
    }
    /**Hàm này dùng để trả về trang chủ khi user ở các trang khác trong ứng dụng*/
    public String goHome()
    {
    	book = bookService.getAllBook();
    			return SUCCESS;
    	
    }

	public List<Book> getBook() {
		return book;
	}

}
