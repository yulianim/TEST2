package com.example.demo.model;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=javax.persistence.InheritanceType.TABLE_PER_CLASS)
@DiscriminatorValue(value = "bucket")
public class Bucket extends Artifact{
	@OneToMany
	private Collection<Artifact> requirements;
	
	public Bucket() {
		// TODO Auto-generated constructor stub
	}

}
