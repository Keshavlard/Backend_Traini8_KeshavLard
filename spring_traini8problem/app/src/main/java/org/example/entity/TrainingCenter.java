package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.address.Address;
import java.util.List;

@Entity //jpa entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "training_centers") //table name
public class TrainingCenter {

    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Center name is required")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center code is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    private String centerCode;

    @Embedded
    @NotNull(message = "Address is required")
    private Address address;

    private Integer studentCapacity;

    @ElementCollection
    @CollectionTable(name = "training_center_courses_offered",
            joinColumns = @JoinColumn(name = "training_center_id"))
    @Column(name = "course_name")
    private List<String> coursesOffered;
    private Long createdOn; // Auto-generated timestamp

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number format")
    private String contactPhone;

    // Auto timestamp
    @PrePersist
    protected void onCreate() {
        this.createdOn = System.currentTimeMillis();
    }
}
