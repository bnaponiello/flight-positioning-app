package br.com.bnaponiello.flight.positioning.model;

import javax.persistence.*;
import java.util.Date;

/**
 * The pilot model.
 *
 * @author Bruno Naponiello
 * @since 01/12/2016
 */
@Entity
@Table(name = "PILOT")
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PILOT_ID", nullable = false)
    private Long pilotId;

    @Column(name = "NAME", nullable = false, length = 500)
    private String name;

    @Column(name = "NATIONAL_ORIGIN", nullable = false, length = 200)
    private String nationalOrigin;

    @Column(name = "LICENSE", nullable = false, length = 50)
    private String license;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "FLIGHT_HOURS", nullable = false)
    private Integer flightHours;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "FLIGHT_ID", nullable = false)
    private Flight flight;

    @Column(name = "CREATE_DATE", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "UPDATE_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public Long getPilotId() {
        return pilotId;
    }

    public void setPilotId(Long pilotId) {
        this.pilotId = pilotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalOrigin() {
        return nationalOrigin;
    }

    public void setNationalOrigin(String nationalOrigin) {
        this.nationalOrigin = nationalOrigin;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(Integer flightHours) {
        this.flightHours = flightHours;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
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