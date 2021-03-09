package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Artifact;
import com.example.demo.model.Bucket;
import com.example.demo.model.Requirement;
import com.example.demo.service.IBucketService;
import com.example.demo.service.IRequirementService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import aj.org.objectweb.asm.TypeReference;


@RestController
@RequestMapping("/buckets")
public class BucketController {
	@Autowired
	private IBucketService bucketService;
	@Autowired
	private IRequirementService requirementService;
	
		// http://localhost:8080/buckets/listar (GET)
		@GetMapping(value = "/listar", produces = "application/json")
		public ResponseEntity<List<Bucket>> listar() {		
			List<Bucket> lista = new ArrayList<>();
			try {
				lista = bucketService.listar();	
			}catch(Exception e) {
				return new ResponseEntity<List<Bucket>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);	
			}
			return new ResponseEntity<List<Bucket>>(lista, HttpStatus.OK);
		}
		//http://localhost:8080/buckets/registrar (POST)
		@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Integer> registrar(@RequestBody Bucket b) {
			int resultado = 0;
			try {
				bucketService.registrar(b);
				resultado = 1;
			} catch (Exception e) {
				return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
		}
		/**
		//http://localhost:8080/buckets/actualizar  (PUT)
		@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Integer> actualizar(@RequestBody Bucket b) {
			int resultado = 0;
			try {
				service.modificar(b);
				resultado = 1;
			} catch (Exception e) {
				return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
		}*/
		/**@PutMapping(value = "/actualizar/{id}")
		public ResponseEntity<Bucket> actualizarBucket(@PathVariable Integer id) {
	        Bucket bucketActualizado = this.service.ListarId(id);
	        Log.info("Bucket obtenido: "+bucketActualizado.toString());
	        if (bucketActualizado != null) {
	        	service.registrar(bucketActualizado);
	            return new ResponseEntity(bucketActualizado, HttpStatus.OK);
	        }
	        return ResponseEntity.notFound().build();
	    }*/
		/**@throws JsonProcessingException 
		 * @throws JsonMappingException 
		 * @PutMapping(value = "/actualizar/{id}")
		public ResponseEntity<Bucket> actualizarBucket(@PathVariable Integer id) {
			Bucket bucket=new Bucket();
			try {
				bucket=bucketService.ListarId(2);
				System.out.println("Bucket: "+bucket.id+", Description:"+bucket.description);
				Requirement r1=new Requirement();
				r1=requirementService.ListarId(3);
				System.out.println("Requirement 1: "+ r1.toString());
				Requirement r2=new Requirement();
				Bucket b1=new Bucket();
				b1=bucketService.ListarId(1);
				r2=requirementService.ListarId(4);
				System.out.println("Requirement 2: "+ r2.toString());
				List<Artifact> listaRequirements=new ArrayList<>();
				listaRequirements.add(r1);
				listaRequirements.add(r2);
				listaRequirements.add(b1);
				System.out.println("Lista de requirements: "+listaRequirements.toString());
				bucket.setArtifacts(listaRequirements);
				bucketService.modificar(bucket);
				return new ResponseEntity<Bucket>(bucket, HttpStatus.OK);
				
			}
			catch (Exception ex) {
			return new ResponseEntity<Bucket>(bucket, HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    }*/
		@PutMapping(value = "/actualizar")
		public ResponseEntity<Bucket> actualizarBucket(@RequestBody com.fasterxml.jackson.databind.JsonNode bucket) throws JsonMappingException, JsonProcessingException {
			ObjectMapper mapper=new ObjectMapper();
			Bucket b=new Bucket();
			JsonNode jsonNode =bucket;
			JsonNode id=jsonNode.get("id");
			String artifacts= jsonNode.get("artifacts").toString();
			Artifact[] art = mapper.readValue(artifacts, Artifact[].class);
			Artifact a;
			System.out.println("Id : "+ id);
			System.out.println("artifacts : "+ artifacts);
			//b.setArtifacts(lista);
			 System.out.println("JSON array to Array objects...");
	            for (Artifact a : art) {
	                System.out.println(a);
	            }
		    bucketService.modificar(b);
			return new ResponseEntity<Bucket>(b, HttpStatus.OK);
			
	    }
		
		//http://localhost:8080/requeriments/eliminar/{ID}  (DELETE)
		@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
			int resultado = 0;
			try {
				bucketService.eliminar(id);
				resultado = 1;
			} catch (Exception e) {
				return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
		}

		@GetMapping(value = "/{id}")
		public ResponseEntity<Bucket> listarId(@PathVariable Integer id) 
			{		
				Bucket bucket=new Bucket();
				try {
				bucket=bucketService.ListarId(id);
			   	return new ResponseEntity<Bucket>(bucket, HttpStatus.OK);}
				catch (Exception ex){
					return new ResponseEntity<Bucket>(bucket, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		
		@PutMapping(value="/process")
	    public void process(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
	        System.out.println(payload);
	    }
		
}
