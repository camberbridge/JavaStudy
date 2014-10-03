import java.io.*;

public class StreamTokenizerDemo4 {
	public static void main(String args[]){
		try{
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			StreamTokenizer st = new StreamTokenizer(br);
			
			while(st.nextToken() != StreamTokenizer.TT_EOF){
				switch(st.ttype){
					case StreamTokenizer.TT_WORD:
						System.out.format("%02d) %s\n", st.lineno(), st.sval);
						break;
					case StreamTokenizer.TT_NUMBER:
						System.out.format("%02d) %s\n", st.lineno(), st.nval);
						break;
					default:
						System.out.format("%02d) %c\n", st.lineno(), (char)st.ttype);
				}
			}
			
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
