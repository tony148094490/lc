package airbnb;
/**
 * Given an array of arrays, implement an iterator class to allow the client to traverse and remove elements in the array list.  This iterator should provide three public class member functions:
.1point3acres缃�
boolean hasNext()
    return true if there is another element in the set

int next()
    return the value of the next element in the array 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�.

void remove()
    remove the last element returned by the iterator.
    That is, remove the element that the previous next() returned
    This method can be called only once per call to next(),
    otherwise an exception will be thrown
 */
import java.util.Iterator;
import java.util.List;

public class TwoDVector implements Iterator<Integer>{
	List<List<Integer>> list;
	boolean canRemove = false;
	int row = 0;
	int col = 0;
	public TwoDVector(List<List<Integer>> vector) {
		list = vector;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(list.get(row).size() > col) return true;
		row++;
		col = 0;
		while(row < list.size() && list.get(row).size() == 0) row++;
		if(row < list.size()) return true;
		
		return false;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		if(!hasNext()) return null;
		int res = list.get(row).get(col);
		col++;
		canRemove = true;
		return res;
	}

	
	@Override
	public void remove() {
		if(!canRemove) throw new UnsupportedOperationException();
		if(col == 0) {
			list.get(row-1).remove(list.get(row-1).size()-1);
		} else {
			list.get(row).remove(col-1);
			col--;
		}
		canRemove = false;
	}
}
