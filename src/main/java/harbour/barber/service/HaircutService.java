package harbour.barber.service;

import harbour.barber.mapper.HaircutMapper;
import harbour.barber.model.dto.HaircutDto;
import harbour.barber.repository.HaircutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HaircutService {

    private final HaircutRepository haircutRepository;

    private final HaircutMapper mapper;

    public List<HaircutDto> getAll() {
        return haircutRepository.findAll()
                .stream()
                .map(mapper::mapToHaircutDto)
                .collect(Collectors.toList());
    }

}


