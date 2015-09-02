import java.util.List;
import java.util.ArrayList;

class DocumentOrderingDemo {
	public static void main(String[] args) {
		List<String> filenames = new ArrayList<String>();
		List<String> words = new ArrayList<String>();
		filenames.add("Document1.txt");
		filenames.add("Document2.txt");	
		filenames.add("Document3.txt");
		filenames.add("Document4.txt");
		words.add("Animal");
		words.add("fossil");
		words.add("animals");
		words.add("types");
		DocumentOrdering documents = new DocumentOrdering(filenames, words);
		List<String> sortedFilenames = documents.sortingDocs();
		for (String filename : sortedFilenames) {
			System.out.println(filename);
		}
	}
}