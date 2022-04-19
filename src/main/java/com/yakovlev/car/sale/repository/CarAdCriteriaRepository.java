package com.yakovlev.car.sale.repository;

import com.yakovlev.car.sale.mapper.CarAdMapper;
import com.yakovlev.car.sale.model.CarAd;
import com.yakovlev.car.sale.model.CarAdPage;
import com.yakovlev.car.sale.model.CarAdSearchCriteria;
import com.yakovlev.car.sale.model.Generation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CarAdCriteriaRepository {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public CarAdCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<CarAd> findAllWithFilters(CarAdPage carAdPage, CarAdSearchCriteria carAdSearchCriteria){
        CriteriaQuery<CarAd> criteriaQuery = criteriaBuilder.createQuery(CarAd.class);
        Root<CarAd> carAdRoot = criteriaQuery.from(CarAd.class);
        //Join<CarAd, Generation> carAdGenerationJoin = carAdRoot.join("generation");
        carAdRoot.join("body");
        Predicate predicate = getPredicate(carAdSearchCriteria, carAdRoot);
        criteriaQuery.where(predicate);
        setOrder(carAdPage, criteriaQuery, carAdRoot);

        TypedQuery<CarAd> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(carAdPage.getPageNumber() * carAdPage.getPageSize());
        typedQuery.setMaxResults(carAdPage.getPageSize());

        Pageable pageable = getPageable(carAdPage);

        long carAdCount = getCarAdCount(predicate);

        return new PageImpl<>(typedQuery.getResultList(), pageable, carAdCount);
    }

    private Predicate getPredicate(CarAdSearchCriteria carAdSearchCriteria, Root<CarAd> carAdRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(carAdSearchCriteria.getMileage())){
            predicates.add(
                    criteriaBuilder.like(carAdRoot.get("mileage"),
                            "%" + carAdSearchCriteria.getMileage() + "%")
            );
        }
        if(Objects.nonNull(carAdSearchCriteria.getDescription())){
            predicates.add(
                    criteriaBuilder.like(carAdRoot.get("description"),
                            "%" + carAdSearchCriteria.getDescription() + "%")
            );
        }
        if(Objects.nonNull(carAdSearchCriteria.getGeneration())){
            predicates.add(
                    criteriaBuilder.like(carAdRoot.get("generation"),
                            "%" + carAdSearchCriteria.getGeneration() + "%")
            );
        }
        if(Objects.nonNull(carAdSearchCriteria.getBody())){
            predicates.add(
                    criteriaBuilder.like(carAdRoot.get("body"),
                            "%" + carAdSearchCriteria.getBody().getId() + "%")
            );
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void setOrder(CarAdPage carAdPage, CriteriaQuery<CarAd> criteriaQuery, Root<CarAd> carAdRoot) {
        if(carAdPage.getSortDirection().equals(Sort.Direction.ASC)){
            criteriaQuery.orderBy(criteriaBuilder.asc(carAdRoot.get(carAdPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(carAdRoot.get(carAdPage.getSortBy())));
        }
    }

    private Pageable getPageable(CarAdPage carAdPage) {
        Sort sort = Sort.by(carAdPage.getSortDirection(), carAdPage.getSortBy());
        return PageRequest.of(carAdPage.getPageNumber(), carAdPage.getPageSize(), sort);
    }

    private long getCarAdCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<CarAd> countRoot = countQuery.from(CarAd.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return  entityManager.createQuery(countQuery).getSingleResult();
    }
}
