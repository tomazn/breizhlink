package Breizhlink;

import java.io.IOException;
import java.sql.SQLException;

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
		String url = request.getRequestURI();
		String id = url.replace("/breizhlink/", "");
		
		
		try {
			beanUrl urlOut = new beanUrl();
			urlOut = urlOut.getOne(id);
			
			if(urlOut != null) {
				String password = urlOut.getPassword();
				if(password != null && password != "") {
					HttpSession session = request.getSession();
					session.setAttribute("urlOut", urlOut);
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
			response.sendRedirect(urlOut.getUrl());	
		}else{
			String message = "";
			message = "Wrong password";
			request.setAttribute("messageUrlout", message);	
			this.getServletContext().getRequestDispatcher( "/urlout.jsp" ).forward( request, response );
		}
	}

}
