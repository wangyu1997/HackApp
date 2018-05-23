package com.malasong.server.Repository;

import com.malasong.server.Model.PicModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PicRepository extends JpaRepository<PicModel, Long> {
}
