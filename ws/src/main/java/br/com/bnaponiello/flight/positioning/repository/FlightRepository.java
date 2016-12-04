package br.com.bnaponiello.flight.positioning.repository;

import br.com.bnaponiello.flight.positioning.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

/**
 * The flight JPA repository.
 *
 * @author Bruno Naponiello
 * @since 01/12/2016
 */
public interface FlightRepository extends JpaRepository<Flight, Long> {

    /**
     * Finds all {@link Flight} from database.
     *
     * @return a list of {@link Flight}.
     */
    List<Flight> findAll();

    /**
     * Finds a {@link Flight} by its flight identifier.
     *
     * @param flightId
     *      the flight identifier to be find.
     * @return the {@link Flight} found.
     */
    Flight findByFlightId(final Long flightId);

    /**
     * Finds all {@link Flight} that matches with de provided ident.
     *
     * @param ident
     *      the ident of the flights to find.
     * @return a list of {@link Flight} found.
     */
    List<Flight> findByIdent(final String ident);

    /**
     * Finds all {@link Flight} that matches with the provided airline name.
     *
     * @param airlineName
     *      the airline name of the flights to find.
     * @return a list of {@link Flight} found.
     */
    List<Flight> findByAirlineName(final String airlineName);

    /**
     * Finds all {@link Flight} that matches with the provided ident and airline name.
     *
     * @param ident
     *      the ident of the flights to find.
     * @param airlineName
     *      the airline name of the flights to find.
     * @return a list of {@link Flight} found.
     */
    @Query("SELECT f FROM Flight f WHERE f.ident LIKE CONCAT('%', :ident, '%') AND f.ident.airline.name LIKE CONCAT('%', :airlineName, '%')")
    List<Flight> findByIdentAndAirlineName(@Param("ident") final String ident,
                                           @Param("airlineName") final String airlineName);

}
