package br.com.bnaponiello.flight.positioning.web.api.v1.flight;

import br.com.bnaponiello.flight.positioning.model.Flight;
import br.com.bnaponiello.flight.positioning.service.FlightService;
import br.com.bnaponiello.flight.positioning.web.api.v1.flight.mapper.FlightResponseMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * The flight controller.
 *
 * @author Bruno Naponiello
 * @since 01/12/2016
 */
@RestController
@RequestMapping("api/v1/flights")
public class FlightController {

    private static final ResponseEntity NO_CONTENT_RESPONSE = new ResponseEntity<>(HttpStatus.NO_CONTENT);

    @Autowired
    private FlightService flightService;

    /**
     * Finds all {@link Flight} which corresponds to the parameters provided.
     * If none of parameters were provided, all flights will be gotten.
     *
     * @param ident
     *      the ident of the flights.
     * @param airlineName
     *      the airlineName name.
     * @return a collection of {@link Flight}.
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<FlightResponse>> findFlights(
            @RequestParam(value = "ident", required = false) final String ident,
            @RequestParam(value = "airlineName", required = false) final String airlineName) {
        ResponseEntity responseEntity = NO_CONTENT_RESPONSE;

        FlightRequest flightRequest = new FlightRequest();
        flightRequest.setIdent(ident);
        flightRequest.setAirlineName(airlineName);

        Collection<Flight> flights = flightService.findByFlightRequest(flightRequest);

        if (CollectionUtils.isNotEmpty(flights)) {
            responseEntity = new ResponseEntity<>(new FlightResponseMapper().mapToCollection(flights), HttpStatus.OK);
        }

        return responseEntity;
    }

    /**
     * Get a specific flight by its identifier.
     *
     * @param flightId
     *      the flight identifier to be gotten.
     * @return the {@link FlightResponse} data.
     */
    @CrossOrigin
    @RequestMapping(value = "/{flightId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flight> findFlightByFlightId(@PathVariable("flightId") final Long flightId) {
        ResponseEntity responseEntity = NO_CONTENT_RESPONSE;
        Flight flight = flightService.findByFlightId(flightId);

        if (flight != null) {
            responseEntity = new ResponseEntity<>(new FlightResponseMapper().map(flight), HttpStatus.OK);
        }

        return responseEntity;
    }

}
