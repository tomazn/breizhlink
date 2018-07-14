package Breizhlink;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.db;

/**
 * Servlet implementation class register
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/register.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String message = "";
		
		if(email == "" || password == "") {
			if(email == "") {
				message = "email is empty";
			}else if(password == "") {
				message = "password is empty";
			}
			request.setAttribute("message", message);
			this.getServletContext().getRequestDispatcher( "/register.jsp" ).forward( request, response );
		}
		
		
		
		try {
			
			if(email != "" || password != "") {
			
			String db_root = getServletContext().getInitParameter("db_path");
			String db_user = getServletContext().getInitParameter("db_user");
			String db_pwd = getServletContext().getInitParameter("db_pwd");
			//Init database connection
			java.sql.Connection conn = db.init(db_root,db_user,db_pwd);
			//Prepared statemen
			java.sql.PreparedStatement insertUser = conn.prepareStatement("INSERT INTO user (email,password) VALUES (?,?);");
			insertUser.setString(1, email);
			insertUser.setString(2,password); 
			
			insertUser.executeUpdate();
			db.close(conn);
			}
			//Close db

			message = "User created";
			request.setAttribute("message", message);
			
			RequestDispatcher rd = null;
			rd = getServletContext().getRequestDispatcher("/index.jsp");
	        rd.forward(request, response);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

}
