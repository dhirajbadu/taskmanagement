package com.taskmanagement.core.converter;

import java.util.List;

/**
 * @author dhiraj
 *
 * @param <E>
 * @param <D>
 */
public interface IConvertable<E, D> {

    /***
     * Convert DTO to Entity
     *
     * @param dto
     * @return entity
     */
    E convertToEntity(D dto);

    /***
     * Convert Entity to DTO
     *
     * @param entity
     * @return entity
     */
    D convertToDto(E entity);

    /***
     * Copy DTO to Entity
     *
     * @param entity , dto
     * @return entity
     */

    E copyConvertToEntity(D dto, E entity);

    /***
     * Convert Entity List to DTO list
     *
     * @param entities
     * @return
     */
    List<D> convertToDtoList(List<E> entities);

    /***
     * Convert DTO List to Entity List
     *
     * @param dtoList
     * @return
     */
    List<E> convertToEntityList(List<D> dtoList);

}

