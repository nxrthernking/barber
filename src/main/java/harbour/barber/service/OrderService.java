package harbour.barber.service;

import harbour.barber.model.Order;
import harbour.barber.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public List<Order> getAll(){
        return repository.findAll();
    }

    public void add(Order order){
        repository.save(order);
    }

    public void remove(Long id){
        repository.deleteById(id);
    }
}
