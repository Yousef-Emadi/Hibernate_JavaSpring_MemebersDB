package com.joseph.MemberDatabse.repository;

import com.joseph.MemberDatabse.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
}
