package goinventory.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Alex created 06/10/2021
 **/
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @OneToOne
    private Category categoryId;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private LocalDateTime lastPurchasedDate;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(final Category categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(final LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDateTime getLastPurchasedDate() {
        return lastPurchasedDate;
    }

    public void setLastPurchasedDate(final LocalDateTime lastPurchasedDate) {
        this.lastPurchasedDate = lastPurchasedDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(categoryId, product.categoryId) &&
                Objects.equals(creationDate, product.creationDate) &&
                Objects.equals(updateDate, product.updateDate) &&
                Objects.equals(lastPurchasedDate, product.lastPurchasedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, categoryId, creationDate, updateDate, lastPurchasedDate);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", categoryId=").append(categoryId);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", lastPurchasedDate=").append(lastPurchasedDate);
        sb.append('}');
        return sb.toString();
    }
}
