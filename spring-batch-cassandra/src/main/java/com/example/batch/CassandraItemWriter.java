package com.example.batch;

import java.util.List;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.repository.CrudRepository;

public class CassandraItemWriter<Model, Key> implements ItemWriter<Model>, InitializingBean {

	private CrudRepository<Model, Key> repository;

	public CassandraItemWriter(CrudRepository<Model, Key> repository) {
		this.repository = repository;
	}

	@Override
	public void write(List<? extends Model> arg0) throws Exception {
		repository.saveAll(arg0);

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
