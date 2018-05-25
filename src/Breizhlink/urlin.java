package Breizhlink;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanUrl.beanUrl;
import urlShortener.urlShortener;

/**
 * Servlet implementation class urlin
 */
public class urlin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public urlin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/urlin.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("url");
		
		urlShortener u = new urlShortener(5, "http://localhost:8080/breizhlink/");
		
		String urlShort = u.shortenURL(url);
		String urlReveal = u.expandURL(urlShort);
		
		beanUrl beanUrl = new beanUrl();
		beanUrl.setUrl(url);
		beanUrl.setUrlShort(urlShort);
		beanUrl.setUrlReveal(urlReveal);
		
		request.setAttribute("url", beanUrl);
		
		this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response );
	}

}
