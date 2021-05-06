package harbour.barber.mapper;

import harbour.barber.model.Employee;
import harbour.barber.model.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDto mapToEmployeeDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .secondName(employee.getSecondName())
                .lastName(employee.getLastName())
                .phoneNumber(employee.getPhoneNumber())
                .passportNumber(employee.getPassportNumber())
                .categoryNumber(employee.getCategory().getNumber())
                .build();
    }

    public Employee mapToEmployee(EmployeeDto employeeDto){
        return Employee.builder()
                .id(employeeDto.getId())
                .firstName(employeeDto.getFirstName())
                .secondName(employeeDto.getSecondName())
                .lastName(employeeDto.getLastName())
                .phoneNumber(employeeDto.getPhoneNumber())
                .passportNumber(employeeDto.getPassportNumber())
                .build();
    }
}
