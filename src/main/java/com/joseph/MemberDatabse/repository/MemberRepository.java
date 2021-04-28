package com.joseph.MemberDatabse.repository;

import com.joseph.MemberDatabse.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Integer> {
}
