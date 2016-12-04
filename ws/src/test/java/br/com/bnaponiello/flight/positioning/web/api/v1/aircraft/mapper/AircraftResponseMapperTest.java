package br.com.bnaponiello.flight.positioning.web.api.v1.aircraft.mapper;

import br.com.bnaponiello.flight.positioning.model.Aircraft;
import br.com.bnaponiello.flight.positioning.template.model.AircraftTemplateLoader;
import br.com.bnaponiello.flight.positioning.util.BaseTestFixture;
import br.com.bnaponiello.flight.positioning.web.api.v1.aircraft.AircraftResponse;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * The unit tests of {@link AircraftResponseMapper}.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class AircraftResponseMapperTest extends BaseTestFixture {

    private Aircraft aircraft;

    @Before
    public void setUp() {
        aircraft = Fixture.from(Aircraft.class).gimme(AircraftTemplateLoader.VALID_AIRCRAFT_DATA);
    }

    @Test
    public void testValidMap() {
        AircraftResponse aircraftResponse = new AircraftResponseMapper().map(aircraft);
        assertThatAreAllNotNull(aircraftResponse);
        assertThatAreAllEqualsTo(aircraft, aircraftResponse);
    }

    public static void assertThatAreAllNotNull(final AircraftResponse aircraftResponse) {
        assertNotNull(aircraftResponse);
        assertNotNull(aircraftResponse.getAircraftId());
        assertNotNull(aircraftResponse.getName());
        assertNotNull(aircraftResponse.getYear());
        assertNotNull(aircraftResponse.getFuelCapacityInLitre());
        assertNotNull(aircraftResponse.getManufacturer());
        assertNotNull(aircraftResponse.getNationalOrigin());
    }

    public static void assertThatAreAllEqualsTo(final Aircraft aircraft, final AircraftResponse aircraftResponse) {
        assertEquals(aircraft.getAircraftId(), aircraftResponse.getAircraftId());
        assertEquals(aircraft.getName(), aircraftResponse.getName());
        assertEquals(aircraft.getYear(), aircraftResponse.getYear());
        assertEquals(aircraft.getFuelCapacityInLitre(), aircraftResponse.getFuelCapacityInLitre());
        assertEquals(aircraft.getManufacturer(), aircraftResponse.getManufacturer());
    }
}
