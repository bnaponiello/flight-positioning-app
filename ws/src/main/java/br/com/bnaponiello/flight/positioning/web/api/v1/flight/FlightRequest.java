package br.com.bnaponiello.flight.positioning.web.api.v1.flight;

/**
 * The flight request.
 *
 * @author Bruno Naponiello
 * @since 01/12/2016
 */
public class FlightRequest {

    private String airlineName;

    private String ident;

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }
}
