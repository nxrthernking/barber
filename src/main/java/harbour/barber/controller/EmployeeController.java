package harbour.barber.controller;

import harbour.barber.model.dto.EmployeeDto;
import harbour.barber.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "employees";
    }

    @GetMapping(value = "/add")
    @Secured(value = "ROLE_ADMIN")
    public String addForm(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "employee_add";
    }

    @PostMapping(value = "/add")
    @Secured(value = "ROLE_ADMIN")
    public String employeeSubmit(@ModelAttribute EmployeeDto employeeDto, Model model) {
        employeeService.add(employeeDto);
        return "redirect:/employees";
    }


    @GetMapping(value = "/delete/{id}")
    @Secured(value = "ROLE_ADMIN")
    public String delete(@PathVariable(value = "id") String id){
        employeeService.remove(Long.valueOf(id));
        return "redirect:/employees";
    }

    @GetMapping(value = "/{id}")
    @Secured(value = "ROLE_ADMIN")
    public String getById(@PathVariable(value = "id") Long id,Model model){
        model.addAttribute("employee",employeeService.findById(id));
        return "employee-info";
    }


}
