package com.criteria.query.rest.api.ultility.search.dto.base;



import javax.validation.Valid;

import com.criteria.query.rest.api.ultility.search.DateRange;

public abstract class AuditableSearchParameters extends PageSearchParameters {

    boolean includeDeleted;

    @Valid
    protected DateRange creationDateRange;

    @Valid
    protected DateRange modifiedDateRange;

    public boolean isIncludeDeleted() {
        return includeDeleted;
    }

    public void setIncludeDeleted(boolean includeDeleted) {
        this.includeDeleted = includeDeleted;
    }

    public DateRange getCreationDateRange() {
        return creationDateRange;
    }

    public void setCreationDateRange(DateRange creationDateRange) {
        this.creationDateRange = creationDateRange;
    }

    public DateRange getModifiedDateRange() {
        return modifiedDateRange;
    }

    public void setModifiedDateRange(DateRange modifiedDateRange) {
        this.modifiedDateRange = modifiedDateRange;
    }

    @Override
    public String toString() {
        return "AuditableSearchParameters{" +
                "includeDeleted=" + includeDeleted +
                ", creationDateRange=" + creationDateRange +
                ", modifiedDateRange=" + modifiedDateRange +
                '}';
    }
}
