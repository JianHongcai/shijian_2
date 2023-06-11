package com.iflytek.services.impl;

import com.iflytek.dao.PlayerDao;

import com.iflytek.dao.impl.PlayerDaoImpl;

import com.iflytek.pojo.Player;
import com.iflytek.services.PlayerService;

import java.util.List;

public class PlayerServiceImpl implements PlayerService {


    private PlayerDao playerDao =  new PlayerDaoImpl();
    @Override
    public void addPlayer(Player player) {
        playerDao.addPlayer(player);
    }

    @Override
    public void deletePlayer(String sid) {
       playerDao.deletePlayer(sid);
    }

    @Override
    public void updatePlayer(Player player) {
        playerDao.updatePlayer(player);
    }

    @Override
    public List<Player> selectPlayer() {
        List<Player>stus = playerDao.selectPlayer();
        return stus;

    }
}
