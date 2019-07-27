package simpledb;

import java.io.IOException;
import java.util.Iterator;

public class PageIterator implements Iterator<Tuple>{
	private DbIterator _dbIterator;
	private int _currentTuple;
	private int _pagesInRelation;
	private int _tuplesInPage;
	private Tuple[][] tupleArray;
	
	public PageIterator(DbIterator dbIterator) throws DbException, TransactionAbortedException, IOException{ //_outerRelation or _innerRelation
		this._dbIterator = dbIterator;
		this._currentTuple = 0;
		this._pagesInRelation = ((SeqScan)dbIterator).getPagesRead();
		this._tuplesInPage = BufferPool.PAGE_SIZE / _dbIterator.getTupleDesc().getSize();
		for(int i = 0; i < _pagesInRelation; i++){
			for(int j = 0; j < _tuplesInPage; j++){//error?
				if(!dbIterator.hasNext()){
					break;
				}
				tupleArray[i][j] = dbIterator.next();
			}
		}
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tuple next() {
		// TODO Auto-generated method stub
		return null;
	}

}
