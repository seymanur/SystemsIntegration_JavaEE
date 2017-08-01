package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import xmlMapping.Region;

import common.NewsJPA;

/**
 * Session Bean implementation class NewsBean
 */
@Stateless
public class NewsBean implements NewsBeanRemote {
    @PersistenceContext(name = "TestPersistence")
    private EntityManager em;

    private List<NewsJPA> news = null;
    private List<String> reg = null;
    private List<Region> regions = null;

    /**
     * Default constructor.
     */
    public NewsBean() {
	// TODO Auto-generated constructor stub

    }

    public List<NewsJPA> getNewsList() {
	// TODO Auto-generated method stub
	String query = "SELECT m from NewsJPA m ASC";
	List<NewsJPA> news = null;
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
	    this.news = news;
	}
	return this.news;
    }



    // get dates between 2 days
    @Override
    public List<NewsJPA> newsForGivenDate(String givenDate)
    {
	System.out.println("Entrei1 " + givenDate +"\n");
	String query = "SELECT n FROM NewsJPA n WHERE datetime >= '" + givenDate + "'";

	@SuppressWarnings("unchecked")
	List<NewsJPA> ulist = em.createQuery(query).getResultList();
	/*System.out.println("Entrei2\n");
	List<NewsJPA> goodList = new ArrayList<NewsJPA>();
	System.out.println("Entrei3\n");
	for (NewsJPA x: ulist) {
	    System.out.println("Entrei4 " + x.getDatetime().getDay() + " " + x.getDatetime().getMonth() + " " + givenDate.getDay() + " " + givenDate.getMonth() + "\n");
	    if ((x.getDatetime().getDay() == givenDate.getDay()) && (x.getDatetime().getMonth() == givenDate.getMonth()) && (x.getDatetime().getYear() == givenDate.getYear()))
		//if (x.getDatetime().compareTo(givenDate) == 0)
	    {
		goodList.add(x);
	    }
	}
	System.out.println("Entrei5\n");*/
	return ulist;

    }



    /**
     * List news with a given author
     **/

    @Override
    public List<NewsJPA> checkAuthors(String author)
    {
	String query = "SELECT n FROM NewsJPA n, JournalistJPA j WHERE n.id = j.journalistid AND j.journalistname='"+ author+ "'";
	@SuppressWarnings("unchecked")
	List<NewsJPA> ulist = em.createQuery(query).getResultList();

	return ulist;
    }


    /**
     * List news with highlights that have a given word
     **/

    @Override
    public List<NewsJPA> getNewsByKeyword(String key) {

	//String query = "Select n.news FROM NewsJPA n, HighlightJPA h, WHERE n.id = h.highlightid AND h.text LIKE '%" + key + "%' ORDER BY h.news.date DESC";

	String query = "Select n FROM NewsJPA n, HighlightJPA h WHERE n.id = h.highlightid AND h.highlight_title LIKE CONCAT('% "+key +" %') ORDER BY n.datetime DESC";



	@SuppressWarnings("unchecked")
	List<NewsJPA> ulist = em.createQuery(query).getResultList();

	return ulist;
    }


    @Override
    public List<NewsJPA> getNewsByRegion(String region)
    {
	String query = "SELECT n FROM NewsJPA n, RegionJPA r WHERE n.id=r.regionid AND r.regionName='"+region + "'";

	@SuppressWarnings("unchecked")
	List<NewsJPA> ulist = em.createQuery(query).getResultList();


	return ulist;
    }
    /*
     *
     *
    public List<News> getNewsByRegion(String regionID)
    {

	List<News> news = new ArrayList<News>();

	for(News n:this.news)
	{

	}

	for(Region r : this.regions)
	{
	    r.getId() ;

	}
    }*/
}
