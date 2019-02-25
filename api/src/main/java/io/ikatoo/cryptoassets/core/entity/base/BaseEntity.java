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
import javax.persistence.MappedSuperclass;

/**
 * BaseEntity
 */

@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 7569786796357595895L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private OffsetDateTime createdAt;
    private OffsetDateTime UpdatedAt;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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
