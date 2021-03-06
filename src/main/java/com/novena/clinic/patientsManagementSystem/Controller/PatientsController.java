package com.novena.clinic.patientsManagementSystem.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.novena.clinic.patientsManagementSystem.Entities.Patient;
import com.novena.clinic.patientsManagementSystem.Entities.StaffPatient;
import com.novena.clinic.patientsManagementSystem.Entities.StudentPatient;
import com.novena.clinic.patientsManagementSystem.Service.ServiceImpl.PatientServiceImpl;

@Controller
public class PatientsController {
	
	@Autowired
	private PatientServiceImpl patientServ;
	
	@RequestMapping(value="/createStudentPatient", method=RequestMethod.POST)
	public String addStudentPatient(
			@ModelAttribute("object") @Valid StudentPatient patient,BindingResult errors,ModelMap model) {
		System.out.println("Patient Gotten "+ patient);
		 if(errors.hasErrors()){	
			 CommonModels.studentModel(model);
			 return "registerpatient";
		 }
		patientServ.addPatient(patient);
		return "redirect:/";
	}
	
	@RequestMapping("/patientdetails")
	public String viewPatient(ModelMap model) {
		Optional<Patient> patient = patientServ.findPatient(1);
		model.addAttribute("breadcrumb", "Patients");
		model.addAttribute("breadcrumbItem", "Patient Information");
		model.addAttribute("pageTitle", "Patient Detail");
		model.addAttribute("patientObj", patient.get() );
		return"patientDetails";
	}

	@RequestMapping(value="/createStaffPatient", method=RequestMethod.POST)
	public String addStaffPatient(
			@ModelAttribute("object") @Valid StaffPatient patient,BindingResult errors,ModelMap model) {
		if(errors.hasErrors()){
			CommonModels.staffModel(model);
	         return"registerpatient";
	         }
		patientServ.addPatient(patient);
		return "redirect:/";
	}
}
