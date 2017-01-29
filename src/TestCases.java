public class TestCases {
	
	public static void cmp (String beingCmp , LongInt cmp, LongInt A, LongInt B,
			LongInt C,LongInt D,LongInt E,LongInt F,LongInt G,LongInt H,LongInt I)
	{
		System.out.println(beingCmp + " compared to A");
		System.out.println("Equal to:   " + cmp.equalTo(A) + "\t" +
							"Less Than:   " + cmp.lessThan(A) + "\t" +
							"Greater Than:   " + cmp.greaterThan(A) + "\n");
		
		System.out.println(beingCmp + " compared to B");
		System.out.println("Equal to:   " + cmp.equalTo(B) + "\t" +
							"Less Than:   " + cmp.lessThan(B) + "\t" +
							"Greater Than:   " + cmp.greaterThan(B) + "\n");
		
		System.out.println(beingCmp + " compared to C");
		System.out.println("Equal to:   " + cmp.equalTo(C) + "\t" +
							"Less Than:   " + cmp.lessThan(C) + "\t" +
							"Greater Than:   " + cmp.greaterThan(C) + "\n");

		System.out.println(beingCmp + " compared to D");
		System.out.println("Equal to:   " + cmp.equalTo(D) + "\t" +
							"Less Than:   " + cmp.lessThan(D) + "\t" +
							"Greater Than:   " + cmp.greaterThan(D) + "\n");

		System.out.println(beingCmp + " compared to E");
		System.out.println("Equal to:   " + cmp.equalTo(E) + "\t" +
							"Less Than:   " + cmp.lessThan(E) + "\t" +
							"Greater Than:   " + cmp.greaterThan(E) + "\n");

		System.out.println(beingCmp + " compared to F");
		System.out.println("Equal to:   " + cmp.equalTo(F) + "\t" +
							"Less Than:   " + cmp.lessThan(F) + "\t" +
							"Greater Than:   " + cmp.greaterThan(F) + "\n");

		System.out.println(beingCmp + " compared to G");
		System.out.println("Equal to:   " + cmp.equalTo(G) + "\t" +
							"Less Than:   " + cmp.lessThan(G) + "\t" +
							"Greater Than:   " + cmp.greaterThan(G) + "\n");

		System.out.println(beingCmp + " compared to H");
		System.out.println("Equal to:   " + cmp.equalTo(H) + "\t" +
							"Less Than:   " + cmp.lessThan(H) + "\t" +
							"Greater Than:   " + cmp.greaterThan(H) + "\n");

		System.out.println(beingCmp + " compared to I");
		System.out.println("Equal to:   " + cmp.equalTo(I) + "\t" +
							"Less Than:   " + cmp.lessThan(I) + "\t" +
							"Greater Than:   " + cmp.greaterThan(I) + "\n");
	}
	

	public static void main(String[] args) {
		
		String A = "2222";
		String B = "99999999";
		String C = "-246813575732";
		String D = "180270361023456789";
		String E = "1423550000000010056810000054593452907711568359";
		String F = "-350003274594847454317890";
		String G = "29302390234702973402973420937420973420937420937234872349872934872893472893749287423847";
		String H = "-98534342983742987342987339234098230498203894209928374662342342342356723423423";
		String I = "8436413168438618351351684694835434894364351846843435168484351684684315384684313846813153843135138413513843813513813138438435153454154515151513141592654543515316848613242587561516511233246174561276521672162416274123076527612";
		
		//Part 1
		LongInt intA = new LongInt(A);
		LongInt intB = new LongInt(B);
		LongInt intC = new LongInt(C);
		LongInt intD = new LongInt(D);
		LongInt intE = new LongInt(E);
		LongInt intF = new LongInt(F);
		LongInt intG = new LongInt(G);
		LongInt intH = new LongInt(H);
		LongInt intI = new LongInt(I);	

		//Part 2
		System.out.print("Part 2 output: Traversal \n\n");
		intA.traverse();
		System.out.println("Total number of digits: " + intA.getDigitCount());
		intB.traverse();
		System.out.println("Total number of digits: " + intB.getDigitCount());
		intC.traverse();
		System.out.println("Total number of digits: " + intC.getDigitCount());
		intD.traverse();
		System.out.println("Total number of digits: " + intD.getDigitCount());
		intE.traverse();
		System.out.println("Total number of digits: " + intE.getDigitCount());
		intF.traverse();
		System.out.println("Total number of digits: " + intF.getDigitCount());
		intG.traverse();
		System.out.println("Total number of digits: " + intG.getDigitCount());
		intH.traverse();
		System.out.println("Total number of digits: " + intH.getDigitCount());
		intI.traverse();
		System.out.println("Total number of digits: " + intI.getDigitCount());
		
		//Part 3
		System.out.print("\n\nPart 3 output: Output()\n\n");
		intA.output();
		intB.output();
		intC.output();
		intD.output();
		intE.output();
		intF.output();
		intG.output();
		intH.output();
		intI.output();
		
		//Part 4
		System.out.print("\n\nPart 4 output: Sign and number of digits\n\n");
		System.out.print("LongInt A: ");
		intA.printSign();
		System.out.println("\tNumber of digits: " + intA.getDigitCount());
		System.out.print("LongInt B: ");
		intB.printSign();
		System.out.println("\tNumber of digits: " + intB.getDigitCount());
		System.out.print("LongInt C: ");
		intC.printSign();
		System.out.println("\tNumber of digits: "  + intC.getDigitCount());
		System.out.print("LongInt D: ");
		intD.printSign();
		System.out.println("\tNumber of digits: "  + intD.getDigitCount());
		System.out.print("LongInt E: ");
		intE.printSign();
		System.out.println("\tNumber of digits: "  + intE.getDigitCount());
		System.out.print("LongInt F: ");
		intF.printSign();
		System.out.println("\tNumber of digits: "  + intF.getDigitCount());
		System.out.print("LongInt G: ");
		intG.printSign();
		System.out.println("\tNumber of digits: "  + intG.getDigitCount());
		System.out.print("LongInt H: ");
		intH.printSign();
		System.out.println("\tNumber of digits: "  + intH.getDigitCount());
		System.out.print("LongInt I: ");
		intI.printSign();
		System.out.println("\tNumber of digits: "  + intI.getDigitCount());
		
		//Part 5
		System.out.print("\n\nPart 5 output: A and B regular ints util methods\n\n");
		int realA = Integer.parseInt(A);
		int realB = Integer.parseInt(B);
		System.out.println("All utility methods for A: ");
		System.out.println("Overflow: " + LongIntUtils.overflow(realA));
		System.out.println("Underlow: " + LongIntUtils.underflow(realA));
		System.out.println("Upperhalf: " + LongIntUtils.upperHalf(realA));
		System.out.println("Lowerhalf: " + LongIntUtils.lowerHalf(realA));
		System.out.println("Digits: " + LongIntUtils.digits(realA) + "\n");
		System.out.println("All utility methods for B: ");
		System.out.println("Overflow: " + LongIntUtils.overflow(realB));
		System.out.println("Underlow: " + LongIntUtils.underflow(realB));
		System.out.println("Upperhalf: " + LongIntUtils.upperHalf(realB));
		System.out.println("Lowerhalf: " + LongIntUtils.lowerHalf(realB));
		System.out.println("Digits: " + LongIntUtils.digits(realB));
		
		
		//Part 6
		System.out.print("\n\nPart 6 output: Comparisons\n\n");
		TestCases.cmp("A", intA, intA, intB, intC, intD, intE, intF, intG, intH, intI);	
		System.out.print("\n");
		TestCases.cmp("B", intB, intA, intB, intC, intD, intE, intF, intG, intH, intI);	
		System.out.print("\n");
		TestCases.cmp("C", intC, intA, intB, intC, intD, intE, intF, intG, intH, intI);	
		System.out.print("\n");
		TestCases.cmp("D", intD, intA, intB, intC, intD, intE, intF, intG, intH, intI);	
		System.out.print("\n");
		TestCases.cmp("E", intE, intA, intB, intC, intD, intE, intF, intG, intH, intI);	
		System.out.print("\n");
		TestCases.cmp("F", intF, intA, intB, intC, intD, intE, intF, intG, intH, intI);	
		System.out.print("\n");
		TestCases.cmp("G", intG, intA, intB, intC, intD, intE, intF, intG, intH, intI);	
		System.out.print("\n");
		TestCases.cmp("H", intH, intA, intB, intC, intD, intE, intF, intG, intH, intI);	
		System.out.print("\n");
		TestCases.cmp("I", intI, intA, intB, intC, intD, intE, intF, intG, intH, intI);	
	}

}