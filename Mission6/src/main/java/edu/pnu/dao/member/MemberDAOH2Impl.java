package edu.pnu.dao.member;

import edu.pnu.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemberDAOH2Impl implements MemberInterface{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberDAOH2Impl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map<String, Object> getMembers() {
        String sqlString = "select * from member order by id asc";
        Map<String, Object> map = new HashMap<>();
        map.put("sql", sqlString);
        try {
            List<MemberVO> list = jdbcTemplate.query(sqlString, new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
            map.put("data", list);
        } catch (Exception e){
            map.put("data", null);
        }
        return map;
    }

    @Override
    public Map<String, Object> getMember(Integer id) {
        String sqlString = String.format("select * from member where id=%d", id);
        Map<String, Object> map = new HashMap<>();
        map.put("sql", sqlString);
        try {
            MemberVO member = jdbcTemplate.queryForObject(sqlString, new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
            map.put("data", member);
        } catch (Exception e){
            map.put("data", null);
        }
        return map;
    }

    @Override
    public Map<String, Object> addMember(MemberVO member) {
        String sqlString = "insert into member (id,pass,name) values (?,?,?)";
        Map<String, Object> map = new HashMap<>();
        map.put("sql", sqlString);
        int id;
        try {
            id = jdbcTemplate.queryForObject("select max(id) from member", Integer.class) + 1;
        } catch (Exception e){
            map.put("data", null);
            return map;
        }
        try {
            if (jdbcTemplate.update(sqlString, id, member.getPass(), member.getName()) != 0){
                Map<String, Object> ret = getMember(id);
                map.put("data", ret.get("data"));
            } else {
                map.put("data", null);
            }
        } catch (Exception e){
            map.put("data", null);
        }
        return map;
    }

    @Override
    public Map<String, Object> updateMember(MemberVO member) {
        String sqlString = String.format("update member set pass='%s',name='%s' where id=%d",
            member.getPass(), member.getName(), member.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("sql", sqlString);
        try {
            if (jdbcTemplate.update(sqlString) != 0){
                Map<String, Object> ret = getMember(member.getId());
                map.put("data", ret.get("data"));
            } else {
                map.put("data", null);
            }
        } catch (Exception e){
            map.put("data", null);
        }
        return map;
    }

    @Override
    public Map<String, Object> deleteMember(Integer id) {
        String sqlString = String.format("delete from member where id=%d", id);
        Map<String, Object> map = new HashMap<>();
        map.put("sql", sqlString);
        try {
            Map<String, Object> ret = getMember(id);
            if (ret.get("data") != null && jdbcTemplate.update(sqlString) != 0){
                map.put("data", ret.get("data"));
            } else {
                map.put("data", null);
            }
        } catch (Exception e){
            map.put("data", null);
        }
        return map;
    }
}
