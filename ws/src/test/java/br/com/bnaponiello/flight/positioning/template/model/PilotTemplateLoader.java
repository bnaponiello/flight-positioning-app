package br.com.bnaponiello.flight.positioning.template.model;

import br.com.bnaponiello.flight.positioning.model.Airport;
import br.com.bnaponiello.flight.positioning.model.Pilot;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.text.SimpleDateFormat;

/**
 * The pilote template loader.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class PilotTemplateLoader implements TemplateLoader {

    public static final String VALID_PILOT_DATA = "VALID_PILOT_DATA";

    @Override
    public void load() {
        Fixture.of(Pilot.class).addTemplate(VALID_PILOT_DATA, new Rule() {
            {
                add("pilotId", random(Long.class, range(1L, 1000L)));
                add("name", random("Fernando Pessoa", "Alberto Santos Dummont", "Dan Brown"));
                add("nationalOrigin", random("Portugal", "Brazil", "United States"));
                add("license", random("12313123QWER1", "ASDD123313", "ASD13313DSAD"));
                add("email", random("fernandopessoa@email.com.pt", "albertodummont@email.com.br", "danbrown@email.com"));
                add("flightHours", random(Integer.class, range(200, 100000)));
                add("createDate", randomDate("2000-04-15", "2017-12-07", new SimpleDateFormat("yyyy-MM-dd")));
                add("updateDate", randomDate("2000-04-15", "2017-12-07", new SimpleDateFormat("yyyy-MM-dd")));
            }
        });
    }

}
