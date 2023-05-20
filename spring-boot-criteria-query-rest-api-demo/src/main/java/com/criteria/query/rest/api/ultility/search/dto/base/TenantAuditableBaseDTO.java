package com.criteria.query.rest.api.ultility.search.dto.base;

public class TenantAuditableBaseDTO extends AuditableBaseDTO {
	protected String tenant;

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	@Override
	public String toString() {
		return "TenantAuditableBaseDTO{" + "tenant='" + tenant + '\'' + '}';
	}
}
