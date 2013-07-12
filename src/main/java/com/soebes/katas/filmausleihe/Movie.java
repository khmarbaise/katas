package com.soebes.katas.filmausleihe;

public class Movie {

	private PriceType priceType;
	
	private String title;

    public Movie(String title, PriceType price) {
        super();
        this.title = title;
        this.priceType = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PriceType getPriceType() {
		return priceType;
	}

	public void setPriceType(PriceType price) {
		this.priceType = price;
	}

}
