package com.ansim.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SafestoreDTO {

    private String district;
    private String store_brand;
    private String store_nm;
    private String addr;
    private BigDecimal latitude;
    private BigDecimal longitude;

}
