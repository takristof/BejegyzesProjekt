package com.company;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Bejegyzes {

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
    @Override
    public String toString() {
        return this.szerzo+this.likeok+this.letrejott+"Szerkeztve:"+this.szerkeztve+this.tartalom;
    }



}
