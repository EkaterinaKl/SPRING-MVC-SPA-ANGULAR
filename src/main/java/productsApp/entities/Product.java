package productsApp.entities;



/**
 * @author Ekaterina
 */

import java.io.Serializable;
import javax.persistence.*;

import productsApp.exceptions.RestException;

@Entity
/**
 * Entity "Product"
 *  @param id            id, AUTO
 *  @param name            name
 *  @param price        price
 *  @param description    long description of the item
 *  @param img            image, not available for editing now
 *  @param status        define status "enabled for order": 1 if true and 0 otherwise
 */
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = true)
    private String img;
    @Column(nullable = true)
    private int status;


    protected Product() {
    }


    public Product(String name, String description, Double price, String img, int status) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.img = img;
        this.status = status;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the  description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param  description the  description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
}
