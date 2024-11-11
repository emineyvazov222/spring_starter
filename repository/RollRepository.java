package org.spring.springlesson2.repository;

import org.spring.springlesson2.entities.Roll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RollRepository extends JpaRepository<Roll, Long> {
}
