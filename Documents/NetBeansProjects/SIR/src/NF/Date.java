package NF;

public class Date {

    private int jour;
    private int mois;
    private int annee;
    private int heure;
    private int minute;

    public Date(int jour, int mois, int annee, int heure, int minute) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.heure = heure;
        this.minute = minute;
    }

    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    @Override
    public String toString() {
        String s = "";
        if (jour < 10) {
            s += "0" + jour +"/";
        } else {
            s += jour+"/";
        }
        if( mois<10){
            s+="0"+mois+"/";
        }
        else s+=mois+"/";
        s+=annee +" a "+ heure+"h";
        if(minute<10)s+="0"+minute;
        else s+=minute;
        return s;
    }

    public String afficherDatedeNaissance() {
        if (mois < 10 && jour < 10) {
            return "0" + jour + " / 0" + mois + " / " + annee;
        }
        if (mois < 10) {
            return jour + " / 0" + mois + " / " + annee;
        }
        if (jour < 10) {
            return "0" + jour + " / " + mois + " / " + annee;
        } else {
            return +jour + " / " + mois + " / " + annee;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Date) {
            Date d = (Date) o;
            return (annee == d.annee) && (mois == d.mois) && (jour == d.jour) && (heure == d.heure) && (minute == d.minute);
        } else {
            return false;
        }
    }

    public boolean equalsDateDeNaissance(Object o) {
        if (o instanceof Date) {
            Date d = (Date) o;
            return (annee == d.annee) && (mois == d.mois) && (jour == d.jour);
        } else {
            return false;
        }
    }
  

}