package it.polito.tdp.imdb.model;

public class Adiacenza {
 private int m1;
 private int m2;
 private int c;
public Adiacenza(int m1, int m2, int c) {
	super();
	this.m1 = m1;
	this.m2 = m2;
	this.c = c;
}
public int getM1() {
	return m1;
}
public void setM1(int m1) {
	this.m1 = m1;
}
public int getM2() {
	return m2;
}
public void setM2(int m2) {
	this.m2 = m2;
}
public int getC() {
	return c;
}
public void setC(int c) {
	this.c = c;
}
@Override
public String toString() {
	return "Adiacenza [m1=" + m1 + ", m2=" + m2 + ", c=" + c + "]";
}
 
 
}
