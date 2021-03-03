package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Requeriment;

public interface IRequerimentService {
	void registrar(Requeriment requeriment);
	void modificar(Requeriment requeriment);
	void eliminar(int idRequeriment);
	List<Requeriment> listar();
	public Optional<Requeriment> ListarId(int id);

}
