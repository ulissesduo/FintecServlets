package br.com.fiap.fintech.FIAP;

import br.com.fiap.fintech.Entities.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameDaoImp implements GameDao {


    @Override
    public void save(Game game) {
        Connection con = ConnectionManager.getConnection();

        PreparedStatement stmt = null;
        String sql = "INSERT INTO tb_games (game_id, titulo, estudio,ano_lancamento,finalizado) values (?, ?, ?, ?,?)";

        try{
            stmt=con.prepareStatement(sql);
            stmt.setLong(1, game.getId_game());
            stmt.setString(2, game.getTitulo());
            stmt.setString(3, game.getEstudio());
            stmt.setInt(4,game.getAno());
            stmt.setBoolean(5,game.isFinalizado());
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                stmt.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public void findById(Long id) {

    }
}
