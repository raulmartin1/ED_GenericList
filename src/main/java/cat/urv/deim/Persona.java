package cat.urv.deim;

public class Persona implements Comparable<Persona>{
    private int id_persona;
    private String nom;
    private String cognom;
    private int edat;
    private int pes;
    private int alsada;

    public Persona(int id_persona, int edat, String nom, String cognom, int alsada, int pes) {
        this.id_persona = id_persona;
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        this.pes = pes;
        this.alsada = alsada;
    }

    public int getId_persona() {
        return id_persona;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public int getEdat() {
        return edat;
    }

    public int getPes() {
        return pes;
    }

    public int getAlsada() {
        return alsada;
    }

    // Falta implementar correctament aquest metode per a fer la comparacio de persones. La comparacio
    // es fara pel COGNOM i NOM de la persona: primer comparem cognom, i si son iguals llavors comparem noms
    public int compareTo(Persona p) {
       int num = cognom.compareTo(p.getCognom());
       if(num==0) {
        num = nom.compareTo(p.getNom());
       }
       return num;
    }

    // Dues persones son iguals si tenen el mateix ID
    public boolean equals(Persona p) {
        return(id_persona==p.getId_persona());
    }
}

