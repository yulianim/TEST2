package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=javax.persistence.InheritanceType.TABLE_PER_CLASS)
@DiscriminatorValue(value = "bucket")
public class Bucket extends Artifact{
	@OneToMany(mappedBy = "bucket")
	private List<Artifact> artifacts=new ArrayList<>();
	public Bucket() {
		// TODO Auto-generated constructor stub
	}
	
	public Bucket(List<Artifact> artifacts) {
		super();
		this.artifacts = artifacts;
	}

	public List<Artifact> getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(List<Artifact> artifacts) {
		this.artifacts = artifacts;
	}
	@Override
	public String toString() {
		return "Bucket [artifacts=" + artifacts + "]";
	}

}
