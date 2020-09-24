package homework1;
public class DiningHall{
	class Dining{
	boolean DiningHall,Library = true; 
 print("You arrive at the dining hall of hogwarts. You had heard it was the largest enclosed area in the school yet the sheer scale of it still surprises you,");
 print("it is marked by a rustic victorian design with gilded chandeliers and excessively large dining tables interspersed throughout the well lit halls");
while(DiningHall)
{
	getInput();
	if(input.contains("look"))
	{
		print("Scanning the surroundings of the large hall you see professor Dumbledore standing towards its northern corner");
		print("He seems to be welcoming new students to the school. Arrayed on the dining tables is a large variety of strange dishes.");
		print("On a heavily embroidered wooden chair to your left you see the sorting hat assigning new students to one of the school's four houses");
	}
	if(input.contains("use sorting hat"))
	{
		int x = Rand.nextInt();
		
				if(x%1==0){
					print("Gryffindor");
				}
				else if (x%2==0){
					print("Hufflepuff");
					
				}
				else if (x%3==0){
					print("Ravenclaw");
				}
				else {
					print("Slytherin");
					}
	}
	if((input.contains("hold food"))||(input.contains("grab food")))
	{
		print("you grab a morself of food from one of the strange dishes and attempt to eat it");
	}
	if(input.contains("talk to Dumbledore"))
	{
		print("Welcome to the dining hall! Interact with the sorting hat to be sorted into a house, then enjoy the food served in the hall");
	}
	if(input.contains("south"))
	{
		DiningHall = false; Entrance = true;
	}
}
	}

