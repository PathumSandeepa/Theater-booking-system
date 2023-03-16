package newTheatre.com;

public class Ticket {
    private int row;
    private int seat;
    private double price;
    private  Person customerDetails;


    public Ticket(int row, int seat, double price, Person customerDetails) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.customerDetails = customerDetails;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    public Person getCustomerDetails() {
        return customerDetails;
    }

    public void print(){
        System.out.println();
        System.out.println("Name : " + customerDetails.getName());
        System.out.println("Surname : " + customerDetails.getSurname());
        System.out.println("Email : " + customerDetails.getEmail());
        System.out.print("Row number : " + getRow() + ", ");
        System.out.println("Seat number : " + getSeat() );
        System.out.println("Price : " + getPrice());
    }

}


