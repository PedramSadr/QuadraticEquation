package com.adv.demo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Digits;

@Data
public class Params {

    @Digits(integer = 2 , fraction = 2)
    private Double coefficientA = 0.0;

    @Digits(integer = 2 , fraction = 2)
    private  Double coefficientB = 0.0;
    @Digits(integer = 2 , fraction = 2)
    private  Double constant = 0.0;


}
