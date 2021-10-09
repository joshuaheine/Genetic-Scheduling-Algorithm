package genetic.algorithm.scheduling;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class GeneticAlgorithm {
    private Data data;

    public GeneticAlgorithm(Data data) {
        this.data = data;
    }
    
    //this perfroms mutate population on crossover population for the population
    public Population evolve(Population population){
        return mutatePopulation(crossoverPopulation(population));
    }
    
    //This perfroms crossover population where it compares the populations by their fitness and replaces the initial population if it has a better fitness
    Population crossoverPopulation(Population population){
        Population crossoverPopulation = new Population(population.getSchedules().size(), data);
        IntStream.range(0, Driver.NUM_OF_ELITE_SCHEDULES).forEach(x -> crossoverPopulation.getSchedules().set(x,population.getSchedules().get(x)));
        IntStream.range(Driver.NUM_OF_ELITE_SCHEDULES, population.getSchedules().size()).forEach(x ->{
            if(Driver.CROSSOVER_RATE > Math.random()) {
                Schedule schedule1 = selectTornamentPopulation(population).sortByFitness().getSchedules().get(0);
                Schedule schedule2 = selectTornamentPopulation(population).sortByFitness().getSchedules().get(0);
                crossoverPopulation.getSchedules().set(x,crossoverSchedule(schedule1,schedule2));
            }
            else  crossoverPopulation.getSchedules().set(x, population.getSchedules().get(x));
        });
        return crossoverPopulation;
    }
    
    //this performs crossover population to check if the schedule can be switched (like schedule1 will be switched with schedule2)
     Schedule crossoverSchedule(Schedule schedule1,Schedule schedule2){
        Schedule crossoverSchedule = new Schedule(data).initialize();
        IntStream.range(0, crossoverSchedule.getClasses().size()).forEach(x ->{
            if (Math.random() > 0.5) crossoverSchedule.getClasses().set(x,schedule1.getClasses().get(x));
            else crossoverSchedule.getClasses().set(x, schedule2.getClasses().get(x));
        });
        return crossoverSchedule;
    }
    
    //This mutates the population by mutating the population by changing the schedules inside it(a more general mutate schedule)
    Population mutatePopulation(Population population){
        Population mutatePopulation = new Population(population.getSchedules().size(),data);
        ArrayList<Schedule> schedules =mutatePopulation.getSchedules();
        IntStream.range(0, Driver.NUM_OF_ELITE_SCHEDULES).forEach(x -> schedules.set(x,population.getSchedules().get(x)));
        IntStream.range(Driver.NUM_OF_ELITE_SCHEDULES, population.getSchedules().size()).forEach(x ->{
            schedules.set(x, mutateSchedule(population.getSchedules().get(x)));
        });
        return mutatePopulation;
    }
    
    //This mutates the schedule to have some random variable to be changed out for new ones (i.e. its changing the time of the meeting from MT1 to MT2)
    Schedule mutateSchedule(Schedule mutateSchedule){
        Schedule schedule = new Schedule(data).initialize();
         IntStream.range(0, mutateSchedule.getClasses().size()).forEach(x ->{
             if(Driver.MUTATION_RATE > Math.random()) mutateSchedule.getClasses().set(x,schedule.getClasses().get(x));
         });
        return mutateSchedule;
    }
    
    //Based on the number of factors it selects which one is the best
    Population selectTornamentPopulation(Population population){
        Population tournamentPopulation = new Population(Driver.TOURNAMENT_SELECTION_SIZE,data);
        IntStream.range(0, Driver.TOURNAMENT_SELECTION_SIZE).forEach( x-> {
            tournamentPopulation.getSchedules().set(x, population.getSchedules().get((int)(Math.random() * population.getSchedules().size())));
        });
        return tournamentPopulation;
    }
}
