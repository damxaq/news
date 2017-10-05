package models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class User extends Model{
	
	public String login;
	public String password;
	public String email;
	public String fullName;
	public String role;
	
	public String rated;
	
	public User(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}
	
    public static User connect(String email, String password){
    	return find("byEmailAndPassword", email, password).first();
    }
    
    

}
