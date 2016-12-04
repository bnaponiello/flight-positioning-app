package br.com.bnaponiello.flight.positioning.mapper;

import java.util.Collection;

/**
 * The base mapper interface for collections.
 *
 * @param <OUTPUT> the mapped collection of {@link Object}.
 * @param <INPUT> the collection of {@link Object} to be mapped.
 * @author Bruno Naponiello
 * @since 01/12/2016
 */
public interface CollectionBaseMapper<OUTPUT, INPUT> {

    /**
     * Maps a collection of {@link Object} into a collection of {@link OUTPUT}.
     *
     * @param inputs
     *      the collection of {@link INPUT} to be mapped.
     * @return the collection of {@link OUTPUT} mapped.
     */
    Collection<OUTPUT> mapToCollection(Collection<INPUT> inputs);

}
