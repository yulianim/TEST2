package com.example.demo.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IRequirementDAO;
import com.example.demo.model.Requirement;
import com.example.demo.service.IRequirementService;

@Service
public class RequirementServiceImpl implements IRequirementService{
	@Autowired
	private IRequirementDAO dao;

	@Override
	public void registrar(Requirement requeriment) {
		// TODO Auto-generated method stub
		dao.save(requeriment);
	}

	@Override
	public void modificar(Requirement requeriment) {
		// TODO Auto-generated method stub
		dao.save(requeriment);
	}

	@Override
	public void eliminar(Integer idRequeriment) {
		// TODO Auto-generated method stub
		dao.deleteById(idRequeriment);
	}

	@Override
	public List<Requirement> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Requirement ListarId(Integer id) {
		return dao.findById(id).orElse(null);
	}
    
	
}
