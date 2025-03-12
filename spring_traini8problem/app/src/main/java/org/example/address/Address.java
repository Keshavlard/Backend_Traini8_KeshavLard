package org.example.address;

import jakarta.persistence.Embeddable;
import lombok.Data;


/*
object of address, it is embedded into TrainingCenter,
meaning its fields,
will be stored as columns in the training_centers table itself.


And @Autowired is a Spring dependency injection
annotation used to inject beans (i.e., objects managed by Spring).
@Embedded is a JPA annotation that
helps in mapping database fields inside an entity.
Since Address is not a Spring-managed bean,
using @Autowired doesn’t make sense.
*/

@Data
@Embeddable
public class Address {
    private String detailedAddress;
    private String city;
    private String state;
    private String pincode;
}
