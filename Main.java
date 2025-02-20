public class Main {
    public static void main(String[] args) {
        TicketBooking ticketBooking = new TicketBooking();

        BookingThread vip1 = new BookingThread(ticketBooking, "VIP Customer 1");
        BookingThread regular1 = new BookingThread(ticketBooking, "Regular Customer 1");
        BookingThread vip2 = new BookingThread(ticketBooking, "VIP Customer 2");
        BookingThread regular2 = new BookingThread(ticketBooking, "Regular Customer 2");

        vip1.setPriority(Thread.MAX_PRIORITY);
        regular1.setPriority(Thread.NORM_PRIORITY);
        vip2.setPriority(Thread.MAX_PRIORITY);
        regular2.setPriority(Thread.NORM_PRIORITY);

        vip1.start();
        regular1.start();
        vip2.start();
        regular2.start();
    }
}