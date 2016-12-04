package br.com.bnaponiello.flight.positioning.web.api.v1.pilot.mapper;

import br.com.bnaponiello.flight.positioning.model.Airport;
import br.com.bnaponiello.flight.positioning.model.Pilot;
import br.com.bnaponiello.flight.positioning.template.model.AirportTemplateLoader;
import br.com.bnaponiello.flight.positioning.template.model.PilotTemplateLoader;
import br.com.bnaponiello.flight.positioning.util.BaseTestFixture;
import br.com.bnaponiello.flight.positioning.web.api.v1.pilot.PilotResponse;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * The unit testes of {@link PilotResponseMapper}.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class PilotResponseMapperTest extends BaseTestFixture {

    private Pilot pilot;

    @Before
    public void setUp() {
        pilot = Fixture.from(Pilot.class).gimme(PilotTemplateLoader.VALID_PILOT_DATA);
    }

    @Test
    public void testValidMap() {
        PilotResponse pilotResponse = new PilotResponseMapper().map(pilot);
        assertThatAreAllNotNull(pilotResponse);
        assertThatAreAllEqualsTo(pilot, pilotResponse);
    }

    public static void assertThatAreAllNotNull(final PilotResponse pilotResponse) {
        assertNotNull(pilotResponse.getPilotId());
        assertNotNull(pilotResponse.getName());
        assertNotNull(pilotResponse.getNationalOrigin());
        assertNotNull(pilotResponse.getLicense());
        assertNotNull(pilotResponse.getEmail());
        assertNotNull(pilotResponse.getFlightHours());
    }

    public static void assertThatAreAllEqualsTo(final Pilot pilot, final PilotResponse pilotResponse) {
        assertEquals(pilot.getPilotId(), pilotResponse.getPilotId());
        assertEquals(pilot.getName(), pilotResponse.getName());
        assertEquals(pilot.getNationalOrigin(), pilotResponse.getNationalOrigin());
        assertEquals(pilot.getLicense(), pilotResponse.getLicense());
        assertEquals(pilot.getEmail(), pilotResponse.getEmail());
        assertEquals(pilot.getFlightHours(), pilotResponse.getFlightHours());
    }
}
