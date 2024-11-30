package com.app.myapp.model.model.carmembers;

public enum Bodytype {
    SMALL_CARS("e.g. Citroen C1, Fiat 500, SMart, Kia Picanto"),
    CITY_CAR("e.g. Opel Corsa, Ford Fiesta, Renault Clio"),
    COUPE("e.g. Audi A5, BMW 4, Ford Mustang"),
    CABRIOLET("e.g. Mazda MX-5, Peugeot 207 CC, Porsche Boxster"),
    STATION_WAGON("e.g. Skoda Occtavia Station Wago, Audi A4 Avant, BMW 5 Touring"),
    COMPACT("e.g. Volkswagen Golf, Ford Focus, Toyota Auris"),
    MINIVAN("e.g. Renault Scenic, Citroen C4 Picasso, Opel Zafira"),
    SEDAN("e.g. Volkswagen Passat, Opel Insignia, Mercedes C Class"),
    SUV("e.g. Volvo XC 60, Toyota RAV4, Kia Sportage");

    private String description;

    Bodytype(String description) {
        this.description = description;
    }
}
