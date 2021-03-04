package com.example.demo.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="bucket")
public class Bucket extends Artifact{
	public Long owner;
	
	@ElementCollection
	public Collection<Artifact> artifacts;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Collection<Artifact> getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(Collection<Artifact> artifacts) {
		this.artifacts = artifacts;
	}
	public Bucket(Long id, Collection<Artifact> artifacts) {
		super();
		this.id = id;
		this.artifacts = artifacts;
	}
	public Bucket() {
		// TODO Auto-generated constructor stub
	}

}
