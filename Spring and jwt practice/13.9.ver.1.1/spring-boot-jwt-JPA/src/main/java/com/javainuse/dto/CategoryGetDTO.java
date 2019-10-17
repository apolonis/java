package com.javainuse.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryGetDTO extends CategoryPostDTO{

    private int id;
}
