package common;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: RegionJPA
 *(cascade = CascadeType.ALL)
 */
@Entity
//@Table(name="regionTable", schema="is_db")
public class RegionJPA implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regionid")
    private int regionid;
    private String regionName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<NewsJPA> newsList;

    public RegionJPA() {
	super();
    }
    public int getRegionid() {
	return this.regionid;
    }

    public void setRegionid(int regionid) {
	this.regionid = regionid;
    }
    public String getRegionName() {
	return this.regionName;
    }

    public void setRegionName(String regionName) {
	this.regionName = regionName;
    }


    public List<NewsJPA> getNewsList() {
	return newsList;
    }

    public void setNewsList(List<NewsJPA> newsList) {
	this.newsList = newsList;
    }

}
