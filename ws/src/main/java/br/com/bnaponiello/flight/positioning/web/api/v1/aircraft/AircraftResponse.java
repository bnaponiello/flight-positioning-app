package br.com.bnaponiello.flight.positioning.web.api.v1.aircraft;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;

/**
 * The aircraft response.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class AircraftResponse {

    private Long aircraftId;

    private String name;

    private Integer year;

    private BigDecimal fuelCapacityInLitre;

    private String manufacturer;

    private String nationalOrigin;

    public Long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getFuelCapacityInLitre() {
        return fuelCapacityInLitre;
    }

    public void setFuelCapacityInLitre(BigDecimal fuelCapacityInLitre) {
        this.fuelCapacityInLitre = fuelCapacityInLitre;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getNationalOrigin() {
        return nationalOrigin;
    }

    public void setNationalOrigin(String nationalOrigin) {
        this.nationalOrigin = nationalOrigin;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
