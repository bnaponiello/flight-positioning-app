package br.com.bnaponiello.flight.positioning.service.v1;

import br.com.bnaponiello.flight.positioning.model.Flight;
import br.com.bnaponiello.flight.positioning.repository.FlightRepository;
import br.com.bnaponiello.flight.positioning.template.model.FlightTemplateLoader;
import br.com.bnaponiello.flight.positioning.util.BaseTestFixture;
import br.com.bnaponiello.flight.positioning.web.api.v1.flight.FlightRequest;
import br.com.six2six.fixturefactory.Fixture;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * The unit test of {@link FlightServiceImpl}.
 *
 * @author Bruno Naponiello
 * @since 04/12/2016
 */
public class FlightServiceImplTest extends BaseTestFixture {

    @InjectMocks
    private FlightServiceImpl flightServiceImpl;

    @Mock
    private FlightRepository flightRepository;

    private List<Flight> flights;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        flights = Fixture.from(Flight.class).gimme(10, FlightTemplateLoader.VALID_FLIGHT_DATA);
    }

    @Test
    public void testFindAll() {
        when(flightRepository.findAll()).thenReturn(flights);

        Collection<Flight> flightsFound = flightServiceImpl.findAll();

        verify(flightRepository, times(1)).findAll();
        verifyNoMoreInteractions(flightRepository);

        assertNotNull(flightsFound);
        assertThat(flights.size(), equalTo(flightsFound.size()));
    }

    @Test
    public void testFindByFlightRequestWithIdentAndAirline() {
        FlightRequest flightRequest = new FlightRequest();
        flightRequest.setIdent("A180");
        flightRequest.setAirlineName("TAM Airlines");

        when(flightRepository.findByIdentAndAirlineName(flightRequest.getIdent(), flightRequest.getAirlineName()))
                .thenReturn(flights);

        Collection<Flight> flightsFound = flightServiceImpl.findByFlightRequest(flightRequest);

        verify(flightRepository, times(1))
                .findByIdentAndAirlineName(flightRequest.getIdent(), flightRequest.getAirlineName());
        verifyNoMoreInteractions(flightRepository);

        assertNotNull(flightsFound);
        assertThat(flights.size(), equalTo(flightsFound.size()));
    }

}
