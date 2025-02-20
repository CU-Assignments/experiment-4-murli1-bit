class TicketBooking {
    private final Lock lock = new ReentrantLock();
    private int availableSeats = 10;

    public void bookTicket(String customerName) {
        lock.lock();
        try {
            if (availableSeats > 0) {
                System.out.println(customerName + " booked a seat. Seats left: " + --availableSeats);
            } else {
                System.out.println("No seats available for " + customerName);
            }
        } finally {
            lock.unlock();
        }
    }
}