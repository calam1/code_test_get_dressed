package commands;

import java.util.NoSuchElementException;

public enum MorningActions {

    PUT_ON_FOOTWEAR("Sandals", "Boots"),
    PUT_ON_SOCKS("Fail", "Socks"),
    PUT_ON_JACKET("Fail", "Jacket"),
    PUT_ON_HEAD_WEAR("Sunglasses", "Hat"),
    PUT_ON_SHIRT("Shirt", "Shirt"),
    PUT_ON_PANTS("Shorts", "Pants"),
    TAKE_OFF_PAJAMAS("Removing PJ's", "Removing PJ's"),
    LEAVE_HOUSE("Leaving house", "Leaving house");

    private final String coldDesc;
    private final String hotDesc;

    MorningActions(String hotDesc, String coldDesc) {
        this.hotDesc = hotDesc;
        this.coldDesc = coldDesc;
    }

    public String getHotDesc() {
        return hotDesc;
    }

    public String getColdDesc() {
        return coldDesc;
    }

    public String getDescription(Temperature temperature){
        if (temperature == Temperature.COLD)
            return getColdDesc();
        else {
            return getHotDesc();
        }
    }
    public static MorningActions getAction(int number){
       switch(number){
           case 1 :
               return PUT_ON_FOOTWEAR;
           case 2 :
               return PUT_ON_HEAD_WEAR;
           case 3 :
               return PUT_ON_SOCKS;
           case 4 :
               return PUT_ON_SHIRT;
           case 5 :
               return PUT_ON_JACKET;
           case 6 :
               return PUT_ON_PANTS;
           case 7 :
               return LEAVE_HOUSE;
           case 8 :
               return TAKE_OFF_PAJAMAS;
           default :
               throw new NoSuchElementException("You have provided an invalid argument there is no such value as: " + number);//TODO: test this
       }
    }

}
