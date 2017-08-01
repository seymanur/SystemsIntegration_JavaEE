package ejb;

import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import common.NewsJPA;
import common.UserJPA;


/**
 * Session Bean implementation class EmailBean
 */
@Stateless
public class EmailBean implements EmailBeanRemote {
    @PersistenceContext(name = "TestPersistence")
    private EntityManager em;

    /**
     * Default constructor.
     */
    public EmailBean() {
	// TODO Auto-generated constructor stub
    }

    @Schedule(second="*", minute="*",hour="*/24", persistent=false)
    public void doWork(){
	sendMail(getNews(), getUsers());
    }

    public List<UserJPA> getUsers(){
	Query query = em.createQuery("Select u From Users u");
	@SuppressWarnings("unchecked")
	List<UserJPA> users = query.getResultList();
	return users;
    }

    public List<NewsJPA> getNews(){
	String data = Calendar.getInstance().YEAR + "-" + Calendar.getInstance().MONTH + "-" + Calendar.getInstance().DATE;
	System.out.println(data);
	Query query = em.createQuery("SELECT r From NewsJPA r Where r.datetime >= '" + "2014-11-19" + "'");
	@SuppressWarnings("unchecked")
	List<NewsJPA> news =  query.getResultList();
	return news;
    }
    UserBean _userbean = null;

    public void sendEmailAllUsers()
    {
	List<String> email = _userbean.getAllEmails();
	for (int i = 0; i<email.size(); i++)
	{
	    //sent.()
	}

    }
    /**
     *
     *
     * @param titleList
     *
     * @param toEmail
     *
     */

    String from = "isjavaenterprise@gmail.com";
    private static final String TEST_STRING = "isjavaenterprise@gmail.com";
    private static final String TEST_PASSWORD = "systemsintegration";
    private static final String NEWS_TITLE = "Recent News";


    public void sendMail(List<NewsJPA> news, List<UserJPA> users) {
	String message = "Dear user, today we have the following news to read: \n-";
	for(NewsJPA n : news){
	    message += n.getTitle() + " - " + n.getDatetime().toString() + "\nAccess the new: " + n.getNewsUrl() + "\n" + "\r";
	}

	for (UserJPA use : users){
	    sendMail(TEST_STRING, NEWS_TITLE, message);
	}

    }
    public void sendMail(String to, String subject, String message) {
	try {
	    Properties props = new Properties();

	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.starttls.enable","true");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.user", from);
	    props.put("mail.debug", "true");
	    props.put("mail.smtp.port", 465);
	    props.put("mail.smtp.socketFactory.port", 465);
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.socketFactory.fallback", "false");

	    SimpleAuth auth = null;

	    Session session = Session.getInstance(props, auth);
	    session.setDebug(false);
	    Message msg = new MimeMessage(session);

	    try {
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		msg.setFrom(new InternetAddress(from));
		msg.setSubject(subject);
		msg.setContent(message,"text/plain");
	    } catch (Exception e) {
		System.out.println(">>Fail to send the email"+ e);
	    }
	    Transport tr;
	    try {
		tr = session.getTransport("smtp");
		tr.connect("smtp.gmail.com", "isjavaenterprise@gmail.com", "systemsintegration");
		msg.saveChanges();
		tr.sendMessage(msg, msg.getAllRecipients());
		tr.close();
	    } catch (Exception e) {
		System.out.println(">> Error1: Message error : "+e);
	    }
	} catch (Exception e) {
	    System.out.println(">> Error2: Message error: "+e);
	}
	/*public void sent(java.util.List<String> newsList, String toEmail)
    {
	try
	{
	    String host = "smtp.gmail.com";
	    final String from = "isjavaenterprise@gmail.com";
	    final String pass = "systemsintegration";
	    Properties props = System.getProperties();
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.user", from);
	    props.put("mail.smtp.password", pass);
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", "true");

	    Session session = Session.getInstance(props, new javax.mail.Authenticator(){
		@Override
		protected PasswordAuthentication getPasswordAuthentication(){
		    return new PasswordAuthentication(from, pass);
		}
	    });
	}
	catch (Exception e) {
	    e.printStackTrace();
	}

    }*/


    }
}
class SimpleAuth extends Authenticator {
    public String username = null;
    public String password = null;


    public SimpleAuth(String user, String pwd) {
	username = user;
	password = pwd;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication (username, password);
    }

}