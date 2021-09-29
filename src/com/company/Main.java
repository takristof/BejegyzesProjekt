package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	Bejegyzes b1=new Bejegyzes("Pisti","Cicák");
	Bejegyzes b2=new Bejegyzes("Panna ","Kutyus");
	Bejegyzes[] bejegyzesek = {b1,b2};
	Bejegyzes bk1 = new Bejegyzes(bejegyzesek);
	Bejegyzes bk2 = new Bejegyzes("bejegyzesek.txt");
	

    }
}
