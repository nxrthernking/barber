package harbour.barber.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String secondName;

    private String lastName;

    private String passportNumber;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private boolean active = true;

}
