package com.example.demo.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@DiscriminatorValue(value="requirement")
public class Requeriment extends Artifact {
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using=ToStringSerializer.class)
	private Date creation_date;
	//MUCHOS REQUERIMIENTOS PUEDEN TENER UN BUCKET
	@ManyToOne
	@JoinColumn(name="id_bucket", nullable=false)
	private Bucket IdBucket;
	public Date getCreation_date() {
		return creation_date;
	}
	private Long owner;
	public void setOwner(Long owner) {
		this.owner = owner;
	}
	
	public Requeriment() {
		super();
	}
	public Requeriment(Requeriment req) {
		// TODO Auto-generated constructor stub
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public Long getOwner() {
		return owner;
	}
	
		

}
