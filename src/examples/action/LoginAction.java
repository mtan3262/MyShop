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

@StrutsAction(input = LoginAction.SUCCESS)
public class LoginAction {
	
	@StrutsActionForward
    public static final String SUCCESS = "/success.jsp";
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

   



	public String execute()
    {
    	
    	if(loginService.CheckLogin(loginForm))
    		{

    			req.getSession().setAttribute("listbook", null);
    			req.getSession().setAttribute("user", loginForm.getUsername());
    			req.getSession().setAttribute("tongsach", 0);
    			req.getSession().setAttribute("tongtien", 0);
    			
    			////////////////////////
    			
    			book = bookService.getAllBook();
    			System.out.println("=======HELLO=======");
    			return SUCCESS;
    		}
    	else{
    		loginForm.setPassword("");
    		loginForm.setUsername("");
    		return FAILURE;
    	}
    }
    
    public String goHome()
    {
    	book = bookService.getAllBook();
    			return SUCCESS;
    	
    }

	public List<Book> getBook() {
		return book;
	}

}
