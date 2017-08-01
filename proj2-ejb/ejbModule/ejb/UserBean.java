package ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import xmlMapping.News;

import common.UserJPA;
/**
 * Session Bean implementation class UserBean
 */
@Stateful
public class UserBean implements UserBeanRemote {
    @PersistenceContext (name="TestPersistence")
    private EntityManager em;
    private UserJPA user = null;


    private List<News> newslist = null;

    /**
     * Default constructor.
     */
    public UserBean() {
	// TODO Auto-generated constructor stub
    }

    /**
     * login
     */

    @SuppressWarnings("unchecked")
    private boolean checkUserExists(String username)
    {
	String query = "SELECT u FROM UserJPA u WHERE username = '" + username + "'";
	List<UserJPA> ulist = em.createQuery(query).getResultList();
	if(ulist.size() > 0)
	{
	    return true;
	}
	else {
	    return false;
	}
    }


    /**
     * login
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean login(String username, String password)
    {
	String query = "Select u FROM UserJPA u WHERE username ='" + username + "' AND password='" + password +"'";
	List<UserJPA> ulist = em.createQuery(query).getResultList();
	if(ulist.size() > 0)
	{
	    user = ulist.get(0);
	    return true;
	}
	else {
	    return false;
	}
    }

    /**
     * logout
     */

    @Override
    public boolean logout()
    {
	user = null;
	return true;
    }

    /**
     * Return the name of the user who has logged in.
     */
    @Override
    public String getName()
    {
	if(user != null){
	    return user.getUsername();
	}
	else {
	    return null;
	}
    }

    /**
     * Return the email of the user who has logged in.
     * */

    @Override
    public String getEmail()
    {
	if(user != null)
	{
	    return user.getEmail();
	}
	else {
	    return null;
	}
    }

    /**
     * Perform registration
     */

    @Override
    public boolean register(String username, String password, String email, String name, String phone)
    {
	//Verify if the username already exists
	if(checkUserExists(username) == false)
	{
	    UserJPA newuser = new UserJPA(username, password, email, name, phone);
	    em.persist(newuser);
	    return true;
	}
	else {
	    return false;
	}
    }




    /**
     * List the recent news than a given date
     */



    /**
     * List the news for each author
     */

    public void listForAuthor(String author1, String author2) {
	if(author2 != "")
	{

	}
	else
	{

	}

    }

    public List<String> getAllEmails()
    {
	String query = "SELECT u.email FROM UserJPA u";

	List<String> emailList = em.createQuery(query).getResultList();

	return emailList;

    }
    @SuppressWarnings("unchecked")
    public List<News> getNewsList1() {
	// TODO Auto-generated method stub
	String query = "SELECT m from News m";
	List<News> news = null;
	try
	{
	    news = em.createQuery(query).getResultList();

	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	System.out.println(news.size());
	if (news.size() > 0) {
	    this.newslist = news;
	}
	return this.newslist;
    }

}
