package com.example.demo.controller;

import java.util.ArrayList;
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

import com.example.demo.model.Bucket;
import com.example.demo.service.IBucketService;

import jdk.internal.org.jline.utils.Log;

@RestController
@RequestMapping("/buckets")
public class BucketController {
	@Autowired
	private IBucketService service;
		// http://localhost:8080/buckets/listar (GET)
		@GetMapping(value = "/listar", produces = "application/json")
		public ResponseEntity<List<Bucket>> listar() {		
			List<Bucket> lista = new ArrayList<>();
			try {
				lista = service.listar();	
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
				service.registrar(b);
				resultado = 1;
			} catch (Exception e) {
				return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
		}
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
		}
		//http://localhost:8080/requeriments/eliminar/{ID}  (DELETE)
		@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
			int resultado = 0;
			try {
				service.eliminar(id);
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
				bucket=service.ListarId(id);
			   	return new ResponseEntity<Bucket>(bucket, HttpStatus.OK);
			}

}
