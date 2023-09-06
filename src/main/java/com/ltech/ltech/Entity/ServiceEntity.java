package com.ltech.ltech.Entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "Servicios")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idService;
    private String nameService;
    private String descriptionService;
    private Boolean enabled;
}
