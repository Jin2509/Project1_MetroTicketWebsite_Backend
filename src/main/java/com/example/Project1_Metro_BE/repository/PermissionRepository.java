package com.example.Project1_Metro_BE.repository;

import com.example.Project1_Metro_BE.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    List<Permission> findByRoleId(Long roleId);
    List<Permission> findByFunctionEntityId(Long functionId);
}
