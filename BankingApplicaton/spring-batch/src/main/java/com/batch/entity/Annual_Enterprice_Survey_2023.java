package com.batch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Annual_Enterprice_Survey_2023 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String Year;
	private String Industry_aggregation_NZSIOC;
	private String Industry_code_NZSIOC;
	private String Industry_name_NZSIOC;
	private String Units;
	private String	Variable_code;
	private String Variable_name;
	private String Variable_category;
	private String Value;
	private String Industry_code_ANZSIC06;

}
