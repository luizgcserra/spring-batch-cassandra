package com.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;
import com.example.model.Beneficiary;

@Configuration
@EnableCassandraRepositories(basePackageClasses = com.example.repository.BeneficiaryRepository.class)
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Autowired
	private Session session;

	@Value("${spring.data.cassandra.contact-points}")
	private String HOST;

	@Value("${spring.data.cassandra.keyspace-name}")
	private String KEY_SPACE;

	@Value("${spring.data.cassandra.port}")
	private int PORT;

	@Autowired
	public CassandraConfig(Environment env) {
		this.HOST = env.getProperty("spring.data.cassandra.contact-points");
		this.PORT = Integer.parseInt(env.getProperty("spring.data.cassandra.port"));
		this.KEY_SPACE = env.getProperty("spring.data.cassandra.keyspace-name");
	}

	@Bean
	public MappingManager mappingManager() {
		return new MappingManager(session);
	}

	@Override
	protected String getKeyspaceName() {
		return KEY_SPACE;
	}

	@Override
	protected String getContactPoints() {
		return HOST;
	}

	@Override
	protected int getPort() {
		return PORT;
	}

	@Override
	public String[] getEntityBasePackages() {
		return new String[] { Beneficiary.class.getPackage().getName() };
	}

	@Bean(name = "cassandraTemplate")
	public CassandraTemplate profileCassandraTemplate() throws Exception {
		final CassandraTemplate cassandraTemplate = new CassandraTemplate(session().getObject(), cassandraConverter());

		return cassandraTemplate;
	}

}