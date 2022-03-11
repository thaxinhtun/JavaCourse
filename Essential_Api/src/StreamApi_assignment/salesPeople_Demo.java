package StreamApi_assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class salesPeople_Demo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				List<Salespeople> saleslist = Arrays.asList(
						new Salespeople("Peel", "London", 0.12),
						new Salespeople("Serres", "San Jose", 0.13),
						new Salespeople("Motika", "London", 0.11),
						new Salespeople("Rifkin", "Barcelona", 0.15),
						new Salespeople("Axelord", "New York", 0.10)
						);
					//no1
					saleslist.stream()
						.filter(s -> s.getCity().equals("London") && s.getComm() > .10)
						.forEach(s->System.out.println(s.getName() + "\t" +s.getCity()));
					
					//no2	
					List<Salespeople> n2 = saleslist.stream()
								.filter(s-> (s.getComm() != 0.10 ) && (s.getComm() != 0.13) && (s.getComm()!=0.15))
								.collect(Collectors.toList());
					System.out.println("\n"+n2);
					
					//no3
					List<String> n3 = saleslist.stream()
									.map(s->s.getCity())
									.distinct()
									.collect(Collectors.toList());
					System.out.println("\nDiffersent cities: "+n3);
					
					//no4
					List<String> n4 = saleslist.stream()
							.map(s->s.getName())
							.collect(Collectors.toList());
					System.out.println("\ntop 3 salespeople: ");
					System.out.println(n4.subList(0, 3));
		
					//no5
					List<Salespeople> n5 = saleslist.stream()
										.filter(s->s.getCity().equals("Rome"))
										.collect(Collectors.toList());
					System.out.println("\nSalespeople who live in Rome: " + n5);
					
					//no6
					List<Salespeople> n6 = saleslist.stream()
										.filter(s->s.getCity().equals("London"))
										.collect(Collectors.toList());
					System.out.println("\nno of salespeople who live in London: "+ n6.size());
					
					//no7
					System.out.println("\nSalespeople descending order of commission");
					 saleslist.stream()
							.sorted(Comparator.comparingDouble(Salespeople::getComm).reversed())
							.forEach(System.out::println);
					
					
	} 
}

	
	