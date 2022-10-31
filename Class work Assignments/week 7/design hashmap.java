class MyHashMap {
    
public class MapNode {
    //bucket ke andar ll h unka type yaah stored h 
	int key;
	int value;
	MapNode next;
	
	public MapNode(int key , int value) {//constructor mai key ki value or value ki value
		this.key = key;
		this.value = value;
	}

}    

ArrayList<MapNode> buckets;
int numBuckets; 

    public MyHashMap() {
        buckets = new ArrayList<>();
		numBuckets = 20;    //bucket size
		for(int i = 0 ; i < numBuckets ; i++) {
			 buckets.add(null); // har idx mpe jake ek khale linked list ko generate kia h 
		}
    }
    
 private int getBucketIndex(int key) {
		 int hc = key;
     //hashvode +ve or -ve hoskta h isliye positive ke liey abs 
            // abh idx ki val 0 se size-1 ke beech aani chaiye  
		 return hc % numBuckets;
	 }


    public void put(int key, int value) {
         int bucketIndex = getBucketIndex(key);
		 MapNode di = buckets.get(bucketIndex);
		 //element is already there ? just update its value
		 while(di != null) {
			 if(di.key == key) {
				 di.value = value;
				 return;
			 }
			 di = di.next;
		 }
		 
		 //element is not there . insert at 0th position of linked list
		 di = buckets.get(bucketIndex);
		 MapNode newNode = new MapNode(key,value);
		 newNode.next = di;
		 buckets.set(bucketIndex, newNode);
		
    }
    
    public int get(int key) {
        int bucketIndex = getBucketIndex(key);
		MapNode di = buckets.get(bucketIndex);
		 
		 while(di != null) {
			 if(di.key == key) {
				 
				 return di.value;
			 }
			 di = di.next;
		 }
		 return -1;
    }
    
    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);
		MapNode di = buckets.get(bucketIndex);
		MapNode prev = null;
		 while(di != null) {
			 if(di.key == key) {
				 if(prev != null) {
				prev.next = di.next;
			  }
			 else {
				 buckets.set(bucketIndex, di.next);
			 }
		   }	 
			 prev = di;
			 di = di.next;
		 }
		 return;
    }
}