package br.com.bnaponiello.flight.positioning.service.v1;

import br.com.bnaponiello.flight.positioning.model.Flight;
import br.com.bnaponiello.flight.positioning.repository.FlightRepository;
import br.com.bnaponiello.flight.positioning.service.FlightService;
import br.com.bnaponiello.flight.positioning.web.api.v1.flight.FlightRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The implementation of flight service.
 *
 * @author Bruno Naponiello
 * @since 01/12/2016
 */
@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Collection<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight findByFlightId(final Long flightId) {
        return flightRepository.findByFlightId(flightId);
    }

    @Override
    public Collection<Flight> findByIdent(final String ident) {
        return flightRepository.findByIdent(ident);
    }

    @Override
    public Collection<Flight> findByFlightRequest(final FlightRequest flightRequest) {
        Collection<Flight> flights = new ArrayList<>();
        if (isToSearchByIdent(flightRequest) && isToSearchByAirlineName(flightRequest)) {
            flights = flightRepository.findByIdentAndAirlineName(
                    flightRequest.getIdent(), flightRequest.getAirlineName());

        } else if (isToSearchByIdent(flightRequest)) {
            flights = findByIdent(flightRequest.getIdent());
        } else if (isToSearchByAirlineName(flightRequest)) {
            flights = flightRepository.findByAirlineName(flightRequest.getAirlineName());
        } else {
            flights = findAll();
        }
        return flights;
    }

    private Boolean isToSearchByIdent(final FlightRequest flightRequest) {
        return StringUtils.isNotBlank(flightRequest.getIdent());
    }

    private Boolean isToSearchByAirlineName(final FlightRequest flightRequest) {
        return StringUtils.isNotBlank(flightRequest.getAirlineName());
    }

}
