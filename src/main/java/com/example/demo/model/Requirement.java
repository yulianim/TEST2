package com.example.demo.model;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Inheritance(strategy=javax.persistence.InheritanceType.TABLE_PER_CLASS)
@DiscriminatorValue(value = "requirement")
public class Requirement extends Artifact {
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonSerialize(using=ToStringSerializer.class)
	public Date creation_date;

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
    
	

}
