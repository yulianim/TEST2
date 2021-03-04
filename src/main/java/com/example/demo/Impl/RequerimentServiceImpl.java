package com.example.demo.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IRequerimentDAO;
import com.example.demo.model.Requeriment;
import com.example.demo.service.IRequerimentService;

@Service
public class RequerimentServiceImpl implements IRequerimentService{
	@Autowired
	private IRequerimentDAO dao;

	@Override
	public void registrar(Requeriment requeriment) {
		// TODO Auto-generated method stub
		dao.save(requeriment);
	}

	@Override
	public void modificar(Requeriment requeriment) {
		// TODO Auto-generated method stub
		dao.save(requeriment);
	}

	@Override
	public void eliminar(int idRequeriment) {
		// TODO Auto-generated method stub
		dao.deleteById(idRequeriment);
	}

	@Override
	public List<Requeriment> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Requeriment> ListarId(int id) {
		Optional<Requeriment> req = dao.findById(id);
		return null;
	}
    
	
}
