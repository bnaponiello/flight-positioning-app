package br.com.bnaponiello.flight.positioning.web.api.v1.pilot;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The pilot response.
 *
 * @author Bruno Naponiello
 * @since 02/12/2016
 */
public class PilotResponse {

    private Long pilotId;

    private String name;

    private String nationalOrigin;

    private String license;

    private String email;

    private Integer flightHours;

    public Long getPilotId() {
        return pilotId;
    }

    public void setPilotId(Long pilotId) {
        this.pilotId = pilotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalOrigin() {
        return nationalOrigin;
    }

    public void setNationalOrigin(String nationalOrigin) {
        this.nationalOrigin = nationalOrigin;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(Integer flightHours) {
        this.flightHours = flightHours;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
