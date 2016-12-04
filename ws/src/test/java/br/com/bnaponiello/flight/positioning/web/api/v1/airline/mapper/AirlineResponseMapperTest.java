package br.com.bnaponiello.flight.positioning.web.api.v1.airline.mapper;

import br.com.bnaponiello.flight.positioning.model.Airline;
import br.com.bnaponiello.flight.positioning.template.model.AirlineTemplateLoader;
import br.com.bnaponiello.flight.positioning.util.BaseTestFixture;
import br.com.bnaponiello.flight.positioning.web.api.v1.airline.AirlineResponse;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * The unit tests of {@link AirlineResponseMapper}.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class AirlineResponseMapperTest extends BaseTestFixture {

    private Airline airline;

    @Before
    public void setUp() {
        airline = Fixture.from(Airline.class).gimme(AirlineTemplateLoader.VALID_AIRLINE_DATA);
    }

    @Test
    public void testValidMap() {
        AirlineResponse airlineResponse = new AirlineResponseMapper().map(airline);
        assertThatAreAllNotNull(airlineResponse);
        assertThatAreAllEqualsTo(airline, airlineResponse);
    }

    public static void assertThatAreAllNotNull(final AirlineResponse airlineResponse) {
        assertNotNull(airlineResponse);
        assertNotNull(airlineResponse.getAirlineId());
        assertNotNull(airlineResponse.getName());
    }

    public static void assertThatAreAllEqualsTo(final Airline airline, final AirlineResponse airlineResponse) {
        assertEquals(airline.getAirlineId(), airlineResponse.getAirlineId());
        assertEquals(airline.getName(), airlineResponse.getName());
    }

}
