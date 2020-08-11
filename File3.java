//package ir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class represents a corpus of documents.
 * It will create an inverted index for these documents.
 * @author swapneel
 *
 */
public class File3 {
	
	/**
	 * An arraylist of all documents in the corpus.
	 */
	private ArrayList<File4> documents;
	
	/**
	 * The inverted index. 
	 * It will map a term to a set of documents that contain that term.
	 */
	private HashMap<String, Set<File4>> invertedIndex;
	
	/**
	 * The constructor - it takes in an arraylist of documents.
	 * It will generate the inverted index based on the documents.
	 * @param documents the list of documents
	 */
	public File3(ArrayList<File4> documents) {
		this.documents = documents;
		invertedIndex = new HashMap<String, Set<File4>>();
		
		createInvertedIndex();
	}
	
	/**
	 * This method will create an inverted index.
	 */
	private void createInvertedIndex() {
		
		for (File4 document : documents) {
			Set<String> terms = document.getTermList();
			
			for (String term : terms) {
				if (invertedIndex.containsKey(term)) {
					Set<File4> list = invertedIndex.get(term);
					list.add(document);
				} else {
					Set<File4> list = new TreeSet<File4>();
					list.add(document);
					invertedIndex.put(term, list);
				}
			}
		}
	}
	
	/**
	 * This method returns the idf for a given term.
	 * @param term a term in a document
	 * @return the idf for the term
	 */
	public double getInverseDocumentFrequency(String term) {
		if (invertedIndex.containsKey(term)) {
			double size = documents.size();
			Set<File4> list = invertedIndex.get(term);
			double documentFrequency = list.size();
			
			return Math.log10(size / documentFrequency);
		} else {
			return 0;
		}
	}

	/**
	 * @return the documents
	 */
	public ArrayList<File4> getDocuments() {
		return documents;
	}

	/**
	 * @return the invertedIndex
	 */
	public HashMap<String, Set<File4>> getInvertedIndex() {
		return invertedIndex;
	}
}