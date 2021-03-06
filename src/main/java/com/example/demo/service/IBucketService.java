package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Bucket;


public interface IBucketService {
	void registrar(Bucket bucket);
	void modificar(Bucket bucket);
	void eliminar(Integer idBucket);
	//List<Bucket> guadarLista(List<Bucket> buckets);
	List<Bucket> listar();
	Bucket ListarId(int id);
}
