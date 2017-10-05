package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Article extends Model {

	@ManyToOne
	public User author;
	public String title;
	
	@Lob
	public String text;
	public Date date;
	
	@OneToMany(mappedBy="article", cascade=CascadeType.ALL)
	public List<Opinion> opinions;
	
	public int rated;
	public Article(String title, String text, User author) {
		this.opinions = new ArrayList<Opinion>();
		this.author = author;
		this.title = title;
		this.text = text;
		this.date = new Date();
	}
	
	public Article addOpinion(String author, String text){
		Opinion newOpinion = new Opinion(author, text, this).save();
		this.opinions.add(newOpinion);
		this.save();
		return this;
	}
	
}
