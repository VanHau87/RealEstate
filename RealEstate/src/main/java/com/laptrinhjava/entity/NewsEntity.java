package com.laptrinhjava.entity;

import com.laptrinhjava.annotation.Column;
import com.laptrinhjava.annotation.Entity;
import com.laptrinhjava.annotation.Table;

@Entity
@Table(name = "news")
public class NewsEntity {
	@Column(name = "newsid")
	private Integer newsId;
	@Column(name = "title")
	private String title;
	@Column(name = "shortdescription")
	private String shortDescription;
	@Column(name = "content")
	private String content;
	
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
