package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: News_Table
 *
 */
@Entity
//@Table(name = "News_Table", schema="is_db")
public class NewsJPA implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "newsid")
    private int id;
    @Column(columnDefinition="TEXT")
    private String newsUrl;
    @Column(columnDefinition="TEXT")
    private String title;
    @Column(columnDefinition="TEXT")
    private String location;
    @Column(columnDefinition="TEXT")
    private String text;
    private Date datetime;
    // private ArrayList<String> journalistList;
    private ArrayList<String> photoList;
    @Column(columnDefinition="TEXT")
    private String videoUrl;
    // private ArrayList<String> storyhighlightList;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<JournalistJPA> journaList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<HighlightJPA> highlightList;



    public NewsJPA() {
	super();
    }

    public int getId() {
	return this.id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getNewsUrl() {
	return this.newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
	this.newsUrl = newsUrl;
    }

    public String getTitle() {
	return this.title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getLocation() {
	return this.location;
    }

    public void setLocation(String location) {
	this.location = location;
    }

    public String getText() {
	return this.text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public Date getDatetime() {
	return this.datetime;
    }

    public void setDatetime(Date datetime) {
	this.datetime = datetime;
    }

    /*  public ArrayList getJournalistList() {
	return this.journalistList;
    }

    public void setJournalistList(ArrayList<String> journalistList) {
	this.journalistList = journalistList;
    }*/

    public ArrayList getPhotoList() {
	return this.photoList;
    }

    public void setPhotoList(ArrayList<String> photoList) {
	this.photoList = photoList;
    }

    public String getVideoUrl() {
	return this.videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
	this.videoUrl = videoUrl;
    }

    //    public ArrayList getStoryhighlightList() {
    //	return this.storyhighlightList;
    //    }
    //
    //    public void setStoryhighlightList(ArrayList storyhighlightList) {
    //	this.storyhighlightList = storyhighlightList;
    //    }

    public List<JournalistJPA> getJournaList() {
	return journaList;
    }

    public void setJournaList(List<JournalistJPA> journaList) {
	this.journaList = journaList;
    }

    public List<HighlightJPA> getHighlightList() {
	return highlightList;
    }

    public void setHighlightList(List<HighlightJPA> highlightList) {
	this.highlightList = highlightList;
    }
}
