package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Saikumar Jalda
 * @since: 14/02/2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImportASG {
    //region Members
    @JsonIgnore
    private Set<String>               isSet;
    private String                    product;
    private List<String>              spotInstanceTypes;
    private String                    name;
    private String                    availabilityVsCost;

    //endregion

    //region Constructor

    public ImportASG() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        isSet.add("product");
        this.product = product;
    }

    public List<String> getSpotInstanceTypes() {
        return spotInstanceTypes;
    }

    public void setSpotInstanceTypes(List<String> spotInstanceTypes) {
        isSet.add("spotInstanceTypes");
        this.spotInstanceTypes = spotInstanceTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getAvailabilityVsCost() {
        return availabilityVsCost;
    }

    public void setAvailabilityVsCost(String availabilityVsCost) {
        isSet.add("availabilityVsCost");
        this.availabilityVsCost = availabilityVsCost;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private ImportASG importASG;

        //endregion


        private Builder() {
            this.importASG = new ImportASG();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setProduct(final String product) {
            importASG.setProduct(product);
            return this;
        }

        public Builder setSpotInstanceTypes(List<String> spotInstanceTypes) {
            importASG.setSpotInstanceTypes(spotInstanceTypes);
            return this;
        }

        public Builder setName(final String name) {
            importASG.setName(name);
            return this;
        }

        public Builder setAvailabilityVsCost(final String availabilityVsCost) {
            importASG.setAvailabilityVsCost(availabilityVsCost);
            return this;
        }

        public ImportASG build() {
            // Validations
            return importASG;
        }
        //endregion
    }
    //endregion

    //region isSet methods
    // Is name Set boolean method
    @JsonIgnore
    public boolean isProductSet() { return isSet.contains("product");
    }

    // Is spotInstanceTypes Set boolean method
    @JsonIgnore
    public boolean isSpotInstanceTypesSet() {
        return isSet.contains("spotInstanceTypes");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isAvailabilityVsCostSet() {
        return isSet.contains("availabilityVsCost");
    }


    //endregion
}
