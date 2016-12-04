package br.com.bnaponiello.flight.positioning.template.model;

import br.com.bnaponiello.flight.positioning.model.Airline;
import br.com.bnaponiello.flight.positioning.model.Airport;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.text.SimpleDateFormat;

/**
 * The airport template loader.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class AirportTemplateLoader implements TemplateLoader {

    public static final String VALID_AIRPORT_DATA = "VALID_AIRPORT_DATA";

    @Override
    public void load() {
        Fixture.of(Airport.class).addTemplate(VALID_AIRPORT_DATA, new Rule() {
            {
                add("airportId", random(Long.class, range(1L, 1000L)));
                add("code", random("GRU", "KJFK", "KLAX"));
                add("name", random("Aeroporto Internacional de Guarulhos", "John F Kennedy Airport"));
                add("region", random("Guarulhos", "Jonh F Kennedy"));
                add("city", random("São Paulo", "New York"));
                add("country", random("Brazil", "United States"));
                add("createDate", randomDate("2000-04-15", "2017-12-07", new SimpleDateFormat("yyyy-MM-dd")));
                add("updateDate", randomDate("2000-04-15", "2017-12-07", new SimpleDateFormat("yyyy-MM-dd")));
            }
        });
    }

}
