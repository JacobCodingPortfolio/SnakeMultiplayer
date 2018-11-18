package pl.game.client.logic;

import javafx.scene.paint.Color;

import java.util.Random;

public class ColorSelector {

    private ColorSelector(){}

    private static Random random = new Random();

    private static final Color[] COLORS = new Color[]{
        Color.YELLOWGREEN,Color.YELLOW,Color.WHITESMOKE,Color.WHITE,Color.WHEAT,Color.VIOLET,Color.TURQUOISE,Color.TURQUOISE,Color.TOMATO,
        Color.THISTLE,Color.TEAL,Color.TAN,Color.STEELBLUE,Color.SPRINGGREEN,Color.SNOW,Color.SLATEGREY,Color.SLATEBLUE,Color.SKYBLUE,Color.SILVER,Color.SIENNA,
        Color.SEASHELL,Color.SEAGREEN,Color.SANDYBROWN,Color.SALMON,Color.SADDLEBROWN,Color.ROYALBLUE,Color.ROSYBROWN,Color.RED,Color.PURPLE,Color.POWDERBLUE,
        Color.PLUM,Color.PERU,Color.PEACHPUFF,Color.PAPAYAWHIP,Color.PALEVIOLETRED,Color.PALETURQUOISE,Color.PALEGREEN,Color.PALEGOLDENROD,Color.ORCHID,Color.ORANGERED,Color.ORANGE,Color.OLIVEDRAB,
        Color.OLIVE,Color.OLDLACE,Color.NAVY,Color.NAVAJOWHITE,Color.MOCCASIN,Color.MISTYROSE,Color.MINTCREAM,Color.MIDNIGHTBLUE,Color.MEDIUMVIOLETRED,Color.MEDIUMTURQUOISE,
        Color.MEDIUMSPRINGGREEN,Color.MEDIUMSLATEBLUE,Color.MEDIUMSEAGREEN,Color.MEDIUMPURPLE,Color.MEDIUMORCHID,Color.MEDIUMBLUE,Color.MEDIUMAQUAMARINE,
        Color.MAROON,Color.MAGENTA,Color.LINEN,Color.LIMEGREEN,Color.LIME,Color.LIGHTYELLOW,Color.LIGHTSTEELBLUE,Color.LIGHTSLATEGREY,Color.LIGHTSKYBLUE,Color.LIGHTSEAGREEN,Color.LIGHTSALMON,Color.LIGHTPINK,
        Color.LIGHTGREY,Color.LIGHTGREEN,Color.LIGHTGOLDENRODYELLOW,Color.LIGHTGRAY,Color.LIGHTCYAN,Color.LIGHTCORAL,Color.LIGHTBLUE,Color.LEMONCHIFFON,Color.LAWNGREEN,
        Color.LAWNGREEN,Color.LAVENDERBLUSH,Color.LAVENDER,Color.KHAKI,Color.IVORY,Color.INDIGO,Color.INDIANRED,Color.HOTPINK,Color.HONEYDEW,
        Color.GREY,Color.GREENYELLOW,Color.GREEN,Color.GRAY,Color.GOLDENROD,Color.GOLD,Color.GHOSTWHITE,Color.GAINSBORO,Color.FUCHSIA,Color.FORESTGREEN,Color.FLORALWHITE,Color.FIREBRICK,Color.DODGERBLUE,Color.DODGERBLUE,
        Color.DIMGREY,Color.DIMGRAY,Color.DEEPSKYBLUE,Color.DEEPPINK,Color.DARKVIOLET,Color.DARKTURQUOISE,Color.DARKSLATEGREY,Color.DARKSLATEGRAY,
        Color.DARKSLATEBLUE,Color.DARKSEAGREEN,Color.DARKSALMON,Color.DARKRED,Color.DARKORCHID,Color.DARKORANGE,Color.DARKOLIVEGREEN,Color.DARKMAGENTA,
        Color.DARKKHAKI,Color.DARKGREY,Color.DARKGREEN,Color.DARKGRAY,Color.DARKGOLDENROD,Color.DARKCYAN,Color.DARKBLUE,Color.CYAN,Color.CRIMSON,Color.CORNSILK,Color.CORNFLOWERBLUE,Color.CORAL,Color.CHOCOLATE,
        Color.CHARTREUSE,Color.CADETBLUE,Color.BURLYWOOD,Color.BROWN,Color.BLUEVIOLET,Color.BLUE,Color.BLANCHEDALMOND,Color.BLACK,Color.BISQUE,Color.BEIGE,Color.AZURE,Color.AQUAMARINE,Color.AQUA,Color.ANTIQUEWHITE,Color.ALICEBLUE};

    private static final int getColorsTabLen(){return COLORS.length; }

    public static Color getRandomColor(){
        //Firstly I must draw a number
        //The draw number must be higher than 0 and smaller than COLOR length
        int number = Math.abs(random.nextInt()) % getColorsTabLen();
        //Now I get the item from tab by drawing index
        //String colorName = colorNames[number];
        //In this case I get the color by index
        try {
            return COLORS[number];
        } catch (ArrayIndexOutOfBoundsException e){
            return getRandomColor();
        }
    }

}
