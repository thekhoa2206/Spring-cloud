package com.sapo.coffeeshop.models.repository;

import com.sapo.coffeeshop.models.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// extends CrudRepository
@Repository
public interface UserRepository1 extends CrudRepository<User, Long> {

    // hỗ trợ filter theo các trường action(count,find,exist) + By + field
    long countByStatus(String status);
    User findById(int id);
    User findByStatus(int id);
    User findTopById(int id);
    List<User> findByRoles_Id(int idRole);

//    @Lock(LockModeType.NONE)
    /*
    None: không khóa dữ liệu khi truy vấn
    PESSIMISTIC_READ: read bị khóa
    PESSIMISTIC_WRITE: write bị khóa
    PESSIMISTIC_FORCE_INCREMENT: write bị khóa với phiên bản update
    */
    @Query(value = "select * from accounts WHERE  status = ?", nativeQuery = true)
    List<User> findByByStatus(String status);

    /*
    * Page và Slice đều lấy 1 phần dữ liệu phân trang từ kết quả truy vấn
    * Slice: không cần tải toàn bộ dữ liệu, không lấy dc tổng số bản ghi
    * Page: cần tải toàn bộ dữ liệu, có thể lấy được tổng số bản ghi
    * */
    Page<User> findByName(String lastname, Pageable pageable);
    Slice<User> findByAddress(String address, Pageable pageable);

//    Page<User> findByName(String lastname, Sort sort);
//
//    Page<User> findFirst10ByName(String name);
//    @Nullable
//    Streamable<User> findsByName(@Nullable String name);

}
