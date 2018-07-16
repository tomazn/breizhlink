package Breizhlink;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.beanUrl;

/**
 * Servlet implementation class urlOut
 */
@WebServlet("/urlOut")
public class urlout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private beanUrl url;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public urlout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String url = request.getRequestURI();
		String id = url.replace("/breizhlink/", "");
		try {
			beanUrl urlOut = new beanUrl();
			urlOut = urlOut.getOne(id);
			
			if(urlOut != null) {
				String password = urlOut.getPassword();
				if(password != null && password != "") {
					
					if(urlOut.isCaptcha()) {
						request.setAttribute("captcha", true);
					}else {
						request.setAttribute("captcha", false);
					}
					
					java.util.Date minDate = urlOut.getMinDate();
					java.util.Date maxDate = urlOut.getMaxDate();
					//java.util.Date today = new java.util.Date();
					
					request.setAttribute("outday", false);
					if(minDate != null && maxDate != null) {
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date today = Calendar.getInstance().getTime();        
						
						String todayParse = df.format(today);
						String minDateParse = df.format(minDate);
						String maxDateParse = df.format(maxDate);
						
						 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

						    java.util.Date _today = format.parse(todayParse);
						    java.util.Date _minDate = format.parse(minDateParse);
						    java.util.Date _maxDate = format.parse(maxDateParse);						   
						    
						
						if(_today.compareTo(_minDate) >= 0 && _maxDate.compareTo(_today) >= 0) {
							//ok
							request.setAttribute("outday", false);
						}else {
							request.setAttribute("outday", true);
						}
					}
					
					request.setAttribute("urlOut", urlOut);
					this.getServletContext().getRequestDispatcher( "/urlout.jsp" ).forward( request, response );
				}else {
					response.sendRedirect(urlOut.getUrl());	
				}
			}else {
				response.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		HttpSession session = request.getSession();		
		beanUrl urlOut = (beanUrl) session.getAttribute("urlOut");
		String beanPassword = urlOut.getPassword();
		if(password.equals(beanPassword)) {
			String url = urlOut.getUrl();
			session.setAttribute("urlOut",null);
			response.sendRedirect(url);	
		}else{
			String message = "";
			message = "Wrong password";
			request.setAttribute("messageUrlout", message);	
			this.getServletContext().getRequestDispatcher( "/urlout.jsp" ).forward( request, response );
		}
	}

}
