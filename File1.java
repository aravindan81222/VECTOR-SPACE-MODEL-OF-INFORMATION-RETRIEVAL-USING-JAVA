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
public class File1 
{
	public static void main(String[] args) 
	{
		Random random = new Random();
		System.out.println("1)Please give the path of the cranfield_collection\nExample:\nC:\\Program Files\\Java\\jdk1.8.0_181\\bin\\cranfield_collection.txt\n");
		System.out.println("Now please type the path:");
		Scanner in = new Scanner(System.in); 
		String data = ""; //having the whole file in string
		List<String> sw=new ArrayList<String>();//having the data in arraylist
		try
		{
		String collect=in.nextLine(); 		
		data = new String (Files.readAllBytes(Paths.get(collect)));
		System.out.println("Successfully received the cranfield_collection");
		System.out.println("\n2)Please give the path of the stopwords\nExample:\nC:\\Program Files\\Java\\jdk1.8.0_181\\bin\\stopwords.txt\n");
		System.out.println("Now please type the path:");
		Scanner in1 = new Scanner(System.in); 
		String stopwords=in1.nextLine();
		BufferedReader reader=new BufferedReader(new FileReader(stopwords)); //arraylist buffered reader
		System.out.println("Successfully received the stopwords file");
		System.out.println("\n3)Please give the path folder to store the output\nExample:\nC:\\Program Files\\Java\\jdk1.8.0_181\\bin");
		System.out.println("Now please type the path:");
		String output=in.nextLine();
		String line; 
		System.out.println("Please wait, TF and IDF calculation is processing");
		System.out.println("It takes approximately 3mins");
		long startTime = System.currentTimeMillis();
		while((line=reader.readLine())!=null)
		{
			sw.add(line); //adding whole file to array list
		}
		String[] finaldoc=data.split(".I"); //using the single string creating a array and tokenizing the data
		//stopwords
		for(int j=0;j<finaldoc.length;j++) //stopword removal
		{
		for(int i=0;i<sw.size();i++)
		{
			finaldoc[j]=finaldoc[j].replaceAll("\\b"+sw.get(i)+"\\b"," ").trim();;
			finaldoc[j]=finaldoc[j].replaceAll("\\p{Punct}",""); 
		}
		}
		String s7="(?s).W\\s(.*)";  //fetching the exact documents
		Pattern p7=Pattern.compile(s7); //important words
		for(int k=0;k<finaldoc.length;k++)
		{
		Matcher m=p7.matcher(finaldoc[k]);
		if(m.find())
		{
			finaldoc[k]=m.group(1);
		}
		else{}
		}
		//Stemming
		Stemmer s=new Stemmer();
		for(int j=0;j<finaldoc.length;j++)
		{
			String hello7="";
		char[] ab;
		String[] words=finaldoc[j].split(" ",1000);
		for(String word:words)
		{
			ab=word.toCharArray();
			for(int k=0;k<ab.length;k++)
			{
				s.add(ab[k]);
			}
			s.stem();
			{
				String u;
				u=s.toString();
				u = new String(s.getResultBuffer(), 0, s.getResultLength()); 
				hello7=hello7.concat(u+" ");
			}
		}
		finaldoc[j]=hello7;
		}
		//tfidf
		List<List<String>> documents7 = new ArrayList<List<String>>();
		for(int i=0;i<finaldoc.length;i++)
		{
		List<String> s77=new ArrayList<String>();
		String[] arr=finaldoc[i].split(" ");
		for(String q:arr)
		{
			s77.add(q);
		}
		s77.removeIf(sz -> sz.equals(""));
		documents7.add(s77);
		}
		//tfidf
		BufferedWriter writer7777 = new BufferedWriter(new FileWriter(output+"\\tfidf.txt"));
		File1 calculator = new File1();
        for(int g=0;g<finaldoc.length;g++)
		{
			if(g==0)
			{
			}
			else
			{
			writer7777.write("DOCUMENT:"+g);
			writer7777.newLine();
		List<String> s88=new ArrayList<String>();
		String[] aww=finaldoc[g].split(" ");
		for(String x:aww)
		{
			s88.add(x);
		}
		for(int j=0;j<s88.size();j++)
		{
			s88.removeIf(sx -> sx.equals(""));
			double tfidf=calculator.tfIdf(s88,documents7,s88.get(j));
			writer7777.write("TF-IDF "+s88.get(j)+" = "+tfidf);
			writer7777.newLine();
		}
		}
		}
		long endTime = System.currentTimeMillis(); 
    	long runningTime = endTime - startTime; //calculating the runtime
		System.out.println("Running Time = " + runningTime/1000.0+ " secs");
		System.out.println("\nTFIDF are located in tfidf.txt file\n");
		
		
		
		//cosine similarity
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Your option:\n1.Finding cosine similarity\n2.Exit");
		int choice = sc.nextInt();
			if(choice==1)
			{
				BufferedWriter writer211 = new BufferedWriter(new FileWriter(output+"\\sample.txt"));
				System.out.println("Please paste the query:");
				Scanner object7 = new Scanner(System.in);
				String input = object7.nextLine();
				for(int j=0;j<sw.size();j++)
				{
					input=input.replaceAll("\\b"+sw.get(j)+"\\b"," ").trim();;
					input=input.replaceAll("\\p{Punct}","");
				}
				String h="";
				char[] z;
				String[] t=input.split(" ",1000);
				for(String qq:t)
				{
					z=qq.toCharArray();
					for(int k=0;k<z.length;k++)
					{
						s.add(z[k]);
					}
					s.stem();
					{
						String y;
						y=s.toString();
						y = new String(s.getResultBuffer(), 0, s.getResultLength());
						h=h.concat(y+" ");
					}
				}
				input=h;
				writer211.write(input);
				writer211.close();
				System.out.println("Please wait:");
				System.out.println("It takes approximately 30 seconds:");
				ArrayList<Sort7> ar = new ArrayList<Sort7>(); 
				String ds_2012="ds_2012";
				File4 query = new File4(output+"\\sample.txt");
				ArrayList<File4> documents = new ArrayList<File4>();
				documents.add(query);
				for(int j=0;j<finaldoc.length;j++)
				{
				BufferedWriter writer = new BufferedWriter(new FileWriter(output+"\\sample1.txt"));
				writer.write(finaldoc[j]);
				writer.close();
				File4 d1 = new File4(output+"\\sample1.txt");
				documents.add(d1);
				}
				File3 corpus = new File3(documents);
				File2 vectorSpace = new File2(corpus);
				for(int i = 1; i < documents.size(); i++) 
				{
				File4 doc = documents.get(i);
				//System.out.println("\nComparing to " + doc);
				ar.add(new Sort7(i-1,vectorSpace.cosineSimilarity(query, doc)));
				}
				String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				String pass = "";
				for (int i = 0; i < 3; i++) 
				{
				pass += alphabet.charAt(random.nextInt(alphabet.length()));
				}
				BufferedWriter writer7 = new BufferedWriter(new FileWriter(output+"\\"+pass+".txt"));
				System.out.println("\nYour output is in the filename:\n"+pass+"\n");
				Collections.sort(ar,new Sortbyvv());
				//Collections.reverse(ww);		
				for(int i=0;i<101;i++)
				{
				if(i!=0)
				{
				String lem = (ar.get(i)).toString();
				writer7.write(i+" "+lem);
				writer7.newLine();
				}
				}
				writer7.close();
			}
		else if(choice==2)
		{
			break;
		}
		else
		{
			break;
		}
		
		}
		
		//writer7777.close();
		reader.close();
		}
		catch(Exception e)
		{
		}
	}
	public double tf(List<String> doc, String term) {
        double result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word))
                result++;
        }
        return result / doc.size();
    }
    public double idf(List<List<String>> docs, String term) {
        double n = 0;
        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log((double)docs.size());
    }
    public double tfIdf(List<String> doc, List<List<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);

    }
}
class Sort7 
{ 
    int id; 
    Double vv; 
	public Sort7(int id,double vv) 
    { 
        this.id = id; 
        this.vv = vv;  
    } 
	public String toString() 
    { 
        return this.id + " " + this.vv; 
    } 
}
class Sortbyvv implements Comparator<Sort7> 
{ 
    public int compare(Sort7 a, Sort7 b) 
    { 
    double delta= a.vv - b.vv;
    if(delta > 0) return -1;
    if(delta < 0) return 1;
    return 0; 
    } 
}
class Stemmer
{  private char[] b;
   private int i,     /* offset into b */
               i_end, /* offset to end of stemmed word */
               j, k;
   private static final int INC = 50;
                     /* unit of size whereby b is increased */
   public Stemmer()
   {  b = new char[INC];
      i = 0;
      i_end = 0;
   }

   /**
    * Add a character to the word being stemmed.  When you are finished
    * adding characters, you can call stem(void) to stem the word.
    */

   public void add(char ch)
   {  if (i == b.length)
      {  char[] new_b = new char[i+INC];
         for (int c = 0; c < i; c++) new_b[c] = b[c];
         b = new_b;
      }
      b[i++] = ch;
   }


   /** Adds wLen characters to the word being stemmed contained in a portion
    * of a char[] array. This is like repeated calls of add(char ch), but
    * faster.
    */

   public void add(char[] w, int wLen)
   {  if (i+wLen >= b.length)
      {  char[] new_b = new char[i+wLen+INC];
         for (int c = 0; c < i; c++) new_b[c] = b[c];
         b = new_b;
      }
      for (int c = 0; c < wLen; c++) b[i++] = w[c];
   }

   /**
    * After a word has been stemmed, it can be retrieved by toString(),
    * or a reference to the internal buffer can be retrieved by getResultBuffer
    * and getResultLength (which is generally more efficient.)
    */
   public String toString() { return new String(b,0,i_end); }

   /**
    * Returns the length of the word resulting from the stemming process.
    */
   public int getResultLength() { return i_end; }

   /**
    * Returns a reference to a character buffer containing the results of
    * the stemming process.  You also need to consult getResultLength()
    * to determine the length of the result.
    */
   public char[] getResultBuffer() { return b; }

   /* cons(i) is true <=> b[i] is a consonant. */

   private final boolean cons(int i)
   {  switch (b[i])
      {  case 'a': case 'e': case 'i': case 'o': case 'u': return false;
         case 'y': return (i==0) ? true : !cons(i-1);
         default: return true;
      }
   }

   /* m() measures the number of consonant sequences between 0 and j. if c is
      a consonant sequence and v a vowel sequence, and <..> indicates arbitrary
      presence,

         <c><v>       gives 0
         <c>vc<v>     gives 1
         <c>vcvc<v>   gives 2
         <c>vcvcvc<v> gives 3
         ....
   */

   private final int m()
   {  int n = 0;
      int i = 0;
      while(true)
      {  if (i > j) return n;
         if (! cons(i)) break; i++;
      }
      i++;
      while(true)
      {  while(true)
         {  if (i > j) return n;
               if (cons(i)) break;
               i++;
         }
         i++;
         n++;
         while(true)
         {  if (i > j) return n;
            if (! cons(i)) break;
            i++;
         }
         i++;
       }
   }

   /* vowelinstem() is true <=> 0,...j contains a vowel */

   private final boolean vowelinstem()
   {  int i; for (i = 0; i <= j; i++) if (! cons(i)) return true;
      return false;
   }

   /* doublec(j) is true <=> j,(j-1) contain a double consonant. */

   private final boolean doublec(int j)
   {  if (j < 1) return false;
      if (b[j] != b[j-1]) return false;
      return cons(j);
   }

   /* cvc(i) is true <=> i-2,i-1,i has the form consonant - vowel - consonant
      and also if the second c is not w,x or y. this is used when trying to
      restore an e at the end of a short word. e.g.

         cav(e), lov(e), hop(e), crim(e), but
         snow, box, tray.

   */

   private final boolean cvc(int i)
   {  if (i < 2 || !cons(i) || cons(i-1) || !cons(i-2)) return false;
      {  int ch = b[i];
         if (ch == 'w' || ch == 'x' || ch == 'y') return false;
      }
      return true;
   }

   private final boolean ends(String s)
   {  int l = s.length();
      int o = k-l+1;
      if (o < 0) return false;
      for (int i = 0; i < l; i++) if (b[o+i] != s.charAt(i)) return false;
      j = k-l;
      return true;
   }

   /* setto(s) sets (j+1),...k to the characters in the string s, readjusting
      k. */

   private final void setto(String s)
   {  int l = s.length();
      int o = j+1;
      for (int i = 0; i < l; i++) b[o+i] = s.charAt(i);
      k = j+l;
   }

   /* r(s) is used further down. */

   private final void r(String s) { if (m() > 0) setto(s); }

   /* step1() gets rid of plurals and -ed or -ing. e.g.

          caresses  ->  caress
          ponies    ->  poni
          ties      ->  ti
          caress    ->  caress
          cats      ->  cat

          feed      ->  feed
          agreed    ->  agree
          disabled  ->  disable

          matting   ->  mat
          mating    ->  mate
          meeting   ->  meet
          milling   ->  mill
          messing   ->  mess

          meetings  ->  meet

   */

   private final void step1()
   {  if (b[k] == 's')
      {  if (ends("sses")) k -= 2; else
         if (ends("ies")) setto("i"); else
         if (b[k-1] != 's') k--;
      }
      if (ends("eed")) { if (m() > 0) k--; } else
      if ((ends("ed") || ends("ing")) && vowelinstem())
      {  k = j;
         if (ends("at")) setto("ate"); else
         if (ends("bl")) setto("ble"); else
         if (ends("iz")) setto("ize"); else
         if (doublec(k))
         {  k--;
            {  int ch = b[k];
               if (ch == 'l' || ch == 's' || ch == 'z') k++;
            }
         }
         else if (m() == 1 && cvc(k)) setto("e");
     }
   }

   /* step2() turns terminal y to i when there is another vowel in the stem. */

   private final void step2() { if (ends("y") && vowelinstem()) b[k] = 'i'; }

   /* step3() maps double suffices to single ones. so -ization ( = -ize plus
      -ation) maps to -ize etc. note that the string before the suffix must give
      m() > 0. */

   private final void step3() { if (k == 0) return; /* For Bug 1 */ switch (b[k-1])
   {
       case 'a': if (ends("ational")) { r("ate"); break; }
                 if (ends("tional")) { r("tion"); break; }
                 break;
       case 'c': if (ends("enci")) { r("ence"); break; }
                 if (ends("anci")) { r("ance"); break; }
                 break;
       case 'e': if (ends("izer")) { r("ize"); break; }
                 break;
       case 'l': if (ends("bli")) { r("ble"); break; }
                 if (ends("alli")) { r("al"); break; }
                 if (ends("entli")) { r("ent"); break; }
                 if (ends("eli")) { r("e"); break; }
                 if (ends("ousli")) { r("ous"); break; }
                 break;
       case 'o': if (ends("ization")) { r("ize"); break; }
                 if (ends("ation")) { r("ate"); break; }
                 if (ends("ator")) { r("ate"); break; }
                 break;
       case 's': if (ends("alism")) { r("al"); break; }
                 if (ends("iveness")) { r("ive"); break; }
                 if (ends("fulness")) { r("ful"); break; }
                 if (ends("ousness")) { r("ous"); break; }
                 break;
       case 't': if (ends("aliti")) { r("al"); break; }
                 if (ends("iviti")) { r("ive"); break; }
                 if (ends("biliti")) { r("ble"); break; }
                 break;
       case 'g': if (ends("logi")) { r("log"); break; }
   } }

   /* step4() deals with -ic-, -full, -ness etc. similar strategy to step3. */

   private final void step4() { switch (b[k])
   {
       case 'e': if (ends("icate")) { r("ic"); break; }
                 if (ends("ative")) { r(""); break; }
                 if (ends("alize")) { r("al"); break; }
                 break;
       case 'i': if (ends("iciti")) { r("ic"); break; }
                 break;
       case 'l': if (ends("ical")) { r("ic"); break; }
                 if (ends("ful")) { r(""); break; }
                 break;
       case 's': if (ends("ness")) { r(""); break; }
                 break;
   } }

   /* step5() takes off -ant, -ence etc., in context <c>vcvc<v>. */

   private final void step5()
   {   if (k == 0) return; /* for Bug 1 */ switch (b[k-1])
       {  case 'a': if (ends("al")) break; return;
          case 'c': if (ends("ance")) break;
                    if (ends("ence")) break; return;
          case 'e': if (ends("er")) break; return;
          case 'i': if (ends("ic")) break; return;
          case 'l': if (ends("able")) break;
                    if (ends("ible")) break; return;
          case 'n': if (ends("ant")) break;
                    if (ends("ement")) break;
                    if (ends("ment")) break;
                    /* element etc. not stripped before the m */
                    if (ends("ent")) break; return;
          case 'o': if (ends("ion") && j >= 0 && (b[j] == 's' || b[j] == 't')) break;
                                    /* j >= 0 fixes Bug 2 */
                    if (ends("ou")) break; return;
                    /* takes care of -ous */
          case 's': if (ends("ism")) break; return;
          case 't': if (ends("ate")) break;
                    if (ends("iti")) break; return;
          case 'u': if (ends("ous")) break; return;
          case 'v': if (ends("ive")) break; return;
          case 'z': if (ends("ize")) break; return;
          default: return;
       }
       if (m() > 1) k = j;
   }

   /* step6() removes a final -e if m() > 1. */

   private final void step6()
   {  j = k;
      if (b[k] == 'e')
      {  int a = m();
         if (a > 1 || a == 1 && !cvc(k-1)) k--;
      }
      if (b[k] == 'l' && doublec(k) && m() > 1) k--;
   }

   /** Stem the word placed into the Stemmer buffer through calls to add().
    * Returns true if the stemming process resulted in a word different
    * from the input.  You can retrieve the result with
    * getResultLength()/getResultBuffer() or toString().
    */
   public void stem()
   {  k = i - 1;
      if (k > 1) { step1(); step2(); step3(); step4(); step5(); step6(); }
      i_end = k+1; i = 0;
   }
}