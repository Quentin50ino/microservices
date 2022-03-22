package it.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.example.user.VO.Department;
import it.example.user.VO.ResponseTemplateVO;
import it.example.user.entity.User;
import it.example.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        ,Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

}
