package AlgorithmPartAB;

public class TestDrive {

	public static void main(String[] args) {

		Algorithm myAlg=new LessSizeAlgorithm(20);

		System.out.println(myAlg.toString());
		
		System.out.println(myAlg.runAlgorithm(300, 300) );
		
		System.out.println(myAlg.toString());
		
		// Use big array
		Algorithm myAlg2=new MoreSizeAlgorithm(200);
		
		System.out.println(myAlg2.toString());
		
		System.out.println(myAlg2.runAlgorithm(300, 300) );
		
		System.out.println(myAlg2.toString());
	}

}
