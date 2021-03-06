package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Requirement;

public interface IRequirementService {
	void registrar(Requirement requirement);
	void modificar(Requirement requirement);
	void eliminar(Integer idRequirement);
	List<Requirement> listar();
	public Requirement ListarId(Integer id);

}
