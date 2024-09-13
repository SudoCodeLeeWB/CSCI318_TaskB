package Jome.User_Microservice.infrastructure.persistence;

import Jome.User_Microservice.domain.entity.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<ServiceUser, Long> {
}
