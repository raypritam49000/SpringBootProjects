package com.criteria.query.rest.api.ultility.search.entity;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TenantAuditableBaseEntity extends AuditableBaseEntity {
    protected String tenant;

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    @Override
    public String toString() {
        return "TenantAuditableBaseEntity{" +
                "tenant='" + tenant + '\'' +
                '}';
    }
}
