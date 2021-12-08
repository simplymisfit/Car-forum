package edu.uph.ii.springbootprj.repositories;

import edu.uph.ii.springbootprj.entities.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SearchRepostiory extends JpaRepository<Topic, Long>, JpaSpecificationExecutor<Topic> {

}
