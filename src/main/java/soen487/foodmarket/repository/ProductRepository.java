package soen487.foodmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soen487.foodmarket.dataobject.ProductInfo;

public interface ProductRepository extends JpaRepository<ProductInfo, String> {
}
