package com.ltech.ltech.Dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SoftwareDto {
    private Integer idSoftware;
    private String nameService;
    private String descriptionService;
    private Boolean enabled;
}
