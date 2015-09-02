import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Collections;

class DocumentOrdering {
	List<String> fileNames;
	List<String> fileContents;
	List<String> words;
	List<Integer> wordCount;
	DocumentOrdering(List<String> fileNames, List<String> words) {
		this.fileNames = fileNames;
		this.words = words;
		this.fileContents = new ArrayList<String>();
		this.wordCount = new ArrayList<Integer>();
		this.extractFileContent();
	}

	public void extractFileContent() {
		StringBuffer content = new StringBuffer();
		for (String fileName : fileNames) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				String line;
				while ((line = br.readLine()) != null) {
					content.append(line);
				}
				fileContents.add(content.toString());
				br.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public List<String> sortingDocs() {
		int k = 0;
		for (String content : fileContents) {
			int count = 0;
			StringTokenizer st = new StringTokenizer(content,".? \t\n\"!");
			while (st.hasMoreTokens()){
				String contentWord = st.nextToken();
				for (String word : words) {
					if(contentWord.equalsIgnoreCase(word)) {
						count++;
					}
				}
			}
			fileNames.set(k,fileNames.get(k) + "-" + count);
			wordCount.add(count);
			k++;			
		}
		for (int i = 0; i < wordCount.size(); i++) {
			for (int j = 0; j < wordCount.size(); j++) {
				if (wordCount.get(i) > wordCount.get(j)) {
					Collections.swap(fileNames,i,j);
				}
			}
		}
		return fileNames;
	}

}