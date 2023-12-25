
package com.playdata.eungae.doctor.domain;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import com.playdata.eungae.base.BaseEntity;
import com.playdata.eungae.hospital.domain.Hospital;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@Table(name = "doctor")
@Entity
public class Doctor extends BaseEntity {

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private Long doctorSeq;

	@ManyToOne
	@JoinColumn(name = "hospital_seq")
	private Hospital hospital;

	@Column(nullable = false)
	private String name;

	@ColumnDefault("'1'")
	private String status;

	@ColumnDefault("'3'")
	private Long treatmentPossible;

	private String profileImage;
}
