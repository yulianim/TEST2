package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Artifact;
import com.example.demo.model.Bucket;
import com.example.demo.model.Requirement;
import com.example.demo.service.IBucketService;
import com.example.demo.service.IRequirementService;

@SpringBootApplication
public class RequerimentApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RequerimentApplication.class, args);	
	}
	
	@Autowired
	private IBucketService bucketService;
	@Autowired 
	private IRequirementService requirementService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Bucket b1=new Bucket();
		b1.setTitle("Bucket 1 titulo");
		b1.setDescription("Descripcion del bucket 1");
		b1.setOwner(Long.valueOf(1));
		bucketService.registrar(b1);
		
		Bucket b2=new Bucket();
		b2.setTitle("Bucket 2 titulo");
		b2.setDescription("Descripcion bucket 2");
		b2.setOwner(Long.valueOf(2));
		bucketService.registrar(b2);
		
		Requirement r1=new Requirement();
		r1.setTitle("Requirement 1 titulo");
		r1.setDescription("Descripcion del requirement 1");
		r1.setOwner(Long.valueOf(1));
		r1.setCreation_date(new Date());
		requirementService.registrar(r1);
		
		Requirement r2=new Requirement();
		r2.setTitle("Requirement 2 titulo");
		r2.setDescription("Descripcion del requirement 2");
		r2.setOwner(Long.valueOf(2));
		r2.setCreation_date(new Date());
		requirementService.registrar(r2);
		
		List<Artifact> artifacts=new ArrayList<>();
		artifacts.add(r1);
		artifacts.add(r2);
		artifacts.add(b1);
		artifacts.add(b2);
		System.out.println("Lista: "+artifacts.toString());
		
		//System.out.println(bucketService.editarBucket(1));
		
	}
	

}
