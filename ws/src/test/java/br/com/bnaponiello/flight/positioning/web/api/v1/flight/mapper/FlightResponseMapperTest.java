package br.com.bnaponiello.flight.positioning.web.api.v1.flight.mapper;

import br.com.bnaponiello.flight.positioning.model.Flight;
import br.com.bnaponiello.flight.positioning.model.Pilot;
import br.com.bnaponiello.flight.positioning.template.model.FlightTemplateLoader;
import br.com.bnaponiello.flight.positioning.util.BaseTestFixture;
import br.com.bnaponiello.flight.positioning.web.api.v1.aircraft.mapper.AircraftResponseMapperTest;
import br.com.bnaponiello.flight.positioning.web.api.v1.airline.mapper.AirlineResponseMapperTest;
import br.com.bnaponiello.flight.positioning.web.api.v1.flight.FlightResponse;
import br.com.bnaponiello.flight.positioning.web.api.v1.pilot.PilotResponse;
import br.com.bnaponiello.flight.positioning.web.api.v1.pilot.mapper.PilotResponseMapperTest;
import br.com.bnaponiello.flight.positioning.web.api.v1.route.mapper.RouteResponseMapperTest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * The unit tests of {@link FlightResponseMapper}.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class FlightResponseMapperTest extends BaseTestFixture {

    private Flight flight;

    @Before
    public void setUp() {
        flight = Fixture.from(Flight.class).gimme(FlightTemplateLoader.VALID_FLIGHT_DATA);
    }

    @Test
    public void testValidMap() {
        FlightResponse flightResponse = new FlightResponseMapper().map(flight);
        assertThatAreAllNotNull(flightResponse);
        assertThatAreAllEqualsTo(flight, flightResponse);
    }

    public static void assertThatAreAllNotNull(final FlightResponse flightResponse) {
        assertNotNull(flightResponse);
        assertNotNull(flightResponse.getFlightId());
        assertNotNull(flightResponse.getIdent());
        assertNotNull(flightResponse.getPilots());
        assertNotNull(flightResponse.getCurrentFlightStatus());
        AirlineResponseMapperTest.assertThatAreAllNotNull(flightResponse.getAirline());
        AircraftResponseMapperTest.assertThatAreAllNotNull(flightResponse.getAircraft());
        RouteResponseMapperTest.assertThatAreAllNotNull(flightResponse.getRoute());

        Iterator<PilotResponse> pilotResponseIteratorFromFlightResponse = flightResponse.getPilots().iterator();
        while(pilotResponseIteratorFromFlightResponse.hasNext()) {
            PilotResponseMapperTest.assertThatAreAllNotNull(pilotResponseIteratorFromFlightResponse.next());
        }
    }

    public static void assertThatAreAllEqualsTo(final Flight flight, final FlightResponse flightResponse) {
        assertThat(flight.getFlightId(), equalTo(flightResponse.getFlightId()));
        assertThat(flight.getIdent(), equalTo(flightResponse.getIdent()));
        assertThat(flight.getPilots().size(), equalTo(flightResponse.getPilots().size()));

        Iterator<Pilot> pilotIteratorFromFlight = flight.getPilots().iterator();
        Iterator<PilotResponse> pilotResponseIteratorFromFlightResponse = flightResponse.getPilots().iterator();
        while(pilotIteratorFromFlight.hasNext()) {
            PilotResponseMapperTest.assertThatAreAllEqualsTo(
                    pilotIteratorFromFlight.next(), pilotResponseIteratorFromFlightResponse.next());
        }

        AirlineResponseMapperTest.assertThatAreAllEqualsTo(flight.getAirline(), flightResponse.getAirline());
        AircraftResponseMapperTest.assertThatAreAllEqualsTo(flight.getAircraft(), flightResponse.getAircraft());
        assertThat(flight.getCurrentFlightStatus(), equalTo(flightResponse.getCurrentFlightStatus()));
    }
}
