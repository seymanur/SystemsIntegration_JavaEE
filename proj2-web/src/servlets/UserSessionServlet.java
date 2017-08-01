package servlets;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.NewsJPA;

import ejb.NewsBeanRemote;
import ejb.UserBeanRemote;

/**
 * Servlet implementation class UserSessionServlet
 */
@WebServlet("/UserSessionServlet")
public class UserSessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NewsBeanRemote _newsBean;
    private UserBeanRemote _userBean;
    private InitialContext context ;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSessionServlet() {
	super();
	try {
	    context = new InitialContext();
	    _newsBean = (NewsBeanRemote) context.lookup("java:global/proj2/proj2-ejb/NewsBean!ejb.NewsBeanRemote");

	}
	catch (NamingException e) {
	    e.printStackTrace();
	    System.out.println("");
	}

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Request has arrived to UserSessionServlet...");

	HttpSession session;
	session = request.getSession();

	if(!session.isNew())
	{
	    Date limitByDay = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
	    Date limitByHour = new Date(System.currentTimeMillis() - 60 * 60 * 1000);
	    Date created = new Date(session.getCreationTime());
	    Date accessed = new Date(session.getLastAccessedTime());

	    // identify which user is logged in
	    String value = _userBean.getName();

	    request.setAttribute("value", value);
	    request.getRequestDispatcher("page.jsp").forward(request, response);


	    // Invalidate the session if it's more than a day old or has been
	    // inactive for more than an hour.
	    if (created.before(limitByDay) || accessed.before(limitByHour)) {
		session.invalidate();
		session = request.getSession(); // get new sesion

	    }


	    if(!request.getParameterMap().isEmpty())
	    {
		List<NewsJPA> byRegion = null;
		String region = null;
		System.out.println("KKKK " + request.getParameter("submitSearch"));
		if(request.getParameter("submitSearch")!=null)
		{
		    String searchButton = request.getParameter("submitSearch");
		    if(searchButton.equals("US"))
		    {
			region = request.getParameter("US");
			System.out.println("region US : " + region);
			byRegion = _newsBean.getNewsByRegion("US");
			if(byRegion != null && byRegion.size()>0)
			{
			    session.setAttribute("news", byRegion);

			} else {
			    System.out.println("[USERSERVLET] empty date news");
			}
		    }
		    if(searchButton.equals("Africa"))
		    {
			region =  request.getParameter("Africa");
			System.out.println("region US : " + region);
			byRegion = _newsBean.getNewsByRegion("AFRICA");
			if(byRegion != null && byRegion.size()>0)
			{
			    session.setAttribute("news", byRegion);

			} else {
			    System.out.println("[USERSERVLET] empty date news");
			}
		    }
		    if(searchButton.equals("Europe"))
		    {
			region =  request.getParameter("Europe");
			System.out.println("region US : " + region);
			byRegion = _newsBean.getNewsByRegion("EUROPE");
			if(byRegion != null && byRegion.size()>0)
			{
			    session.setAttribute("news", byRegion);

			} else {
			    System.out.println("[USERSERVLET] empty date news");
			}
		    }
		    if(searchButton.equals("Asia"))
		    {
			region =  request.getParameter("Asia");
			System.out.println("region US : " + region);
			byRegion = _newsBean.getNewsByRegion("ASIA");
			if(byRegion != null && byRegion.size()>0)
			{
			    session.setAttribute("news", byRegion);

			} else {
			    System.out.println("[USERSERVLET] empty date news");
			}
		    }
		    if(searchButton.equals("Latin America"))
		    {
			region =  request.getParameter("Latin America");
			System.out.println("region US : " + region);
			byRegion = _newsBean.getNewsByRegion("LATINAMERICA");
			if(byRegion != null && byRegion.size()>0)
			{
			    session.setAttribute("news", byRegion);

			} else {
			    System.out.println("[USERSERVLET] empty date news");
			}
		    }
		    if(searchButton.equals("Middle East"))
		    {
			region =  request.getParameter("Middle East");
			System.out.println("region US : " + region);
			byRegion = _newsBean.getNewsByRegion("MIDDLEEAS");
			if(byRegion != null && byRegion.size()>0)
			{
			    session.setAttribute("news", byRegion);

			} else {
			    System.out.println("[USERSERVLET] empty date news");
			}

		    }


		    if(searchButton.equals("authorvalue"))
		    {
			String author = request.getParameter("author");
			System.out.println("author: " + author);
			List<NewsJPA> authornews = _newsBean.checkAuthors(author);
			if(authornews != null && authornews.size()>0)
			{
			    session.setAttribute("news", authornews);

			} else {
			    System.out.println("[USERSERVLET] empty author news");
			}
		    }
		    if(searchButton.equals("keyvalue"))
		    {
			String key = request.getParameter("key");
			System.out.println("key: " + key);
			List<NewsJPA> keynews = _newsBean.getNewsByKeyword(key);
			if(keynews != null && keynews.size()>0)
			{
			    session.setAttribute("news", keynews);

			} else {
			    System.out.println("[USERSERVLET] empty date news");
			}
		    }

		    if(searchButton.equals("datevalue"))
		    {
			System.out.println(request.getParameter("date"));
			if((request.getParameter("date")!=null) && (!request.getParameter("date").isEmpty()))
			{
			    String dateString = request.getParameter("date");

			    //Date chosenDate =new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
			    String []dale = dateString.split("/");
			    String nova = dale[2] + "-" + dale[0] + "-" + dale[1];
			    List<NewsJPA> datenews = _newsBean.newsForGivenDate(nova);
			    if(datenews != null && datenews.size()>0)
			    {
				session.setAttribute("news", datenews);

			    } else {
				System.out.println("[USERSERVLET] empty date news");
			    }}

			else {
			    System.out.println("Empty date. You cannot");
			}
		    }

		}

	    }
	    response.sendRedirect("user_session.jsp");
	}

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
