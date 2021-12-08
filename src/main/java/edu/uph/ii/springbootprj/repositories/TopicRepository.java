package edu.uph.ii.springbootprj.repositories;

import edu.uph.ii.springbootprj.entities.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    Long countTopicsByUser_Id(Long id);

    Topic findTopicById(Long id);

    List<Topic> findTopicsByCategoryOrderByCreatedDateDesc(String category);
    List<Topic> findTopicsByUser_IdOrderByCreatedDateDesc(Long id);

    //=========================================================

//    Page<Topic> findVehiclesByModelIgnoreCaseContaining(String phraseModel, Pageable pageable);
//
//    Page<Topic> findVehiclesUsingNamedQuery(
//            String phrase,
//            Pageable pageable
//    );

    List<Topic> findTopicsByTitle(String phrase, Pageable pageable);
}
