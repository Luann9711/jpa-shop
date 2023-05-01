package jpashop.jpashop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Category {
    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;
}
