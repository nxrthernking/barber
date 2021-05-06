package harbour.barber.mapper;

import harbour.barber.model.Haircut;
import harbour.barber.model.dto.HaircutDto;
import org.springframework.stereotype.Component;

@Component
public class HaircutMapper {
    public HaircutDto mapToHaircutDto(Haircut haircut){
        return new HaircutDto(haircut.getName(), haircut.getPrice());
    }

    public Haircut mapToHaircut(HaircutDto haircutDto){
        return Haircut.builder()
                .name(haircutDto.getName())
                .price(haircutDto.getPrice())
                .build();
    }
}
