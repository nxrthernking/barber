package harbour.barber.controller;

import harbour.barber.model.dto.EmployeeDto;
import harbour.barber.service.EmployeeService;
import lombok.RequiredArgsConstructor;
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
    public String addForm(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "employee-add";
    }

    @PostMapping(value = "/add")
    public String employeeSubmit(@ModelAttribute EmployeeDto employeeDto, Model model) {
        employeeService.add(employeeDto);
        return "redirect:employees";
    }


    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        employeeService.remove(id);
        return "redirect:employees";
    }

    @GetMapping(value = "/{id}")
    public String getById(@PathVariable(value = "id") Long id,Model model){
        model.addAttribute("employee",employeeService.findById(id));
        return "";
    }


}
