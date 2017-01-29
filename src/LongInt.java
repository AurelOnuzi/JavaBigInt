public class LongInt {

	// DO NOT CHANGE OR REMOVE THIS LINE (UNTIL STEP 3)
	// This will give a warning about raw types, but you can ignore it for this
	// project
	//private final LongIntList list = new SLLLongIntList();

	// USE THIS LINE IN STEP 3
	private final LongIntList list = new ArrayLongIntList();

	//private boolean isNegative;
	//changed to non-final for setSign()
	private boolean isNegative;
	private boolean borrowOne;
	private boolean switchedSignAbs;
	
	public LongInt() {
		this.isNegative = false;
		this.borrowOne = false;
		this.switchedSignAbs = false;
	}

	public LongInt(String s) {
		int eightDigitChar = 0;
		int prefixDigits = 0;
		
		//negative number part
		if (s.substring(0,1).equals("-"))
		{
			//taking only the digits out of the string
			String onlyNums = s.substring(1,s.length());
			int numLen = onlyNums.length();
			int numOfPrefixDigits = numLen%8;
			//taking non-8 block digit from the entire number and inserting it to the list
			if (numOfPrefixDigits != 0 )
			{
				prefixDigits = Integer.parseInt(onlyNums.substring(0, numOfPrefixDigits));
				list.insertFirst(prefixDigits);
			}
			String onlyEightDigits =  onlyNums.substring(numOfPrefixDigits,numLen);
			int numLenEightDigits = onlyEightDigits.length();
			
			//inserting the rest of the numbers in 8 block intervals
			for(int i=0; i<numLenEightDigits/8 ; i++)
			{
				eightDigitChar = Integer.parseInt(onlyEightDigits.substring(i*8, (i+1)*8));
				list.insertFirst(eightDigitChar);
			}
			//its a negative number, so change its sign
			setSign(true);
			
		}
		else
		{
			int numLen = s.length();
			int numOfPrefixDigits = numLen%8;
			//same as above, for positive numbers
			if (numOfPrefixDigits != 0 )
			{
				prefixDigits = Integer.parseInt(s.substring(0, numOfPrefixDigits));
				list.insertFirst(prefixDigits);
			}
			String onlyEightDigits =  s.substring(numOfPrefixDigits,numLen);
			int numLenEightDigits = onlyEightDigits.length();
			
			for(int i=0; i<numLenEightDigits/8; i++)
			{
				eightDigitChar = Integer.parseInt(onlyEightDigits.substring(i*8, (i+1)*8));
				list.insertFirst(eightDigitChar);
			}
			setSign(false);
		}
		
	}	
	//traversing the list and displaying the number as a string
	public void output() {
		String output= "";
		if (list.isEmpty())
		{
			System.out.println(output);
		}
		Position H = list.first();
		while (!(list.isLast(H)))
		{
			//padding 0s to output the number correctly
			output = String.format("%08d", H.getValue()) + output;
			H = list.after(H);
		}
		output = Integer.toString(list.last().getValue()) + output;
		if (isNegative)
		{
			output = "-" + output;
			System.out.println(output);
		}
		else
		{
			System.out.println(output);
		}

	}

	//traverses the list from the head node 
	//and places -> between nodes
	//ex output would be : [] -> [] -> []
	//where [] is the node representing up to 8 numbers
	public void traverse() {
		String output = "";
		if (list.isEmpty())
		{
			System.out.println(output);
		}
		Position H = list.first();
		while (!(list.isLast(H)))
		{
			output = " -> " + Integer.toString(H.getValue()) + output;
			H = list.after(H);
		}
		output = Integer.toString(list.last().getValue()) + output;
		System.out.println(output);

	}

	//simply return the sign of the longint
	public boolean getSign() {
		return isNegative;
	}
	
	//assigns the sign to a LongInt, also used for changing the sign
	public void setSign(boolean sign) {
		this.isNegative = sign;
	}
	public boolean getSwitchSignAbs(){
		return switchedSignAbs;
	}
	public void switchSignAbs(boolean sign){
		this.switchedSignAbs = sign;
	}
	
	//prints to standard output the sign
	//- for negative(when isnegative = true)
	//+ For positive(when isnegative = false)
	public void printSign(){ 
		if (getSign() == true)
		{
			System.out.print("Sign is: -");
		}
		else
		{
			System.out.print("Sign is: +");
		}
	}
	
	//returns number of digits of the longint by taking list size times 8, minus 8 for the 
	//node representing the starting digits of a number
	//then gets the digits of that node and adds it to the number, returns that number
	public int getDigitCount() {
		int numDigits = (8*list.size())-8;
		numDigits = numDigits + LongIntUtils.digits(list.last().getValue());
		return numDigits;		
	}

	//checking equality. If they have different signs or amount of digits, they clearly are not equal
	//if they do have same sign and digits, then traverses each list and compares nodes to each other
	public boolean equalTo(LongInt i) {
		if (i.getSign() != getSign())
		{
			return false;
		}
		else if (i.getDigitCount() != getDigitCount())
		{
			return false;
		}
		else
		{
			 Position firstInt = list.first();
			 Position secondInt = i.list.first();
			 
			 while(!(list.isLast(firstInt)))
			 {
				 if (firstInt.getValue() != secondInt.getValue())
				 {
					 return false;
				 }
				 firstInt = list.after(firstInt);
				 secondInt = list.after(secondInt);
			 }
			 //handle edge case at last position
			 firstInt = list.last();
			 secondInt = i.list.last();
			 if (firstInt.getValue() != secondInt.getValue())
			 {
				 return false;
			 }
			 return true;
		}

	}

	//checking if one is less than the other through sign first, then traversal if necessary
	//if one is positive and the other is negative, no need to traverse 
	//if same sign, but one has more digits, then one number is clearly less than, no need to traverse 
	public boolean lessThan(LongInt i) {
		if ((getSign() == false) && (i.getSign() == true))
		{
			return false;
		}
		else if ((getSign() == true) && (i.getSign() == false))
		{
			return true;
		}
		else
		{
			boolean firstSign = getSign();
			int firstDigits = getDigitCount();
			int secondDigits = i.getDigitCount();
			
			if ( ((firstSign == true) && (firstDigits < secondDigits))
					|| ((firstSign == false) && (firstDigits > secondDigits)))
			{
				return false;
			}
			else if (((firstSign == true) && (firstDigits > secondDigits))
					|| ((firstSign == false) && (firstDigits < secondDigits)))
			{
				return true;
			}
			else
			{
				Position firstInt = list.last();
				Position secondInt = i.list.last();
				while( !(list.isFirst(firstInt)) )
				{
					if (firstSign == true)
					{
						if (firstInt.getValue() > secondInt.getValue())
						{
							return true;
						}
						else if (firstInt.getValue() < secondInt.getValue())
						{
							return false;
						}
						
						firstInt = list.before(firstInt);
						secondInt = i.list.before(secondInt);
					}
					else 
					{
						if (firstInt.getValue() > secondInt.getValue())
						{
							return false;
						}
						else if (firstInt.getValue() < secondInt.getValue())
						{
							return true;
						}
						
						firstInt = list.before(firstInt);
						secondInt = i.list.before(secondInt);
					}
				}
				//handle edge case at header(ending digits of the longint
				firstInt = list.first();
				secondInt = i.list.first();
				if (firstSign == true)
				{
					if (firstInt.getValue() > secondInt.getValue())
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else
				{
					if (firstInt.getValue() < secondInt.getValue())
					{
						return true;
					}
					else
					{
						return false;
					}
				}
			}
				
		}
	}

	//pretty much same as less than with the logic reversed
	public boolean greaterThan(LongInt i) {
		if ((getSign() == false) && (i.getSign() == true))
		{
			return true;
		}
		else if ((getSign() == true) && (i.getSign() == false))
		{
			return false;
		}
		else
		{
			boolean firstSign = getSign();
			int firstDigits = getDigitCount();
			int secondDigits = i.getDigitCount();
			
			if ( ((firstSign == true) && (firstDigits < secondDigits))
					|| ((firstSign == false) && (firstDigits > secondDigits)))
			{
				return true;
			}
			else if (((firstSign == true) && (firstDigits > secondDigits))
					|| ((firstSign == false) && (firstDigits < secondDigits)))
			{
				return false;
			}
			else
			{
				Position firstInt = list.last();
				Position secondInt = i.list.last();
				while( !(list.isFirst(firstInt)) )
				{
					if (firstSign == true)
					{
						if (firstInt.getValue() > secondInt.getValue())
						{
							return false;
						}
						else if (firstInt.getValue() < secondInt.getValue())
						{
							return true;
						}
						
						firstInt = list.before(firstInt);
						secondInt = i.list.before(secondInt);
					}
					else 
					{
						if (firstInt.getValue() > secondInt.getValue())
						{
							return true;
						}
						else if (firstInt.getValue() < secondInt.getValue())
						{
							return false;
						}
						
						firstInt = list.before(firstInt);
						secondInt = i.list.before(secondInt);
					}
				}
				//handle edge case at header(ending digits of the longint
				firstInt = list.first();
				secondInt = i.list.first();
				if (firstSign == true)
				{
					if (firstInt.getValue() < secondInt.getValue())
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else
				{
					if (firstInt.getValue() > secondInt.getValue())
					{
						return true;
					}
					else
					{
						return false;
					}
				}
			}
				
		}

	}
	
	public LongInt removeZerosFront(LongInt i){
		LongInt removedZ = new LongInt();
		Position first = i.list.first();
		Position last = i.list.last();
		if (first.getValue() != 0)
		{
			while (last.getValue() != 0 | last == first)
			{
				removedZ.list.insertFirst(last.getValue());
				last = i.list.before(last);
			}
			while (last != first)
			{
				removedZ.list.insertFirst(last.getValue());
				last = i.list.before(last);
			}
			removedZ.list.insertFirst(first.getValue());
			return removedZ;
		}
		return i;
		
	}
	public LongInt add(LongInt i) {
        LongInt answer=new LongInt();
        int rollingSum=0;
        int carry=0;
        Position x=list.first();
        Position y=i.list.first();
        if (i.getSign() == getSign())
        {
        	if (getSign() == true)
        	{
        		answer.setSign(true);
        	}
            while (!list.isLast(x)&& !i.list.isLast(y))
            {
                rollingSum=(x.getValue() + y.getValue()+carry);
                carry=LongIntUtils.overflow(rollingSum);
                rollingSum=LongIntUtils.underflow(rollingSum);
                answer.list.insertLast(rollingSum);
                x=list.after(x);
                y=i.list.after(y);
            }
            if (list.isLast(x) || i.list.isLast(y))
            {
            	rollingSum=x.getValue() + y.getValue()+carry;        
            	carry=LongIntUtils.overflow(rollingSum);
                rollingSum=LongIntUtils.underflow(rollingSum);
                answer.list.insertLast(rollingSum);

                if (i.list.isLast(y) && list.isLast(x))
                {
                	if (carry > 0)
                	{
                		answer.list.insertLast(carry);
                	}
                }

                if (!i.list.isLast(y)&&list.isLast(x))
                {  
                    y=i.list.after(y);
                    carry=y.getValue()+carry;
                    answer.list.insertLast(carry);
                    while (!i.list.isLast(y))
                    {
                        y=i.list.after(y);
                        answer.list.insertLast(y.getValue());
                    }
                } 
                else if (!list.isLast(x)&&i.list.isLast(y))
                {   
                    x=list.after(x);
                    carry=x.getValue()+carry; 
                    answer.list.insertLast(carry);      
                    while (!list.isLast(x))
                    {
                        x=list.after(x);
                        answer.list.insertLast(x.getValue());
                    }
                }
            }
            return answer;
        }
        else 
        {
        	if ( (getSign() == true) && (i.getSign() == false))
        	{
        		setSign(false);
        		if (greaterThan(i))
        		{
           			answer = subtract(i);
        			answer.setSign(true);
        		}
        		else
        		{
        			switchSignAbs(true);
        			answer = subtract(i);
        			answer.setSign(false);
        		}
       			setSign(true);
       			switchSignAbs(false);
       			i.switchSignAbs(false);
       			return answer;
        	}
        	else if ((getSign()==false) && (i.getSign()== true))
        	{	
        		i.setSign(false);
        		if (greaterThan(i))
        		{
        			//switchSignAbs(true);
        			//i.switchSignAbs(true);       			        				        			
            		answer = subtract(i);
        			answer.setSign(false);
        		}
        		else
        		{
        			//switchSignAbs(true);  
            		answer = i.subtract(this);
        			answer.setSign(true);
        		}
        		i.setSign(true);
        		switchSignAbs(false);
        		i.switchSignAbs(false);
        		return answer;
        	}
        	else
        	{
        		return answer;
        	}
        }  
    }
	
	public LongInt subtract(LongInt i) {
		LongInt answer = new LongInt();
		//changing sign then adding since a-(-b) = a+b, then changing sign back
		//so don't have to make a copy
		if ((getSign() == true) && (i.getSign() == false))
		{
			setSign(false);
			answer = add(i);
			if (greaterThan(i))
			{
				answer.setSign(true);
			}
			else
			{
				answer.setSign(false);
			}
			setSign(true);
			return answer;
		}
		else if ((getSign() == false) && (i.getSign() == true))
		{
			i.setSign(false);
			answer =  add(i);
			i.setSign(true);
			answer.setSign(getSign());
			return answer;
		}
		else
		{
			if ( getSign() == i.getSign() )
			{
				if (equalTo(i))
				{
					answer.list.insertFirst(0);
					return answer;
				}
				else if (greaterThan(i))
				{
					if (getSign() == true)
					{
						i.setSign(false);
						setSign(false);
						answer = i.subtract(this);
						i.setSign(true);
						setSign(true);
						return answer;
					}
					
					Position x = list.first();
					Position y = i.list.first();
					while (!list.isLast(x) && !i.list.isLast(y))
					{
						int tempBorrow = x.getValue();
						if (borrowOne)
						{
							tempBorrow = tempBorrow-1;
							borrowOne = false;
						}
						if (y.getValue() < tempBorrow)
						{
							answer.list.insertLast(tempBorrow-y.getValue());
						}
						else if (y.getValue() == tempBorrow)
						{
							answer.list.insertLast(0);
						}
						else
						{
							if ((getSwitchSignAbs() == true) | (i.getSwitchSignAbs() == true))
							{
								answer.list.insertLast(Math.abs(tempBorrow-y.getValue()));
							}
							else
							{
							answer.list.insertLast(Math.abs((tempBorrow+100000000)-y.getValue()));
							borrowOne = true;
							}
						}
						x = list.after(x);
						y = i.list.after(y);
					}
					
					int tempBorrow = x.getValue();
					if (borrowOne)
					{
						tempBorrow = tempBorrow-1;
						borrowOne = false;
					}
					
					if (list.isLast(x) && i.list.isLast(y))
					{
						answer.list.insertLast(Math.abs(tempBorrow-y.getValue()));
					}
					
					else if (!list.isLast(x) && i.list.isLast(y))
					{
						if (y.getValue() < tempBorrow)
						{
							answer.list.insertLast(tempBorrow-y.getValue());
						}
						else if (y.getValue() == tempBorrow)
						{
							answer.list.insertLast(0);
						}
						else
						{
							if ((getSwitchSignAbs() == true) | (i.getSwitchSignAbs() == true))
							{
								answer.list.insertLast(Math.abs(tempBorrow-y.getValue()));
							}
							else
							{
							answer.list.insertLast(Math.abs((tempBorrow+100000000)-y.getValue()));
							borrowOne = true;
							}
						}
						{
							x = list.after(x);
							while (!list.isLast(x))
							{
								tempBorrow=x.getValue();
								if (borrowOne)
								{
									tempBorrow = tempBorrow-1;
									borrowOne = false;
								}
								answer.list.insertLast(tempBorrow);
								x = list.after(x);
							}
							tempBorrow = x.getValue();
							if (borrowOne)
							{
								tempBorrow = tempBorrow-1;
								borrowOne = false;
							}							
							answer.list.insertLast(tempBorrow);
							return answer;
						}
					}
					else
					{
						answer.list.insertLast(Math.abs(tempBorrow-(y.getValue())));
						y = i.list.after(y);
						while (!i.list.isLast(y))
						{
							answer.list.insertLast(y.getValue());
							y = i.list.after(y);
						}
						answer.list.insertLast(y.getValue());
						return answer;
					}			
				}
				else
				{
					if (getSign() == false)
					{
						answer.setSign(true);
					}
					else if (getSign() == true)
					{
						answer.setSign(true);
					}
					Position x = list.first();
					Position y = i.list.first();
					while(!list.isLast(x) && !i.list.isLast(y))
					{
						int tempBorrow = x.getValue();
						if (borrowOne)
						{
							tempBorrow = tempBorrow-1;
							borrowOne = false;
						}
						if (y.getValue() < tempBorrow)
						{
							answer.list.insertLast(tempBorrow-y.getValue());
						}
						else if (y.getValue() == tempBorrow)
						{
							answer.list.insertLast(0);
						}
						else
						{
							if ((getSwitchSignAbs() == true) | (i.getSwitchSignAbs() == true))
							{
								answer.list.insertLast(Math.abs(tempBorrow-y.getValue()));
							}
							else
							{
								answer.list.insertLast(Math.abs((tempBorrow+100000000)-y.getValue()));
								borrowOne = true;
							}
						}
						x = list.after(x);
						y = i.list.after(y);
					}
					int tempBorrow = x.getValue();
					
					if (borrowOne)
					{
						tempBorrow = tempBorrow-1;
						borrowOne = false;
					}
					if (list.isLast(x) && i.list.isLast(y))
					{
						if (y.getValue() < tempBorrow)
						{
							answer.list.insertLast(Math.abs(tempBorrow-y.getValue()));
						}
						else
						{
							if ((getSwitchSignAbs() == true) | (i.getSwitchSignAbs() == true))
							{
								answer.list.insertLast(Math.abs(tempBorrow-y.getValue()));
							}
							else
							{
								answer.list.insertLast(Math.abs((tempBorrow+100000000)-y.getValue()));
								borrowOne = true;
							}
						}
						return answer;
					}
					else
					{
						tempBorrow = x.getValue();
						if (borrowOne)
						{
							tempBorrow = tempBorrow-1;
							borrowOne = false;
						}						
						answer.list.insertLast(Math.abs(tempBorrow-y.getValue()));
						if (getSign() == false)
						{ 
							y = i.list.after(y);
							while (!i.list.isLast(y))
							{
								answer.list.insertLast(y.getValue());
								y = i.list.after(y);
							}
							answer.list.insertLast(y.getValue());
							return answer;
						}
						else
						{
							x = list.after(x);
							while (!list.isLast(x))
							{
								answer.list.insertLast(x.getValue());
								x = list.after(x);
							}
							answer.list.insertLast(x.getValue());
							return answer;
						}
					}	
				}
			}
		}
		return answer;
	}

	public LongInt multiply(LongInt i) {
		LongInt answer = new LongInt();
		LongInt topSum = new LongInt();
		LongInt botSum = new LongInt();
		LongInt tempSum = new LongInt();
		Position x = list.first();
		Position y = i.list.first();
		int zerosPadding = 0;
		int topNum = 0;
		
		while (!i.list.isLast(y))
		{
			x = list.first();
			topSum = new LongInt();
			botSum = new LongInt();
			topNum = 0;
			
			for (int j=0; j<(zerosPadding+1); j++)
			{
				botSum.list.insertFirst(0);
	        }
			for (int j=0; j<(zerosPadding); j++)
			{
				topSum.list.insertFirst(0);
			}
			
			while (!list.isLast(x))
			{
				int C1 = LongIntUtils.upperHalf(y.getValue());
				int C2 = LongIntUtils.lowerHalf(y.getValue());
				int D1 = LongIntUtils.upperHalf(x.getValue());
				int D2 = LongIntUtils.lowerHalf(x.getValue());
				
				int z1 = C1*D1;
				int z3 = C2*D2;
				int z2 = ((C1+C2)*(D1+D2))-z3-z1;
				int v1 = z1 + LongIntUtils.upperHalf(z2);
				int v2 = z3 + (LongIntUtils.lowerHalf(z2)*10000);
				
				int botNum = 0;
				botNum = v2+LongIntUtils.overflow(topNum);
				topSum.list.insertLast(LongIntUtils.underflow(botNum));
				topNum = v1+LongIntUtils.overflow(botNum)+(LongIntUtils.overflow(z2)*10000);
				botSum.list.insertLast(LongIntUtils.underflow(topNum));
				
				x = list.after(x);
			}
			
			if (list.isLast(x))
			{
				int C1 = LongIntUtils.upperHalf(y.getValue());
				int C2 = LongIntUtils.lowerHalf(y.getValue());
				int D1 = LongIntUtils.upperHalf(x.getValue());
				int D2 = LongIntUtils.lowerHalf(x.getValue());
				
				int z1 = C1*D1;
				int z3 = C2*D2;
				int z2 = ((C1+C2)*(D1+D2))-z3-z1;
				int v1 = z1 + LongIntUtils.upperHalf(z2);
				int v2 = z3 + (LongIntUtils.lowerHalf(z2)*10000);
				
				int botNum = 0;
				botNum = v2+LongIntUtils.overflow(topNum);
				topSum.list.insertLast(LongIntUtils.underflow(botNum));
				topNum = v1+LongIntUtils.overflow(botNum)+(LongIntUtils.overflow(z2)*10000);
				
				if (topNum > 0)
				{
					botSum.list.insertLast(LongIntUtils.underflow(topNum));
				}
				if ((LongIntUtils.overflow(topNum) > 0) && (LongIntUtils.underflow(topNum) > 0))
				{
					botSum.list.insertLast(LongIntUtils.overflow(topNum));
				}
				else if ((LongIntUtils.overflow(topNum) > 0) && (LongIntUtils.underflow(topNum) == 0))
				{
					botSum.list.insertLast(0);
					botSum.list.insertLast(LongIntUtils.overflow(topNum));
				}
				
			}
			
			tempSum = topSum.add(botSum);
			
			if (answer.list.isEmpty())
            {
				answer = tempSum;
            }
            else
            {
            	answer = answer.add(tempSum);
            }
			
			zerosPadding++;
            y = i.list.after(y);
            //return answer;
		}
		
		if (i.list.isLast(y))
		{
			topSum = new LongInt();
			botSum = new LongInt();
			
			x = list.first();
			topNum = 0;
			
			for (int j=0; j<(zerosPadding+1); j++)
			{
				botSum.list.insertFirst(0);
	        }
			for (int j=0; j<(zerosPadding); j++)
			{
				topSum.list.insertFirst(0);
			}
			
			while (!list.isLast(x))
			{
				int C1 = LongIntUtils.upperHalf(y.getValue());
				int C2 = LongIntUtils.lowerHalf(y.getValue());
				int D1 = LongIntUtils.upperHalf(x.getValue());
				int D2 = LongIntUtils.lowerHalf(x.getValue());
				
				int z1 = C1*D1;
				int z3 = C2*D2;
				int z2 = ((C1+C2)*(D1+D2))-z3-z1;
				int v1 = z1 + LongIntUtils.upperHalf(z2);
				int v2 = z3 + (LongIntUtils.lowerHalf(z2)*10000);
				
				int botNum = 0;
				botNum = v2+LongIntUtils.overflow(topNum);
				topSum.list.insertLast(LongIntUtils.underflow(botNum));
				topNum = v1+LongIntUtils.overflow(botNum)+(LongIntUtils.overflow(z2)*10000);
				botSum.list.insertLast(LongIntUtils.underflow(topNum));
				
				x = list.after(x);
			}
			
			if (list.isLast(x))
			{
				int C1 = LongIntUtils.upperHalf(y.getValue());
				int C2 = LongIntUtils.lowerHalf(y.getValue());
	
				int D1 = LongIntUtils.upperHalf(x.getValue());
				int D2 = LongIntUtils.lowerHalf(x.getValue());
				
				int z1 = C1*D1;
				int z3 = C2*D2;
				int z2 = ((C1+C2)*(D1+D2))-z3-z1;
				int v1 = (z1 + LongIntUtils.upperHalf(z2));
				int v2 = (z3 + (LongIntUtils.lowerHalf(z2)*10000));
				
				int botNum = v2+LongIntUtils.overflow(topNum);
				topSum.list.insertLast(LongIntUtils.underflow(botNum));
				topNum = v1+LongIntUtils.overflow(botNum)+(LongIntUtils.overflow(z2)*10000);
				
				if (topNum > 0)
				{
					botSum.list.insertLast(LongIntUtils.underflow(topNum));
				}
				if ((LongIntUtils.overflow(topNum) > 0) && (LongIntUtils.underflow(topNum) > 0))
				{
					botSum.list.insertLast(LongIntUtils.overflow(topNum));
				}
				else if ((LongIntUtils.overflow(topNum) > 0) && (LongIntUtils.underflow(topNum) == 0))
				{
					botSum.list.insertLast(0);
					botSum.list.insertLast(LongIntUtils.overflow(topNum));
				}
				
				tempSum = topSum.add(botSum);
				
				if (answer.list.isEmpty())
		        {
					answer = tempSum;
		        }
		        else
		        {
		        	answer = answer.add(tempSum);
		        }
			}
		}
		if ((!getSign() && i.getSign()) || (getSign() && !i.getSign()))
		{
			answer.setSign(true);
		}
		return answer;
	}

	public LongInt power(int p) {
		LongInt answer = new LongInt();
		answer = this;
		
		if ((p%2)==1)
		{
			answer.setSign(getSign());
		}
		else
		{
			answer.setSign(false);
		}
		
		if (p == 0)
		{
			LongInt one = new LongInt();
			one.list.insertFirst(1);
			return one;
		}
		else if (p < 0)
		{
			throw new IllegalArgumentException("Must be positive or 0, can't do power of negative currently.");
		}
		else if (p == 1)
		{
			return this;
		}
		else
		{
			LongInt one = new LongInt();
			one.list.insertFirst(1);
			while(p != 0)
			{
				if ((p & 1)==1) //when the right most bit is 1, multiply that by the current rolling total
				{
					one = answer.multiply(one);
				}
				p = (p/2); //also can do : p >>= 1, both are bitwise shifts ex: when p = 10, 10/2 = 5 so 101, and 10>>1 is also 101, both resulting in 101 in binary;
				answer = answer.multiply(answer);
			}
			return one;
		}
	}

}
