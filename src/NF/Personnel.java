package NF;

public class Personnel {

    private String nom;

    private String prenom;

    private String identifiant;

    private String mdp;

    private Statut statut;

    private boolean chefService;

    public Personnel(String nom, String prenom, String identifiant, String mdp, Statut statut, boolean chefService) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.mdp = mdp;
        this.statut = statut;
        this.chefService = false;
    }
    
    //affiche les informations du professionnel
    public String toString(){
        return ""+statut.toString()+" : "+this.nom+" "+this.prenom;
    }
    
    //vérifie si deux instances de Personnel sont égales
    public boolean equals(Object o){
        if (o instanceof Personnel){
        Personnel p = (Personnel) o;
        return this.nom.equals(p.nom)&& this.prenom.equals(p.prenom)&& this.statut.equals(p.statut);
        }
        else{
            return false;
        }
    }

    //retourne le nom
    public String getNom() {
        return nom;
    }

    //change le nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    //retourne le prénom
    public String getPrenom() {
        return prenom;
    }

    //changer le prénom
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    //retourne l'identifiant
    public String getIdentifiant() {
        return identifiant;
    }

    //change l'identifiant
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    //retourne le mot de passe
    public String getMdp() {
        return mdp;
    }

    //change le mot de passe
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    //retourne le statut professionnel
    public Statut getStatut() {
        return statut;
    }

    //change le statut professionnel
    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    //retourne si le professionnel est le chef de service
    public boolean isChefService() {
        return chefService;
    }

    //change si le professionnel est le chef de service
    public void setChefService(boolean chefService) {
        this.chefService = chefService;
    }

}
