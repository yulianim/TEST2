package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Artifact {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	public String title;
	public String description;
	public Long owner;
	public Artifact() {
		// TODO Auto-generated constructor stub
	}
	
	public Artifact(Integer id, String title, String description, Long owner, Bucket bucket) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.owner = owner;
		this.bucket = bucket;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="bucket_id",referencedColumnName="id") 
	public Bucket bucket;
	public Bucket getBucket() {
		return bucket;
	}
	public void setBucket(Bucket bucket) {
		this.bucket = bucket;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getOwner() {
		return owner;
	}
	public void setOwner(Long owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "Artifact [id=" + id + ", title=" + title + ", description=" + description + ", owner=" + owner
				+ ", bucket=" + bucket + "]";
	}
	
	
	
}
