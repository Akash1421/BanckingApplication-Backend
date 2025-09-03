package service;

import com.example.demo.dto.EmployeeRequest;
import entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeEntity> getAllEmployeed();
    Optional<EmployeeEntity> getEmployeeById(Long id);
    EmployeeEntity createEmployee(EmployeeRequest request);
    EmployeeEntity updateEmployee(Long id,EmployeeEntity employeeEntity);
    void deleteEmployee(Long id);
}
