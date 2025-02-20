class BookingThread extends Thread {
    private final TicketBooking ticketBooking;
    private final String customerName;

    public BookingThread(TicketBooking ticketBooking, String customerName) {
        this.ticketBooking = ticketBooking;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        ticketBooking.bookTicket(customerName);
    }
}