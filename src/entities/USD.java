package entities;

public class USD {
    private double price;
    private Number volume_24h;
    private double volume_change_24h;
    private double percent_change_1h;
    private double percent_change_24h;
    private double percent_change_7d;
    private double percent_change_30d;
    private Number market_cap;
    private double market_cap_dominance;
    private double fully_diluted_market_cap;
    private String last_updated;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Number getVolume_24h() {
        return volume_24h;
    }

    public void setVolume_24h(Number volume_24h) {
        this.volume_24h = volume_24h;
    }

    public double getVolume_change_24h() {
        return volume_change_24h;
    }

    public void setVolume_change_24h(double volume_change_24h) {
        this.volume_change_24h = volume_change_24h;
    }

    public double getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(double percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public double getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(double percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public double getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(double percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public double getPercent_change_30d() {
        return percent_change_30d;
    }

    public void setPercent_change_30d(double percent_change_30d) {
        this.percent_change_30d = percent_change_30d;
    }

    public Number getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(Number market_cap) {
        this.market_cap = market_cap;
    }

    public double getMarket_cap_dominance() {
        return market_cap_dominance;
    }

    public void setMarket_cap_dominance(double market_cap_dominance) {
        this.market_cap_dominance = market_cap_dominance;
    }

    public double getFully_diluted_market_cap() {
        return fully_diluted_market_cap;
    }

    public void setFully_diluted_market_cap(double fully_diluted_market_cap) {
        this.fully_diluted_market_cap = fully_diluted_market_cap;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }
}
