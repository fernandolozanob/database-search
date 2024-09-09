/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jawhar
 */
public class DAO {
    
    Connexion connexion;
    DAO(){
        connexion = new Connexion("E:/bd/lotdatabase");
        connexion.connect();
        
    }
    
    
    
    public List recherche(String ch) throws SQLException{
        
        ResultSet res = connexion.query("SELECT * FROM projet where (nom_projet like '%"+ch+"%' or client like '%"+ch+"%' or usage like '%"+ch+"%' or secteur1 like "
                + "'%"+ch+"%' or description like '%"+ch+"%'"
                + "or materiel like '%"+ch+"%' or logiciel like '%"+ch+"%' or sdk like '%"+ch+"%')" );
        
        
        
        List<Projet> liste=new ArrayList<Projet>();
        
        while(res.next())
        {
            
            Projet p=new Projet();
               p.setClient(ch);
               p.setClient(res.getString("client"));
               p.setUsage(res.getString("usage"));
               p.setSecteur1(res.getString("secteur1"));
               p.setSecteur2(res.getString("secteur2"));
               p.setLot1(res.getString("lot1"));
               p.setLot2(res.getString("lot2"));
               p.setDescription(res.getString("description"));
               p.setMateriel(res.getString("materiel"));
               p.setLogiciel(res.getString("logiciel"));
               p.setLanguage(res.getString("language"));
               p.setPlateforme_dev(res.getString("plateforme_dev"));
               p.setEnvironnement(res.getString("environnement"));
               p.setSdk(res.getString("sdk"));
               p.setLibrairie_os(res.getString("librairie_os"));
               p.setPlateforme_cv(res.getString("plateforme_cv"));
               p.setPlateforme_hard(res.getString("plateforme_hard"));
               p.setMachine_cv(res.getString("machine_cv"));
               p.setNom_projet(res.getString("nom_projet"));
                
            
        
            liste.add(p);
        }
        return liste;
    }
    
    
}
