package it.polito.tdp.imdb.model;

public class FilmW {
private Movie m;
private int w;
public FilmW(Movie m, int w) {
	super();
	this.m = m;
	this.w = w;
}
public Movie getM() {
	return m;
}
public void setM(Movie m) {
	this.m = m;
}
public int getW() {
	return w;
}
public void setW(int w) {
	this.w = w;
}
@Override
public String toString() {
	return   m + "  (" + w + ")";
}

}
