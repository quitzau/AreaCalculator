package dk.topdanmark.area.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
    @NamedQuery(name = Square.GET_ALL, query="select s from Square s")
})
@XmlRootElement
public class Square extends Area {
    
    public static final String GET_ALL = "dk.topdanmark.area.entity.Square";
       
}
