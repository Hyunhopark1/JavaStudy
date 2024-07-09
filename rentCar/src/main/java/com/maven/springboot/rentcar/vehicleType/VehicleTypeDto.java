package com.maven.springboot.rentcar.vehicleType;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleTypeDto implements IVehicleType {


    private Long id;
    private String name;
}
