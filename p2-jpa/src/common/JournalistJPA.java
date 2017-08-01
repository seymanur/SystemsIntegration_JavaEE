package common;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


/**
 * Entity implementation class for Entity: JournalistJPA_Table
 *
 */
@Entity
//@Table(name="Journalist_Table", schema="is_db")

public class JournalistJPA implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journalistid")
    private int journalistid;
    @Column(columnDefinition="TEXT")
    private String journalistname;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "journaList")
    private List<NewsJPA> newsList;


    public JournalistJPA() {
	super();
    }
    public int getJournalistid() {
	return this.journalistid;
    }

    public void setJournalistid(int jourid) {
	this.journalistid = jourid;
    }
    public String getJournalistname() {
	return this.journalistname;
    }

    public void setJournalistname(String journalistname) {
	this.journalistname = journalistname;
    }

    public List<NewsJPA> getNewsList() {
	return newsList;
    }

    public void setNewsList(List<NewsJPA> newsList) {
	this.newsList = newsList;
    }
}
