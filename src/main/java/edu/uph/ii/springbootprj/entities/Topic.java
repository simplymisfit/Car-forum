package edu.uph.ii.springbootprj.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.OperationNotSupportedException;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 32)
    private String title;

    @Column(nullable = false, length = 1024)
    private String content;

    @Column(nullable = false, length = 16)
    private String category;

    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "topic")
    private List<Answer> answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String displayParsedCreatedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm - dd.MM.yyyy");
        return this.createdDate.format(formatter);
    }


    //========================================================

//    @RequestMapping(value="/list",method = {RequestMethod.GET, RequestMethod.POST})
//    protected String showList(Model model, @ModelAttribute("vehicleFilter") VehicleFilter vehicleFilter,
//                              @PageableDefault(sort="id", size=20) Pageable pageable) throws OperationNotSupportedException//?page=x&size=y&sort=prop1,ASC&sort=prop2,DESC
//    {
//        Page page = null;
//
//        if(vehicleFilter.isEmpty()){
//            page = vehicleRepository.findAll(pageable);
//        }else {
//
//            switch (vehicleFilter.getQueryMode()) {
//                case NAMED_METHOD -> {
//                    page = vehicleRepository.findVehiclesByModelIgnoreCaseContainingOrMarkaIgnoreCaseContainingOrCoverTypeNameIgnoreCaseContaining(vehicleFilter.getPhrase(), vehicleFilter.getPhrase(), vehicleFilter.getPhrase(), pageable);
//                }
//                case NAMED_QUERY -> {
//                    page = vehicleRepository.findVehiclesUsingNamedQuery(
//                            vehicleFilter.getPhrase(),
//                            vehicleFilter.getMinPrice(),
//                            vehicleFilter.getMaxPrice(),
//                            vehicleFilter.isCoverTypesEmpty()?null:vehicleFilter.getCoverTypes(),
//                            vehicleFilter.isVehicleGenresEmpty()?null:vehicleFilter.getVehicleGenres(),
//                            pageable
//                    );
//                }
//                case QUERY -> {
//                    page = vehicleRepository.findVehiclesUsingQuery(
//                            vehicleFilter.getPhraseLIKE(),
//                            vehicleFilter.getMinPrice(),
//                            vehicleFilter.getMaxPrice(),
//                            vehicleFilter.isCoverTypesEmpty()?null:vehicleFilter.getCoverTypes(),
//                            vehicleFilter.isVehicleGenresEmpty()?null:vehicleFilter.getVehicleGenres(),
//                            pageable
//                    );
//                }
//
//                case SpEL_AND_ENTITY_GRAPH -> {
//                    page = vehicleRepository.findVehiclesUsingSpEL(vehicleFilter,pageable);
//                }
//
//                case CRITERIA -> {
//                    page = vehicleRepository.findAll(
//                            Specification.where(
//                                    VehicleSpecifications.findByPhrase(vehicleFilter.getPhraseLIKE()).
//                                            and(
//                                                    VehicleSpecifications.findByPriceRange(vehicleFilter.getMinPrice(), vehicleFilter.getMaxPrice())
//                                            )
//                            ), pageable
//                    );
//                }
//
//                default -> throw new OperationNotSupportedException(String.format("Typ '%s' nie jest obsługiwany", vehicleFilter.getQueryMode()));
//            }
//        }
//        //model.addAttribute("vehicleList", DBDump.vehicleList);
////        if(vehicleFilter.isEmpty()){
////            model.addAttribute("page", vehicleRepository.findAll(pageable));
////        }
////        else{
//        model.addAttribute("page",page);
//        return "vehicle/carList";
//    }
}
