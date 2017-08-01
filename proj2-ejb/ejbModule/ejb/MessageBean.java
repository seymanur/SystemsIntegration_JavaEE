package ejb;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import xmlMapping.Cnn;
import xmlMapping.News;
import xmlMapping.Region;

import common.HighlightJPA;
import common.JournalistJPA;
import common.NewsJPA;
import common.RegionJPA;

/**
 * Message-Driven Bean implementation class for: MessageBean
 */
@MessageDriven(activationConfig = {
	@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
	@ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/test")

})

public class MessageBean implements MessageListener {



    @PersistenceContext(name = "TestPersistence")
    private EntityManager em;


    /**
     * Default constructor.
     */
    public MessageBean() {
	// TODO Auto-generated constructor stub
    }

    


    /**
     * @see MessageListener#onMessage(Message)
     */
    @Override
    public void onMessage(Message message) {
	System.out.println("CORI CORRI CORRI CORII ||||||||||||||||||");

	try {

	    JAXBContext context = JAXBContext.newInstance(Cnn.class);
	    JournalistJPA jourjpa = new JournalistJPA();
	    HighlightJPA highjpa = new HighlightJPA();

	    //
	    Unmarshaller unmarshaller = context.createUnmarshaller();
	    String msg = ((TextMessage) message).getText();
	    StringReader reader = new StringReader(msg);

	    Cnn regionList = (Cnn) unmarshaller.unmarshal(new StreamSource(reader));

	    List<RegionJPA> regions = new ArrayList<RegionJPA>();
	    for(Region r :regionList.getRegion())
	    {
		RegionJPA rjpa = new RegionJPA();
		rjpa.setRegionName(r.getId());
		List<NewsJPA> newsList = new ArrayList<NewsJPA>();
		for(News n : r.getNews())
		{
		    NewsJPA newsjpa = new NewsJPA();

		    //newsjpa.setId(n.getId());
		    //newsjpa.getId();
		    newsjpa.setNewsUrl(n.getNewsurl());
		    //System.out.println(newsjpa.getNewsUrl());
		    newsjpa.setTitle(n.getTitle());
		    //System.out.println(newsjpa.getTitle());
		    newsjpa.setLocation(n.getLocation());
		    //System.out.println(newsjpa.getLocation());
		    newsjpa.setText(n.getText());
		    //System.out.println(newsjpa.getText());
		    newsjpa.setDatetime(n.getDatetime());

		    List<JournalistJPA> lista_jornalistas = new ArrayList<JournalistJPA>();
		    List<String> xx = n.getJournalistList().getJournalist();
		    for (String aba: xx)
		    {
			JournalistJPA novojournalist = new JournalistJPA();

			novojournalist.setJournalistname(aba);
			lista_jornalistas.add(novojournalist);
			System.out.println("");

		    }
		    newsjpa.setJournaList(lista_jornalistas);
		    for(int i = 0; i<newsjpa.getJournaList().size(); i++)
		    {
			System.out.println("journalist :   " + newsjpa.getJournaList().get(i));
		    }
		    newsjpa.setPhotoList((ArrayList<String>) n.getPhotoList().getPhoto());
		    //System.out.println(" photolost : " + newsjpa.get);

		    for (int i = 0; i < newsjpa.getPhotoList().size(); i ++)
		    {
			System.out.println("Photo : " + newsjpa.getPhotoList().get(i));
		    }

		    newsjpa.setVideoUrl(n.getVideourl());
		    System.out.println("video url : " + newsjpa.getVideoUrl());

		    //newsjpa.setStoryhighlightList((ArrayList<String>) n.getStoryhighlightsList().getStoryhighlight());


		    //Set storyhighlight

		    List<HighlightJPA> lista_highlight = new ArrayList<HighlightJPA>();
		    List<String> hh = n.getStoryhighlightsList().getStoryhighlight();
		    for (String s : hh)
		    {
			HighlightJPA novohighlight = new HighlightJPA();

			novohighlight.setHighlight_title(s);
			lista_highlight.add(novohighlight);
		    }
		    newsjpa.setHighlightList(lista_highlight);



		    /// set photo list

		    newsList.add(newsjpa);

		}
		rjpa.setNewsList(newsList);
		regions.add(rjpa);

	    }

	    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");

	    //em = emf.createEntityManager();
	    //EntityTransaction tx = em.getTransaction();

	    //tx.begin();
	    for (RegionJPA regionJPA: regions)
	    {
		System.out.println("Uma regiao " + regionJPA.getRegionName() + " -> " + regionJPA.getNewsList());
		em.persist(regionJPA);
	    }
	    //tx.commit();

	    //em.close();
	    //emf.close();
	}
	catch (JAXBException | JMSException e) {
	    // TODO Auto-generated catch block
	    System.out.println("Message Bean ERROR");
	    e.printStackTrace();
	}

    }

}
