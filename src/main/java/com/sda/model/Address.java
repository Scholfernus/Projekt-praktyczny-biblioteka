package com.sda.model;

import lombok.Builder;

@Builder
public class Address {
private String street;
private String buildingNo;
private String apartmentNo;
private String postalCode;

}
