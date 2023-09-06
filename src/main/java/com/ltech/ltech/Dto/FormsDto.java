package com.ltech.ltech.Dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormsDto {
    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private String telephone;
    private String message;
    private Boolean attended;
}
