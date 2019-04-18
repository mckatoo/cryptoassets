/**
 * @author Milton Carlos Katoo
 * @email mckatoo@gmail.com
 * @create date 2019-02-01 22:35:42
 * @modify date 2019-02-01 22:35:42
 * @desc [description]
 */

package io.ikatoo.cryptoassets.core.entity.base;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * BaseEntity
 */

@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @JoinColumn(name = "id", nullable = false)
    private Integer id;
    private OffsetDateTime createdAt;
    private OffsetDateTime UpdatedAt;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return this.UpdatedAt;
    }

    public void setUpdatedAt(OffsetDateTime UpdatedAt) {
        this.UpdatedAt = UpdatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BaseEntity)) {
            return false;
        }
        BaseEntity baseEntity = (BaseEntity) o;
        return id == baseEntity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
