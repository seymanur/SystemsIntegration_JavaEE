package common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="User_Table")
public class UserJPA implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private static final long serialVersionUID = 1L;


    public UserJPA() {
	super();
    }
    public UserJPA(String username, String password, String email, String name, String phone) {
	// TODO Auto-generated constructor stub
	this.username = username;
	this.password = password;
	this.email = email;
	this.name = name;

    }
    public int getId() {
	return this.id;
    }

    public void setId(int id) {
	this.id = id;
    }
    public String getUsername() {
	return this.username;
    }

    public void setUsername(String username) {
	this.username = username;
    }
    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }
    public String getEmail() {
	return this.email;
    }

    public void setEmail(String email) {
	this.email = email;
    }
    public String getPhone() {
	return this.phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }


    @Override
    public String toString() {
	return "User " + id + ": " + username + ":" + password + " " + email + " " + name + " " + phone;
    }

}
