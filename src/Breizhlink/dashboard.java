package Breizhlink;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.db;

/**
 * Servlet implementation class dashboard
 */

public class dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Check if user is logged
		HttpSession MySession = request.getSession();
		Object logged = MySession.getAttribute("login");
		
		//Redirect to login if not logged
		if(logged == null || logged.toString() == "false") {
			response.sendRedirect("/Pouet/login");
			return;
		}
		
		try {
			String db_root = getServletContext().getInitParameter("db_path");
			String db_user = getServletContext().getInitParameter("db_user");
			String db_pwd = getServletContext().getInitParameter("db_pwd");
			java.sql.Connection conn = db.init(db_root,db_user,db_pwd);
			
			String strQuery = "SELECT * FROM user;";

			java.sql.Statement stSelect = conn.createStatement();
			
			ResultSet rsSelect = stSelect.executeQuery(strQuery);
			
			//ArrayList of user
			ArrayList<user> users = new ArrayList<user>();
			 
			//Add each query result in ArrayList
			 while(rsSelect.next()) {
				 user usr = new user(rsSelect.getString(2), rsSelect.getString(3), rsSelect.getInt(1));
				 users.add(usr);
			 }
			 rsSelect.close();
			 
			 //Set session attribute users
			request.getSession().setAttribute("users", users);
			 
			 this.getServletContext().getRequestDispatcher( "/dashboard.jsp" ).forward( request, response );
			 
			db.close(conn);
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
