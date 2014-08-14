package examples.action;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
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
	
	private LoginForm loginForm;
	private List<Book> book;
	@Resource
	private LoginService loginService;
	@Resource
	private BookService	bookService;

	public BookService getBookService() {
		return bookService;
	}

	public void setAddForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

    
    
	
    
    public String execute()
    {
    	//String username = loginForm.getUsername();
    	//loginService.CheckLogin(loginForm);
    	if(loginService.CheckLogin(loginForm))
    		{
    	
    			book = bookService.getAllBook();
    			return SUCCESS;
    		}
    	else{
    		loginForm.setPassword("");
    		loginForm.setUsername("");
    		return FAILURE;
    	}
    }

}
