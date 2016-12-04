package br.com.bnaponiello.flight.positioning.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The aircraft model.
 *
 * @author Bruno Naponiello
 * @since 01/12/2016
 */
@Entity
@Table(name = "AIRCRAFT")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AIRCRAFT_ID", nullable = false)
    private Long aircraftId;

    @Column(name = "NAME", nullable = false, length = 500)
    private String name;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "FUEL_CAPACITY")
    private BigDecimal fuelCapacityInLitre;

    @Column(name = "MANUFACTURER", length = 200)
    private String manufacturer;

    @Column(name = "NATIONAL_ORIGIN", nullable = false, length = 200)
    private String nationalOrigin;

    @Column(name = "CREATE_DATE", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "UPDATE_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
