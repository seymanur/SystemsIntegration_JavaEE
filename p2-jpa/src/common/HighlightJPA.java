package common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Hightlight
 *
 */
@Entity
//@Table(name="Highlight_Table", schema="is_db")
public class HighlightJPA implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "highlightid")
    private int highlightid;
    @Column(columnDefinition="TEXT")
    private String highlight_title;

    public HighlightJPA() {
	super();
    }
    public int getHighlightid() {
	return this.highlightid;
    }

    public void setHighlightid(int highlightid) {
	this.highlightid = highlightid;
    }
    public String getHighlight_title() {
	return this.highlight_title;
    }

    public void setHighlight_title(String highlight_title) {
	this.highlight_title = highlight_title;
    }

}
