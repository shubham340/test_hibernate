package codemeek.dropwizard.example.models;
import javax.persistence.Embeddable;


/**
 * Created by shubham on 18/06/18.
 */
@Embeddable
public class Address {
    private String city;
    private int phone;
    private int pincode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}
