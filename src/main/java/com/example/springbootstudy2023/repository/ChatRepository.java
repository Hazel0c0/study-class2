package com.example.springbootstudy2023.repository;

import com.example.springbootstudy2023.vo.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, String> {

    @Query("select c from Chat c where c.createDate >= " +
            "(select c2.createDate from Chat c2 where c2.uuid = :uuid)")
    List<Chat> findAllByAfterUuidCreateDate(String uuid);

}
