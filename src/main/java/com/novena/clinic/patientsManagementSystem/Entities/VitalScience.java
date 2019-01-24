package com.novena.clinic.patientsManagementSystem.Entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class VitalScience extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private double weight;
	@NotNull
	private double temperture;
	@NotNull
	private int pluseRate;
	@OneToMany(mappedBy = "vaitalScience", fetch = FetchType.LAZY)
	private Set<ClinicalReport> clinicalReport;

	public VitalScience() {
	}

	public VitalScience(double weight, double temperture, int pluseRate) {
		this.weight = weight;
		this.temperture = temperture;
		this.pluseRate = pluseRate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getTemperture() {
		return temperture;
	}

	public void setTemperture(double temperture) {
		this.temperture = temperture;
	}

	public int getPluseRate() {
		return pluseRate;
	}

	public void setPluseRate(int pluseRate) {
		this.pluseRate = pluseRate;
	}

	public Set<ClinicalReport> getClinicalReport() {
		return clinicalReport;
	}

	public void setClinicalReport(Set<ClinicalReport> clinicalReport) {
		this.clinicalReport = clinicalReport;
	}

}
