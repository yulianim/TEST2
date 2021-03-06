package com.example.demo.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IBucketDAO;
import com.example.demo.model.Bucket;
import com.example.demo.service.IBucketService;

@Service
public class BucketServiceImpl implements IBucketService{
	@Autowired
	private IBucketDAO dao;

	@Override
	public void registrar(Bucket bucket) {
		// TODO Auto-generated method stub
		dao.save(bucket);
	}

	@Override
	public void modificar(Bucket bucket) {
		// TODO Auto-generated method stub
		bucket.getArtifacts().forEach(x->x.setBucket(bucket));
		dao.save(bucket);
	}

	@Override
	public void eliminar(Integer idBucket) {
		// TODO Auto-generated method stub
		dao.deleteById(idBucket);
	}

	@Override
	public List<Bucket> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Bucket ListarId(int id) {
		// TODO Auto-generated method stub
		//Optional<Bucket> bucket = dao.findById(id);
		return dao.findById(id).orElse(null);
	}
}
