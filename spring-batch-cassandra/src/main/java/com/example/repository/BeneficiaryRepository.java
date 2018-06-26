package com.example.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Beneficiary;

@Repository
public interface BeneficiaryRepository extends CassandraRepository<Beneficiary, String> {
	@Query(value="SELECT count(*) FROM beneficiary")
	public long count();
}
