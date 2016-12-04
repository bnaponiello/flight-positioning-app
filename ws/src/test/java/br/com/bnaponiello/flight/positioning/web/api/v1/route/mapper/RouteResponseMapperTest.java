package br.com.bnaponiello.flight.positioning.web.api.v1.route.mapper;

import br.com.bnaponiello.flight.positioning.model.Route;
import br.com.bnaponiello.flight.positioning.template.model.RouteTemplateLoader;
import br.com.bnaponiello.flight.positioning.util.BaseTestFixture;
import br.com.bnaponiello.flight.positioning.web.api.v1.airport.mapper.AirportResponseMapperTest;
import br.com.bnaponiello.flight.positioning.web.api.v1.route.RouteResponse;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * The unit tests of {@link RouteResponseMapper}.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class RouteResponseMapperTest extends BaseTestFixture {

    private Route route;

    @Before
    public void setUp() {
        route = Fixture.from(Route.class).gimme(RouteTemplateLoader.VALID_ROUTE_DATA);
    }

    @Test
    public void testValidMap() {
        RouteResponse routeResponse = new RouteResponseMapper().map(route);
        assertThatAreAllNotNull(routeResponse);
        assertThatAreAllEqualsTo(route, routeResponse);
    }

    public static void assertThatAreAllNotNull(final RouteResponse routeResponse) {
        assertNotNull(routeResponse);
        assertNotNull(routeResponse.getRouteId());
        assertNotNull(routeResponse.getDepartureAirport());
        assertNotNull(routeResponse.getDepartureDate());
        assertNotNull(routeResponse.getArrivalDate());
        AirportResponseMapperTest.assertThatAreAllNotNull(routeResponse.getDepartureAirport());
        AirportResponseMapperTest.assertThatAreAllNotNull(routeResponse.getArrivalAirport());
    }

    public static void assertThatAreAllEqualsTo(final Route route, final RouteResponse routeResponse) {
        assertThat(route.getRouteId(), equalTo(routeResponse.getRouteId()));
        assertThat(route.getDepartureDate(), equalTo(routeResponse.getDepartureDate()));
        assertThat(route.getArrivalDate(), equalTo(routeResponse.getArrivalDate()));
        AirportResponseMapperTest.assertThatAreAllEqualsTo(route.getDepartureAirport(), routeResponse.getDepartureAirport());
        AirportResponseMapperTest.assertThatAreAllEqualsTo(route.getArrivalAirport(), routeResponse.getArrivalAirport());
    }
}
