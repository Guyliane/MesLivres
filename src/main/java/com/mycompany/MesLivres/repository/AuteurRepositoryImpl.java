package com.mycompany.MesLivres.repository;

import com.mycompany.MesLivres.DataSourceProvider;
import com.mycompany.MesLivres.entity.Auteur;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuteurRepositoryImpl {

    public void create(Auteur auteur){
        Connection conn = null;
        try {

            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn=dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("insert into AUTEUR (NOM, PRENOM) values (?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, auteur.getNom());
            preparedStatement.setString(2, auteur.getPrenom());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();

            if(rs.next()){
                auteur.setId(rs.getLong(1));
            }

            System.out.println("Auteur ajouté");

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

    public void update(Auteur auteur){
        Connection conn = null;
        try {

            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn=dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("update AUTEUR set NOM=?, PRENOM=? where ID = ?");
            preparedStatement.setString(1, auteur.getNom());
            preparedStatement.setString(2, auteur.getPrenom());
            preparedStatement.setLong(3, auteur.getId());


            preparedStatement.executeUpdate();

            System.out.println("Auteur modifié");

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

            PreparedStatement preparedStatement = conn.prepareStatement("delete from AUTEUR where ID = ?");
            preparedStatement.setLong(1, id);


            preparedStatement.executeUpdate();

            System.out.println("Auteur supprimé");

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

    public Auteur getById(Long id){
        Connection conn = null;
        Auteur auteur = null;
        try {

            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn=dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("select NOM, PRENOM from AUTEUR where ID = ?");
            preparedStatement.setLong(1, id);


            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                auteur = new Auteur();
                auteur.setId(id);
                auteur.setNom(rs.getString("NOM"));
                auteur.setPrenom(rs.getString("PRENOM"));
            }

            System.out.println("Auteur lu");

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
        return auteur;
    }

    public List<Auteur> list(Long id){
        Connection conn = null;
        List<Auteur> auteurs = new ArrayList<>();
        try {

            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn=dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement("select ID, NOM, PRENOM from AUTEUR");

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Auteur auteur = new Auteur();
                auteur.setId(rs.getLong("ID"));
                auteur.setNom(rs.getString("NOM"));
                auteur.setPrenom(rs.getString("PRENOM"));
                auteurs.add(auteur);
            }

            System.out.println("Auteurs lus");

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
        return auteurs;
    }
}
