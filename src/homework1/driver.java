package homework1;
import java.util.Random;
import java.util.Scanner;
class Object {
	String Name;
	String Description;
	
	public Object(String n, String d) {
		this.Name = n;
		this.Description = d;
	}
	
	public void use() {
		System.out.println(this.Description);
	}
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
	Object Objects[];
	public Scene(String d,Character c,Object o1,Object o2) {
		this.Description = d;
		this.charachter = c;
		Object[] temp = {o1,o2};
		this.Objects = temp;
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
		System.out.println();
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
		double stomach = 0.0;
		Integer potionsMade =0;
		String[] bookText = {"A Wizard's Guide to Spells\nAccio\nThis charm summons an object to the caster, potentially over a significant distance. Its opposite is the "
				+ "Banishing Charm\nAge Line\nCreates a thin, shimmering line that can only be passed by people of a set age. Aging potions are useless\n" + 
				"against age lines. Incantation unknown.\nAguamenti\nProduces a jet of water from the caster’s wand.",""};
		Integer roomNo =-1;
		String house=":P";
		Object hat = new Object("Sorting Hat",sortHat());
		Object foodTray = new Object("Food tray","i can use this to eat food, im hungry");//changed "food" to "foodtray" because use food sounds awkward
		Object book = new Object("Book","oh A Wizard's Guide to Spells, a great book to read!!");
		Object quill = new Object("Quill","i can use to write in my book");
		Object cauldron = new Object("Cauldron","i can make potions here");
		Object potion = new Object("Potion","i can test out potions i made");
		boolean keepPlaying=false;
		Character ddore = new Character("Dumbledore","Welcome to the dining hall! Interact with the sorting hat to be sorted\r\n" + 
				"into a house, then enjoy the food served in the hall.\r\n");
		Character herm = new Character("Hermione","I'm so sorry but I'm just so busy I have to prepare for professor McGonagall's class you can sit there to read a book or write or use a quill to write");
		Character snape = new Character("Professor Snape","make sure to test your Felix Felicis potions they might work and increase your luck making you better students");
		Scene entrance = new Scene("The Entrance\r\n" + 
				"You arrive at the doors of Hogwarts. The door on the north wall leads to\r\n" + 
				"the dining hall, the door to the east leads to the Potions class, and\r\n" + 
				"the door to the west leads to the Library.",null,null,null);
		Scene dHall = new Scene("The dining hall is the biggest open area inside Hogwarts. Professor Dumbledore is in the hall to welcome new students.",ddore,hat,foodTray);
		Scene Lib = new Scene("The Library\nWhere students spend a lot of their time reading and writing books, Hermione is there there preparing for professor McGonagall's class.",herm,book,quill);
		Scene classR = new Scene("Potions Classroom\nPotions is one of the core subjects that first year students are required to\r\n" + 
				"study. In the potions classthere is Professor Snape who teaches the subject. The Potions Classroom\r\n" + 
				"is full of equipment and material that the player can use including a cauldron to make potions, and\r\n" + 
				"a potion to drink that casts a magical spell.",snape,cauldron,potion);
		rooms = new Scene[] {entrance,dHall,Lib,classR};
		
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
			while(roomNo==0) {
			print(entrance.Description);
			input = getInput();
			if(input.contains("north")) {
				print("You have entered the dining hall.");
				roomNo=1;
				break;
			}
			if(input.contains("west")) {
				print("You have entered the Library.");
				roomNo=2;
				break;
			}
			if(input.contains("east")) {
				print("You have entered the potions class.");
				roomNo=3;
				break;
			}
			if(input.equals("mischief managed")) {
				print("Hiding map contents...end.");
				keepPlaying=false;
				break;
			}else {
				print("invalid input :/");
			}
			}
			
			break;
		case 1://Dining Hall
			while(roomNo==1) {
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
				}else if(input.contains("food tray")) {
					if(stomach == 1.0) {print("can't eat anymore i'm so full");}else {
						rooms[roomNo].Objects[1].use();
						stomach += 0.2;
						}
					}else {print("This object is not in the room...try again!");
				}	
			}
			
			if(input.contains("north")||input.contains("west")||input.contains("east")) {
				print("can't go there the room is has one exit to the south");
			}if (input.contains("south")) {
				roomNo =0;
			}
			if(input.equals("mischief managed")) {
				print("Hiding map contents...end.");
				keepPlaying=false;
				break;
			}else {
				print("invalid input :/");
			}
				
			}
			break;
		case 2://Library
			while(roomNo==2) {
			input = getInput();
			if (input.contains("look")) {
				print(rooms[roomNo].Description);
			}
			if(input.contains("talk")) {
				if(input.contains(rooms[roomNo].charachter.name.toLowerCase())) {
					rooms[roomNo].charachter.talk();
				}else {print("This character is not in the room...try again!");}
			}
			if(input.contains("use")) {
				if(input.contains("book")) {
					rooms[roomNo].Objects[0].use();
					String reading ="";
					Integer page=0;
					while (reading!="q") {
						print(bookText[page]);
						print("\n\n");
						print("press n to to next page\npress p for previous\npress q to quit");
						reading = getInput();
						switch(reading) {
						case "n":if((page+1)==bookText.length) {
							print("end of book, it seems someone stole the spells related to talking to other dimensional beings");
						}else {page++;}
							break;
						case "p":if(page==0) {
							print("this is the first page...");
						}else {page--;}
							break;
						case "q":
							break;
							default:print("invalid input :/");
						}
						
					}
				}else if(input.contains("quill")) {
					rooms[roomNo].Objects[1].use();
					String writtenBook = getInput();
					print("let me double check..,\n\n");
					print(writtenBook+"\n\n my best work yet.");
				}else {
					print("object does not exist");	
				}
			}
			if(input.contains("north")||input.contains("west")||input.contains("east")) {
				print("can't go there the room is has one exit to the south");
			}if (input.contains("south")) {
				roomNo =0;
			}
			if(input.equals("mischief managed")) {
				print("Hiding map contents...end.");
				keepPlaying=false;
				break;
			}else {
				print("invalid input :/");
			}
			}
			break;
		case 3://classroom
			getInput();
			while(roomNo==3) {
				input = getInput();
				if (input.contains("look")) {
					print(rooms[roomNo].Description);
				}
				if(input.contains("talk")) {
					if(input.contains(rooms[roomNo].charachter.name.toLowerCase())) {
						rooms[roomNo].charachter.talk();
					}else {print("This character is not in the room...try again!");}
				}
				if(input.contains("use")) {
					if(input.contains("cauldron")) {
						rooms[roomNo].Objects[0].use();
						potionsMade++;
					}else if(input.contains("potion")){
						if(potionsMade==0) {print("i need to make a potion first");}else {rooms[roomNo].Objects[1].use();potionsMade--;}
					}else {
						print("object does not exist");	
					}
				}
				if(input.contains("north")||input.contains("west")||input.contains("east")) {
					print("can't go there the room is has one exit to the south");
				}if (input.contains("south")) {
					roomNo =0;
				}
				if(input.equals("mischief managed")) {
					print("Hiding map contents...end.");
					keepPlaying=false;
					break;
				}else {
					print("invalid input :/");
				}
			}
			break;
			default:
		}
	}
		}

}
