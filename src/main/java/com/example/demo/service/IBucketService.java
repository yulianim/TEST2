package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Bucket;


public interface IBucketService {
	void registrar(Bucket bucket);
	void modificar(Bucket bucket);
	void eliminar(int idBucket);
	List<Bucket> listar();
	public Optional<Bucket> ListarId(int id);
}
