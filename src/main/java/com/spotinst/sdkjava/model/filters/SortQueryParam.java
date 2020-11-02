package com.spotinst.sdkjava.model.filters;

import com.spotinst.sdkjava.model.AscDescEnum;

public class SortQueryParam {
    //region members
    private String      sortField;
    private AscDescEnum sortOrder;
    //endregion

    //region constructor
    public SortQueryParam(String sortField) {
        this.sortField = sortField;
    }

    public SortQueryParam(String sortField, AscDescEnum sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    //endregion

    //region getters & setters
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

    //region public methods
    public String toQueryParamString() {
        String retVal;
        AscDescEnum sortOrder = this.getSortOrder();

        if (sortOrder != null) {
            retVal = this.sortField + ":" + sortOrder.getName();
        } else {
            retVal = this.sortField;
        }

        return retVal;
    }
    //endregion

}
