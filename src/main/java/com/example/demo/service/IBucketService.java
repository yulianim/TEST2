package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Artifact;
import com.example.demo.model.Bucket;


public interface IBucketService {
	Bucket registrar(Bucket bucket);
	void modificar(Bucket bucket);
	void eliminar(Integer idBucket);
	List<Bucket> listar();
	Bucket ListarId(int id);
	Bucket editarBucket(int id);
}
