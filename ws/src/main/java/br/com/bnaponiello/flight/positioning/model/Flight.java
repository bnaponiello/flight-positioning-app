package br.com.bnaponiello.flight.positioning.model;

import br.com.bnaponiello.flight.positioning.enums.FlightStatusEnum;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * The flight model.
 *
 * @author Bruno Naponiello
 * @since 01/12/2016
 */
@Entity
@Table(name = "FLIGHT")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FLIGHT_ID", nullable = false)
    private Long flightId;

    @Column(name = "IDENT", nullable = false, length = 10)
    private String ident;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "FLIGHT_ID")
    private Collection<Pilot> pilots;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "AIRLINE_ID", nullable = false)
    private Airline airline;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "AIRCRAFT_ID", nullable = false)
    private Aircraft aircraft;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private FlightStatusEnum currentFlightStatus;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "ROUTE_ID", nullable = false)
    private Route route;

    @Column(name = "CREATE_DATE", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "UPDATE_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public Collection<Pilot> getPilots() {
        return pilots;
    }

    public void setPilots(Collection<Pilot> pilots) {
        this.pilots = pilots;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public FlightStatusEnum getCurrentFlightStatus() {
        return currentFlightStatus;
    }

    public void setCurrentFlightStatus(FlightStatusEnum currentFlightStatus) {
        this.currentFlightStatus = currentFlightStatus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
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
