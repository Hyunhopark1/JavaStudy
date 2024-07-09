package com.maven.springboot.rentcar.vehicleType;


import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vehicletype")
public class VehicleTypeEntity implements IVehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 20,unique = true)
    private String name;

    @Override
    public String toString() {
        return String.format("ID : %6d, 이름:  %s", this.id, this.name);
    }
}
