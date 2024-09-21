package entities;

import java.util.List;

public class DataItem {
    private String id;
    private String name;
    private String symbol;
    private String slug;
    private int num_market_pairs;
    private String date_added;
//    private List<String> tags;
    private double max_supply;
    private double circulating_supply;
    private double total_supply;
//    private Platform platform;
    private int cmc_rank;
    private double self_reported_circulating_supply;
    private double self_reported_market_cap;
    private String last_updated;
    private Quote quote;
    

    public DataItem(String id, String name, String symbol, String slug, double max_supply, double circulating_supply,
			double total_supply, int cmc_rank, Quote quote) {
		super();
		this.id = id;
		this.name = name;
		this.symbol = symbol;
		this.slug = slug;
		this.max_supply = max_supply;
		this.circulating_supply = circulating_supply;
		this.total_supply = total_supply;
		this.cmc_rank = cmc_rank;
		this.quote = quote;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getNum_market_pairs() {
        return num_market_pairs;
    }

    public void setNum_market_pairs(int num_market_pairs) {
        this.num_market_pairs = num_market_pairs;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

//    public List<String> getTags() {
//        return tags;
//    }
//
//    public void setTags(List<String> tags) {
//        this.tags = tags;
//    }

    public double getMax_supply() {
        return max_supply;
    }

    public void setMax_supply(double max_supply) {
        this.max_supply = max_supply;
    }

    public double getCirculating_supply() {
        return circulating_supply;
    }

    public void setCirculating_supply(double circulating_supply) {
        this.circulating_supply = circulating_supply;
    }

    public double getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(double total_supply) {
        this.total_supply = total_supply;
    }

    public int getCmc_rank() {
        return cmc_rank;
    }

    public void setCmc_rank(int cmc_rank) {
        this.cmc_rank = cmc_rank;
    }

    public double getSelf_reported_circulating_supply() {
        return self_reported_circulating_supply;
    }

    public void setSelf_reported_circulating_supply(double self_reported_circulating_supply) {
        this.self_reported_circulating_supply = self_reported_circulating_supply;
    }

    public double getSelf_reported_market_cap() {
        return self_reported_market_cap;
    }

    public void setSelf_reported_market_cap(double self_reported_market_cap) {
        this.self_reported_market_cap = self_reported_market_cap;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

	@Override
	public String toString() {
		return "DataItem [id=" + id + ", name=" + name + ", symbol=" + symbol + ", slug=" + slug + ", num_market_pairs="
				+ num_market_pairs + ", date_added=" + date_added + ", max_supply=" + max_supply
				+ ", circulating_supply=" + circulating_supply + ", total_supply=" + total_supply + ", cmc_rank="
				+ cmc_rank + ", self_reported_circulating_supply=" + self_reported_circulating_supply
				+ ", self_reported_market_cap=" + self_reported_market_cap + ", last_updated=" + last_updated
				+ ", quote=" + quote + "]";
	}
    

}
