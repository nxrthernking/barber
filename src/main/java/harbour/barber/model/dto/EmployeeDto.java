package harbour.barber.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class EmployeeDto {

    private Long id;

    private String firstName;

    private String secondName;

    private String lastName;

    private String passportNumber;

    private String phoneNumber;

    private int categoryNumber;
}
