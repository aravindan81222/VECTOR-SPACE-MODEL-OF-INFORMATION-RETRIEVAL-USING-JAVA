import java.util.*; 
import java.lang.*; 
import java.io.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
import java.nio.file.Files; 
import java.nio.file.Paths;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * This class implements the Vector-Space model.
 * It takes a corpus and creates the tf-idf vectors for each document.
 * @author swapneel
 *
 */
public class File2 
{
	
	/**
	 * The corpus of documents.
	 */
	private File3 corpus;
	
	/**
	 * The tf-idf weight vectors.
	 * The hashmap maps a document to another hashmap.
	 * The second hashmap maps a term to its tf-idf weight for this document.
	 */
	private HashMap<File4, HashMap<String, Double>> tfIdfWeights;
	
	/**
	 * The constructor.
	 * It will take a corpus of documents.
	 * Using the corpus, it will generate tf-idf vectors for each document.
	 * @param corpus the corpus of documents
	 */
	public File2(File3 corpus) {
		this.corpus = corpus;
		tfIdfWeights = new HashMap<File4, HashMap<String, Double>>();
		
		createTfIdfWeights();
	}

	/**
	 * This creates the tf-idf vectors.
	 */
	private void createTfIdfWeights() 
	{
		Set<String> terms = corpus.getInvertedIndex().keySet();
		
		for (File4 document : corpus.getDocuments()) {
			HashMap<String, Double> weights = new HashMap<String, Double>();
			
			for (String term : terms) 
			{
				double tf = document.getTermFrequency(term);
				double idf = corpus.getInverseDocumentFrequency(term);
				
				double weight = tf * idf;
				
				weights.put(term, weight);
			}
			tfIdfWeights.put(document, weights);
		}
	}
	
	
	/**
	 * This method will return the magnitude of a vector.
	 * @param document the document whose magnitude is calculated.
	 * @return the magnitude
	 */
	private double getMagnitude(File4 document) {
		double magnitude = 0;
		HashMap<String, Double> weights = tfIdfWeights.get(document);
		
		for (double weight : weights.values()) {
			magnitude += weight * weight;
		}
		
		return Math.sqrt(magnitude);
	}
	
	/**
	 * This will take two documents and return the dot product.
	 * @param d1 Document 1
	 * @param d2 Document 2
	 * @return the dot product of the documents
	 */
	private double getDotProduct(File4 d1, File4 d2) { //tfidf
		double product = 0;
		HashMap<String, Double> weights1 = tfIdfWeights.get(d1);
		HashMap<String, Double> weights2 = tfIdfWeights.get(d2);
		
		for (String term : weights1.keySet()) {
			product += weights1.get(term) * weights2.get(term);
		}
		
		return product;
	}
	
	/**
	 * This will return the cosine similarity of two documents.
	 * This will range from 0 (not similar) to 1 (very similar).
	 * @param d1 Document 1
	 * @param d2 Document 2
	 * @return the cosine similarity
	 */
	public double cosineSimilarity(File4 d1, File4 d2) {
		return getDotProduct(d1, d2) / (getMagnitude(d1) * getMagnitude(d2));
	}
	
	
}