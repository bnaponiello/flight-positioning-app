package br.com.bnaponiello.flight.positioning.web.api.v1.aircraft.mapper;

import br.com.bnaponiello.flight.positioning.mapper.BaseMapper;
import br.com.bnaponiello.flight.positioning.model.Aircraft;
import br.com.bnaponiello.flight.positioning.web.api.v1.aircraft.AircraftResponse;

/**
 * The aircraft response mapper.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class AircraftResponseMapper implements BaseMapper<AircraftResponse, Aircraft> {

    @Override
    public AircraftResponse map(final Aircraft aircraft) {
        final AircraftResponse aircraftResponse = new AircraftResponse();
        if (aircraft != null) {
            aircraftResponse.setAircraftId(aircraft.getAircraftId());
            aircraftResponse.setName(aircraft.getName());
            aircraftResponse.setYear(aircraft.getYear());
            aircraftResponse.setFuelCapacityInLitre(aircraft.getFuelCapacityInLitre());
            aircraftResponse.setManufacturer(aircraft.getManufacturer());
            aircraftResponse.setNationalOrigin(aircraft.getNationalOrigin());
        }
        return aircraftResponse;
    }

}
