package com.iflytek.dao.impl;

import com.iflytek.dao.PlayerDao;
import com.iflytek.pojo.Player;
import com.iflytek.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlayerDaoImpl implements PlayerDao {
    @Override
    public void addPlayer(Player player) {

        try{
        Connection conn = JdbcUtil.getConnection();
        String sql ="INSERT INTO tb_player(sid,NAME,sex,age,collage) VALUES("+player.getSid()+",'"+player.getName()+"','"+player.getSex()+"',"+player.getAge()+",'"+player.getCollage()+"')";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = ps.executeUpdate();
        System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Player> selectPlayer() {
        try{
            Connection conn = JdbcUtil.getConnection();
            String sql = "select * from tb_player";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Player>stus = new ArrayList<>();
            while (rs.next()){
                Player student = new Player();
                student.setId(rs.getInt("id"));
                student.setSid(rs.getString("sid"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setAge(rs.getInt("age"));
                student.setCollage(rs.getString("collage"));
                stus.add(student);
            }

            return stus;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deletePlayer(String sid) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "DELETE FROM tb_player WHERE sid ='"+sid+"'";
            PreparedStatement ps = conn.prepareStatement(sql);
            int i = ps.executeUpdate();
            System.out.println(i);

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    public void updatePlayer(Player player) {
        try {
            Connection conn = JdbcUtil.getConnection();
            String sql ="UPDATE tb_player SET sid ='"+player.getSid()+"',NAME='"+player.getName()+"',sex='"+player.getSex()+"',age="+player.getAge()+",collage='"+player.getCollage()+"' WHERE id= "+player.getId()+"";
            PreparedStatement ps = conn.prepareStatement(sql);
            int i = ps.executeUpdate();
            System.out.println(i);

        }catch (Exception e){
            e.printStackTrace();


        }
    }
}
