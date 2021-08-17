package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingPojo {
    private  String FirstName;
    private  String lastName;
    private  int totalPrice;
    private  boolean depositPaid;
    private BookingDatePojo bookingDates;

    //2.step


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDepositPaid() {
        return depositPaid;
    }

    public void setDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    public BookingDatePojo getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(BookingDatePojo bookingDates) {
        this.bookingDates = bookingDates;
    }

    public BookingPojo() {
    }

    public BookingPojo(String firstName, String lastName, int totalPrice, boolean depositPaid, BookingDatePojo bookingDates) {
        FirstName = firstName;
        this.lastName = lastName;
        this.totalPrice = totalPrice;
        this.depositPaid = depositPaid;
        this.bookingDates = bookingDates;
    }

    @Override
    public String toString() {
        return "BookingPojo{" +
                "FirstName='" + FirstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", totalPrice=" + totalPrice +
                ", depositPaid=" + depositPaid +
                ", bookingDates=" + bookingDates +
                '}';
    }
}
