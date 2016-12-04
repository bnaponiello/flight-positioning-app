package br.com.bnaponiello.flight.positioning.template.model;

import br.com.bnaponiello.flight.positioning.model.Airline;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.text.SimpleDateFormat;

/**
 * The airline template loader.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class AirlineTemplateLoader implements TemplateLoader {

    public static final String VALID_AIRLINE_DATA = "VALID_AIRCRAFT_DATA";

    @Override
    public void load() {
        Fixture.of(Airline.class).addTemplate(VALID_AIRLINE_DATA, new Rule() {
            {
                add("airlineId", random(Long.class, range(1L, 1000L)));
                add("name", random("TAM Airlines", "GOL Airlines", "Azul Airlines"));
                add("createDate", randomDate("2000-04-15", "2017-12-07", new SimpleDateFormat("yyyy-MM-dd")));
                add("updateDate", randomDate("2000-04-15", "2017-12-07", new SimpleDateFormat("yyyy-MM-dd")));
            }
        });
    }
}
