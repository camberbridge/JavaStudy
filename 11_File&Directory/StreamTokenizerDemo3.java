import java.io.*;

public class StreamTokenizerDemo3 {
	public static void main(String args[]){
		try{
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			StreamTokenizer st = new StreamTokenizer(br);
			int line = 0;
			
			st.eolIsSignificant(true);  //行の終わりをトークンとして扱う
			while(st.nextToken() != StreamTokenizer.TT_EOF){
				switch(st.ttype){
					case StreamTokenizer.TT_EOL:  //行の終わりの場合(10)
						++line;
				}
			}
			System.out.println("There are " + line + " lines");
			
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
