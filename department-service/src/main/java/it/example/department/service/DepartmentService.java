package it.example.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.example.department.entity.Department;
import it.example.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentService.class);

	public Department saveDepartment(Department department) {
		log.info("Inside saveDeprtment of DepartmentService");
		return departmentRepository.save(department);
	}

	
	public Department findDepartmentById(Long departmentId) {
		log.info("Inside findDepartmentId of DepartmentService");
		return departmentRepository.findByDepartmentId(departmentId);
	}

}
