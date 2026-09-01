package school.sorokin.azizov.reservation_system;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    List<ReservationEntity> findAllByStatusIs(ReservationStatus status);

//    @Query("select r from ReservationEntity r where r.s")   // Вариант с использованием JPQL
//    List<ReservationEntity> findAllByStatusIs(ReservationStatus status);

//    @Query(value = "select * from reservations r where r.status = :status", nativeQuery = true) // Вариант с использованием SQL
//    List<ReservationEntity> findAllByStatusIs(ReservationStatus status);


//    // JPQL: выбрать все бронирования для комнаты с переданным id.
//    @Query("select r from ReservationEntity r where r.roomId = :roomId")
//    List<ReservationEntity> findAllByRoomId(@Param("roomId") Long roomId);


//    // Обновляет все поля бронирования по его id.
//    @Transactional
//    @Modifying
//    @Query("""
//        update ReservationEntity r
//        set r.userId = :userId,
//            r.roomId = :roomId,
//            r.startDate = :startDate,
//            r.endDate = :endDate,
//            r.status = :status
//        where r.id = :id
//        """)
//    int updateAllFields(
//            @Param("id") Long id,
//            @Param("userId") Long userId,
//            @Param("roomId") Long roomId,
//            @Param("startDate") LocalDate startDate,
//            @Param("endDate") LocalDate endDate,
//            @Param("status") ReservationStatus status
//    );

    @Modifying
    @Query("""
        update ReservationEntity r
        set
            r.status = :status
        where r.id = :id
        """)

    void setStatus(
            @Param("id") Long id,
            @Param("status") ReservationStatus reservationStatus
    );
}
