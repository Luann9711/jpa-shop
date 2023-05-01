package jpashop.jpashop.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String street;
    private String zipcode;
}
