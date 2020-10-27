package com.spotinst.sdkjava.model.filters;

import com.spotinst.sdkjava.model.AscDescEnum;

public class SortFilter {
    //region members
    private Integer     limit;
    private String      sortField;
    private AscDescEnum sortOrder;
    //endregion

    //region getters & setters
    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public AscDescEnum getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(AscDescEnum sortOrder) {
        this.sortOrder = sortOrder;
    }
    //endregion


}
