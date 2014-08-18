package examples.action;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.seasar.struts.annotation.tiger.StrutsAction;
import org.seasar.struts.annotation.tiger.StrutsActionForward;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import examples.dto.InvoiceDto;
import examples.service.BookService;

/**
 *Đưa  người dùng xem lịch sử mua sắm của mình
 *@author Cao.Tan
 *@version 1.0	 
 */
@StrutsAction(input = ViewAction.HISTORY)
public class ViewAction {
	
	@StrutsActionForward
    public static final String HISTORY = "/bookHistory.jsp";
	@Resource
	private BookService bookService;
	private ArrayList<InvoiceDto> invoiceDto;
	private HttpServletRequest res;
	
	public void setRes(HttpServletRequest res) {
		this.res = res;
	}

	public ArrayList<InvoiceDto> getInvoiceDto() {
		return invoiceDto;
	}

	public void setInvoiceDto(ArrayList<InvoiceDto> invoiceDto) {
		this.invoiceDto = invoiceDto;
	}
/**Xem lịch sử mua sắm khi ở bất kì trong trong ứng dụng*/
	public String goView()
	{
		/**Biến tenKhach lấy tên của người dùng để có thể lấy được lịch sử mua sắm của người đó*/
		String tenKhach = (String)res.getSession().getAttribute("user");
		
		/**Lấy tất cả các hóa đơn của user có tên trong biến tenKhach và lưu trong list invoiceDto*/
		invoiceDto = bookService.getAll(tenKhach);
		
		//đưa list này và request để show cho người dùng
		res.setAttribute("history", invoiceDto);
		return HISTORY;
	}

}
