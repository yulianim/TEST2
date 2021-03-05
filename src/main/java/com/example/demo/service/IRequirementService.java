package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Requirement;

public interface IRequirementService {
	void registrar(Requirement requirement);
	void modificar(Requirement requirement);
	void eliminar(Long idRequirement);
	List<Requirement> listar();
	public Optional<Requirement> ListarId(Long id);

}
