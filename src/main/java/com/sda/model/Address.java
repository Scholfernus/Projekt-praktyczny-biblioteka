package com.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Address {
private String street;
private String buildingNo;
private String apartmentNo;
private String postalCode;

}
