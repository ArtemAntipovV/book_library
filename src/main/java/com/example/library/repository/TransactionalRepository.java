package com.example.library.repository;


import com.example.library.model.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;


public interface TransactionalRepository extends JpaRepository<Transactional, Long> {

    @Query("SELECT t.reader.phoneNumber, COUNT(t) " +
            "FROM Transactional t " +
            "WHERE t.operationType = 'BORROW' " +
            "GROUP BY t.reader.phoneNumber " +
            "ORDER BY COUNT(t) DESC")
    List<Object[]> findMostActiveReader();

    @Query("SELECT t.reader.phoneNumber, COUNT(t) " +
            "FROM Transactional t " +
            "WHERE t.operationType = 'BORROW' AND t.dateTime IS NOT NULL " +
            "GROUP BY t.reader.phoneNumber " +
            "ORDER BY COUNT(t) DESC")
    List<Object[]> findReadersWithUnreturnedBooks();

    @Query("SELECT a FROM Author a JOIN a.books b JOIN Transactional t ON t.book = b " +
            "WHERE t.dateTime BETWEEN :startDate AND :endDate " +
            "GROUP BY a ORDER BY COUNT(t) DESC")
    List<Object[]> findMostPopularAuthorBetweenDates(@Param("startDate") LocalDateTime startDate,
                                                   @Param("endDate") LocalDateTime endDate);
}
