package org.spring.springlesson2.service;

import org.spring.springlesson2.dao.response.RollResponse;
import org.spring.springlesson2.entities.Roll;

import java.util.List;

public interface RollService {

    Roll save(Roll roll);

    List<Roll> findAll(Roll roll);

    Roll findById(Long id);

    Roll update(Long id, Roll roll);

    void delete(Long id);

    RollResponse getResponse(Long id,Roll roll);


}
