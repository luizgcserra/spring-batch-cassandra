package com.example.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraBatchOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.example.model.Beneficiary;
import com.example.model.BeneficiaryKey;

public class BeneficiaryRepositoryImpl implements BeneficiaryRepository {

	private final CassandraTemplate cassandraTemplate;

	@Autowired
	public BeneficiaryRepositoryImpl(CassandraTemplate cassandraTemplate) {
		this.cassandraTemplate = cassandraTemplate;
	}

	@Override
	public <S extends Beneficiary> List<S> saveAll(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beneficiary> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beneficiary> findAllById(Iterable<BeneficiaryKey> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Slice<Beneficiary> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Beneficiary> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public <S extends Beneficiary> List<S> insert(Iterable<S> entities) {

		final CassandraBatchOperations batchOps = cassandraTemplate.batchOps();
		batchOps.insert(entities);
		batchOps.execute();

		return (List<S>) entities;
	}

	@Override
	public void delete(Beneficiary arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Beneficiary> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(BeneficiaryKey arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsById(BeneficiaryKey arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Beneficiary> findById(BeneficiaryKey arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Beneficiary> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


}