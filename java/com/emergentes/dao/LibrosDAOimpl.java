package com.emergentes.dao;

import com.emergentes.modelo.Libros;
import com.emergentes.utiles.ConectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibrosDAOimpl extends ConectionDB implements LibrosDAO{

    @Override
    public void insert(Libros libros) throws Exception {
      try{  
         this.conectar();
         PreparedStatement ps = this.conn.prepareStatement("INSERT INTO libros (titulo,autor,disponible,categoria) values(?,?,?,?)");
         ps.setString(1, libros.getTitulo());
         ps.setString(2, libros.getAutor());
         ps.setString(3, libros.getDisponible());
         ps.setString(4, libros.getCategoria());
         ps.executeUpdate();
      } catch(Exception e){
          throw e;
      }finally {    
          this.desconectar();
      } 
    }
    @Override
    public void update(Libros libros) throws Exception {
         try{  
         this.conectar();
         PreparedStatement ps = this.conn.prepareStatement("UPDATE libros SET titulo= ?,autor=?,disponible=?,categoria=? where id = ? ");
         ps.setString(1, libros.getTitulo());
         ps.setString(2, libros.getAutor());
         ps.setString(3, libros.getDisponible());
         ps.setString(4, libros.getCategoria());
         ps.setInt(5, libros.getId());
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
         PreparedStatement ps = this.conn.prepareStatement("DELETE FROM libros WHERE id = ? ");
         ps.setInt(1, id);
        
         ps.executeUpdate();
      } catch(Exception e){
          throw e;
      }finally {    
          this.desconectar();
      }
    }

    @Override
    public Libros getById(int id) throws Exception {   
        Libros li = new Libros();
        try{  
         this.conectar();
         
         PreparedStatement ps = this.conn.prepareStatement("SELECT * from libros WHERE id = ?");
         ps.setInt(1,id);
        
         ResultSet rs = ps.executeQuery();
         if (rs.next()){
             li.setId(rs.getInt("id"));
             li.setTitulo(rs.getString("titulo"));
             li.setAutor(rs.getString("autor"));
             li.setDisponible(rs.getString("disponible"));
             li.setCategoria(rs.getString("categoria"));
         }
         
      } catch(Exception e){
          throw e;
      }finally {    
          this.desconectar();
      }
        return li;
    }
    @Override
    public List<Libros> getAll() throws Exception {
        List<Libros> lista = null;
        try{  
         this.conectar();
         
         PreparedStatement ps = this.conn.prepareStatement("SELECT * from libros");
         ResultSet rs = ps.executeQuery();
         
         lista = new ArrayList<Libros>();
         
         while (rs.next()){
             Libros li = new Libros();
             
             li.setId(rs.getInt("id"));
             li.setTitulo(rs.getString("titulo"));
             li.setAutor(rs.getString("autor"));
             li.setDisponible(rs.getString("disponible"));
             li.setCategoria(rs.getString("categoria"));
             
             lista.add(li);
         }
         rs.close();
         ps.close();;
         
      } catch(Exception e){
          throw e;
      }finally {    
          this.desconectar();
      }
        return lista;
    }
    
}
