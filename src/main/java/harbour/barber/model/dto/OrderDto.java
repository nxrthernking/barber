package harbour.barber.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {
    private Long employeeId;
    private String username;
    private String haircutName;
//    @DateTimeFormat(pattern = "yyyy-MM-ddThh-mm")
    private String date;
}
