
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
        System.out.println("----------------Oppgave2.5-----------toString------------------------");
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


        //=====================================Oblig2 ends here=======================================================================================



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

        System.out.println();
        System.out.println("----------------Oppgave2.5-----------------------------------");

        //Rolle objects
        Rolle producer = new Rolle("executive","producer",new Person("homer","simpson"));
        Rolle castingPerson = new Rolle("casting","director",new Person("bart","simpson"));
        Rolle artDP = new Rolle("art","department",new Person("lisa","simpson"));
        Rolle soundDP = new Rolle("sound","department",new Person("maggie","simpson"));

        //to avoid looping like in oppgave2.4, creating new Film and Episode instance to use is easier
        Film theSimpsonsMovie = new Film("the simpsons",145,LocalDate.of(2007,7,27));

        //add 2 roller to the new movie using set method which can add multiple items
        //first create and ArrayList to hold the 2 roller that is being added to the movie
        ArrayList<Rolle> movieCreators = new ArrayList<>();
        movieCreators.add(producer);
        movieCreators.add(castingPerson);

        //now add movieCreators list to the movie
        theSimpsonsMovie.leggTilMangeRoller(movieCreators);

        //to print out roller in the Film object, we need to use the get method which Film class has inherited from Production class.
        //First store rolle ArrayList in a Rolle variable than be looped through
        ArrayList<Rolle> simpsonsMovieRoller = theSimpsonsMovie.getRoller();

        //loop through each Rolle item and finally print out content inside each array object
        System.out.println();
        System.out.println("Rolle in The Simpons Movie: ");
        for(Rolle enRolle : simpsonsMovieRoller){
            System.out.printf("%s har rollen: \"%s %s\"\n",enRolle.getSkuespiller().getFullName(),enRolle.getRolleFornavn(),enRolle.getRolleEtternavn());
        }

        //Add roller to an Episode object. This is similar to step above when adding roller to theSimpsonsMovie
        //first create an Episode object. This is also to avoid looping through entire Epside list which is over 100+ episodes.
        Episode simpsonsEpisode = new Episode("Episode by the children",321,7,44);

        //Array:ist to roller
        ArrayList<Rolle> episodeRoller = new ArrayList<>();

        //add roller to the empty ArrayList,episoderoller. We are using the remaining 2 Rolle objects, artDP and soundDP
        episodeRoller.add(artDP);
        episodeRoller.add(soundDP);

        //now the Arraylist to episode as new Rolle objects
        simpsonsEpisode.leggTilMangeRoller(episodeRoller);

        //same as before. Store rolle ArrayList in simponsEpisode in an ArrayList that can be looped to print out data
        ArrayList<Rolle> simpsonsEpisodeRoller = simpsonsEpisode.getRoller();

        //loop through list
        //using normal for loop because it is better imo
        System.out.println();
        System.out.println("Rolle in simpons episode: ");
        for(int i = 0; i < simpsonsEpisodeRoller.size(); i++){

            //variable to store rolle in loop iteration using index for loop
            Rolle enRolle = simpsonsEpisodeRoller.get(i);

            //print out to console data from each rolle in the episode
            System.out.printf("%s har rollen: \"%s %s\"\n",enRolle.getSkuespiller().getFullName(),enRolle.getRolleFornavn(),enRolle.getRolleEtternavn());

        }

        System.out.println();
        System.out.println("----------------Oppgave2.6 - toString()-----------------------------------");

        //print out generic info from classes using toString() method
        //new class which didn't have toString() override are: Film, Person, Rolle, Production classes.

        //Production class is an abstract class, so it is not easy to access it's toString() unless it is changed to static method
        //we get other issues when toString() in Production class is static since children class(Epsidoe, Film) would need to change their..
        //toString() to static too. So toString() in Production class is quite useless outside simple print which children classes would inherit

        //Film class toString()
        System.out.println(avengers.toString());
        //Rolle class toString()
        System.out.println(producer.toString());
        //Person class toStirng()
        System.out.println(neo.toString());


        System.out.println();
        System.out.println("----------------Oppgave2.7-----------------------------------");

        //All episodes in TVSerie futurama have no roller.
        //first ArrayList<Episode> which stores all Episode objects in futurama TVSerie using getter method
        ArrayList<Episode> allFuturamaEpisodes = futurama.getEpisoder();



        //To add Rolle rolle to each episode, loop first through entire ArrayList, allFuturamaEpisodes
        for(Episode episode : allFuturamaEpisodes){
            //add Rolle to each episode
            //this means that all episode will have same Rolle objects.
            episode.leggTilEnRolle(producer);
        }


        //To get all Rolle in all episodes, we can use the method hentRollebesetning() in TVSerie
        //store in an ArrayList<Rolle> that can be looped through to print out data
        ArrayList<Rolle> allFuturamaEpisodesRoller = futurama.hentRollebesetning();


        //loop through ArrayList and print out data from each Rolle object
        for(Rolle rolle : allFuturamaEpisodesRoller){

            //Here we print out navn of rolle and skuespiller fullName.
            System.out.printf("Navn: %s har rollen: %s %s\n",rolle.getSkuespiller().getFullName(),rolle.getRolleFornavn(),rolle.getRolleEtternavn());
        }







     //main method end
    }
}