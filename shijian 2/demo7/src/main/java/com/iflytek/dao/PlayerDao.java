package com.iflytek.dao;

import com.iflytek.pojo.Player;
//import com.iflytek.pojo.Student;

import java.util.List;

public interface PlayerDao {

    void addPlayer(Player player);

    List<Player> selectPlayer();

    void deletePlayer(String sid);

    void updatePlayer(Player player);


}
