package br.com.bnaponiello.flight.positioning.web.api.v1.airport.mapper;

import br.com.bnaponiello.flight.positioning.model.Airline;
import br.com.bnaponiello.flight.positioning.model.Airport;
import br.com.bnaponiello.flight.positioning.template.model.AirlineTemplateLoader;
import br.com.bnaponiello.flight.positioning.template.model.AirportTemplateLoader;
import br.com.bnaponiello.flight.positioning.util.BaseTestFixture;
import br.com.bnaponiello.flight.positioning.web.api.v1.airport.AirportResponse;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * The unit tests of {@link AirportResponseMapper}.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class AirportResponseMapperTest extends BaseTestFixture {

    private Airport airport;

    @Before
    public void setUp() {
        airport = Fixture.from(Airport.class).gimme(AirportTemplateLoader.VALID_AIRPORT_DATA);
    }

    @Test
    public void testValidMap() {
        AirportResponse airportResponse = new AirportResponseMapper().map(airport);
        assertThatAreAllNotNull(airportResponse);
        assertThatAreAllEqualsTo(airport, airportResponse);
    }

    public static void assertThatAreAllNotNull(final AirportResponse airportResponse) {
        assertNotNull(airportResponse);
        assertNotNull(airportResponse.getAirportId());
        assertNotNull(airportResponse.getCode());
        assertNotNull(airportResponse.getName());
        assertNotNull(airportResponse.getCity());
        assertNotNull(airportResponse.getRegion());
        assertNotNull(airportResponse.getCountry());
    }

    public static void assertThatAreAllEqualsTo(final Airport airport, final AirportResponse airportResponse) {
        assertThat(airport.getAirportId(), equalTo(airportResponse.getAirportId()));
        assertThat(airport.getCode(), equalTo(airportResponse.getCode()));
        assertThat(airport.getName(), equalTo(airportResponse.getName()));
        assertThat(airport.getCity(), equalTo(airportResponse.getCity()));
        assertThat(airport.getRegion(), equalTo(airportResponse.getRegion()));
        assertThat(airport.getCountry(), equalTo(airportResponse.getCountry()));
    }
}
