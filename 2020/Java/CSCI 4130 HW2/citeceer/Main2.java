/*
 * Casey Pollock
 * CSCI 4130
 * 3/5/2020
 * 
 * This program is used to tokenize a file of documents and print and find the 
 * similarity these documents share with given queries.  The top 10 documents 
 * will have their names and similarities printed to the screen for each query. 
 */

package citeceer;

import java.io.*;
import java.util.*;
import ir.utilities.Porter;

public class Main2 {

	/*
	 * FillList will fill a Document with StopWords that are from a specific text 
	 * document.  This fill list is used to take a document of words, that will 
	 * be removed later, and save the words for later use.
	 */
	public static void fillList(List<StopWords> stopWords, String fileLoc) {
		
		try {
			
			String stp;
			StopWords stopword;
			char frtltr;
			boolean added;
			Iterator<StopWords> iter;
			Scanner inFile = new Scanner(new File(fileLoc));
			while(inFile.hasNext()) {
			
				added = false;
				stp = inFile.next();
				stp = stp.toLowerCase();
				frtltr = stp.charAt(0);
				if(stopWords.isEmpty()) {
					
					stopWords.add(new StopWords(frtltr));
					stopWords.get(0).add(stp);
					
					
				}
				else {
					
					iter = stopWords.iterator();
					while(iter.hasNext()) {
						
						stopword = iter.next();
						if(stopword.getFirst() == frtltr) {
							
							if (!stopword.equals(stp)) {
							
								stopword.add(stp);
								added = true;
							
							}

						}
						
					}
					if(!added) {
						
						stopWords.add(new StopWords(frtltr));
						stopWords.get((stopWords.size()-1)).add(stp);
						
					}
					
				}
			
			}
			inFile.close();
		
		}
		catch(FileNotFoundException e) {
			
			System.out.println("Error: File not found.");
			
		}
		
	}
	
	/*
	 * PuncTest checks if a character is some punctuation symbol.
	 */
	public static boolean puncTest(char character) {
		
		return (character=='('||character=='+'||character=='<'||character=='='
				||character=='`'||character==')'||character=='.'||character=='!'
				||character==','||character=='?'||character==';'||character==':'
				||character=='\''||character=='['||character==']'||character=='\"'
				||character=='-'||character=='\\'||character=='/'||character=='{'
				||character=='}'||character=='*'||character=='@'||character=='#'
				||character=='>');
		
	}
	
	/*
	 * PuncRemove removes punctuation symbols from within a word.
	 */
	public static String puncRemove(String word) {
		
		int wordLength = word.length();
		String temp = ""; 
		char character;
		for(int count = 0; count < wordLength; count++) {
			
			character = word.charAt(count);
			if(!puncTest(character)) {
				
				temp = (temp+character);
				
			}
			
		}
		return temp;
		
	}
	
	/*
	 * StopCheck checks if a given word is a stop word.
	 */
	public static boolean stopCheck(String word, List<StopWords> stpwrds) {
		
		Iterator<StopWords> iter = stpwrds.iterator();
		StopWords stp;
		while(iter.hasNext()) {
			
			stp = iter.next();
			if(stp.equals(word)) {
				
				return true;
				
			}
			
		}
		return false;
		
	}
	
	/*
	 * Tokenize will take a document and store its words into a Document.  The words 
	 * will have there punctuation removed and converted to affixes. Any stop words 
	 * will be removed from the list of words. This tokenize is designed for a word 
	 * to word entry.
	 */
	public static void tokenize(File file, List<StopWords> stpwrds, Document doc) {
		
		try {
		
			Scanner inFile = new Scanner(file);
			String word;
			Porter port = new Porter();
			while(inFile.hasNext()) {
				
				word = inFile.next();
				word = puncRemove(word);
				word = word.toLowerCase();
				if(!stopCheck(word, stpwrds) && !word.equals("")) {
					
					word = port.stripAffixes(word);
					if(doc.contains(word)) {
						
						doc.getWord(word).newOccurrence();
						
					}
					else {
						
						doc.add(word);
						
					}
					
				}
				
				
			}
			inFile.close();
			
		}
		catch(FileNotFoundException e) {
			
			System.out.println("Error: File not found.");
			
		}
		
	}
	
	/*
	 * FillList will fill a Document with Tokens that are from a specific text document.
	 * This fill list is used to take a file of different documents that need to be saved.
	 */
	public static void fillList(List<Document> docs, String fileLoc, List<Token> allWords, List<StopWords>stpwrds) {
		
		Document document = null;
		String word;
		Iterator<Token> iter;
		Token toke;
		Comparator<Token> sort =new sortByOccurrence();
		File file;
		File[] textFiles = new File(fileLoc).listFiles();
		int numofiles = textFiles.length;
		for(int count = 0; count < numofiles; count++) {
			
			file = textFiles[count];
			docs.add(new Document(file.getName()));
			document = docs.get(count);
			tokenize(file, stpwrds, document);
			document.getWords().sort(sort);
			iter = document.iterator();
			while(iter.hasNext()) {
				
				
				toke = iter.next();
				word = toke.getWord();
				if(!allWords.contains(word)) {
					
					allWords.add(new Token(word));
					
				}
				else {
					
					allWords.get(allWords.indexOf(word)).newDoc();
					
				}
				
			}
			
		}
		
	}
	
	/*
	 * Tokenize will take a document and store its words into a Document.  The words 
	 * will have there punctuation removed and converted to affixes. Any stop words 
	 * will be removed from the list of words. This tokenize is designed for entire 
	 * lines of text to be taken in.
	 */
	public static void tokenize(Document doc, List<StopWords> stpwrds, String[] query) {
		
		String word;
		int numowords = query.length;
		Porter port = new Porter();
		for(int count = 0; count < numowords; count++) {
	
			word = query[count];
			word = puncRemove(word);
			word = word.toLowerCase();
			if(!stopCheck(word, stpwrds) && !word.equals("")) {
			
				word = port.stripAffixes(word);
				if(doc.contains(word)) {
				
					doc.getWord(word).newOccurrence();
				
				}
				else {
				
					doc.add(word);
				
				}
			
			}
			
		}
		
	}
	
	/*
	 * FillList will fill a Document with Tokens that are from a specific text 
	 * document.  This fill list is used to take a text document with multiple 
	 * lines of text and convert each line into a separate document.
	 */
	public static void fillList(List<Document> query, String file, List<StopWords> stpwrds) {
		
		try {
			
			Scanner inFile = new Scanner(new File(file));
			Comparator<Token> sort =new sortByOccurrence();
			String question;
			int queryCount = 0;
			String[] words;
			while(inFile.hasNextLine()) {
				
				question = inFile.nextLine();
				words = question.split(" ");
				query.add(new Document("query "+queryCount));
				tokenize(query.get(queryCount), stpwrds, words);
				query.get(queryCount).getWords().sort(sort);
				queryCount++;
				
			}
			inFile.close();
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Error: File not found.");
			
		}
		
	}
	
	/*
	 * TermFreq will calculate the frequency of a term in a Document.	
	 */
	public static double termFreq(int max, String word, Document doc) {
		
		if(doc.contains(word)) {
			
			return (double) (doc.getWord(word).getOccurrence())/(double) (max);
			
		}
		return 0;
	}
	
	/*
	 * InverTermFreq will calculate the inverse term frequency of a term from a 
	 * group of Documents.
	 */
	public static double inverTermFreq(int num, List<Token> all, String word) {
		
		Iterator<Token> iter = all.iterator();
		Token toke;
		while(iter.hasNext()) {
			
			toke = iter.next();
			if(toke.equals(word)) {
			
				int use = toke.getOccurrence();
				return Math.log10(num/use)/Math.log10(2);
			
			}
			
		}
		return 0;
		
	}
	
	/*
	 * TopGen will return the dot product of a document when given the weights 
	 * of the terms that are being compared.
	 */
	public static double topGen(double[] docWeight, double[] queryWeight, int hold) {
		
		if(hold < docWeight.length) {
			
			double doc = docWeight[hold];
			double query = queryWeight[hold];	
			return (doc * query) + topGen(docWeight, queryWeight, hold+1);
			
		}
		else {
			
			return 0;
			
		}
		
		
	}
	
	/*
	 * BottomGen will return the bottom half of the equation used in producing a 
	 * Document's cosine similarity with another Document.
	 */
	public static double bottomGen(double[] docWeight, double[] queryWeight) {
		
		int docSize = docWeight.length;
		int querySize = queryWeight.length;
		double bhalf1 = 0, bhalf2 = 0;
		for(int count = 0; count < docSize && count < querySize; count++) {
			
			bhalf1 = docWeight[count] + bhalf1;
			bhalf2 = queryWeight[count] + bhalf2;
			
		}
		return Math.sqrt(bhalf1 * bhalf2);
		
	}
	
	/*
	 * CalcCosSim will calculate and return the cosine similarity of a Document.
	 */
	public static double calcCosSim(double[] docWeight, double[] queryWeight) {
		
		double top = topGen(docWeight, queryWeight, 0);
		double bottom = bottomGen(docWeight, queryWeight);
		if(top == 0 && bottom == 0) {
			
			return 0;
			
		}
		return top / bottom;
		
	}
	
	/*
	 * InsertTop10 will check if a Document is in the top 10 and insert it in its 
	 * position if it is and remove any additional Documents.
	 */
	public static void insertTop10(List<Document> top10, Document doc) {
		
		Iterator<Document> top10Iter = top10.iterator();
		double testSim = doc.getSim();
		double sim;
		int index = 0;
		if(top10.isEmpty()) {
			
			top10.add(doc);
			
		}
		else {
			
			while(top10Iter.hasNext()) {
				
				sim = top10Iter.next().getSim();
				if(sim < testSim) {
					
					top10.add(index, doc);
					break;
					
				}
				index++;
				
			}
			if(top10.size() > 10) {
				
				top10.remove(10);
				
			}
			
		}
		
	}
	
	/*
	 * Top10List will generate a top 10 list of the Documents with the highest 
	 * similarity and print them to the screen.
	 */
	public static void top10List(List<Document> docs, int queryNum) {
		
		Iterator<Document> docIter = docs.iterator();
		Document doc;
		List<Document> top10 = new ArrayList<Document>();
		while(docIter.hasNext()) {
			
			doc = docIter.next();
			insertTop10(top10, doc);
						
		}
		docIter = top10.iterator();
		System.out.println("Query " + queryNum);
		while(docIter.hasNext()) {
			
			doc = docIter.next();
			System.out.printf("\t" + doc.getName() + " Simularty %.2f\n", doc.getSim());
			
		}
		
	}
	
	/*
	 * resetDocs will chance the similarity of all Documents back to 0 for 
	 * another similarity check to be performed.
	 */
	public static void resetDocs(List<Document> docs) {
		
		Iterator<Document> docsIter = docs.iterator();
		while(docsIter.hasNext()) {
			
			docsIter.next().clearSim();
			
		}
		
	}
	
	/*
	 * CalculateSim will calculate the similarity of all Documents to a to a 
	 * list of queries.  It will then print to the screen the top 10 Documents 
	 * that match each query.
	 */
	public static void calculateSim(List<Document> docs, List<Token> allwords, List<Document> queryList) {
		
		int numodocs = docs.size();
		int queryLength;
		int queryCount = 1;
		int currentWord;
		int maxTerm;
		Document doc;
		Document queryDoc;
		List<Token> query;
		Iterator<Token> queryIter;
		Iterator<Document> docIter;
		Iterator<Document> queryDocsIter = queryList.iterator();
		String word;
		double[] docWeight;
		double[] queryWeight;
		double termFreq;
		while (queryDocsIter.hasNext()) {
			
			docIter = docs.iterator();
			queryDoc = queryDocsIter.next();
			query = queryDoc.getWords();
			queryLength = query.size();
			docWeight = new double[queryLength];
			queryWeight = new double[queryLength];
			while(docIter.hasNext()) {
				
				doc = docIter.next();
				queryIter = query.iterator();
				maxTerm = doc.getWords().get(0).getOccurrence();
				currentWord = 0;
				while(queryIter.hasNext()) {
					
					word = queryIter.next().getWord();
					termFreq =termFreq(maxTerm, word, doc);
					if(termFreq <= 0) {
						
						docWeight[currentWord] = 0;
						
					}
					else { 
						
						queryWeight[currentWord] = termFreq(query.get(0).getOccurrence(), word, queryDoc)
												   * inverTermFreq(numodocs + 1, allwords, word);
						docWeight[currentWord] =  termFreq * inverTermFreq(numodocs + 1, allwords, word);
					
					}
					currentWord++;
					
				}
				doc.setSim(calcCosSim(docWeight, queryWeight));
				
				
			}
			top10List(docs, queryCount++);
			resetDocs(docs);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		String docFiles;
		System.out.println("Please enter the location of the folder containg the documents.");
		docFiles = kbd.nextLine();
		System.out.println("Please enter the location of the stop word document.");
		String stopFile = kbd.nextLine();
		System.out.println("Please enter the location of the query document.");
		String queryFile = kbd.nextLine();
		System.out.println("Compiling Data.");
		List<Token> allWords = new ArrayList<Token>();
		List<Document> docs = new LinkedList<Document>();
		List<StopWords> stopWords = new LinkedList<StopWords>();
		List<Document> query = new ArrayList<Document>();
		fillList(stopWords, stopFile);
		fillList(docs, docFiles, allWords, stopWords);
		fillList(query, queryFile, stopWords);
		System.out.println("Calculating Simularity");
		calculateSim(docs, allWords, query);
		

	}

}
