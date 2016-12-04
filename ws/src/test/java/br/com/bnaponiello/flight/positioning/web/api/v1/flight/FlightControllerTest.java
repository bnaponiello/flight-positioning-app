package br.com.bnaponiello.flight.positioning.web.api.v1.flight;

import br.com.bnaponiello.flight.positioning.model.Flight;
import br.com.bnaponiello.flight.positioning.service.FlightService;
import br.com.bnaponiello.flight.positioning.template.model.FlightTemplateLoader;
import br.com.bnaponiello.flight.positioning.util.BaseTestFixture;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * The unit test of {@link FlightControllerTest}.
 *
 * @author Bruno Naponiello
 * @since 04/12/2016
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FlightController.class})
public class FlightControllerTest extends BaseTestFixture {

    @InjectMocks
    private FlightController flightController;

    @Mock
    private FlightService flightService;

    @Mock
    FlightRequest flightRequest;

    private Collection<Flight> flights;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        flights = Fixture.from(Flight.class).gimme(10, FlightTemplateLoader.VALID_FLIGHT_DATA);
    }

    @Test
    public void testFindFlights() throws Exception {
        PowerMockito.whenNew(FlightRequest.class).withAnyArguments().thenReturn(flightRequest);
        when(flightService.findByFlightRequest(flightRequest)).thenReturn(flights);

        ResponseEntity<Collection<FlightResponse>> responseEntity = flightController.findFlights(null, null);

        verify(flightService, times(1)).findByFlightRequest(flightRequest);
        verifyNoMoreInteractions(flightService);

        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        assertThat(flights.size(), equalTo(responseEntity.getBody().size()));
    }

}
