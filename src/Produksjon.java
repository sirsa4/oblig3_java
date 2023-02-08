import java.time.LocalDate;

public abstract class Produksjon {

    //oppgave2.1 - move title and spilleTid from Episode class to abstract Produksjon class
    private String title;
    private double spilletid;

    //oppgave2.2
    private String beskrivelse;
    private LocalDate utgivelsesdato;


    //oppgave2.1

    //constructor for this class has only two instance variables in oppgave2.1 so far
    public Produksjon(String title, double spilletid){
        this.title = title;
        this.spilletid = spilletid;
    }

    //oppgave2.3
    //method overall on constructor to make sure previous code in oppgave2.2 does not crash
    public Produksjon(String title, double spilletid,LocalDate utgivelsesdato){
        this.title = title;
        this.spilletid = spilletid;
        this.utgivelsesdato = utgivelsesdato;
    }

    //oppgave2.3 constructor will 5 needed instance variables so far
    public Produksjon(String title, double spilletid,String beskrivelse,LocalDate utgivelsesdato){
        this.title = title;
        this.spilletid = spilletid;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
    }

    //Empty constructor is needed for the constructor in Episode class which is missing spilletid instance variable
    public Produksjon(){}

    //getter and setter for title and spilletid in oppgave2.1
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public double getSpilletid(){
        return this.spilletid;
    }
    public void setSpilletid(double spilletid){
        this.spilletid = spilletid;
    }

    //oppgave2.3
    //Setter and getter methods for instance variable "utgivelsesdato".
    //setter getter methods for utgivelsesdato is moved from Film class to here.
    public LocalDate getUtgivelsesdato(){
        return this.utgivelsesdato;
    }
    public void setUtgivelsesdato(LocalDate utgivelsesdato){
        this.utgivelsesdato = utgivelsesdato;
    }

    public String getBeskrivelse(){
        return this.beskrivelse;
    }
    public void setBeskrivelse(String beskrivelse){
        this.beskrivelse = beskrivelse;
    }


}//end of class