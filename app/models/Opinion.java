package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Opinion extends Model{

	public String author;
	
	@Lob
	public String text;
	
	@ManyToOne
	public Article article;
	
	public Date date;
	public int rated;
	public Opinion(String author, String text, Article article) {
		this.article = article;
		this.author = author;
		this.text = text;
		this.date = new Date();
	}
	
	
	
	
}
