
public class StringIndexOutOfBounds {
	public static void main(String args[]){
		try{
		  String s = "This is a string";
		  int l = s.length();  //String�N���X�̃C���X�^���X���\�b�h�B���݂̃I�u�W�F�N�g�̕�������Ԃ�->16
		  System.out.println(s.charAt(l));  /*String�N���X�̃C���X�^���X���\�b�h�B
		                                     *������l�̒l�Ŏw�肳���ʒu�̕�����Ԃ��B
		                                     *�z��Ƃ��čl���邽�߁A0���琔����B
		                                     *����āA16�Ԗڂ͉����Ȃ�null�B
		                                     */
		}
		catch(Exception /*StringIndexOutOfBoundsException�ł��悢*/ e){
			System.out.println(e);
		}
	}
}
