package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Bejegyzes {

    private FileReader fr;
    private BufferedReader br;
    public List<Bejegyzes> bejegyzesekLista;
    public static Random random=new Random();

    public Bejegyzes(Bejegyzes[] bejegyzesTomb){
        this.bejegyzesekLista = new ArrayList<>();
        for (int i = 0; i < bejegyzesTomb.length; i++) {
            bejegyzesekLista.add(bejegyzesTomb[i]);
        }
    }
    public Bejegyzes(String fileNev){
        this.bejegyzesekLista = new ArrayList<>();
        try {
            this.fr = new FileReader(fileNev);
            this.br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null){
                String[] adatok = line.split(";");
                Bejegyzes obj = new Bejegyzes(adatok[0], adatok[1]);
                bejegyzesekLista.add(obj);
                line = br.readLine();
            }

            br.close();
            fr.close();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    private String szerzo;
    private String tartalom;
    private int likeok=0;
    private LocalDateTime letrejott=LocalDateTime.now();
    private LocalDateTime  szerkeztve=LocalDateTime.now();

    public Bejegyzes(String szerzo,String tartalom){
    this.szerzo=szerzo;
    this.tartalom=tartalom;
    }

    public String getSzerzo(){
        return szerzo;
    }
    public String getTartalom(){
        return tartalom;
    }
    public void setTartalom(String ujtartalom) {
        this.tartalom = ujtartalom;
        szerkeztve=LocalDateTime.now();
    }
    public int getLikeok(){
        return likeok;
    }
    public LocalDateTime getLetrejott(){
        return letrejott;
    }
    public LocalDateTime getSzerkeztve(){
        return szerkeztve;
    }
    public void like(){
        likeok++;
    }
    public void likeAdas(){
        int bejegyzes20=bejegyzesekLista.size();
        for (int i=0; i<bejegyzes20;i++) {
        bejegyzesekLista.get(random.nextInt(bejegyzesekLista.size())).like();
        }

    }
    public void Kiiratas() {
        for (Bejegyzes item : bejegyzesekLista) {
            System.out.println(item);
        }

    }
    public int kevesebbMintTizenot(){
        int ossz=0;
        for(Bejegyzes item:bejegyzesekLista){
            if(item.getLikeok()<15){
                ossz++;
            }
        }
        return ossz;
    }
    @Override
    public String toString() {
        return this.szerzo +
                "\n" + this.likeok+"\n" +
                this.letrejott+"\n" + "Szerkeztve:" +
                this.szerkeztve+"\n" + this.tartalom;
    }



}
