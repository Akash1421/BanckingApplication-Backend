package service.serviceImpl;

import com.example.demo.dto.EmployeeRequest;
import com.example.demo.dto.EmployeeResponse;
import entity.EmployeeEntity;
import org.springframework.stereotype.Service;
import repository.EmployeeRepo;
import service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo repository;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo){
        this.repository = employeeRepo;
    }
    @Override
    public List<EmployeeEntity> getAllEmployeed() {
        return repository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    @Override
    public EmployeeEntity createEmployee(EmployeeRequest request) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(request.getName());
        employeeEntity.setRole(request.getRole());

        EmployeeEntity saved = repository.save(employeeEntity);

        return mapToResponse(saved);
    }

    private EmployeeResponse mapToResponse(EmployeeEntity employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getRole()
        );
    }

    @Override
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeEntity) {
        return repository.findById(id).map(existing ->{
            existing.setName(employeeEntity.getName());
            existing.setRole(employeeEntity.getRole());
            return repository.save(existing);

        }).orElseThrow(() -> new RuntimeException("Employee not found with id: "+id));
    }

    @Override
    public void deleteEmployee(Long id) {
    repository.deleteById(id);
    }
}
