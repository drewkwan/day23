package vttp.day23.day23.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.day23.day23.models.Brewery;
import vttp.day23.day23.models.Style;
import static vttp.day23.day23.repositories.Queries.*;

@Repository
public class BeerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public List<Style> getStyles() {

        List<Style> styles = new LinkedList<>();
        //perform the query
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SELECT_STYLES);


  
        while (rs.next()) {
            Style style = new Style();
            int id = rs.getInt("id");
            String name = rs.getString("style_name");
            style.setId(id);
            style.setStyleName(name);
            styles.add(style);
            }
        
        System.out.println(">>>>>>>>>>>test" + styles.size());
        return styles;

    }

    public List<Brewery> getBreweries(Integer id) {

        //perform the query
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_BREWERIES, id);
        List<Brewery> breweries = new LinkedList<>();

        while (rs.next()) {
            Brewery brewery = new Brewery();
            brewery.setId(rs.getInt("brewery_id"));
            brewery.setName(rs.getString("brewery_name"));
            breweries.add(brewery);
        }
        System.out.println("!!!!!!!!!!!!!!!!! " + breweries.size());
        return breweries;

    }

    
}
