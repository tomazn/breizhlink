package Breizhlink;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import DB.db;

/**
 * Servlet implementation class login
 */

public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession MySession = request.getSession();
		 if(MySession.getAttribute("login") == null || MySession.getAttribute("login") == "false") {
			this.getServletContext().getRequestDispatcher( "/login.jsp" ).forward( request, response );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession MySession = request.getSession();
		MySession.setAttribute("login", "false");
		try {
			String db_root = getServletContext().getInitParameter("db_path");
			String db_user = getServletContext().getInitParameter("db_user");
			String db_pwd = getServletContext().getInitParameter("db_pwd");
			//Init database connection
			java.sql.Connection conn = db.init(db_root,db_user,db_pwd);
			//Prepared statement
			java.sql.PreparedStatement selectUser = conn.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
			selectUser.setString(1, request.getParameter("email"));
			selectUser.setString(2,request.getParameter("password")); 
			
			ResultSet rsSelect = selectUser.executeQuery();
			
			boolean result = false;
			
			//If there is user, set session user's login
			while(rsSelect.next()){
				MySession.setAttribute("login", "true");
				MySession.setAttribute("loginName", rsSelect.getString("email"));
				MySession.setAttribute("loginId", rsSelect.getString("id"));
				result = true;
			}
			
			//Close db
			db.close(conn);
			
			String message = "";
			
			//If there isn't user, show error message
			if(!result) {
				message = "Wrong credential";
				request.setAttribute("message", message);	
			}
			RequestDispatcher rd = null;
			rd = getServletContext().getRequestDispatcher("/index.jsp");
	        rd.forward(request, response);
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}

}
