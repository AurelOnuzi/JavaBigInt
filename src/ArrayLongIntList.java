public class ArrayLongIntList implements LongIntList<ArrayEntry> {

	private int n;
	private ArrayEntry[] entries;

	public ArrayLongIntList() {
		this(1);
	}

	public ArrayLongIntList(int cap) {
		if (cap < 0)
		{
			throw new IllegalArgumentException("No negatives");
		}
		entries = new ArrayEntry[cap];
		n = 0;
	}

	public void insertFirst(int value) {
		ArrayEntry [] newEntries = new ArrayEntry [n+1];
	    if (n == 0)
	    {
	    	newEntries[n] = new ArrayEntry(value,n);
	    	n++;
	    	entries = newEntries;
	    }
	    else
	    {
		    for (int i=0; i<entries.length; i++)
		    {
		        newEntries[i] = entries[i];
		        newEntries[i].setIndex(i);
		    }
	    	newEntries[n] = new ArrayEntry(value,n);
	    	n++;
	    	entries = newEntries;
	    }
	}

	public void insertLast(int value) {
		ArrayEntry [] newEntries = new ArrayEntry [n+1];
		if (n == 0)
		{
	    	newEntries[0] = new ArrayEntry (value, 0);
	    	n++;
	    	entries = newEntries;
	    }
	    else
	    {
			for (int i=0; i<entries.length; i++)
			{
	            newEntries[i+1] = entries[i];
	            newEntries[i+1].setIndex(i+1);
	        }
			n++;
	        newEntries[0] = new ArrayEntry(value, 0);
	        entries = newEntries;
	    }
	}

	public ArrayEntry first() {
		return entries[n-1];
	}

	public ArrayEntry last() {
		return entries[0];
	}

	public boolean isFirst(ArrayEntry p) {
		return (p.getIndex() == first().getIndex());
	}

	public boolean isLast(ArrayEntry p) {
		return (p.getIndex() == last().getIndex());
	}

	public ArrayEntry before(ArrayEntry p) {
        if (p.getIndex() != (n-1))
        {
            return entries[p.getIndex()+1];
        }
        return null;
	}

	public ArrayEntry after(ArrayEntry p) {
		if ( p.getIndex() != 0)
		{
            return entries[p.getIndex()-1];
        }
        return null;
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	public int size() {
		return n;
	}

}
