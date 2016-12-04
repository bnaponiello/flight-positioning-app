package br.com.bnaponiello.flight.positioning.enums;

/**
 * The flight status enum.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public enum FlightStatusEnum {

    WAITING("Waiting"),

    DELAYED("Delayed"),

    FLYING("Flying"),

    ARRIVED("Arrived");

    private String status;

    FlightStatusEnum(final String status) {
        this.status = status;
    }

}
