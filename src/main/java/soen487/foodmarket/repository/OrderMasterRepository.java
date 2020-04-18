package soen487.foodmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soen487.foodmarket.dataobject.OrderMaster;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
