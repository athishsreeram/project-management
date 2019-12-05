package org.github.athishsreeram.team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRespository extends JpaRepository<Team, String> {
}