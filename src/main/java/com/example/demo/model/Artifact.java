package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Artifact {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	public String title;
	public String description;
	public Long owner;
	@ManyToOne
	@JoinColumn(name="bucket_id",referencedColumnName="id") 
	public Bucket bucket;
	public Bucket getBucket() {
		return bucket;
	}
	public void setBucket(Bucket bucket) {
		this.bucket = bucket;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	
	
}
