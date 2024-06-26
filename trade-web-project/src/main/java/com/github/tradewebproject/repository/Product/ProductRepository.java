package com.github.tradewebproject.repository.Product;

import com.github.tradewebproject.domain.Product;
import com.github.tradewebproject.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long productId);
    List<Product> findByUserUserId(Long userId);
    List<Product> findByEndDateAfterAndStartDateBeforeOrStartDate(Date endDate, Date startDate1, Date startDate2);

    Page<Product> findAll(Pageable pageable);
    Page<Product> findByUserUserIdAndProductStatus(Long userId, int productStatus, Pageable pageable);

    Page<Product> findAllByProductStatus(int productStatus, Pageable pageable);
    Page<Product> findByProductNameContaining(String keyword, Pageable pageable);


    Page<Product> findAll(Specification<Product> spec, Pageable pageable);


    List<Product> findByCategoryIn(List<String> userInterests);

    Page<Product> findByCategoryInAndProductStatus(List<String> userInterests, int i, Pageable pageable);



}