package Service;

import Entity.CardE;
import Repository.CardR;

import java.util.List;

public class CardS {
    private CardS(){}
    private static CardS cardS=new CardS();
    public static CardS getInstance(){
        return cardS;
    }
    public void save(CardE cardE) throws Exception{
        try (CardR cardR=new CardR()){
            cardR.insert(cardE);
            cardR.commit();
        }
    }
    public void remove(long id) throws Exception{
        try (CardR cardR=new CardR()){
            cardR.delete(id);
            cardR.commit();
        }
    }
    public List<CardE> report() throws Exception{
        List<CardE> cardES;
        try (CardR cardR=new CardR()){
            cardES=cardR.select();
        }
        return cardES;
    }
}
