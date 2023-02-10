
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //oppgave2.7


        //Oppgave 2.6
        //instance of Random class
        Random randomSpilleTid = new Random();
        //source: https://www.baeldung.com/java-generating-random-numbers-in-range
        //source on example: https://www.youtube.com/watch?v=VMZLPl16P5c
        // code snippet: random.nextInt(max - min) + min;
        //max is exclusive, not included in random generated number. So we need to have 1 highter than 30, 30+1 in order to have 30 being included
        double randomTid = randomSpilleTid.nextDouble((30+1) - 20) + 20;

        //TVSerie objekt instance. The tv serie i chose is called futurama. Popular animated series which similar art style to The Simpsons, The Family Guy, American Dad and Cleavland.
        TVSerie futurama = new TVSerie("futurama","Fry is frozen in time and wakes up 100 years into future in 2100", LocalDate.of(1999,03,28));

        //Some episodes for season 1. Here episode is added the method for episoder ArrayList. Episode instance is added as argument without needed to make seperate variable for each episode.
        //I found late that i needed 20 episodes per season. So this is remake instead of creating each episode alone.
        for (int i = 1; i <= 100; i++) {

            int seasong = 0;

            if(i <= 20) {
                seasong = 1;

            } else if (i <= 40) {

                seasong = 2;

            } else if (i <= 60) {

                seasong = 3;

            } else if (i <= 80) {

                seasong = 4;

            } else {
                seasong = 5;
            }

            futurama.leggTilEpisode(new Episode("Episode " + i, i, seasong, randomTid));
        }

        System.out.println();
        System.out.println("----------------Oppgave2.1 and oppgave2.2-----------------------------------");
        //oppgave2.1 and oppgave2.2
        //TVSerie and Episode class created with getter setter methods
        //Object instance of TVSerie called "futurama" is created
        //Using setter method in futurama object, episodes are added

        //Store first episode in a variable. This is for easier print out
        Episode ep1 = futurama.getEpisoder().get(0);

        //simple print of serie name and data about the first episode to console using the getter methods.
        System.out.printf("The serie %s episode number: %d named \"%s\" in season: %d lasts %.2f min\n",futurama.gettTitle(),ep1.getEpisodeNr(),ep1.getTitle(),ep1.getSesongNr(),ep1.getSpilletid());

        System.out.println();
        System.out.println("----------------Oppgave2.3-----------------------------------");
        //oppgave2.3
        //overridden toString method in TVSerie class
        System.out.printf("%s",futurama.toString());

        //get the a episode from the ArrayList episoder in Episode class with getter method. Here the 2nd episode is fetched.
        Episode ep2 = futurama.getEpisoder().get(1);

        //print out the overridden toString() method in Episode class.
        System.out.printf("%s",ep2.toString());

        System.out.println();
        System.out.println("----------------Oppgave2.4-----------------------------------");
        //oppgave2.4
        //ArrayList variable which holds the episodes of specified sesong number. Here sesong 4 as asked in oppgave2.4.
        //hentEpisoderISesong method is called. The loop inside method runs and returns the correct episodes.
        ArrayList<Episode> seasonEpisodes = futurama.hentEpisoderISesong(4);

        //Now that we have a correct episode list stored in ArrayList, we can loop through the ArrayList and show user in terminal all episodes in the specified sesong with generic info.
        for(int i = 0; i < seasonEpisodes.size(); i++){

            //print out to terminal each episode with generic information.
            System.out.println("season: "+seasonEpisodes.get(i).getSesongNr()+ " episode: "+seasonEpisodes.get(i).getEpisodeNr()+ " Episode_name: \""+seasonEpisodes.get(i).getTitle()+ "\" duration: "+seasonEpisodes.get(i).getSpilletid()+ " min");
        }

        System.out.println();
        System.out.println("----------------Oppgave2.5-----------------------------------");
        //oppgave2.5
        //to get average playtime/spille of all episodes added so far, you run get method for gjennomsnittligSpilletid instance variable in TVSerie class object, futurama.
        System.out.printf("Average playtime after 5 seasons: %.2f min\n",futurama.getGjennomsnittligSpilletid());

        System.out.println();
        System.out.println("----------------Oppgave2.6 and oppgave 2.7-----------------------------------");
        //oppgave2.6 and oppgave 2.7
        //Here we try adding 2 episodes in season 10 and 15. This should not work and show error message
        futurama.leggTilEpisode(new Episode("new episode",110,10,randomTid));
        futurama.leggTilEpisode(new Episode("even newer episode",120,15,randomTid));

        //Here add 2 new episodes at season 6. season 6 is one more highter than current max season number which is 5.
        //adding episodes works now since both episodes are at season 6. Now it is possible to add season 7 if we can want.
        futurama.leggTilEpisode(new Episode("working episode 1",110,6,randomTid));
        futurama.leggTilEpisode(new Episode("working episode 2",120,6,randomTid));

        //Store

       ArrayList<Episode> list = futurama.hentEpisoderISesong(6);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getTitle()+ " season"+list.get(i).getSesongNr());
        }


        System.out.println();
        System.out.println("-----------------------------Oblig 3 starts here-------------------------------------------");
        System.out.println("----------------Oppgave2.1-----------------------------------");
        System.out.println("Old from oblig2 works fine");

        System.out.println();
        System.out.println("----------------Oppgave2.2-----------------------------------");

        //Film objects
        Film matrix = new Film("the matrix",136,LocalDate.of(1999,3,31));
        Film dune = new Film("dune",156,LocalDate.of(2021,10,22));
        Film starWars = new Film("star wars A New Hope (1977)",121,LocalDate.of(1977,5,25));
        Film avengers = new Film("the avengers",143,LocalDate.of(2012,4,27));
        Film wakanda = new Film("wakanda",12,LocalDate.of(2022,11,9));

        //print out title of each Film object

        //first create an ArrayList storing all Film objects created so far
        ArrayList<Film> filmList = new ArrayList<>();

        //add Film objects to the empty ArrayLust "filmList"
        //resource for addAll(): https://www.baeldung.com/java-arrays-aslist-vs-new-arraylist
        filmList.addAll(Arrays.asList(matrix,dune,starWars,avengers,wakanda));

        //Finally print out all title of each movie
        for(Film film : filmList){
            System.out.printf("Tittel: %s\n",film.getTitle());
        }

        System.out.println();
        System.out.println("----------------Oppgave2.3-----------------------------------");

        //test out new instance variables(utgivelsesdato and spilletid) in both Film and Episode classes

        //Film object
        Film narnia = new Film("the legend of narnia",150,"Four kids travel through a wardrobe to the land of Narnia and learn of their destiny to free it with the guidance of a mystical lion.",LocalDate.of(2005,12,26));
       futurama.leggTilEpisode(new Episode("special episode",145,6,44,"this episode is very special for sure",LocalDate.of(2023,2,8)));

       //get episodes from season 6 where episodenr 145 is located
       ArrayList<Episode> season6 = futurama.hentEpisoderISesong(6);

       //empty ArrayList to store episodenr 145 during loop below
        ArrayList<Episode> episode145 = new ArrayList<>();

       for(int i = 0; i < season6.size(); i++){
           Episode currentEp = season6.get(i);

           if(currentEp.getEpisodeNr() == 145)
           episode145.add(currentEp);
       }

        System.out.printf("Narnia plot: %s\n",narnia.getBeskrivelse());
        System.out.printf("Episode nr %d, released in %s has plot as follows: \"%s\"\n",episode145.get(0).getEpisodeNr(),episode145.get(0).getUtgivelsesdato(),episode145.get(0).getBeskrivelse());

        System.out.println();
        System.out.println("----------------Oppgave2.4-----------------------------------");

        //oppgave2.4 - regissor

        //regissor instances
        Person neo = new Person("thomas","anderson");
        Person shuri = new Person("aja","adanna");
        Person fry = new Person("phlipp","fry");

        //Adding Person objects as regissor to both to the Film and Episode objects. neo to the matrix and shuri to wankanda

        //add regissor to Film
        System.out.println("Add regissor to films and print out regissor full name: ");
        for(Film film : filmList){
            if(film.getTitle().equals("the matrix")){
                //add neo Person object when Film is the Matrix
                film.setRegissor(neo);
            } else if(film.getTitle().equals("wakanda")){
                //add shuri when loop is at wakanda
                film.setRegissor(shuri);
            }
        }

        //print out Film objects with regissor
        for(Film film : filmList){
            if(film.getTitle().equals("the matrix")){
                System.out.printf("Film: %s, regissor: %s\n",film.getTitle(),film.getRegissor().getFullName());
            } else if(film.getTitle().equals("wakanda")){
                System.out.printf("Film: %s, regissor: %s\n",film.getTitle(),film.getRegissor().getFullName());
            }
        }

        System.out.println();
        System.out.println("Add regissor to an episode and print out regissor full name:");
        //add regissor to Episode object. Here using Episode object episode145 created in oppgave2.3 above
        episode145.get(0).setRegissor(fry);

        //print out regissor in epside145
        System.out.printf("EpisodeNr: %d, regissor: %s\n",episode145.get(0).getEpisodeNr(),episode145.get(0).getRegissor().getFullName());



     //main method end
    }
}