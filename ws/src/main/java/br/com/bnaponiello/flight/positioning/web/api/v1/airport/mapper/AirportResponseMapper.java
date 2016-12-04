package br.com.bnaponiello.flight.positioning.web.api.v1.airport.mapper;

import br.com.bnaponiello.flight.positioning.mapper.BaseMapper;
import br.com.bnaponiello.flight.positioning.model.Airport;
import br.com.bnaponiello.flight.positioning.web.api.v1.airport.AirportResponse;

/**
 * The airport response mapper.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class AirportResponseMapper implements BaseMapper<AirportResponse, Airport> {

    @Override
    public AirportResponse map(final Airport airport) {
        final AirportResponse airportResponse = new AirportResponse();

        if (airport != null) {
            airportResponse.setAirportId(airport.getAirportId());
            airportResponse.setCode(airport.getCode());
            airportResponse.setName(airport.getName());
            airportResponse.setCity(airport.getCity());
            airportResponse.setRegion(airport.getRegion());
            airportResponse.setCountry(airport.getCountry());
        }

        return airportResponse;
    }

}
