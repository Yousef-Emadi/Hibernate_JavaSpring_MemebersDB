package com.joseph.MemberDatabse;

import java.util.List;
import java.util.Optional;

public class HibernateDatabase implements Database{

    private MemberRepository memberRepository = MemberDB_Application.ctx.getBean(MemberRepository.class);

    @Override
    public void createFile(String path) {
    }

    @Override
    public List<Member> downloadFromFile() {
        return null;
    }

    @Override
    public void writeMemberToFile(Member member, String filePath) {

    }

    @Override
    public void uploadToFile(List<Member> list, String filePath) {

    }

    @Override
    public void deleteFile(String path) {

    }

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
    public void removeMember(int id) {
        memberRepository.delete(findMember(id));
    }
}
