package com.javainuse.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductGetDTO extends ProductPostDTO{

    private int id;
}
