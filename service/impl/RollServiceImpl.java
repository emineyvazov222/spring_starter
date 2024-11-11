package org.spring.springlesson2.service.impl;

import org.spring.springlesson2.dao.response.RollResponse;
import org.spring.springlesson2.entities.Roll;
import org.spring.springlesson2.repository.RollRepository;
import org.spring.springlesson2.service.RollService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RollServiceImpl implements RollService {

    @Autowired
    private RollRepository rollRepository;

    @Override
    public Roll save(Roll roll) {
        return rollRepository.save(roll);
    }

    @Override
    public List<Roll> findAll(Roll roll) {
        return rollRepository.findAll();
    }

    @Override
    public Roll findById(Long id) {
        Optional<Roll> byId = rollRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public Roll update(Long id, Roll roll) {
        Roll byId = findById(id);
        if (byId != null) {
            byId.setName(roll.getName());
            byId.setDescription(roll.getDescription());
            return rollRepository.save(byId);
        }
        return null;

    }

    @Override
    public void delete(Long id) {
        Roll byId = findById(id);
        if (byId != null) {
            rollRepository.delete(byId);
        }

    }

    @Override
    public RollResponse getResponse(Long id,Roll roll) {
        Roll byId = findById(id);
        if (byId != null) {
           Roll roll1 = new Roll();
           BeanUtils.copyProperties(roll, roll1);

           RollResponse response = new RollResponse();
            Roll save = rollRepository.save(roll1);
            BeanUtils.copyProperties(save, response);
            return response;
        }
        return null;

    }
}
