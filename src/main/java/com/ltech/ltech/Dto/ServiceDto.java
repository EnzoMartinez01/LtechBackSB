package com.ltech.ltech.Dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {
    private Integer idService;
    private String nameService;
    private String descriptionService;
    private Boolean enabled;
}
