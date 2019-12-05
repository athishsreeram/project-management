package org.github.athishsreeram.project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRespository extends JpaRepository<Project, String> {
}