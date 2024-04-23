/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public TicketMachine(int cost)
    {
        if (cost > 0) {
            price = cost;
        } else {
            System.out.println("ERROR:  precio debe ser mayor que 0 ");
            price = 0;
        }
        balance = 0;
        total = 0;
    }
    
    /**
     * Return the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }
    
    public int refundBalance() 
    {
        if (balance > price) {
            int refund = balance - price;
            balance = price;
            return refund;
        } else {
            return 0;
        }
    }
    
    /**
     * Receive an amount of money from a customer.
     */
    // ejemplo de assert//
    public void insertMoney(int money)
    {
     assert money > 0 : "error: El balance debe ser mayor a 0";
     balance += money;
    }
    // ejemplo de assert//
    public void ChangePrice(int newPrice){
        assert newPrice > 0 : ("ERROR: El nuevo precio debe ser mayor a 0");
        price = newPrice;
        }
        
    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public void printTicket()
    {
        // Simulate the printing of a ticket.
        if(balance >= price){
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();
        // actualiza el precio recaudado//
        total += price;
        // reduce el precio del billete//
        balance -= price;
    } else {
        System.out.println("saldo insuficiente para imprimir ticket.");
    }

    }
}
