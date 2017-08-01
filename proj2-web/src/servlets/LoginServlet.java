package servlets;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejb.UserBeanRemote;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserBeanRemote _userBean;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
	super();
	// TODO Auto-generated constructor stub
	InitialContext ctx;
	try {
	    ctx = new InitialContext();
	    _userBean = (UserBeanRemote) ctx.lookup("java:global/proj2/proj2-ejb/UserBean!ejb.UserBeanRemote");

	}
	catch (NamingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    System.out.println("INITIAL CONTEXT LOOKUP ERROR");
	}
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	HttpSession session;
	RequestDispatcher dispatcher = null;
	System.out.println(request.getParameterMap().entrySet());
	if(!request.getParameterMap().isEmpty())
	{
	    System.out.println(request.getParameter("loginbutton"));
	    String loginButton = request.getParameter("loginbutton");

	    if(loginButton != null)
	    {
		if(request.getParameter("loginbutton").equals("login"))
		{
		    String username = request.getParameter("username");
		    String password = request.getParameter("password");
		    if((username!=null) && (password!=null))
		    {
			if(_userBean.login(username, password))
			{
			    session = request.getSession(true);
			    session.setMaxInactiveInterval(20*60);
			    session.setAttribute("userbean", _userBean);
			    session.setAttribute("nome", _userBean.getName());
			    System.out.println("Success login");
			    /////////////////// set - get attribute
			    dispatcher = request.getRequestDispatcher("/user_session.jsp");
			}
			else
			{
			    dispatcher = request.getRequestDispatcher("/invalidLogin.jsp");
			}
			dispatcher.forward(request, response);
		    }
		    else
		    {
			request.getRequestDispatcher("/login.jsp").include(request, response);
		    }

		}
		else
		{
		    request.getRequestDispatcher("invalidLogin.jsp").include(request, response);
		}
	    }
	    else
	    {
		request.getRequestDispatcher("/login.jsp").include(request, response);

	    }
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
    }

}
