package harbour.barber.service;

import harbour.barber.model.Employee;
import harbour.barber.model.Haircut;
import harbour.barber.model.Order;
import harbour.barber.model.User;
import harbour.barber.model.dto.OrderDto;
import harbour.barber.repository.EmployeeRepository;
import harbour.barber.repository.HaircutRepository;
import harbour.barber.repository.OrderRepository;
import harbour.barber.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final EmployeeRepository employeeRepository;

    private final UserRepository userRepository;

    private final HaircutRepository haircutRepository;

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public List<Order> getAllByUserId(User user){
        return orderRepository.findAllByUser(user);
    }

    public void add(OrderDto request){
        Employee employee = employeeRepository.findById(request.getEmployeeId()).orElseThrow();
        User user = userRepository.findByUsername(request.getUsername());
        Haircut haircut = haircutRepository.findByName(request.getHaircutName());
        Order order = Order.builder()
                .employee(employee)
                .user(user)
                .haircut(haircut)
                .date(LocalDateTime.parse(request.getDate()))
                .totalCost(employee.getCategory().getExtraCharge() + haircut.getPrice())
                .build();
        orderRepository.save(order);

    }

    public void remove(Long id){
        orderRepository.deleteById(id);
    }
}
