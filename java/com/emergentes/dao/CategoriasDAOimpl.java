package com.emergentes.dao;

import com.emergentes.modelo.Categorias;
import com.emergentes.utiles.ConectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class CategoriasDAOimpl extends ConectionDB implements CategoriasDAO {

    @Override
    public void insert(Categorias categoria) throws Exception {
         try{  
         this.conectar();
         String sql = "INSERT INTO categoria (categoria) values(?)";
         PreparedStatement ps = this.conn.prepareStatement(sql);
         ps.setString(1, categoria.getCategoria());
         ps.executeUpdate();
      } catch(Exception e){
          throw e;
      }finally {    
          this.desconectar();
      }
    }

    @Override
    public void update(Categorias categoria) throws Exception {
         try{  
         this.conectar();
         String sql = "UPDATE categoria SET categoria=? WHERE id=?";
         PreparedStatement ps = this.conn.prepareStatement(sql);
         ps.setString(1, categoria.getCategoria());
         ps.setInt(2, categoria.getId() );
         ps.executeUpdate();
      } catch(Exception e){
          throw e;
      }finally {    
          this.desconectar();
      }
    }

    @Override
    public void delete(int id) throws Exception {
       try{  
         this.conectar();
         String sql = "DELETE FROM categoria WHERE id=?";
         PreparedStatement ps = this.conn.prepareStatement(sql);         
         ps.setInt(1,id);
         ps.executeUpdate();
      } catch(Exception e){
          throw e;
      }finally {    
          this.desconectar();
      }     
    }

    @Override
    public Categorias getById(int id) throws Exception {
        Categorias cat = new Categorias();
        try{  
         this.conectar();
         String sql = "SELECT * FROM Categorias WHERE id =?";
         PreparedStatement ps = this.conn.prepareStatement(sql);         
         ps.setInt(1,id);
         ResultSet rs = ps.executeQuery();
         
         if(rs.next()){
             cat.setId(rs.getInt("id"));
             cat.setCategoria(rs.getString("categoria"));
             
         }
      } catch(Exception e){
          throw e;
      }finally {    
          this.desconectar();
      }
        return cat;
    }

    @Override
    public List<Categorias> getAll() throws Exception {
        List<Categorias> lista =null;
          try{  
         this.conectar();
         String sql = "SELECT * FROM Categorias";
         PreparedStatement ps = this.conn.prepareStatement(sql);         
         
         ResultSet rs = ps.executeQuery();
         
        while (rs.next()){
            Categorias cat = new Categorias();
             cat.setId(rs.getInt("id"));
             cat.setCategoria(rs.getString("categoria"));
             
         }
        rs.close();
        ps.close();
      } catch(Exception e){
          throw e;
      }finally {    
          this.desconectar();
      }
          return lista;
    }
    
}
