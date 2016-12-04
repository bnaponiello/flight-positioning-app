package br.com.bnaponiello.flight.positioning.template.model;

import br.com.bnaponiello.flight.positioning.model.Aircraft;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * The aircraft template loader.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class AircraftTemplateLoader implements TemplateLoader {

    public static final String VALID_AIRCRAFT_DATA = "VALID_AIRCRAFT_DATA";

    @Override
    public void load() {
        Fixture.of(Aircraft.class).addTemplate(VALID_AIRCRAFT_DATA, new Rule() {
            {
                add("aircraftId", random(Long.class, range(1L, 1000L)));
                add("name", random("Embraer E-195", "Boeing 747", "Airbus A320"));
                add("year", random(Integer.class, range(1980, 2016)));
                add("fuelCapacityInLitre",
                        random(BigDecimal.class, range(new BigDecimal("23.12"), new BigDecimal("29.68"))));
                add("manufacturer", random("Embraer", "Airbus", "Boeing"));
                add("nationalOrigin", random("Brazil", "European Union", "United States"));
                add("createDate", randomDate("2000-04-15", "2017-12-07", new SimpleDateFormat("yyyy-MM-dd")));
                add("updateDate", randomDate("2000-04-15", "2017-12-07", new SimpleDateFormat("yyyy-MM-dd")));
            }
        });
    }
}
