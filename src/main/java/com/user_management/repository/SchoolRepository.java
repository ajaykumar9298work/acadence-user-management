package com.user_management.repository;

import com.user_management.models.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {

    boolean existsBySchoolCode(String schoolCode);

    SchoolEntity findBySchoolCode(String schoolCode);


    /**
     * Updates specific fields of a SchoolEntity using its unique school code.
     * * @return the number of rows affected (should be 1 if successful)
     */
    @Modifying
    @Transactional
    @Query("UPDATE SchoolEntity s SET " +
            "s.name = :name, " +
            "s.address = :address, " +
            "s.email = :email, " +
            "s.primaryPhone = :primaryPhone, " +
            "s.secondaryPhone = :secondaryPhone, " +
            "s.updatedAt = :updatedAt " +
            "WHERE s.schoolCode = :schoolCode")
    int updateSchoolDetailsByCode(@Param("schoolCode") String schoolCode,
                                  @Param("name") String name,
                                  @Param("address") String address,
                                  @Param("email") String email,
                                  @Param("primaryPhone") String primaryPhone,
                                  @Param("secondaryPhone") String secondaryPhone,
                                  @Param("updatedAt") String updatedAt);

}
