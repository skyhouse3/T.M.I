package filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
/**
 * Servlet Filter implementation class CommonFilter
 */
public class CommonFilter implements Filter {
    /**
     * Default constructor. 
     */
    public CommonFilter() {
    }
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("CommonFilter가 소멸되었습니다.");
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("-- doFilter() 동작합니다. --");
		HttpServletRequest hrequest = (HttpServletRequest)request;	
		if(hrequest.getMethod().equalsIgnoreCase("post")) {
		System.out.println("post 전송시에만 encoding 됩니다.");
		request.setCharacterEncoding("utf-8");		
		}
		chain.doFilter(request, response);
		System.out.println("-- doFilter() 이후 처리되는 코드입니다. --");	
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("CommonFilter 초기화");
	}	
}
