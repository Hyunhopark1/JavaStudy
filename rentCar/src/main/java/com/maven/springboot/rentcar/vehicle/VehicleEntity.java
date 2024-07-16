package com.maven.springboot.rentcar.vehicle;

import com.maven.springboot.rentcar.vehicleType.IVehicleType;
import com.maven.springboot.rentcar.vehicleType.VehicleTypeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Vehicle")
public class VehicleEntity implements IVehicle{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String company;

    @NotNull
    private String model;

    @NotNull
    private int makeYear;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "vehicleType_id")
    private VehicleTypeEntity type;

    @NotNull
    private String color;

    @NotNull
    private int totalKm;

    @NotNull
    private String factoryNumber;

    @NotNull
    private String registerNumber;

    @NotNull
    private VehicleStatus status;

    @Override
    public void setType(IVehicleType type) {
        if (type == null) {
            return;
        }
        VehicleTypeEntity entity= new VehicleTypeEntity();
        entity.copyFields(type);
    }
}
