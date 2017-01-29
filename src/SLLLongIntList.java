
public class SLLLongIntList implements LongIntList<SLLNode> {

	private SLLNode head;
	private SLLNode tail;

	public SLLLongIntList() 
	{
		head = null;
		tail = null;
	}

	public void insertFirst(int value) {
		if (head == null) 
		{
			SLLNode temp = new SLLNode(value);
			temp.setNext(null);
			head = temp;
			tail = temp;
		} 
		else 
		{
			SLLNode temp = new SLLNode(value);
			temp.setNext(head);
			head = temp;
		}
	}

	public void insertLast(int value) {
		if (head == null) 
		{
			SLLNode temp = new SLLNode(value);
			temp.setNext(null);
			head = temp;
			tail = temp;
		}
		else
		{
			SLLNode temp = new SLLNode(value);
			temp.setNext(null);
			tail.setNext(temp);
			tail = temp;
		}
	}

	public SLLNode first() {
		if (head == null) 
		{
			return null;
		} 
		else 
		{
			return head;
		}
	}

	public SLLNode last() {
		if (head == null) 
		{
			return null;
		} 
		else 
		{
			return tail;
		}
	}

	public boolean isFirst(SLLNode p) {
		if (p == first())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isLast(SLLNode p) {
		if (p == last())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public SLLNode before(SLLNode p) {
		if (head == null)
		{
			throw new NullPointerException(); //empty list so before it
		}
		else if (head == p)
		{
			throw new NullPointerException(); //first position so nothing before it
		}
		else
		{
			SLLNode temp = head;
			while (temp.getNext() != p)
			{
				temp = temp.getNext();
			}
			return temp;
		}
	}

	public SLLNode after(SLLNode p) {
		if (head == null)
		{
			throw new NullPointerException(); //empty list so nothing after it
		}
		else if (p == last())
		{
			throw new NullPointerException(); //last position so nothing after it
		}
		else
		{
			return p.getNext();
		}
	}

	public boolean isEmpty() {
		return (head == null);
	}

	//traverses list, adding to a counter for each node it visits
	public int size() {
		if (head == null)
		{
			return 0;
		}
		else
		{
			int count = 1;
			SLLNode temp = head;
			while (temp.getNext() != null)
			{
				count++;
				temp = temp.getNext();;				
			}
			return count;
		}
	}
}
