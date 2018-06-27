package com.example.model;

import java.io.Serializable;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class BeneficiaryKey implements Serializable {

	private static final long serialVersionUID = 5558824374644672397L;

	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private String nisBeneficiario;

	@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordinal = 0, ordering = Ordering.ASCENDING)
	private String mesCompetencia;

	public BeneficiaryKey() {
		
	}
	
	public BeneficiaryKey(String nisBeneficiario, String mesCompetencia) {
		super();
		this.nisBeneficiario = nisBeneficiario;
		this.mesCompetencia = mesCompetencia;
	}

	public String getNisBeneficiario() {
		return nisBeneficiario;
	}

	public void setNisBeneficiario(String nisBeneficiario) {
		this.nisBeneficiario = nisBeneficiario;
	}

	public String getMesCompetencia() {
		return mesCompetencia;
	}

	public void setMesCompetencia(String mesCompetencia) {
		this.mesCompetencia = mesCompetencia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
