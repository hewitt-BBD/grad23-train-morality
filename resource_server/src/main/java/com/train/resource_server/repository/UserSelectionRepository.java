package com.train.resource_server.repository;

import com.train.resource_server.entity.UserSelection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSelectionRepository  extends JpaRepository<UserSelection, Integer> {
}
