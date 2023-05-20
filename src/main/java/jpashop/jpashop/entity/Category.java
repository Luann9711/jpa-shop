package jpashop.jpashop.entity;

import jakarta.persistence.*;
import jpashop.jpashop.entity.item.Item;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Table(name = "category")
@Getter @Setter
public class Category {
    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @Comment("상위 카테고리")
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @Comment("자식 카테고리")
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();


    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
}
