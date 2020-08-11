# VECTOR-SPACE-MODEL-OF-INFORMATION-RETRIEVAL-USING-JAVA

You are required to implement the Vector Space Model of Information Retrieval. You must create a program (using Java) that, using the files in the archive Assignment_Files.zip 

This README file explains how to implement the Vector Space Model of Information Retrieval
	
Scripts:
File1.java
File2.java
File3.java
File4.java

Procedure:

Firstly Compile and Run the "File1.java" to get the desired outputs. 

1. javac File1.java

2. java File1

//It is requesting the path for "cranfield_collection.txt"
//Please type the exact file path for "cranfield_collection.txt"
//For example: C:\\Program Files\\Java\\jdk1.8.0_181\\bin\\cranfield_collection.txt

3. C:\\Program Files\\Java\\jdk1.8.0_181\\bin\\cranfield_collection.txt

//Once you type the path it request file path for "Stopwords.txt"
//For example: C:\\Program Files\\Java\\jdk1.8.0_181\\bin\\stopwords.txt

4. C:\\Program Files\\Java\\jdk1.8.0_181\\bin\\stopwords.txt

//Now it is requesting for the folder path to store the output of "length of documents" as well as cosine similarity for each queries. 
//For example: C:\\Program Files\\Java\\jdk1.8.0_181\\bin

5. C:\\Program Files\\Java\\jdk1.8.0_181\\bin

//Now tfidf calculation is processing.
//It takes 3 mins to calculate the length of the document and store the output results on "tfidf.txt" in the path which has been given previously  
//For example: C:\\Program Files\\Java\\jdk1.8.0_181\\bin\\tfidf.txt -> Output is stored here.

6. Its option to choose to find cosine similarity or exit the program

7. 1 //cosine similarity

//Now it is requesting query on the command prompt to process the cosine similarity and storing the output in a text file
//For example: This query 
magnetohydrodynamic flow past a semi-infinite plate -> This query was 299th document heading and it matches and found the document of 299 by returning with a maximum cosine similarity value and stored in a text format.

8. magnetohydrodynamic flow past a semi-infinite plate

9. Then the process is repeated, until it gets the option 2.



