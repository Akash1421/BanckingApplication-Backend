package controller;

import com.example.demo.api.EmployeeApi;
import com.example.demo.dto.EmployeeRequest;
import com.example.demo.dto.EmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import service.EmployeeService;

@RestController
public class EmployeeController implements EmployeeApi {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService1){
        this.employeeService = employeeService1;
    }

    public ResponseEntity<EmployeeResponse> createEmployee(EmployeeRequest request){
        return ResponseEntity.ok(employeeService.createEmployee(request));
    }
}
