package br.com.bnaponiello.flight.positioning.web.api.v1.flight.mapper;

import br.com.bnaponiello.flight.positioning.mapper.BaseMapper;
import br.com.bnaponiello.flight.positioning.mapper.CollectionBaseMapper;
import br.com.bnaponiello.flight.positioning.model.Flight;
import br.com.bnaponiello.flight.positioning.web.api.v1.aircraft.mapper.AircraftResponseMapper;
import br.com.bnaponiello.flight.positioning.web.api.v1.airline.mapper.AirlineResponseMapper;
import br.com.bnaponiello.flight.positioning.web.api.v1.flight.FlightResponse;
import br.com.bnaponiello.flight.positioning.web.api.v1.pilot.mapper.PilotResponseMapper;
import br.com.bnaponiello.flight.positioning.web.api.v1.route.mapper.RouteResponseMapper;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The flight response mapper.
 *
 * @author Bruno Naponiello
 * @since 01/12/2016
 */
public class FlightResponseMapper implements BaseMapper<FlightResponse, Flight>,
        CollectionBaseMapper<FlightResponse, Flight> {

    private PilotResponseMapper pilotResponseMapper = new PilotResponseMapper();
    private AirlineResponseMapper airlineResponseMapper = new AirlineResponseMapper();
    private AircraftResponseMapper aircraftResponseMapper = new AircraftResponseMapper();
    private RouteResponseMapper routeResponseMapper = new RouteResponseMapper();

    @Override
    public FlightResponse map(final Flight flight) {
        final FlightResponse flightResponse = new FlightResponse();

        if (flight != null) {
            flightResponse.setFlightId(flight.getFlightId());
            flightResponse.setIdent(flight.getIdent());
            flightResponse.setPilots(pilotResponseMapper.mapToCollection(flight.getPilots()));
            flightResponse.setAirline(airlineResponseMapper.map(flight.getAirline()));
            flightResponse.setAircraft(aircraftResponseMapper.map(flight.getAircraft()));
            flightResponse.setCurrentFlightStatus(flight.getCurrentFlightStatus());
            flightResponse.setRoute(routeResponseMapper.map(flight.getRoute()));
        }

        return flightResponse;
    }

    @Override
    public Collection<FlightResponse> mapToCollection(final Collection<Flight> flights) {
        final Collection<FlightResponse> flightResponses = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(flights)) {
            flights.forEach(flight -> flightResponses.add(map(flight)));
        }

        return flightResponses;
    }
}
