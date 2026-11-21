package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	Collectible[] collectibles;
	int item_cnt;


	public NaiveInventory() {
		collectibles = new Collectible[INITIAL_CAPACITY];
		item_cnt = 0;
	}

	@Override
	public void collect(Collectible collectible) {
		if (this.collectibles.length == this.item_cnt)
		{
			copyCollect(collectible);
		}
		else
		{
			simpleCollect(collectible);
		}
	}

	private void copyCollect(Collectible collectible)
	{
		Collectible[] new_Collectibles = new Collectible[this.collectibles.length*2];
		for (int i = 0; i < this.collectibles.length; i++){
			new_Collectibles[i] = collectibles[i];
		}
		this.collectibles = new_Collectibles;
		simpleCollect(collectible);
	}

	private void simpleCollect(Collectible collectible)
	{
		this.collectibles[this.item_cnt] = collectible;
		this.item_cnt ++;
	}

	@Override
	public float getTotalWeight() {
		float total = 0.f;
		for (int i = 0; i < this.item_cnt; i++)
		{
			total += this.collectibles[i].getWeight();
		}
		return total;
	}

	@Override
	public int getCurrentCount() {
		
		return this.item_cnt;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return this.collectibles;
	}
}
