class AuctionSystem {
    HashMap<Integer, TreeSet<Bid>> actionHash;
    HashMap<String, Bid> bidHash;
    public AuctionSystem() {
        actionHash = new HashMap<>();
        bidHash = new HashMap<>();
    }
    
    public void addBid(int userId, int itemId, int amount) {
        if(actionHash.get(itemId) == null){
            actionHash.put(itemId, new TreeSet<>());
        }
        String key = itemId + "," + userId;
        if(bidHash.get(key) != null){
            actionHash.get(itemId).remove(bidHash.get(key));
        }
        Bid bid = new Bid(userId, itemId, amount);
        actionHash.get(itemId).add(bid);
        bidHash.put(key, bid);
    }
    
    public void updateBid(int userId, int itemId, int amount) {
        if(actionHash.get(itemId) == null){
            return;
        }
        String key = itemId + "," + userId;
        if(bidHash.get(key) == null){
            return;
        }
        actionHash.get(itemId).remove(bidHash.get(key));
        Bid bid = new Bid(userId, itemId, amount);
        actionHash.get(itemId).add(bid);
        bidHash.put(key, bid);
    }
    
    public void removeBid(int userId, int itemId) {
        if(actionHash.get(itemId) == null){
            return;
        }
        String key = itemId + "," + userId;
        if(bidHash.get(key) == null){
            return;
        }
        actionHash.get(itemId).remove(bidHash.get(key));
    }
    
    public int getHighestBidder(int itemId) {
        if(actionHash.get(itemId) == null){
            return -1;
        }
        if(actionHash.get(itemId).size() == 0){
            return -1;
        }
        return actionHash.get(itemId).first().userId;
    }
}

class Bid implements Comparable<Bid> {
    int userId;
    int itemId;
    int amount;

    Bid(int userId, int itemId, int amount) {
        this.userId = userId;
        this.itemId = itemId;
        this.amount = amount;
    }

    @Override
    public int compareTo(Bid other) {
        int cmp = Integer.compare(other.amount, this.amount);
        if (cmp != 0) return cmp;

        cmp = Integer.compare(other.userId, this.userId);
        if (cmp != 0) return cmp;

        return Integer.compare(this.itemId, other.itemId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bid bid = (Bid) o;
        return userId == bid.userId && itemId == bid.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, itemId);
    }
}


/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */