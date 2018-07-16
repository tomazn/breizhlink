package Breizhlink;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.beanUrl;
import urlShortener.urlShortener;

/**
 * Servlet implementation class shortener
 */
public class shortener extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shortener() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/shortener.jsp" ).forward( request, response );
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession MySession = request.getSession();
		
		String url = request.getParameter("url");
		String password = request.getParameter("password");
		String captcha = request.getParameter("captcha");
		String minDate = request.getParameter("minDate");
		String maxDate = request.getParameter("maxDate");
		String maxClick = request.getParameter("maxClick");
	

		urlShortener u = new urlShortener(5, getServletContext().getInitParameter("root_domain"));
		
		String urlShort = u.shortenURL(url);
		String urlReveal = u.expandURL(urlShort);
		
		beanUrl beanUrl = new beanUrl();
		beanUrl.setUrl(url);
		beanUrl.setUrlShort(urlShort);
		beanUrl.setUrlReveal(urlReveal);
		beanUrl.setPassword(password);
		String keyShort = urlShort.replace(getServletContext().getInitParameter("root_domain") + "/", "");
		beanUrl.setKeyShort(keyShort);
		
		beanUrl.setCaptcha(captcha.equals("on") ? true : false);
		  try {
			  java.util.Date parseMindate = new SimpleDateFormat("yyyy-MM-dd").parse(minDate);  
			  java.util.Date parseMaxdate = new SimpleDateFormat("yyyy-MM-dd").parse(maxDate);  
			beanUrl.setMinDate(parseMindate);
			beanUrl.setMaxDate(parseMaxdate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		beanUrl.setMaxClick(Integer.parseInt(maxClick));
		
		request.setAttribute("url", beanUrl);
		
		try {
			String login = (String) MySession.getAttribute("login");
			Integer id;
			if(login.equals("true")) {
				 id = (Integer) MySession.getAttribute("loginId");
			}else {
				id = -1;
			}
			
			beanUrl.save(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher( "/shortener.jsp" ).forward( request, response );
	}

}
