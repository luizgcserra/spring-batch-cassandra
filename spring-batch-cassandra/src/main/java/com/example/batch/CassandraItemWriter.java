package com.example.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.cassandra.repository.CassandraRepository;

public class CassandraItemWriter<Model, Key> implements ItemWriter<Model>, InitializingBean {

	private static final Logger log = LoggerFactory.getLogger(CassandraItemWriter.class);
	private CassandraRepository<Model, Key> repository;

	public CassandraItemWriter(CassandraRepository<Model, Key> repository) {
		this.repository = repository;
	}

	@Override
	public void write(List<? extends Model> entities) throws Exception {
		//log.info(String.format("Writing %s entryies", entities.size()));

		repository.insert(entities);

	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

}
