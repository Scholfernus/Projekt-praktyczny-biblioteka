package com.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    private String street;
    private String buildingNo;
    private String apartmentNo;
    private String postalCode;

    public String parseToFileFormat() {
        return street + ";" + buildingNo + ";" + apartmentNo + ";" + postalCode;
    }
}