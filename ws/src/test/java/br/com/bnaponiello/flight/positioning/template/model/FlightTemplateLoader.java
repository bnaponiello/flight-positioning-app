package br.com.bnaponiello.flight.positioning.template.model;

import br.com.bnaponiello.flight.positioning.enums.FlightStatusEnum;
import br.com.bnaponiello.flight.positioning.model.*;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.text.SimpleDateFormat;

/**
 * The flight template loader.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class FlightTemplateLoader implements TemplateLoader {

    public static final String VALID_FLIGHT_DATA = "VALID_FLIGHT_DATA";

    @Override
    public void load() {
        Fixture.of(Flight.class).addTemplate(VALID_FLIGHT_DATA, new Rule() {
            {
                add("flightId", random(Long.class, range(1L, 1000L)));
                add("ident", random("AAL950", "TAM8102", "TAM8080", "DAL472", "TAM8102"));
                add("pilots", has(2).of(Pilot.class, PilotTemplateLoader.VALID_PILOT_DATA));
                add("airline", one(Airline.class, AirlineTemplateLoader.VALID_AIRLINE_DATA));
                add("aircraft", one(Aircraft.class, AircraftTemplateLoader.VALID_AIRCRAFT_DATA));
                add("currentFlightStatus", random(FlightStatusEnum.values()));
                add("route", one(Route.class, RouteTemplateLoader.VALID_ROUTE_DATA));
                add("createDate", randomDate("2000-04-15", "2017-12-07", new SimpleDateFormat("yyyy-MM-dd")));
                add("updateDate", randomDate("2000-04-15", "2017-12-07", new SimpleDateFormat("yyyy-MM-dd")));
            }
        });
    }

}
