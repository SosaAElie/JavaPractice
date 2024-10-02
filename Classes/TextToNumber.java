package Classes;

public enum TextToNumber {
    ONE((byte)1, "one"),
    TWO((byte)2, "two"),
    THREE((byte)3, "three"),
    FOUR((byte)4, "four"),
    FIVE((byte)5, "five"),
    SIX((byte)6, "six"),
    SEVEN((byte)7, "seven"),
    EIGHT((byte)8, "eight"),
    NINE((byte)9, "nine");

    public final byte num;
    public final String word;
    TextToNumber(byte num, String word){
        this.num = num;
        this.word = word;
    }

    public static byte toNumber(String text){
        //Takes in a string and returns the numeric represenation in base-10
        byte num = -1;
        for(TextToNumber n : TextToNumber.values()){
            if(text.indexOf(n.word) > -1) num = n.num;
        }
        return num;
    }
}
