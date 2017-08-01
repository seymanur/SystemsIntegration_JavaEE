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

import ejb.UserBeanRemote;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserBeanRemote _userBean = null;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
	super();
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
	HttpServlet session;
	RequestDispatcher dispatcher = null;
	System.out.println(request.getParameterMap().entrySet());
	if(!request.getParameterMap().isEmpty())
	{
	    System.out.println(request.getParameter("registerbutton"));
	    String registerButton = request.getParameter("registerbutton");
	    if(registerButton != null)
	    {
		if(request.getParameter("registerbutton").equals("register"))
		{
		    String username = request.getParameter("username");
		    String password = request.getParameter("password");
		    String confirmPassword = request.getParameter("username");
		    String name = request.getParameter("password");
		    String email = request.getParameter("username");
		    String phone = request.getParameter("password");
		    System.out.println("REGISTER");

		    if((username!=null) && (password != null) && (name!=null) && (email!=null) && (phone !=null))
		    {
			if(_userBean.register(username, password, email, name, phone))
			{

			    System.out.println("Register...");
			    ///ASK
			    dispatcher = request.getRequestDispatcher("/login.jsp");
			}
			else
			{
			    dispatcher = request.getRequestDispatcher("/register.jsp");
			}
			dispatcher.forward(request, response);

		    }
		}
		else {
		    request.getRequestDispatcher("/invalidRegister.jsp");
		}
	    }else
	    {
		request.getRequestDispatcher("/register.jsp");
	    }
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doGet(request, response);
    }

}
