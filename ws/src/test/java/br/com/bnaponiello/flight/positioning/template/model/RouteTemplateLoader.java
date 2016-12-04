package br.com.bnaponiello.flight.positioning.template.model;

import br.com.bnaponiello.flight.positioning.model.Airport;
import br.com.bnaponiello.flight.positioning.model.Route;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.text.SimpleDateFormat;

/**
 * The route template loader.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class RouteTemplateLoader implements TemplateLoader {

    public static final String VALID_ROUTE_DATA = "VALID_ROUTE_DATA";

    @Override
    public void load() {
        Fixture.of(Route.class).addTemplate(VALID_ROUTE_DATA, new Rule() {
            {
                add("routeId", random(Long.class, range(1L, 1000L)));
                add("departureAirport", one(Airport.class, AirportTemplateLoader.VALID_AIRPORT_DATA));
                add("arrivalAirport", one(Airport.class, AirportTemplateLoader.VALID_AIRPORT_DATA));
                add("departureDate", randomDate("2000-04-15", "2017-12-07", new SimpleDateFormat("yyyy-MM-dd")));
                add("arrivalDate", randomDate("2000-04-15", "2017-12-07", new SimpleDateFormat("yyyy-MM-dd")));
                add("createDate", randomDate("2000-04-15", "2017-12-07", new SimpleDateFormat("yyyy-MM-dd")));
                add("updateDate", randomDate("2000-04-15", "2017-12-07", new SimpleDateFormat("yyyy-MM-dd")));
            }
        });
    }

}
