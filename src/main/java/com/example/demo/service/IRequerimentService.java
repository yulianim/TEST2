package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Requeriment;

public interface IRequerimentService {
	void registrar(Requeriment requeriment);
	void modificar(Requeriment requeriment);
	void eliminar(int idRequeriment);
	List<Requeriment> listar();
	//Requeriment ListarId(int idRequeriment);

}
