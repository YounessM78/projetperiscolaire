package Model;

import java.util.*;

/**
 * 
 */
public class Employes_cantine extends Employes{

    /**
     * Default constructor
     */
    public Employes_cantine(String n, String p, String t) {
    	super(n,p);
    	this.Tache = t;
    }
    
    public static Vector<Employes_cantine> listEmployes_cantine = new Vector<Employes_cantine>();
    
    public static void addEmployes_cantine(String n,String p,String tache) {
    	listEmployes_cantine.add(new Employes_cantine(n,p,tache));
    	System.out.println(listEmployes_cantine.size()+"employé de cantine");
    }

    /**
     * 
     */
    
    /**
     * 
     */
    public String Tache;

    /**
     * 
     */
    public void Connexion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void VisuListEleveC() {
        // TODO implement here
    }

    /**
     * 
     */
    public void AccesEDT() {
        // TODO implement here
    }

}
