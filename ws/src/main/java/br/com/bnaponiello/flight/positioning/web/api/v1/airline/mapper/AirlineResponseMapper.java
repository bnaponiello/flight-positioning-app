package br.com.bnaponiello.flight.positioning.web.api.v1.airline.mapper;

import br.com.bnaponiello.flight.positioning.mapper.BaseMapper;
import br.com.bnaponiello.flight.positioning.mapper.CollectionBaseMapper;
import br.com.bnaponiello.flight.positioning.model.Airline;
import br.com.bnaponiello.flight.positioning.web.api.v1.airline.AirlineResponse;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The airline response mapper.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class AirlineResponseMapper implements BaseMapper<AirlineResponse, Airline>,
        CollectionBaseMapper<AirlineResponse, Airline> {

    @Override
    public AirlineResponse map(final Airline airline) {
        final AirlineResponse airlineResponse = new AirlineResponse();
        if (airline != null) {
            airlineResponse.setAirlineId(airline.getAirlineId());
            airlineResponse.setName(airline.getName());
        }
        return airlineResponse;
    }

    @Override
    public Collection<AirlineResponse> mapToCollection(final Collection<Airline> airlines) {
        final Collection<AirlineResponse> airlineResponses = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(airlines)) {
            airlines.forEach(airline -> airlineResponses.add(map(airline)));
        }
        return airlineResponses;
    }

}
