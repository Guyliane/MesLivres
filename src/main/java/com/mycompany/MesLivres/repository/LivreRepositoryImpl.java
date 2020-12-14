package com.mycompany.MesLivres.repository;

import com.mycompany.MesLivres.DataSourceProvider;
import com.mycompany.MesLivres.entity.Auteur;
import com.mycompany.MesLivres.entity.Livre;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivreRepositoryImpl {

    public void create(Livre livre){
        Connection conn = null;
        try {

            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn=dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("insert into LIVRE (TITRE, RESUME, ID_AUTEUR) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, livre.getTitre());
            preparedStatement.setString(2, livre.getResume());
            preparedStatement.setLong(3, livre.getAuteur().getId());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();

            if(rs.next()){
                livre.setId(rs.getLong(1));
            }

            System.out.println("Livre ajouté");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Livre livre){
        Connection conn = null;
        try {

            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn=dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("update LIVRE set TITRE=?, RESUME=? where ID = ?");
            preparedStatement.setString(1, livre.getTitre());
            preparedStatement.setString(2, livre.getResume());
            preparedStatement.setLong(3, livre.getId());


            preparedStatement.executeUpdate();

            System.out.println("Livre modifié");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(Long id){
        Connection conn = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn=dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("delete from LIVRE where ID = ?");
            preparedStatement.setLong(1, id);


            preparedStatement.executeUpdate();

            System.out.println("Livre supprimé");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Livre getById(Long id){
        Connection conn = null;
        Livre livre = null;
        try {

            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn=dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("select TITRE, RESUME from LIVRE where ID = ?");
            preparedStatement.setLong(1, id);


            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                livre = new Livre();
                livre.setId(id);
                livre.setTitre(rs.getString("TITRE"));
                livre.setResume(rs.getString("RESUME"));
            }

            System.out.println("Livre lu");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return livre;
    }

    public List<Livre> list(Long id){
        Connection conn = null;
        List<Livre> livres = new ArrayList<>();
        try {

            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn=dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("select ID, TITRE, RESUME from LIVRE");

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Livre livre = new Livre();
                livre.setId(rs.getLong("ID"));
                livre.setTitre(rs.getString("TITRE"));
                livre.setResume(rs.getString("RESUME"));
                livres.add(livre);
            }

            System.out.println("Livres lus");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return livres;
    }
}
