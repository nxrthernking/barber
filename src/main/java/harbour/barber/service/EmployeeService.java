package harbour.barber.service;

import harbour.barber.mapper.EmployeeMapper;
import harbour.barber.model.Category;
import harbour.barber.model.Employee;
import harbour.barber.model.dto.EmployeeDto;
import harbour.barber.repository.CategoryRepository;
import harbour.barber.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final CategoryRepository categoryRepository;

    private final EmployeeMapper mapper;

    public List<EmployeeDto> getAll(){
        return employeeRepository.findAll()
                .stream()
                .map(mapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    public void add(EmployeeDto employeeDto){
        Employee employee = mapper.mapToEmployee(employeeDto);
        Category category = categoryRepository.findByNumber(employeeDto.getCategoryNumber());
        employee.setCategory(category);
        employeeRepository.save(employee);
    }

    public void remove(Long id){
        employeeRepository.deleteById(id);
    }

    public Employee findById(Long id){
        return employeeRepository.findById(id).orElseThrow();
    }
}
