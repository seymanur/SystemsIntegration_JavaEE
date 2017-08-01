//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.10.12 at 04:04:05 AM BST
//


package xmlMapping;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}newsurl"/>
 *         &lt;element ref="{}title"/>
 *         &lt;element ref="{}location" minOccurs="0"/>
 *         &lt;element ref="{}text"/>
 *         &lt;element ref="{}datetime"/>
 *         &lt;element ref="{}journalist_list" minOccurs="0"/>
 *         &lt;element ref="{}photo_list" minOccurs="0"/>
 *         &lt;element ref="{}videourl" minOccurs="0"/>
 *         &lt;element ref="{}storyhighlights_list" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"newsurl",
	"title",
	"location",
	"text",
	"datetime",
	"journalistList",
	"photoList",
	"videourl",
	"storyhighlightsList"
})
@XmlRootElement(name = "news")
public class News implements Serializable  {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String newsurl;
    @XmlElement(required = true)
    protected String title;
    protected String location;
    @XmlElement(required = true)
    protected String text;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date datetime;
    @XmlElement(name = "journalist_list")
    protected JournalistList journalistList;
    @XmlElement(name = "photo_list")
    protected PhotoList photoList;
    @XmlSchemaType(name = "anyURI")
    protected String videourl;
    @XmlElement(name = "storyhighlights_list")
    protected StoryhighlightsList storyhighlightsList;
    @XmlAttribute(name = "id", required = true)
    protected int id;


    /**
     * Gets the value of the newsurl property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNewsurl() {
	return newsurl;
    }

    /**
     * Sets the value of the newsurl property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNewsurl(String value) {
	this.newsurl = value;
    }

    /**
     * Gets the value of the title property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTitle() {
	return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTitle(String value) {
	this.title = value;
    }

    /**
     * Gets the value of the location property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLocation() {
	return location;
    }

    /**
     * Sets the value of the location property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLocation(String value) {
	this.location = value;
    }

    /**
     * Gets the value of the text property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getText() {
	return text;
    }

    /**
     * Sets the value of the text property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setText(String value) {
	this.text = value;
    }

    /**
     * Gets the value of the datetime property.
     *
     * @return
     *     possible object is
     *     {@link Date }
     *
     */
    public Date getDatetime() {
	return datetime;
    }

    /**
     * Sets the value of the datetime property.
     *
     * @param value
     *     allowed object is
     *     {@link Date }
     *
     */
    public void setDatetime(Date value) {
	this.datetime = value;
    }

    /**
     * Gets the value of the journalistList property.
     *
     * @return
     *     possible object is
     *     {@link JournalistList }
     *
     */
    public JournalistList getJournalistList() {
	return journalistList;
    }

    /**
     * Sets the value of the journalistList property.
     *
     * @param value
     *     allowed object is
     *     {@link JournalistList }
     *
     */
    public void setJournalistList(JournalistList value) {
	this.journalistList = value;
    }

    /**
     * Gets the value of the photoList property.
     *
     * @return
     *     possible object is
     *     {@link PhotoList }
     *
     */
    public PhotoList getPhotoList() {
	return photoList;
    }

    /**
     * Sets the value of the photoList property.
     *
     * @param value
     *     allowed object is
     *     {@link PhotoList }
     *
     */
    public void setPhotoList(PhotoList value) {
	this.photoList = value;
    }

    /**
     * Gets the value of the videourl property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVideourl() {
	return videourl;
    }

    /**
     * Sets the value of the videourl property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVideourl(String value) {
	this.videourl = value;
    }

    /**
     * Gets the value of the storyhighlightsList property.
     *
     * @return
     *     possible object is
     *     {@link StoryhighlightsList }
     *
     */
    public StoryhighlightsList getStoryhighlightsList() {
	return storyhighlightsList;
    }

    /**
     * Sets the value of the storyhighlightsList property.
     *
     * @param value
     *     allowed object is
     *     {@link StoryhighlightsList }
     *
     */
    public void setStoryhighlightsList(StoryhighlightsList value) {
	this.storyhighlightsList = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public int getId() {
	return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setId(int value) {
	this.id = value;
    }

}
