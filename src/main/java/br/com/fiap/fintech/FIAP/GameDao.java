package br.com.fiap.fintech.FIAP;

import br.com.fiap.fintech.Entities.Game;

public interface GameDao {
    void save(Game game);


    void findById(Long id);
}
