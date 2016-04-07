package com.okas.packModelo;


public class Director {
    private static Director miDirector = null;
    private TableroBuilder tableroBuilder;

    private Director(){}
    public void setTableroBuilder(TableroBuilder tabBuilder){
        tableroBuilder = tabBuilder;
    }

    public static Director getDirector(){
        if (miDirector == null) miDirector = new Director();
        return miDirector;
    }

    public Tablero construirTablero(int nivel){
        switch (nivel){
            case 1: tableroBuilder = new BuilderN1();break;
            case 2: tableroBuilder = new BuilderN2();break;
            case 3: tableroBuilder = new BuilderN3();break;
            default: tableroBuilder = new BuilderN1();break;
        }

        tableroBuilder.construirTablero();
        this.setTableroBuilder(tableroBuilder);

        return tableroBuilder.getTablero();
    }
}
