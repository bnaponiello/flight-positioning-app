package br.com.bnaponiello.flight.positioning.service;

import br.com.bnaponiello.flight.positioning.model.Flight;
import br.com.bnaponiello.flight.positioning.web.api.v1.flight.FlightRequest;

import java.util.Collection;

/**
 * The flight service interface.
 *
 * @author Bruno Naponiello
 * @since 01/12/2016
 */
public interface FlightService {

    /**
     * Finds all {@link Flight}.
     *
     * @return a list of {@link Flight}.
     */
    Collection<Flight> findAll();

    /**
     * Finds a {@link Flight} by its flight identifier.
     *
     * @param flightId
     *      the flight identifier to be find.
     * @return the {@link Flight} found.
     */
    Flight findByFlightId(final Long flightId);

    /**
     * Finds all {@link Flight} that have the ident provided.
     *
     * @param ident
     *      the ident of the flights.
     * @return a collection of {@link Flight}.
     */
    Collection<Flight> findByIdent(final String ident);

    /**
     * Finds a collection of {@link Flight} by the provided {@link FlightRequest}.
     *
     * @param flightRequest
     *      the {@link FlightRequest} with fields to find.
     * @return a collection of {@link Flight}.
     */
    Collection<Flight> findByFlightRequest(final FlightRequest flightRequest);

}
