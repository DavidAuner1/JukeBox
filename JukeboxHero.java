import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;



public class JukeboxHero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 boolean play = true;
		Scanner scan = new Scanner(System.in);
		
		
		//UI
		System.out.println("Welcome to Jukebox Hero,");
		System.out.println("    bringing order to playlists one song at a time");
		System.out.println("");
		System.out.println("*********************************");
		System.out.println("*          Program Menu         *");
		System.out.println("*****************************");
		System.out.println("(L)oad catalog");
		System.out.println("(S)earch catalog");
		System.out.println("(A)nalyse catalog");
		System.out.println("(P)rint catalog");
		System.out.println("(Q)uit");
		System.out.println("");
	//part 2
		//array List
		ArrayList<Song> songList = new ArrayList <Song>();
		ArrayList<Song> searchList = new ArrayList <Song>();
		ArrayList<String> artistList = new ArrayList <String>();
		ArrayList<String> albumList = new ArrayList <String>();
		
		String fileName = "music-collection.csv";
		File file = new File(fileName);
		if(file.exists() && file.canRead()) {
			
			try {
				Scanner fileScan = new Scanner(file);
				
				while(fileScan.hasNext()) {
					String line = fileScan.nextLine();
					Scanner fileScanLine = new Scanner(line);
					fileScanLine.useDelimiter(",");
					//variables
					String artist = fileScanLine.next();
					String album = fileScanLine.next();
					String title = fileScanLine.next();
					int playTime = fileScanLine.nextInt();
					//ads to list
					Song song = new Song(title,artist,album,playTime);
					songList.add(song);
					fileScanLine.close();
				}
				System.out.println("successfully loaded " + songList.size() + " songs!");
				fileScan.close();
				
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		
		while(play == true) {
			System.out.println("Please enter a command (press 'm' for Menu):");
			String command = scan.nextLine().toLowerCase();
		switch(command) {
		
		//prints menu
		case "m":
			System.out.println("Welcome to Jukebox Hero,");
			System.out.println("    bringing order to playlists one song at a time");
			System.out.println("");
			System.out.println("*********************************");
			System.out.println("*          Program Menu         *");
			System.out.println("*****************************");
			System.out.println("(L)oad catalog");
			System.out.println("(S)earch catalog");
			System.out.println("(A)nalyse catalog");
			System.out.println("(P)rint catalog");
			System.out.println("(Q)uit");
			System.out.println("");
			
			
			break;
			
			//quit menu
		case "q":
			System.out.println("Thank you, goodbye");
			play = false;
			
			break;
			//load catalog
		case "l": 
			System.out.println("Please enter filename:");
			
			 fileName = scan.nextLine().toLowerCase();
		//	 fileName = "music-collection.csv";
			 file = new File(fileName);
			if(file.exists() && file.canRead()) {
				
				try {
					Scanner fileScan = new Scanner(file);
					
					while(fileScan.hasNext()) {
						String line = fileScan.nextLine();
						Scanner fileScanLine = new Scanner(line);
						fileScanLine.useDelimiter(",");
						//variables
						String artist = fileScanLine.next();
						String album = fileScanLine.next();
						String title = fileScanLine.next();
						int playTime = fileScanLine.nextInt();
						//ads to list
						Song song = new Song(title,artist,album,playTime);
						songList.add(song);
						fileScanLine.close();
					}
					System.out.println("successfully loaded" + songList.size() + "songs!");
					fileScan.close();
					break;
					
				}
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
						
			}
			else {
				System.out.println("Unable to open file:" + fileName);
			}
			break;
		//print list
		case "p":
			for(Song n : songList) {
				System.out.println(n.toString());
			}
			break;
			
		//search 
		case "s":
			//searchResults.clear();
			System.out.println("Search Catalog ...");
			System.out.println("Please enter the search query:");
			
			String search = scan.nextLine().toLowerCase();
			int count =0;
			for(Song s: songList) {
				if(s.getTitle().toLowerCase().contains(search)) {
					searchList.add(s);
					count++;
				}
				
			}
			System.out.println("Found " + count + "matches");
			System.out.println("--------------------------");
			
			for(Song s: searchList) {
				System.out.println(s);
			}
		
			break;
	
		//analyse catlog
			
		case "a":
			int artistCount = 0;
			int albumCount = 0;
			int playTime = 0;
			System.out.println("Catalog Analysis...");
		
			for(Song s: songList) {
				if(!artistList.contains(s.getArtist())) {
					artistList.add(s.getArtist());
					artistCount++;
				}
				
				if(!albumList.contains(s.getAlbum())) {
					albumList.add(s.getAlbum());
					albumCount++;
					
				}
			playTime += s.getPlayTime();
			}
			System.out.println("Number of Artist: " + artistCount);
			System.out.println("Number of Albums: " + albumCount);
			System.out.println("Number of Songs: " + songList.size());
			System.out.println("Catalog playtime: " + playTime);
			
			break;
		//default
		default:
			System.out.println("Invalid Selection");
			System.out.println("Please enter a command (press 'm' for menu)");
			command = scan.nextLine().toLowerCase();
			
		
			}	
			
		}
		scan.close();
		
		
		
		
		
		
		
		
		
		
		
	}

}
