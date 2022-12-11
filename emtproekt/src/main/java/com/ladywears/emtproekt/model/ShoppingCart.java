package com.ladywears.emtproekt.model;

import com.ladywears.emtproekt.model.enumerations.CartStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private CartStatus status = CartStatus.CREATED;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "cart_ladywears",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "ladywear_id")
    )
    private List<Ladywear> ladywears;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Ladywear> getLadywears() {
        return ladywears;
    }

    public void setLadywears(List<Ladywear> ladywears) {
        this.ladywears = ladywears;
    }
}
