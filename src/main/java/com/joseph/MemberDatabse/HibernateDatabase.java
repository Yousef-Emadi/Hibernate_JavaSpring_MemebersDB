package com.joseph.MemberDatabse;

import java.util.List;
import java.util.Optional;

public class HibernateDatabase implements Database{

    private MemberRepository memberRepository = MemberDB_Application.ctx.getBean(MemberRepository.class);

    @Override
    public boolean addMember(Member member) {
        Member addMemberResult = memberRepository.save(member);
        if (addMemberResult != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Member findMember(int id) {
        // Optional is a special Java feature so methods can avoid returning null.
        Optional<Member> result = memberRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Iterable<Member> listMember() {
        return memberRepository.findAll();
    }

    @Override
    public void removeMember(Member member) {
        memberRepository.delete(member);
    }


}
