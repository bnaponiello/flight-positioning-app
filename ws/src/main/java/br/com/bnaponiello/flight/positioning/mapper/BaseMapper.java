package br.com.bnaponiello.flight.positioning.mapper;

/**
 * The base mapper interface.
 *
 * @param <OUTPUT> the mapped {@link Object}.
 * @param <INPUT> the {@link Object} to be mapped.
 * @author Bruno Naponiello
 * @since 01/12/2016
 */
public interface BaseMapper<OUTPUT, INPUT> {

    /**
     * Maps a {@link INPUT} into a {@link OUTPUT}.
     *
     * @param input
     *      the {@link INPUT} to be mapped.
     * @return the {@link OUTPUT} mapped.
     */
    OUTPUT map(INPUT input);

}
