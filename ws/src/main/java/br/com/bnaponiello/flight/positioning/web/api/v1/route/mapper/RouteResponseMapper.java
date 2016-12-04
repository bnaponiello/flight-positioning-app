package br.com.bnaponiello.flight.positioning.web.api.v1.route.mapper;

import br.com.bnaponiello.flight.positioning.mapper.BaseMapper;
import br.com.bnaponiello.flight.positioning.model.Route;
import br.com.bnaponiello.flight.positioning.web.api.v1.airport.mapper.AirportResponseMapper;
import br.com.bnaponiello.flight.positioning.web.api.v1.route.RouteResponse;

/**
 * The route response mapper.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class RouteResponseMapper implements BaseMapper<RouteResponse, Route> {

    private AirportResponseMapper airportResponseMapper = new AirportResponseMapper();

    @Override
    public RouteResponse map(final Route route) {
        final RouteResponse routeResponse = new RouteResponse();

        if (route != null) {
            routeResponse.setRouteId(route.getRouteId());
            routeResponse.setDepartureAirport(airportResponseMapper.map(route.getDepartureAirport()));
            routeResponse.setArrivalAirport(airportResponseMapper.map(route.getArrivalAirport()));
            routeResponse.setDepartureDate(route.getDepartureDate());
            routeResponse.setArrivalDate(route.getArrivalDate());
        }

        return routeResponse;
    }

}
