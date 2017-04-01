
import java.util.Scanner;
public class NCDriver {
	
	public static void main(String[] args){
		boolean open;
		int recrawl = 0;
		Scanner input = new Scanner(System.in);
		Centipede c = new Centipede();
		Ant.getURLS(input, c);
		Ant.getKeyword(input, c);
		while(recrawl < c.numPages){
			open = Ant.crawl(c.nextPage(), c);
			if(open){
				System.out.print("We have found the word "+ c.keyword + " within "+  c.urlArray[recrawl]);
			}
			recrawl++;
			open = false;
		}
	}

}
