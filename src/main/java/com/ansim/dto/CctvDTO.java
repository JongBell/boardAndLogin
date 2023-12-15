package com.ansim.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class CctvDTO {

    private String addr;
    private String district;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private int quantity;


}
