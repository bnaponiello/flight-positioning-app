package br.com.bnaponiello.flight.positioning.web.api.v1.flight;

import br.com.bnaponiello.flight.positioning.enums.FlightStatusEnum;
import br.com.bnaponiello.flight.positioning.web.api.v1.aircraft.AircraftResponse;
import br.com.bnaponiello.flight.positioning.web.api.v1.airline.AirlineResponse;
import br.com.bnaponiello.flight.positioning.web.api.v1.pilot.PilotResponse;
import br.com.bnaponiello.flight.positioning.web.api.v1.route.RouteResponse;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Collection;

/**
 * The flight response.
 *
 * @author Bruno Naponiello
 * @since 01/12/2016
 */
public class FlightResponse {

    private Long flightId;

    private String ident;

    private Collection<PilotResponse> pilots;

    private AirlineResponse airline;

    private AircraftResponse aircraft;

    private FlightStatusEnum currentFlightStatus;

    private RouteResponse route;

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

    public Collection<PilotResponse> getPilots() {
        return pilots;
    }

    public void setPilots(Collection<PilotResponse> pilots) {
        this.pilots = pilots;
    }

    public AirlineResponse getAirline() {
        return airline;
    }

    public void setAirline(AirlineResponse airline) {
        this.airline = airline;
    }

    public AircraftResponse getAircraft() {
        return aircraft;
    }

    public void setAircraft(AircraftResponse aircraft) {
        this.aircraft = aircraft;
    }

    public FlightStatusEnum getCurrentFlightStatus() {
        return currentFlightStatus;
    }

    public void setCurrentFlightStatus(FlightStatusEnum currentFlightStatus) {
        this.currentFlightStatus = currentFlightStatus;
    }

    public RouteResponse getRoute() {
        return route;
    }

    public void setRoute(RouteResponse route) {
        this.route = route;
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
