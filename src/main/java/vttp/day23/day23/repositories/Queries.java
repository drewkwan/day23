package vttp.day23.day23.repositories;

public class Queries {
    
    public static final String SQL_SELECT_STYLES = "select * from styles";
    public static final String SQL_GET_BREWERIES = "SELECT b.brewery_id, b.name as beer_name, s.style_name, br.name as brewery_name FROM beers b JOIN styles s on s.id = b.style_id JOIN breweries br on b.brewery_id = br.id WHERE s.id=? ORDER BY br.name;";


}
