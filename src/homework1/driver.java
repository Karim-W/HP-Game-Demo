package homework1;
import java.util.Random;
import java.util.Scanner;
class Object {
	String Name; 
}

class Character{
	String name;
	String msg;
	public Character(String n,String m) {
		this.name = n;
		this.msg = m;
	}
	public void talk() {
		System.out.println(this.msg);
	}
}

class Scene{
	String Description;
	Character charachter;//since it's just one character
	Object[] Objects;
	public Scene(String d,Character c) {
		this.Description = d;
		this.charachter = c;
	}
}


public class driver {
	static String[] Houses = {"Gryffindor", "Hufflepuff", "Ravenclaw","Slytherin"}; 
	static Random rand =new Random();
	static Scanner in = new Scanner(System.in);
	private static Scene[] rooms;
	//FUNCTIONS:
	public static void print(String i) {
		System.out.println(i);
	}
	public static String getInput() {
		System.out.print(">");//to get input in the same line
		String input;
		input = in.nextLine();
		return input.toLowerCase();
	}
	public static String sortHat() {
		rand.setSeed(System.currentTimeMillis());
		return Houses[rand.nextInt(4-0)];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		String[] bookText = {"A Wizard's Guide to Spells\nAccio\nThis charm summons an object to the caster, potentially over a significant distance. Its opposite is the "
				+ "Banishing Charm\nAge Line\nCreates a thin, shimmering line that can only be passed by people of a set age. Aging potions are useless\n" + 
				"against age lines. Incantation unknown.\nAguamenti\nProduces a jet of water from the caster’s wand.",""};
		Integer roomNo =-1;
		String house=":P";
		boolean keepPlaying=false;
		Character ddore = new Character("Dumbledore","Welcome to the dining hall! Interact with the sorting hat to be sorted\r\n" + 
				"into a house, then enjoy the food served in the hall.\r\n");
		Character herm = new Character("Hermione","I'm so sorry but I'm just so busy I have to prepare for professor McGonagall's class you can sit there to read a book or write or use a quill to write");
		Scene entrance = new Scene("The Entrance\r\n" + 
				"You arrive at the doors of Hogwarts. The door on the north wall leads to\r\n" + 
				"the dining hall, the door to the east leads to the Potions class, and\r\n" + 
				"the door to the west leads to the Library.",null);
		Scene dHall = new Scene("The dining hall is the biggest open area inside Hogwarts. Professor Dumbledore is in the hall to welcome new students.",ddore);
		Scene Lib = new Scene("The Library\nWhere students spend a lot of their time reading and writing books, Hermione is there there preparing for professor McGonagall's class.",herm);
		rooms = new Scene[] {entrance,dHall};
		print("“Messrs Moony, Wormtail, Padfoot and Prongs Purveyors of Aids to\r\n" + 
				"magical Mischief-Makers are proud to present THE MARAUDER'S MAP”\r\n" + 
				"Say the magic phrase to reveal the map.\r\n" + 
				"");
		if (getInput().equals("i solemnly swear that i am up for no good"))
		{
			roomNo=0;
			keepPlaying = true;
		}
		while(keepPlaying) {
		switch(roomNo) {
		case 0://Entrance
			print(entrance.Description);
			input = getInput();
			if(input.contains("north")) {
				print("You have entered the dining hall.");
				roomNo=1;
			}
			if(input.contains("west")) {
				print("You have entered the Library.");
				roomNo=2;
			}
			
			break;
		case 1://Dining Hall
			boolean inDiningHall =true;
			while(inDiningHall) {
			input = getInput();
			if (input.contains("look")) {
				print(rooms[1].Description);
			}
			if(input.contains("talk")) {
				if(input.contains(rooms[1].charachter.name.toLowerCase())) {
					rooms[1].charachter.talk();
				}else {print("This character is not in the room...try again!");}
			}
			if(input.contains("use")) {
				if(input.contains("hat")) {
					if (house.equals(":P")) {
					house = sortHat();
					}else {System.out.print("you are already in a house, ");}
					print(house+"!");
				}else {
					print("This object is not in the room...try again!");
				}	
			}
			if(input.contains("north")||input.contains("west")||input.contains("east")) {
				print("can't go there the room is has one exit to the south");
			}if (input.contains("south")) {
				roomNo =1;
				inDiningHall = false;
			}
				
			}
			break;
		case 2://Library
			boolean inLib =true;
			while(inLib) {
			input = getInput();
			if (input.contains("look")) {
				print(rooms[roomNo].Description);
			}
			if(input.contains("talk")) {
				if(input.contains(rooms[roomNo].charachter.name.toLowerCase())) {
					rooms[roomNo].charachter.talk();
				}else {print("This character is not in the room...try again!");}
			}
			if(input)
			}
			break;
		case 3://classroom
			break;
			default:
		}
	}
		}

}
