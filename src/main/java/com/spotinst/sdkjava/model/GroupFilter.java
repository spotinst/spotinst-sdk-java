package com.spotinst.sdkjava.model;

/**
 * Created by yossi.elman on 09/02/2020.
 */
public class GroupFilter {

    //region Members
    private String  maxCreatedAt;
    private String  minCreatedAt;
    private Boolean includeDeleted;
    private String  activeTo;
    private String  activeFrom;
    private String  name;
    //endregion

    //region Getter and Setter methods
    public String getMaxCreatedAt() {
        return maxCreatedAt;
    }

    public void setMaxCreatedAt(String maxCreatedAt) {
        this.maxCreatedAt = maxCreatedAt;
    }

    public String getMinCreatedAt() {
        return minCreatedAt;
    }

    public void setMinCreatedAt(String minCreatedAt) {
        this.minCreatedAt = minCreatedAt;
    }

    public Boolean getIncludeDeleted() {
        return includeDeleted;
    }

    public void setIncludeDeleted(Boolean includeDeleted) {
        this.includeDeleted = includeDeleted;
    }

    public String getActiveTo() {
        return activeTo;
    }

    public void setActiveTo(String activeTo) {
        this.activeTo = activeTo;
    }

    public String getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(String activeFrom) {
        this.activeFrom = activeFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
}
