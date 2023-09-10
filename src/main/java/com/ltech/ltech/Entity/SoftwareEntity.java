package com.ltech.ltech.Entity;

import javax.persistence.*;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "softwareservices")
@Entity
public class SoftwareEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idSoftware;
    private String nameService;
    private String descriptionService;
    private Boolean enabled;
}
