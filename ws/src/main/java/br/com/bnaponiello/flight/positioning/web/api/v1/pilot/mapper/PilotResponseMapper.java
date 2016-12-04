package br.com.bnaponiello.flight.positioning.web.api.v1.pilot.mapper;

import br.com.bnaponiello.flight.positioning.mapper.BaseMapper;
import br.com.bnaponiello.flight.positioning.mapper.CollectionBaseMapper;
import br.com.bnaponiello.flight.positioning.model.Pilot;
import br.com.bnaponiello.flight.positioning.web.api.v1.pilot.PilotResponse;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The pilot response mapper.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class PilotResponseMapper implements BaseMapper<PilotResponse, Pilot>,
        CollectionBaseMapper<PilotResponse, Pilot> {

    @Override
    public PilotResponse map(final Pilot pilot) {
        final PilotResponse pilotResponse = new PilotResponse();
        if (pilot != null) {
            pilotResponse.setPilotId(pilot.getPilotId());
            pilotResponse.setName(pilot.getName());
            pilotResponse.setNationalOrigin(pilot.getNationalOrigin());
            pilotResponse.setLicense(pilot.getLicense());
            pilotResponse.setEmail(pilot.getEmail());
            pilotResponse.setFlightHours(pilot.getFlightHours());
        }
        return pilotResponse;
    }

    @Override
    public Collection<PilotResponse> mapToCollection(final Collection<Pilot> pilots) {
        final Collection<PilotResponse> pilotResponses = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(pilots)) {
            pilots.forEach(pilot -> pilotResponses.add(map(pilot)));
        }
        return pilotResponses;
    }
}
