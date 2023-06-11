package com.iflytek.services;

import com.iflytek.pojo.Player;

import java.util.List;
//import com.iflytek.pojo.Student;

public interface PlayerService {
    void addPlayer(Player player);

    void deletePlayer(String sid);

    void updatePlayer(Player player);

    List<Player> selectPlayer();
}
